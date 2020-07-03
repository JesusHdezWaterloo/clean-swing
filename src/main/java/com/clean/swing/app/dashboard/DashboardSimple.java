package com.clean.swing.app.dashboard;

import java.awt.Component;
import java.awt.Container;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class DashboardSimple<MainType> extends Container {

    public abstract void addMainElement(MainType element);

    public abstract void addView(String name, Component compoment);

    public abstract void showView(String name);
}
