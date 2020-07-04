package com.clean.swing.app;

import com.clean.core.app.services.ExceptionHandlerService;
import com.clean.core.app.services.NavigationService;
import com.clean.core.app.services.NotificationService;
import com.clean.core.domain.services.ResourceService;
import com.clean.swing.app.dashboard.DashBoardSimple;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface AbstractSwingApplication extends NavigationService {

    public ExceptionHandlerService exceptionHandler();

    public NotificationService notification();

    public NavigationService navigation();

    public ResourceService resource();

    public List<AbstractSwingModule> installedModules();

    public void registerModule(AbstractSwingModule... moduleToInstall);

    public RootView rootView();

    /**
     * Call to all start in the folowing order: 1 - startServices 2 -
     * startRootView
     *
     * @throws Exception
     */
    public default void run() throws Exception {
        startServices();
        startRootView();
        startApplication();        
        rootView().dashboard().update(rootView().dashboard().getMap());//este es que al final actualiza todo
        rootView().dashboard().format();
    }

    public void startServices() throws Exception;

    public void startRootView() throws Exception;

    public void startApplication() throws Exception;
}
