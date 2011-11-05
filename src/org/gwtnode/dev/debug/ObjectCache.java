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
package org.gwtnode.dev.debug;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Simple cache for Java and JS objects by IDs
 *
 * @author Chad Retz
 */
class ObjectCache {

    private final Map<Integer, JavaScriptObject> javaObjectsById = 
            new HashMap<Integer, JavaScriptObject>();
    private final Map<JavaScriptObject, Integer> javaIdsByObject =
            new HashMap<JavaScriptObject, Integer>();
    private final Set<Integer> javaObjectsToFree = new HashSet<Integer>();
    private final Map<Integer, JavaScriptObject> jsObjectsById = 
            new HashMap<Integer, JavaScriptObject>();
    private final Map<JavaScriptObject, Integer> jsIdsByObject =
            new HashMap<JavaScriptObject, Integer>();
    private int jsObjectCounter = 0;

    public ObjectCache() {
    }
    
    public void freeJavaObject(int id) {
        JavaScriptObject object = javaObjectsById.remove(id);
        if (object != null) {
            javaIdsByObject.remove(object);
        }
        javaObjectsToFree.add(id);
    }
    
    public Set<Integer> getJavaObjectsToFree() {
        return javaObjectsToFree;
    }
    
    public void clearJavaObjectsToFree() {
        javaObjectsToFree.clear();
    }
    
    public Integer getJavaObjectId(JavaScriptObject javaObjectReference) {
        return javaIdsByObject.get(javaObjectReference);
    }
    
    public JavaScriptObject getJavaObjectReference(int id, boolean create) {
        JavaScriptObject ref = javaObjectsById.get(id);
        if (ref == null) {
            if (!create) {
                throw new DebugRuntimeException("Unable to find Java object by ID: " + id);
            }
            ref = JavaScriptObject.createObject();
            javaObjectsById.put(id, ref);
            javaIdsByObject.put(ref, id);
        }
        return ref;
    }
    
    public void freeJavaScriptObject(int id) {
        JavaScriptObject object = jsObjectsById.remove(id);
        if (object != null) {
            jsIdsByObject.remove(object);
        }
    }
    
    public int getJavaScriptObjectId(JavaScriptObject jsObject, boolean create) {
        Integer id = jsIdsByObject.get(jsObject);
        if (id == null) {
            if (!create) {
                throw new DebugRuntimeException("Unable to find ID for JS object: " + jsObject);
            }
            do {
                id = ++jsObjectCounter;
                if (jsObjectCounter == Integer.MAX_VALUE) {
                    jsObjectCounter = 0;
                }
            } while (!jsObjectsById.containsKey(id));
            jsObjectsById.put(id, jsObject);
            jsIdsByObject.put(jsObject, id);
        }
        return id;
    }
    
    public JavaScriptObject getJavaScriptObject(int id) {
        return jsObjectsById.get(id);
    }
}
