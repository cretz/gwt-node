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
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.core.JavaScriptUtils;
import org.gwtnode.core.node.NodeJsError;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;

/**
* A fiber future
*
* @author Chad Retz
*/
public class Future extends JavaScriptObject {
    
    protected Future() {
    }
    
    public final native <T> T get() /*-{
        return this.get();
    }-*/;
    
    public final native void markReturned(Object value) /*-{
        this['return'](value);
    }-*/;
    
    public final native void throwAsReturned(NodeJsError error) /*-{
        this['throw'](error);
    }-*/;
    
    public final native boolean isResolved() /*-{
        return this.isResolved();
    }-*/;
    
    public final native JavaScriptFunction resolver() /*-{
        return this.resolver();
    }-*/;
    
    public final Future resolve(FutureCallback<?> callback) {
        return resolve(callback.getNativeFunction());
    }
    
    public final Future resolve(JavaScriptFunctionWrapper callback) {
        return resolve(callback.getNativeFunction());
    }
    
    public final native Future resolve(JavaScriptFunction callback) /*-{
        return this.resolve(callback);
    }-*/;
    
    public final Future resolveSuccess(FutureSuccessCallback<?> callback) {
        return resolve(callback.getNativeFunction());
    }
    
    public final Future resolveSuccess(JavaScriptFunctionWrapper callback) {
        return resolveSuccess(callback.getNativeFunction());
    }
    
    public final native Future resolveSuccess(JavaScriptFunction callback) /*-{
        return this.resolveSuccess(callback);
    }-*/;
    
    public final native void proxy(Future future) /*-{
        this.proxy(future);
    }-*/;
    
    public final Future proxyErrors(Future... futures) {
        if (futures.length == 1) {
            return proxyErrorsSingleNative(futures[0]);
        } else {
            return proxyErrors(JavaScriptUtils.toMixedArray((Object[]) futures));
        }
    }
    
    private final native Future proxyErrorsSingleNative(Future future) /*-{
        return this.proxyErrors(future);
    }-*/;
    
    public final native Future proxyErrors(JsArrayMixed array) /*-{
        return this.proxyErrors(array);
    }-*/;
    
    public final native <T> T waitForResponse() /*-{
        return this.wait();
    }-*/;
}
