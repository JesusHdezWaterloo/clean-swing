package com.clean.swing.app;

import com.clean.core.app.services.NavigationService;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
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
