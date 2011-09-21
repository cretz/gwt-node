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
package org.gwtnode.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Wrapper around {@link JavaScriptReturningFunction} that can
 * be extended to override {@link #call(JavaScriptFunctionArguments)}
 * and handle it in Java.
 * 
 * @author Chad Retz
 */
public abstract class JavaScriptReturningFunctionWrapper<T> {

    private final JavaScriptObject subObj = JavaScriptObject.createObject();
    
    /**
     * Method to override to implement this JavaScript
     * function in Java.
     * 
     * @param args
     */
    public abstract T call(JavaScriptFunctionArguments args);
    
    /**
     * Get a reference to the native {@link JavaScriptReturningFunction}
     * 
     * @return The native JavaScriptReturningFunction
     */
    public final native JavaScriptReturningFunction<T> getNativeFunction() /*-{
        var subObj = this.@org.gwtnode.core.JavaScriptReturningFunctionWrapper::subObj;
        if (!subObj.func) {
            var wrapper = this;
            subObj.func = function() {
                return wrapper.@org.gwtnode.core.JavaScriptReturningFunctionWrapper::call(Lorg/gwtnode/core/JavaScriptFunctionArguments;)(arguments);
            }
        }
        return subObj.func;
    }-*/;
}
