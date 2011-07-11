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
package org.cretz.gwtnode.client.node.querystring;

import org.cretz.gwtnode.client.JavaScriptReturningFunction;
import org.cretz.gwtnode.client.JavaScriptReturningFunctionWrapper;
import org.cretz.gwtnode.client.JsonStringObjectMap;
import org.cretz.gwtnode.client.node.Global;
import org.cretz.gwtnode.client.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.0/api/querystring.html">querystring</a>
 * module.
 *
 * @author Chad Retz
 */
public class QueryString extends JavaScriptObject implements NodeJsModule {

    private static QueryString instance;
    
    public static QueryString get() {
        if (instance == null) {
            instance = Global.get().require("querystring");
        }
        return instance;
    }
    
    protected QueryString() {
    }
    
    public final String stringify(JsonStringObjectMap<String[]> obj) {
        return stringify(obj.getNativeObject());
    }
    
    public final native String stringify(JavaScriptObject obj) /*-{
        return this.stringify(obj);
    }-*/;
    
    public final String stringify(JsonStringObjectMap<String[]> obj, String sep) {
        return stringify(obj.getNativeObject(), sep);
    }
    
    public final native String stringify(JavaScriptObject obj, String sep) /*-{
        return this.stringify(obj, sep);
    }-*/;
    
    public final String stringify(JsonStringObjectMap<String[]> obj, String sep, String eq) {
        return stringify(obj.getNativeObject(), sep, eq);
    }
    
    public final native String stringify(JavaScriptObject obj, String sep, String eq) /*-{
        return this.stringify(obj, sep, eq);
    }-*/;
    
    public final String stringify(JsonStringObjectMap<String[]> obj, String sep,
            String eq, boolean munge) {
        return stringify(obj.getNativeObject(), sep, eq, munge);
    }
    
    public final native String stringify(JavaScriptObject obj, String sep,
            String eq, boolean munge) /*-{
        return this.stringify(obj, sep, eq, munge);
    }-*/;
    
    public final JsonStringObjectMap<String[]> parseAsMap(String str) {
        return new JsonStringObjectMap<String[]>(parse(str));
    }
    
    public final native JavaScriptObject parse(String str) /*-{
        return this.parse(str);
    }-*/;
    
    public final JsonStringObjectMap<String[]> parseAsMap(String str, String sep) {
        return new JsonStringObjectMap<String[]>(parse(str, sep));
    }
    
    public final native JavaScriptObject parse(String str, String sep) /*-{
        return this.parse(str, sep);
    }-*/;
    
    public final JsonStringObjectMap<String[]> parseAsMap(String str, String sep, String eq) {
        return new JsonStringObjectMap<String[]>(parse(str, sep, eq));
    }
    
    public final native JavaScriptObject parse(String str, String sep, String eq) /*-{
        return this.parse(str, sep, eq);
    }-*/;
    
    public final native String escape(String string) /*-{
        return this.escape(string);
    }-*/;
    
    public final void escape(JavaScriptReturningFunctionWrapper<String> func) {
        escape(func.getNativeFunction());
    }
    
    public final native void escape(JavaScriptReturningFunction<String> func) /*-{
        this.escape = func;
    }-*/;
    
    public final native String unescape(String string) /*-{
        return this.unescape(string);
    }-*/;
    
    public final void unescape(JavaScriptReturningFunctionWrapper<String> func) {
        unescape(func.getNativeFunction());
    }
    
    public final native void unescape(JavaScriptReturningFunction<String> func) /*-{
        this.unescape = func;
    }-*/;
}
