package com.clean.swing.utils;

import java.awt.Component;
import java.util.Map;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 * @param <ComponentType>
 */
public interface CardComponent<ComponentType extends Component> {

    public void addView(String name, ComponentType compoment);

    public void showView(String name);

    public ComponentType getView(String name);

    public void removeView(ComponentType component);

    public Map<String, ComponentType> getAll();

    public default void removeGroupView(String group) {
        for (Map.Entry<String, ComponentType> entry : getAll().entrySet()) {
            if (entry.getKey().startsWith(group)) {
                removeView(entry.getValue());
            }
        }
    }
}
