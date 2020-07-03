package com.clean.swing.app.dashboard;

import java.util.HashMap;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface Mappeable<K, V> {

    /**
     * Add (key,component) to the map, if the class represented by this key is a
     * List, the component is added to the end of it, if not, override the
     * previous value.<\br>
     *
     * @param key
     * @param component
     */
    public void add(K key, V component);

    /**
     * Call to add and inmediatly after to update.
     *
     * @param key
     * @param component
     */
    public default void addUpdate(K key, V component) {
        add(key, component);
        update(getMap());
    }

    /**
     * Directly override the key with component.<\br>
     *
     * @param key
     * @param component
     */
    public void put(K key, V component);

    /**
     * Call to put and inmediatly after to update.
     *
     * @param key
     * @param component
     */
    public default void putUpdate(K key, V component) {
        put(key, component);
        update(getMap());
    }

    /**
     * True if contain an specific key.
     *
     * @param key
     * @return
     */
    public boolean containKey(K key);

    /**
     * Remove the key from the map.<\br>
     *
     * @param key
     * @return
     */
    public boolean removeKey(K key);

    /**
     * Call to removeKey and inmediatly after to update.
     *
     * @param key
     */
    public default void removeKeyUpdate(K key) {
        removeKey(key);
        update(getMap());
    }

    /**
     * Remove all ocurrences of a value, if it's inside a List, remove all
     * ocurrence.
     *
     * @param value
     */
    public void removeValue(V value);

    /**
     * Call to removeValue and inmediatly after to update.
     *
     * @param value
     */
    public default void removeValueUpdate(V value) {
        removeValue(value);
        update(getMap());
    }

    public boolean supportKey(K key);

    public HashMap<String, Object> getMap();

    public void update(HashMap<String, Object> map);

}
