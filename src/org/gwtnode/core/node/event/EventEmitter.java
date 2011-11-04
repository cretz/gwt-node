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
package org.gwtnode.core.node.event;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.core.JavaScriptUtils;
import org.gwtnode.core.meta.GwtNodeEvent;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeModule;
import org.gwtnode.core.meta.GwtNodeObject;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;

/**
 * The node.js 
 * <a href="http://nodejs.org/docs/v0.5.6/api/events.html">EventEmitter</a>
 * 
 * @author Chad Retz
 */
@GwtNodeObject
@GwtNodeModule("events")
public class EventEmitter extends JavaScriptObject {

    private static EventEmitter instance;
    
    private static final native EventEmitter getNative() /*-{
        return require('events').EventEmitter;
    }-*/;
    
    public static EventEmitter get() {
        if (instance == null) {
            instance = getNative();
        }
        return instance;
    }
    
    protected EventEmitter() {
    }
    
    @GwtNodeEvent
    public final void onNewListener(NewListenerEventHandler handler) {
        on("newListener", handler);
    }

    @GwtNodeFunction
    public final void on(String event, JavaScriptFunctionWrapper wrapper) {
        on(event, wrapper.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void on(String event, JavaScriptFunction func) /*-{
        this.on(event, func);
    }-*/;

    @GwtNodeFunction
    public final void once(String event, JavaScriptFunctionWrapper wrapper) {
        once(event, wrapper.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void once(String event, JavaScriptFunction func) /*-{
        this.once(event, func);
    }-*/;

    @GwtNodeFunction
    public final void removeListener(String event, JavaScriptFunctionWrapper listener) {
        removeListener(event, listener.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void removeListener(String event, JavaScriptFunction func) /*-{
        this.removeListener(event, func);
    }-*/;

    @GwtNodeFunction
    public final native void removeAllListeners(String event) /*-{
        this.removeAllListeners(event);
    }-*/;

    @GwtNodeFunction
    public final native void setMaxListeners(int n) /*-{
        this.setMaxListeners(n);
    }-*/;

    @GwtNodeFunction
    public final native JsArray<JavaScriptFunction> listeners(String event) /*-{
        return this.listeners(event);
    }-*/;

    @GwtNodeFunction
    public final void emit(String event, Object... arguments) {
        JsArrayMixed args = JavaScriptObject.createArray().cast();
        JavaScriptUtils.addToArray(args, event);
        for (Object argument : arguments) {
            JavaScriptUtils.addToArray(args, argument);
        }
        emitNative(args);
    }

    private final native void emitNative(JsArrayMixed arguments) /*-{
        this.emit.apply(this, arguments);
    }-*/;
}
