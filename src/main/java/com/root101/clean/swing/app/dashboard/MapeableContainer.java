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
package com.root101.clean.swing.app.dashboard;

import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Only support the Constants defined in DashboardConstants
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public abstract class MapeableContainer extends Container implements Mappeable<String, Object> {

    protected final HashMap<String, Object> elementsMap = new HashMap<>();

    @Override
    public void addKeyValue(String key, Object component) {
        addKeyValue(key, component, -1);
    }

    @Override
    public void addKeyValue(String key, Object component, int pos) {
        Class clss = DashboardConstants.getClassType(key);
        if (clss.equals(List.class)) {
            List oldList;
            Object list = elementsMap.get(key);
            if (list == null) {
                oldList = new ArrayList();
            } else {
                oldList = (List) list;
            }
            if (pos < 0 || pos > oldList.size()) {
                oldList.add(component);
            } else {
                oldList.add(pos, component);
            }
            elementsMap.put(key, oldList);
        } else {
            elementsMap.put(key, component);
        }
    }

    @Override
    public void putKeyValue(String key, Object component) {
        Class clss = DashboardConstants.getClassType(key);
        if (clss.equals(List.class)) {
            List oldList = new ArrayList();
            oldList.add(component);
            elementsMap.put(key, oldList);
        } else {
            elementsMap.put(key, component);
        }
    }

    @Override
    public boolean containKey(String key) {
        return elementsMap.containsKey(key);
    }

    @Override
    public boolean removeKey(String key) {
        return elementsMap.remove(key) != null;
    }

    @Override
    public void clear() {
        elementsMap.clear();
    }

    /**
     * Si esta dentro de una lista lo elimino internamente, sino elimino normal
     *
     * @param value
     */
    @Override
    public void removeValue(Object value) {
        boolean found = false;
        for (String key : elementsMap.keySet()) {
            Object actual = elementsMap.get(key);
            if (actual == null) {//null sigo para el otro
                continue;
            } else if (found) {//ya lo encontre paro
                break;
            }
            if (actual instanceof List) {//si es lista borro 
                List oldList = (List) actual;
                while (oldList.remove(value)) {//borro todos en la lista
                    found = true;
                }
            } else if (actual.equals(value)) {//sino borro normal
                found = removeKey(key);
            }
        }
    }

    /**
     * Por defecto soportados todos los tipos de DashboardConstants, pero una
     * reimplementacion puede ofrecer mas o menos soportes.
     *
     * @param key
     * @return
     */
    @Override
    public boolean supportKey(String key) {
        return DashboardConstants.types().containsKey(key);
    }

    @Override
    public HashMap<String, Object> getMap() {
        return new HashMap<>(elementsMap);
    }
}
