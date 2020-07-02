package com.clean.swing.app;

import com.clean.core.app.services.ExceptionHandler;
import com.clean.core.app.services.Notification;
import com.clean.core.app.services.Navigation;
import javax.swing.JFrame;
import com.clean.swing.app.dashboard.DashboardExtendedDownUp;
import java.util.ArrayList;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SwingApplication {

    public static ExceptionHandler EXCEPTION_HANDLER;

    public static Notification NOTIFICATION;

    public static Navigation NAVIGATION;

    public static JFrame FRAME;

    public static DashboardExtendedDownUp DASHBOARD;

    private final static ArrayList<SwingModule> INSTALLED_MODULES = new ArrayList<>();

    public static void registerModule(SwingModule moduleToInstall) {
        moduleToInstall.register(DASHBOARD);
    }
}
