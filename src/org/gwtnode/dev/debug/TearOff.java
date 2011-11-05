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
package org.gwtnode.dev.debug;

import org.gwtnode.core.JavaScriptFunctionArguments;
import org.gwtnode.core.JavaScriptReturningFunction;
import org.gwtnode.core.JavaScriptReturningFunctionWrapper;
import org.gwtnode.core.JavaScriptUtils;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;

/**
 * Tear off
 * 
 * @author Chad Retz
 */
class TearOff<T> extends 
        JavaScriptReturningFunctionWrapper<JavaScriptReturningFunction<T>> {

    private final HostChannel channel;
    private final SessionHandler handler;
    private final int paramCount;
    
    public TearOff(HostChannel channel, SessionHandler handler, int paramCount) {
        this.channel = channel;
        this.handler = handler;
        this.paramCount = paramCount;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public JavaScriptReturningFunction<T> call(
            JavaScriptFunctionArguments args) {
        final int dispId = Integer.valueOf(args.get(1).toString());
        return new JavaScriptReturningFunctionWrapper<T>() {
            @Override
            public T call(JavaScriptFunctionArguments args) {
                Object[] newArgs = new Object[args.length() + 2];
                newArgs[0] = dispId;
                newArgs[1] = getNativeFunction();
                for (int i = 0; i < paramCount; i++) {
                    newArgs[i + 2] = args.get(0);
                }
                JsArrayMixed array = getStatic().apply(newArgs).cast();
                if (array.getBoolean(0)) {
                    JavaScriptUtils.throwJavaScriptObject(
                            array.getObject(1));
                    //won't get here
                    throw new RuntimeException("Error");
                } else {
                    return (T) array.getObject(1);
                }
            }
        }.getNativeFunction();
    }
    
    private native JavaScriptReturningFunction<JavaScriptObject> getStatic() /*-{
        return __static;
    }-*/;
}
