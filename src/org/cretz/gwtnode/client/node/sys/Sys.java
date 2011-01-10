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
package org.cretz.gwtnode.client.node.sys;

import org.cretz.gwtnode.client.JavaScriptFunction;
import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.Global;
import org.cretz.gwtnode.client.node.NodeJsModule;
import org.cretz.gwtnode.client.node.event.ErrorEventHandler;
import org.cretz.gwtnode.client.node.stream.ReadableStream;
import org.cretz.gwtnode.client.node.stream.WriteableStream;

import com.google.gwt.core.client.JavaScriptObject;


public class Sys extends JavaScriptObject implements NodeJsModule  {

    private static Sys instance;
    
    public static Sys get() {
        if (instance == null) {
            instance = Global.get().require("sys");
        }
        return instance;
    }
    
    protected Sys() {
    }
    
    public final native void print(String string) /*-{
        this.print(string);
    }-*/;
    
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
}
