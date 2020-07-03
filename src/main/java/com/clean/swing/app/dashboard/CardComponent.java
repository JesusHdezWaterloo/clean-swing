package com.clean.swing.app.dashboard;

import java.awt.Component;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface CardComponent {

    public abstract void addView(String name, Component compoment);

    public abstract void showView(String name);
}
