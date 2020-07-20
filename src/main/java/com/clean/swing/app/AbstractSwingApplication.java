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

    public RootView rootView();

    public void initRootView(RootView root);

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
        rootView().dashboard().update(rootView().dashboard().getMap());//este es que al final actualiza todo
        rootView().dashboard().format();
    }

    public void init() throws Exception;

    public void closeApplication();

    public void show();
}
