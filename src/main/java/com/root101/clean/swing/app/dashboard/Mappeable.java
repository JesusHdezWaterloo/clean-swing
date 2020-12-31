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

import java.util.HashMap;

/**
 * 
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 * @param <K>
 * @param <V> 
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

    public void addKeyValue(K key, V value, int pos);

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
     * Remove the all values.<\br>
     *
     */
    public void clear();

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
