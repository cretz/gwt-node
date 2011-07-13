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
package org.gwtnode.client.node.path;

import org.gwtnode.client.JavaScriptFunction;
import org.gwtnode.client.JavaScriptFunctionWrapper;
import org.gwtnode.client.JavaScriptUtils;
import org.gwtnode.client.node.Global;
import org.gwtnode.client.node.NodeJsModule;
import org.gwtnode.client.node.event.BooleanEventHandler;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.0/api/path.html">path</a>
 * module.
 * 
 * @author Chad Retz
 */
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
    
    public final String join(String... paths) {
        return join(JavaScriptUtils.toStringArray(paths));
    }
    
    public final native String join(JsArrayString paths) /*-{
        return this.join.apply(this, paths);
    }-*/;

    public final String resolve(String... to) {
        return resolve(JavaScriptUtils.toStringArray(to));
    }

    public final native String resolve(JsArrayString to) /*-{
        return this.resolve.apply(this, to)
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
    
    public final native void exists(String p) /*-{
        this.exists(p);
    }-*/;
    
    public final void exists(String p, BooleanEventHandler callback) {
        exists(p, callback.getNativeFunction());
    }
    
    public final void exists(String p, JavaScriptFunctionWrapper callback) {
        exists(p, callback.getNativeFunction());
    }
    
    public final native void exists(String p, JavaScriptFunction callback) /*-{
        this.exists(p, callback);
    }-*/;
    
    public final native boolean existsSync(String p) /*-{
        return this.exists(p);
    }-*/;
}
