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
package org.gwtnode.modules.fibers.client;

import org.gwtnode.client.JavaScriptFunction;
import org.gwtnode.client.JavaScriptFunctionWrapper;
import org.gwtnode.client.JavaScriptReturningFunction;
import org.gwtnode.client.JavaScriptReturningFunctionWrapper;
import org.gwtnode.client.node.Global;
import org.gwtnode.client.node.NodeJsError;
import org.gwtnode.client.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The <a href="https://github.com/laverdet/node-fibers">fiber</a> library
 * 
 * @author Chad Retz
 */
public class Fiber extends JavaScriptObject implements NodeJsModule {

    static {
        @SuppressWarnings("unused")
        Fiber temp = Global.get().require("fibers");
    }
    
    public static Fiber create(FiberCallback func) {
        return create(func.getNativeFunction());
    }
    
    public static Fiber create(JavaScriptFunctionWrapper func) {
        return create(func.getNativeFunction());
    }
    
    public static native Fiber create(JavaScriptFunction func) /*-{
        return Fiber(func);
    }-*/;

    public static Fiber create(FiberReturningCallback<?> func) {
        return create(func.getNativeFunction());
    }
    
    public static Fiber create(JavaScriptReturningFunctionWrapper<?> func) {
        return create(func.getNativeFunction());
    }
    
    public static native Fiber create(JavaScriptReturningFunction<?> func) /*-{
        return Fiber(func);
    }-*/;
    
    public static native Fiber current() /*-{
        return Fiber.current;
    }-*/;
    
    public static native <T> T yield() /*-{
        return Fiber.yield();
    }-*/;
    
    public static native <T> T yield(Object param) /*-{
        return Fiber.yield(param);
    }-*/;
    
    protected Fiber() {
    }
    
    public final native <T> T run() /*-{
        return this.run();
    }-*/;
    
    public final native <T> T run(Object param) /*-{
        return this.run(param);
    }-*/;
    
    public final native <T> T reset() /*-{
        return this.reset();
    }-*/;
    
    public final void throwInfo(NodeJsError error) {
        throwInto((JavaScriptObject) error);
    }
    
    public final native void throwInto(JavaScriptObject exception) /*-{
        this.throwInto(exception);
    }-*/;
}
