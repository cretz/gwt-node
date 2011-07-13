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
package org.gwtnode.client.node.util;

import org.gwtnode.client.JavaScriptFunction;
import org.gwtnode.client.JavaScriptFunctionWrapper;
import org.gwtnode.client.node.Global;
import org.gwtnode.client.node.NodeJsModule;
import org.gwtnode.client.node.event.ErrorEventHandler;
import org.gwtnode.client.node.stream.ReadableStream;
import org.gwtnode.client.node.stream.WriteableStream;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.0/api/util.html">util</a>
 * module.
 * 
 * @author Chad Retz
 */
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
    
    public final native void debug(String string) /*-{
        this.debug(string);
    }-*/;
    
    public final native void log(String string) /*-{
        this.log(string);
    }-*/;
    
    public final native String inspect(JavaScriptObject object) /*-{
        return this.inspect(object);
    }-*/;
    
    public final native String inspect(JavaScriptObject object, boolean showHidden) /*-{
        return this.inspect(object, showHidden);
    }-*/;
    
    public final native String inspect(JavaScriptObject object, boolean showHidden, int depth) /*-{
        return this.inspect(object, showHidden, depth);
    }-*/;
    
    public final native void pump(ReadableStream readableStream, WriteableStream writeableStream) /*-{
        this.pump(readableStream, writeableStream);
    }-*/;
    
    public final void pump(ReadableStream readableStream, WriteableStream writeableStream,
            ErrorEventHandler handler) {
        pump(readableStream, writeableStream, handler.getNativeFunction());
    }
    
    public final void pump(ReadableStream readableStream, WriteableStream writeableStream,
            JavaScriptFunctionWrapper wrapper) {
        pump(readableStream, writeableStream, wrapper.getNativeFunction());
    }
    
    public final native void pump(ReadableStream readableStream, WriteableStream writeableStream,
            JavaScriptFunction func) /*-{
        this.pump(readableStream, writeableStream, func);
    }-*/;
    
    public final native void inherits(JavaScriptFunction constructor, 
            JavaScriptFunction superConstructor) /*-{
        this.inherits(constructor, superConstructor);
    }-*/;
}
