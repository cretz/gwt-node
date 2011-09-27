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
package org.gwtnode.modules.fibers;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.JavaScriptReturningFunction;
import org.gwtnode.core.JavaScriptUtils;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;

/**
 * The future module
 *
 * @author Chad Retz
 */
public class FutureModule extends JavaScriptObject implements NodeJsModule {

    private static FutureModule instance;
    
    public static FutureModule get() {
        if (instance == null) {
            instance = Global.get().require("fibers/future");
        }
        return instance;
    }
    
    protected FutureModule() {
        
    }
    
    public static native JavaScriptReturningFunction<Future> wrap(JavaScriptFunction func) /*-{
        return this.wrap(func);
    }-*/;
    
    public static void wait(JavaScriptReturningFunction<Future>... futures) {
        wait(JavaScriptUtils.toMixedArray((Object[]) futures));
    }
    
    public static native void wait(JsArrayMixed futures) /*-{
        this.wait(futures);
    }-*/;

}
