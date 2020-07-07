package com.clean.swing.app;

import com.clean.core.app.services.ExceptionHandlerService;
import com.clean.core.app.services.LoginHandlerService;
import com.clean.core.app.services.NavigationService;
import com.clean.core.app.services.NotificationService;
import com.clean.core.domain.services.ResourceService;
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

    public LoginHandlerService login();

    public List<AbstractSwingModule> installedModules();

    public void registerModule(AbstractSwingModule... moduleToInstall);

    public RootView rootView();

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
        startApplication();
        startServices();
        startRootView();
        rootView().dashboard().update(rootView().dashboard().getMap());//este es que al final actualiza todo
        rootView().dashboard().format();
    }

    public void startServices() throws Exception;

    public void startRootView() throws Exception;

    public void startApplication() throws Exception;

    public void closeApplication();
}
