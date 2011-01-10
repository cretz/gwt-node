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
package org.cretz.gwtnode.client.node.path;

import org.cretz.gwtnode.client.JavaScriptFunction;
import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.Global;
import org.cretz.gwtnode.client.node.NodeJsModule;
import org.cretz.gwtnode.client.node.event.BooleanEventHandler;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class Path extends JavaScriptObject implements NodeJsModule {

    private static Path instance;
    
    public static Path get() {
        if (instance == null) {
            instance = Global.get().require("path");
        }
        return instance;
    }
    
    protected Path() {
    }
    
    public final native String join(String... paths) /*-{
        return this.join.apply(this, paths);
    }-*/;
    
    public final native String join(JsArrayString paths) /*-{
        return this.join.apply(this, paths);
    }-*/;
    
    public final native String[] normalizeArray(String... arr) /*-{
        return this.normalizeArray.apply(this, arr);
    }-*/;
    
    public final native JsArrayString normalizeArray(JsArrayString arr) /*-{
        return this.normalizeArray.apply(this, arr);
    }-*/;
    
    public final native String normalize(String p) /*-{
        return this.normalize(p);
    }-*/;
    
    public final native String dirname(String p) /*-{
        return this.dirname(p);
    }-*/;
    
    public final native String basename(String p) /*-{
        return this.basename(p);
    }-*/;
    
    public final native String basename(String p, String ext) /*-{
        return this.basename(p, ext);
    }-*/;
    
    public final native String extname(String p) /*-{
        return this.extname(p);
    }-*/;
    
    public final native boolean exists(String p) /*-{
        return this.exists(p);
    }-*/;
    
    public final void exists(String p, BooleanEventHandler callback) {
        exists(p, callback.getNativeFunction());
    }
    
    public final void exists(String p, JavaScriptFunctionWrapper callback) {
        exists(p, callback.getNativeFunction());
    }
    
    public final native void exists(String p, JavaScriptFunction callback) /*-{
        return this.exists(p, callback);
    }-*/;
}
