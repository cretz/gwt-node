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
package org.gwtnode.modules.express.client;

import java.util.Map;
import java.util.Map.Entry;

import org.gwtnode.client.JavaScriptFunction;
import org.gwtnode.client.JavaScriptFunctionWrapper;
import org.gwtnode.client.JsonStringObjectMap;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Chad Retz
 */
public class Server extends JavaScriptObject {

    protected Server() {
    }
    
    public final native void set(String name, Object value) /*-{
        this.set(name, value);
    }-*/;
    
    public final native <T> T set(String name) /*-{
        return this.set(name);
    }-*/;
    
    public final native JavaScriptObject settings() /*-{
        return this.settings;
    }-*/;
    
    public final <T> JsonStringObjectMap<T> settingsMap() {
        return new JsonStringObjectMap<T>(settings());
    }
    
    public final native void enable(String name) /*-{
        this.enable(name);
    }-*/;
    
    public final native boolean enabled(String name) /*-{
        return this.enabled(name);
    }-*/;
    
    public final native void disable(String name) /*-{
        this.disable(name);
    }-*/;
    
    public final native boolean disabled(String name) /*-{
        return this.disabled(name);
    }-*/;
    
    public final void configure(JavaScriptFunctionWrapper func) {
        configure(func.getNativeFunction());
    }
    
    public final native void configure(JavaScriptFunction func) /*-{
        this.configure(func);
    }-*/;
    
    public final void configure(String env, JavaScriptFunctionWrapper func) {
        configure(env, func.getNativeFunction());
    }
    
    public final native void configure(String env, JavaScriptFunction func) /*-{
        this.configure(env, func);
    }-*/;
    
    public final native void redirect(String name, String val) /*-{
        this.redirect(name, val);
    }-*/;
    
    public final void redirect(String name, RequestCallback callback) {
        redirect(name, callback.getNativeFunction());
    }
    
    public final void redirect(String name, JavaScriptFunctionWrapper callback) {
        redirect(name, callback.getNativeFunction());
    }
    
    public final native void redirect(String name, JavaScriptFunction callback) /*-{
        this.redirect(name, callback);
    }-*/;
    
    public final void error(ErrorCallback callback) {
        error(callback.getNativeFunction());
    }
    
    public final void error(JavaScriptFunctionWrapper callback) {
        error(callback.getNativeFunction());
    }
    
    public final native void error(JavaScriptFunction callback) /*-{
        this.error(callback);
    }-*/;
    
    public final void helpers(JsonStringObjectMap<?> map) {
        helpers(map.getNativeObject());
    }
    
    public final native void helpers(JavaScriptObject obj) /*-{
        this.helpers(obj);
    }-*/;
    
    public final void dynamicHelpers(Map<String, RequestCallback> obj) {
        JsonStringObjectMap<JavaScriptFunction> newMap = new JsonStringObjectMap<JavaScriptFunction>();
        for (Entry<String, RequestCallback> callback : obj.entrySet()) {
            newMap.put(callback.getKey(), callback.getValue().getNativeFunction());
        }
        dynamicHelpers(newMap);
    }
    
    public final void dynamicHelpers(JsonStringObjectMap<JavaScriptFunction> obj) {
        dynamicHelpers(obj.getNativeObject());
    }

    public final native void dynamicHelpers(JavaScriptObject obj) /*-{
        this.dynamicHelpers(obj);
    }-*/;
    
    //TODO: the rest
}
