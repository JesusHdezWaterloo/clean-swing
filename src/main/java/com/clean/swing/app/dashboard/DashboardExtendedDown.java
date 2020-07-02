package com.clean.swing.app.dashboard;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface DashboardExtendedDown<MainType, DownType> extends DashboardSimple<MainType> {

    public void addDownElement(DownType element);
}
