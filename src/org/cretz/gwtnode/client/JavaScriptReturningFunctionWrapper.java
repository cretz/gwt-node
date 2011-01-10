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
package org.cretz.gwtnode.client;

/**
 * Wrapper around {@link JavaScriptReturningFunction} that can
 * be extended to override {@link #call(Object...)}
 * and handle it in Java.
 * 
 * @author Chad Retz
 */
public abstract class JavaScriptReturningFunctionWrapper<T> {

    /**
     * Method to override to implement this JavaScript
     * function in Java
     * 
     * @param arguments
     */
    public abstract T call(Object... arguments);
    
    /**
     * Get a reference to the native {@link JavaScriptReturningFunction}
     * 
     * @return
     */
    public final native JavaScriptReturningFunction<T> getNativeFunction() /*-{
        return this.@org.cretz.gwtnode.client.JavaScriptReturningFunctionWrapper::call([Ljava/lang/Object;);
    }-*/;
}
