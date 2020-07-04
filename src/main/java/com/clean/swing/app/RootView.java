package com.clean.swing.app;

import com.clean.core.app.services.NavigationService;
import com.clean.swing.app.dashboard.DashBoardSimple;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface RootView extends NavigationService {

    public static final String DASH_NAME = "DASHBOARD";
    public static final String LOGIN_NAME = "LOGIN";

    public DashBoardSimple dashboard();

    public void registerModule(AbstractSwingModule... moduleToInstall);
}
