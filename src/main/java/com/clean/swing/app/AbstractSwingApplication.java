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
package com.clean.swing.app;

import com.root101.clean.core.app.services.NavigationService;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 * @author JesusHdezWaterloo@Github
 */
public interface AbstractSwingApplication extends NavigationService {

    public List<AbstractSwingModule> installedModules();

    public void registerModule(AbstractSwingMainModule... moduleToInstall);

    public void installModules();

    public void desinstallModules();

    public RootView rootView();

    public void initRootView(RootView root);

    public default void validateRootView() {//este es que al final actualiza todo
        rootView().dashboard().update(rootView().dashboard().getMap());
        rootView().dashboard().format();
        rootView().dashboard().revalidate();
    }

    /**
     * Call to all start in the folowing order:<\br>
     * 1 - startApplication <\br>
     * 2 - startServices <\br>
     * 3 - startRootView <\br>
     * 4 - dashboard.update <\br>
     * 5 - dashboard.format <\br>
     *
     * @throws Exception
     */
    public default void run() throws Exception {
        init();
    }

    public default void closeModules() {
        for (AbstractSwingModule module : installedModules()) {
            module.closeModule();
        }
    }

    public void init() throws Exception;

    public void closeApplication();

    public void show();

    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener);

    public void removePropertyChangeListener(java.beans.PropertyChangeListener listener);
}
