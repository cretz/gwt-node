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
package org.gwtnode.core.node.util;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.core.JavaScriptUtils;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeModule;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;
import org.gwtnode.core.node.event.ErrorEventHandler;
import org.gwtnode.core.node.stream.ReadableStream;
import org.gwtnode.core.node.stream.WritableStream;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.6/api/util.html">util</a>
 * module.
 * 
 * @author Chad Retz
 */
@GwtNodeModule
public class Util extends JavaScriptObject implements NodeJsModule {

    private static Util instance;
    
    public static Util get() {
        if (instance == null) {
            instance = Global.get().require("util");
        }
        return instance;
    }
    
    protected Util() {
    }
    
    @GwtNodeFunction
    public final String format(Object... params) {
        return formatNative(JavaScriptUtils.toMixedArray(params));
    }
    
    private final native String formatNative(JsArrayMixed params) /*-{
        return this.format.apply(this, params);
    }-*/;

    @GwtNodeFunction
    public final native void debug(String string) /*-{
        this.debug(string);
    }-*/;

    @GwtNodeFunction
    public final native void log(String string) /*-{
        this.log(string);
    }-*/;

    @GwtNodeFunction
    public final native String inspect(JavaScriptObject object) /*-{
        return this.inspect(object);
    }-*/;

    @GwtNodeFunction
    public final native String inspect(JavaScriptObject object, boolean showHidden) /*-{
        return this.inspect(object, showHidden);
    }-*/;

    @GwtNodeFunction
    public final native String inspect(JavaScriptObject object, boolean showHidden, int depth) /*-{
        return this.inspect(object, showHidden, depth);
    }-*/;

    @GwtNodeFunction
    public final native void pump(ReadableStream readableStream, WritableStream writableStream) /*-{
        this.pump(readableStream, writableStream);
    }-*/;

    @GwtNodeFunction
    public final void pump(ReadableStream readableStream, WritableStream writableStream,
            ErrorEventHandler handler) {
        pump(readableStream, writableStream, handler.getNativeFunction());
    }

    @GwtNodeFunction
    public final void pump(ReadableStream readableStream, WritableStream writableStream,
            JavaScriptFunctionWrapper wrapper) {
        pump(readableStream, writableStream, wrapper.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void pump(ReadableStream readableStream, WritableStream writableStream,
            JavaScriptFunction func) /*-{
        this.pump(readableStream, writableStream, func);
    }-*/;

    @GwtNodeFunction
    public final native void inherits(JavaScriptFunction constructor, 
            JavaScriptFunction superConstructor) /*-{
        this.inherits(constructor, superConstructor);
    }-*/;
}
