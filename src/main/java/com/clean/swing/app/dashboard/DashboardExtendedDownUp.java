package com.clean.swing.app.dashboard;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface DashboardExtendedDownUp<MainType, DownType, UpType> extends DashboardExtendedDown<MainType, DownType> {

    public void addUpElement(UpType element);
}
