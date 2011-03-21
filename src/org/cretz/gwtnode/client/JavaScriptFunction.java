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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;

/**
 * Simple wrapper for a native JavaScript function
 * 
 * @author Chad Retz
 */
public class JavaScriptFunction extends JavaScriptObject {

    protected JavaScriptFunction() {
    }
    
    public final void apply(Object... arguments) {
        apply(JavaScriptUtils.toMixedArray(arguments));
    }
   
    /**
     * Call this function using 
     * <a href="https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/Function/apply">apply</a>
     * but keeping the regular "this".
     * 
     * @param arguments
     */
    public final native void apply(JsArrayMixed arguments) /*-{
        this.apply(this, arguments);
    }-*/; 
    
    public final void applyLocal(Object newThis, Object... arguments) {
        applyLocal(newThis, JavaScriptUtils.toMixedArray(arguments));
    }
    
    /**
     * Call this function using
     * <a href="https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/Function/apply">apply</a>
     * with the new "this".
     * 
     * @param newThis
     * @param arguments
     */
    public final native void applyLocal(Object newThis, JsArrayMixed arguments) /*-{
        this.apply(newThis, arguments);
    }-*/;
}
