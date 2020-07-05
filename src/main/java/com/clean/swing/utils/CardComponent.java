package com.clean.swing.utils;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 * @param <ComponentType>
 */
public interface CardComponent<ComponentType> {

    public abstract void addView(String name, ComponentType compoment);

    public abstract void showView(String name);

    public abstract ComponentType getView(String name);
}
