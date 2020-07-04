package com.clean.swing.app.dashboard;

import java.util.HashMap;
import java.util.List;
import javax.swing.Action;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DashboardConstants {

    public static final String FIRE_CHILD_SELECTED = "Child.Selected";

    public static final String MAIN_ELEMENT = "Main.Element";
    public static final String UP_ELEMENT = "Up.Element";
    public static final String UP_COMPANY = "Up.Company";
    public static final String DOWN_ELEMENT = "Down.Element";
    public static final String DOWN_LICENCE = "Down.Licence";

    private static final HashMap<String, Class> TYPES = new HashMap<>();

    static {
        TYPES.put(MAIN_ELEMENT, List.class);
        TYPES.put(UP_ELEMENT, List.class);
        TYPES.put(DOWN_ELEMENT, List.class);
        TYPES.put(UP_COMPANY, Action.class);
        TYPES.put(DOWN_LICENCE, Action.class);
    }

    //para mantener la integridad y que nadie lo modifique por fuera
    public static HashMap<String, Class> types() {
        return new HashMap<>(TYPES);
    }

    public static Class getClassType(String key) {
        return TYPES.get(key);
    }

}
