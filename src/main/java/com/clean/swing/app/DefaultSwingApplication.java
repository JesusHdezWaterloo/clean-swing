package com.clean.swing.app;

import static com.clean.swing.app.RootView.LOGIN_NAME;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
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
        rootView().dashboard().update(rootView().dashboard().getMap());//este es que al final actualiza todo
        rootView().dashboard().format();
        rootView().dashboard().revalidate();
    }

    @Override
    public void desinstallModules() {
        this.rootView().dashboard().clear();
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
