package com.clean.swing.app;

import com.clean.core.app.services.NavigationService;
import com.clean.swing.app.dashboard.DashBoardSimple;
import java.awt.HeadlessException;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class RootView extends JFrame implements NavigationService {

    public static final String DASH_NAME = "DASHBOARD";
    public static final String LOGIN_NAME = "LOGIN";
    public static final String ON_WINDOWS_CLOSING = "windows.closing";

    public RootView(PropertyChangeListener listener) throws HeadlessException {
        this.addPropertyChangeListener(listener);
    }

    public abstract DashBoardSimple dashboard();
}
