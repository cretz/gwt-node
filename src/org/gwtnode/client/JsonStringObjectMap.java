/*
 * Copyright 2011 Chad Retz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtnode.client;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Map for a JSON object that is keyed by string. Counts will
 * not work correctly if the JavaScriptObject is modified outside
 * of this class. Also, do NOT try to modify this collection during 
 * iteration except via {@link Entry#setValue(Object)}. 
 * {@link Iterator#remove()} is NOT supported, even though
 * {@link Map#remove(Object)} is (but not during iteration).
 * 
 * @author Chad Retz
 */
public class JsonStringObjectMap<T> extends AbstractMap<String, T> {
    
    //XXX: It appears that GWT's JSNI 'this' reference doesn't like
    //  non-static inner classes. That's why all my inner classes here
    //  are static
    
    private native int getCount(JavaScriptObject obj) /*-{
        var cnt = 0;
        for (var key in obj) {
            if (obj.hasOwnProperty(key)) {
                cnt++;
            }
        }
        return cnt;
    }-*/;
    
    private final JavaScriptObject map;
    private int count = 0;
    
    public JsonStringObjectMap() {
        this(JavaScriptObject.createObject());
    }
    
    public JsonStringObjectMap(JavaScriptObject map) {
        this.map = map;
        count = getCount(map);
    }

    private void incrementCount() {
        count++;
    }
    
    private void decrementCount() {
        count--;
    }
    
    public JavaScriptObject getNativeObject() {
        return map;
    }
    
    @Override
    public native T put(String key, T value) /*-{
        var map = this.@org.gwtnode.client.JsonStringObjectMap::map;
        if (!map.hasOwnProperty(key)) {
            this.@org.gwtnode.client.JsonStringObjectMap::incrementCount();
        }
        map[key] = value;
    }-*/;
    
    @Override
    public native T get(Object key) /*-{
        var map = this.@org.gwtnode.client.JsonStringObjectMap::map;
        return map[key];
    }-*/;
    
    @Override
    public native boolean containsKey(Object key) /*-{
        var map = this.@org.gwtnode.client.JsonStringObjectMap::map;
        return map[key];
    }-*/;
    
    @Override
    public native T remove(Object key) /*-{
        var map = this.@org.gwtnode.client.JsonStringObjectMap::map;
        var ret = null;
        if (map[key]) {
            ret = map[key];
            delete map[key];
            this.@org.gwtnode.client.JsonStringObjectMap::decrementCount();
        }
        return ret;
    }-*/;
    
    @Override
    public Set<Entry<String, T>> entrySet() {
        return new JsonStringObjectEntrySet<T>(this);
    }
    
    private static class JsonStringObjectEntrySet<T> extends AbstractSet<Entry<String, T>> {

        private final JsonStringObjectMap<T> base;
        
        private JsonStringObjectEntrySet(JsonStringObjectMap<T> base) {
            this.base = base;
        }
        
        @Override
        public Iterator<Entry<String, T>> iterator() {
            return new JsonStringObjectIterator<T>(base.map);
        }

        @Override
        public int size() {
            return base.count;
        }
        
    }
    
    private static class JsonStringObjectIterator<T> implements Iterator<Entry<String, T>> {

        private final JavaScriptObject map;
        private final JsArrayString keys;
        private int index = 0;
        
        private JsonStringObjectIterator(JavaScriptObject map) {
            this.map = map;
            keys = getKeys(map);
        }
        
        private native JsArrayString getKeys(JavaScriptObject obj) /*-{
            var keys = [];
            for (var key in obj) {
                if (obj.hasOwnProperty(key)) {
                    keys.push(key);
                }
            }
            return keys;
        }-*/;
        
        @Override
        public boolean hasNext() {
            return keys.length() > index;
        }

        @Override
        public Entry<String, T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Entry<String, T> ret = new JsonStringObjectEntry<T>(keys.get(index), map);
            index++;
            return ret;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    private static class JsonStringObjectEntry<T> implements Entry<String, T> {

        private final JavaScriptObject map;
        private final String key;
        
        private JsonStringObjectEntry(String key, JavaScriptObject map) {
            this.map = map;
            this.key = key;
        }
        
        @Override
        public String getKey() {
            return key;
        }

        @Override
        public native T getValue() /*-{
            var map = this.@org.gwtnode.client.JsonStringObjectMap.JsonStringObjectEntry::map;
            var key = this.@org.gwtnode.client.JsonStringObjectMap.JsonStringObjectEntry::key;
            return map[key];
        }-*/;

        @Override
        public native T setValue(T value) /*-{
            var map = this.@org.gwtnode.client.JsonStringObjectMap.JsonStringObjectEntry::map;
            var key = this.@org.gwtnode.client.JsonStringObjectMap.JsonStringObjectEntry::key;
            var ret = map[key];
            map[key] = value;
            return ret;
        }-*/;
        
    }
}
