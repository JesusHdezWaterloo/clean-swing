/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.clean.swing.app.dashboard;

import java.util.HashMap;
import java.util.List;
import javax.swing.Action;

/**
 * 
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
