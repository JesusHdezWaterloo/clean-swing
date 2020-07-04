package com.clean.swing.app.dashboard;

import java.util.HashMap;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 * @param <K> type of the Key
 * @param <V> type of the Value
 */
public interface Mappeable<K, V> {

    /**
     * Add (key,component) to the map, if the class represented by this key is a
     * List, the component is added to the end of it, if not, override the
     * previous value.<\br>
     *
     * @param key
     * @param value
     */
    public void addKeyValue(K key, V value);

    /**
     * Call to addKeyValue and inmediatly after to update.
     *
     * @param key
     * @param value
     */
    public default void addUpdate(K key, V value) {
        addKeyValue(key, value);
        update(getMap());
    }

    /**
     * Directly override the key with component.<\br>
     *
     * @param key
     * @param value
     */
    public void putKeyValue(K key, V value);

    /**
     * Call to putKeyValue and inmediatly after to update.
     *
     * @param key
     * @param value
     */
    public default void putUpdate(K key, V value) {
        putKeyValue(key, value);
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

    public HashMap<K, V> getMap();

    public void update(HashMap<K, V> map);

}
