package com.clean.swing.app;

import com.clean.core.app.services.ExceptionHandlerService;
import com.clean.core.app.services.NavigationService;
import com.clean.core.app.services.NotificationService;
import com.clean.core.domain.services.ResourceService;
import com.clean.swing.app.dashboard.MapeableContainer;
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

    public MapeableContainer dashboard();

    public List<AbstractSwingModule> installedModules();

    public void registerModule(AbstractSwingModule moduleToInstall);

    public void run() throws Exception;
}
