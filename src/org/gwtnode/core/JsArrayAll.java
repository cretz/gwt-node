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

import com.google.gwt.core.client.JsArrayMixed;

/**
 * Similar to {@link JsArrayMixed} but allows you to store
 * Java objects too
 *
 * @author Chad Retz
 */
public class JsArrayAll extends JsArrayMixed {

    protected JsArrayAll() {
    }
    
    public final native Object get(int index) /*-{
        return this[index] != null ? this[index] : null;
    }-*/;
    
    public final native void push(Object value) /*-{
        this[this.length] = value;
    }-*/;
    
    public final native void set(int index, Object value) /*-{
        this[index] = value;
    }-*/;
    
    public final native Object shift() /*-{
        return this.shift();
    }-*/;
    
    public final native void unshift(Object value) /*-{
        this.unshift(value);
    }-*/;
}
