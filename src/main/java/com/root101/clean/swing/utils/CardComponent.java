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
package com.root101.clean.swing.utils;

import java.awt.Component;
import java.util.Map;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 * @param <ComponentType>
 */
public interface CardComponent<ComponentType extends Component> {

    public void addView(String name, ComponentType compoment);

    public void showView(String name);

    public ComponentType getView(String name);

    public String getSelectedViewName();

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
