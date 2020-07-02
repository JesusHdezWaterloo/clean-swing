package com.clean.swing.app;

import com.clean.swing.app.dashboard.DashboardExtendedDown;
import com.clean.swing.app.dashboard.DashboardExtendedDownUp;
import com.clean.swing.app.dashboard.DashboardSimple;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface SwingModule {

    public void register(DashboardSimple dashBoard);

    public void register(DashboardExtendedDownUp dashBoard);

    public void register(DashboardExtendedDown dashBoard);

}
