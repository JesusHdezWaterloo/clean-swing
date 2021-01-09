/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.clean.swing.app;

import static com.root101.clean.swing.app.RootView.LOGIN_NAME;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public abstract class DefaultSwingApplication implements AbstractSwingApplication, PropertyChangeListener {

    private final static ArrayList<AbstractSwingModule> INSTALLED_MODULES = new ArrayList<>();
    private RootView ROOT_VIEW;

    @Override
    public void navigateTo(String string, Object... o) {
        rootView().navigateTo(string, o);
        for (AbstractSwingModule abstractSwingModule : installedModules()) {
            abstractSwingModule.navigateTo(string, o);
        }
    }

    @Override
    public void registerModule(AbstractSwingMainModule... modulesToInstall) {
        this.installedModules().addAll(Arrays.asList(modulesToInstall));
    }

    @Override
    public void installModules() {
        desinstallModules();//antes de instalarlos me aseguro que se desinstalen para no repetir
        for (AbstractSwingModule modulo : INSTALLED_MODULES) {
            if (modulo instanceof AbstractSwingMainModule) {
                ((AbstractSwingMainModule) modulo).register(this);
            }
        }
        this.validateRootView();
    }

    @Override
    public void desinstallModules() {
        this.rootView().dashboard().clear();
        this.validateRootView();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case RootView.ON_WINDOWS_CLOSING:
                closeModules();
                closeApplication();
                break;
            case RootView.FIRE_NAVIGATE_TO:
                rootNavigateTo((String) evt.getNewValue());
                break;
            default:
                return;
        }
        //la sigo propagando
        propertyChangeSupport.firePropertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
    }

    @Override
    public List<AbstractSwingModule> installedModules() {
        return INSTALLED_MODULES;
    }

    @Override
    public void show() {
        rootView().setVisible(true);
    }

    @Override
    public RootView rootView() {
        return ROOT_VIEW;
    }

    @Override
    public void initRootView(RootView root) {
        this.ROOT_VIEW = root;
        this.ROOT_VIEW.navigateTo(LOGIN_NAME);//cuando inicie siempre voy al login
    }

    //Trabajo con property change
    private transient final java.beans.PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    @Override
    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    @Override
    public void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private void rootNavigateTo(String name) {
        switch (name) {
            case RootView.DASH_NAME:
                installModules();
                break;
            case RootView.LOGIN_NAME:
                desinstallModules();
                break;
        }
    }

}
