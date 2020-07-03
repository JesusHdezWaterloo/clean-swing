package com.clean.swing.app.dashboard;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MapeableContainer extends Container implements Mappeable<String, Object> {

    protected final HashMap<String, Object> elementsMap = new HashMap<>();

    @Override
    public void add(String key, Object component) {
        Class clss = DashboardConstants.getClassType(key);
        if (clss.getClass().equals(List.class)) {
            List oldList;
            Object list = elementsMap.get(key);
            if (list == null) {
                oldList = new ArrayList();
            } else {
                oldList = (List) list;
            }
            oldList.add(component);
            elementsMap.put(key, oldList);
        } else {
            elementsMap.put(key, component);
        }
    }

    @Override
    public void put(String key, Object component) {
        Class clss = DashboardConstants.getClassType(key);
        if (clss.getClass().equals(List.class)) {
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