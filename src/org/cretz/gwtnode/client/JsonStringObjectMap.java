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
package org.cretz.gwtnode.client;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Map for a JSON object that is {string : string}. Counts will
 * not work correctly if the JavaScriptObject is modified outside
 * of this class. Also, do NOT try to modify this collection during 
 * iteration except via {@link Entry#setValue(Object)}. 
 * {@link Iterator#remove()} is NOT supported, even though
 * {@link Map#remove(Object)} is (but not during iteration).
 * 
 * @author Chad Retz
 */
public class JsonStringObjectMap extends AbstractMap<String, String> {
    
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
    
    @Override
    public native String put(String key, String value) /*-{
        var map = this.@org.cretz.gwtnode.client.JsonStringObjectMap::map;
        if (!map.hasOwnProperty(key)) {
            this.@org.cretz.gwtnode.client.JsonStringObjectMap::incrementCount();
        }
        map[key] = value;
    }-*/;
    
    @Override
    public native String get(Object key) /*-{
        var map = this.@org.cretz.gwtnode.client.JsonStringObjectMap::map;
        return map[key];
    }-*/;
    
    @Override
    public native boolean containsKey(Object key) /*-{
        var map = this.@org.cretz.gwtnode.client.JsonStringObjectMap::map;
        return map[key];
    }-*/;
    
    @Override
    public native String remove(Object key) /*-{
        var map = this.@org.cretz.gwtnode.client.JsonStringObjectMap::map;
        if (map[key]) {
            delete map[key];
            this.@org.cretz.gwtnode.client.JsonStringObjectMap::decrementCount();
        }
    }-*/;
    
    @Override
    public Set<Entry<String, String>> entrySet() {
        return new JsonStringObjectEntrySet();
    }
    
    private class JsonStringObjectEntrySet extends AbstractSet<Entry<String, String>> {

        @Override
        public Iterator<Entry<String, String>> iterator() {
            return new JsonStringObjectIterator();
        }

        @Override
        public int size() {
            return count;
        }
        
    }
    
    private class JsonStringObjectIterator implements Iterator<Entry<String, String>> {

        private JsArrayString keys;
        private int index;
        
        private JsonStringObjectIterator() {
            keys = getKeys();
        }
        
        private native JsArrayString getKeys() /*-{
            var obj = this.@org.cretz.gwtnode.client.JsonStringObjectMap::map;
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
            return keys.length() < index;
        }

        @Override
        public Entry<String, String> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return new JsonStringObjectEntry(keys.get(++index));
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    private class JsonStringObjectEntry implements Entry<String, String> {

        private final String key;
        
        private JsonStringObjectEntry(String key) {
            this.key = key;
        }
        
        @Override
        public String getKey() {
            return key;
        }

        @Override
        public native String getValue() /*-{
            var map = this.@org.cretz.gwtnode.client.JsonStringObjectMap::map;
            var key = this.@org.cretz.gwtnode.client.JsonStringObjectMap.JsonStringObjectEntry::key;
            return map[key];
        }-*/;

        @Override
        public native String setValue(String value) /*-{
            var map = this.@org.cretz.gwtnode.client.JsonStringObjectMap::map;
            var key = this.@org.cretz.gwtnode.client.JsonStringObjectMap.JsonStringObjectEntry::key;
            var ret = map[key];
            map[key] = value;
            return ret;
        }-*/;
        
    }
}
