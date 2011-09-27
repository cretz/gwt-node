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
import org.gwtnode.core.JavaScriptReturningFunctionWrapper;
import org.gwtnode.dev.debug.HostChannel.ReturnMessageCallback;
import org.gwtnode.dev.debug.message.InvokeFromClientMessage;
import org.gwtnode.dev.debug.message.ReturnMessage;
import org.gwtnode.dev.debug.message.Value;
import org.gwtnode.modules.fibers.Fiber;
import org.gwtnode.modules.fibers.FiberCallback;
import org.gwtnode.modules.fibers.FiberReturningCallback;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Invoker for Java executions
 *
 * @author Chad Retz
 */
@SuppressWarnings("unused")
class JavaInvoker<T> extends JavaScriptReturningFunctionWrapper<T> implements ReturnMessageCallback {

    private final HostChannel channel;
    private final SessionHandler handler;
    private final int paramCount;
    private ReturnMessage returnMessage;
    
    public JavaInvoker(HostChannel channel, SessionHandler handler, int paramCount) {
        this.channel = channel;
        this.handler = handler;
        this.paramCount = paramCount;
    }

    @Override
    public T call(JavaScriptFunctionArguments args) {
        //first is the "this" object
        Value<?> thisObj = handler.getValueFromJavaScriptObject(args.get(0));
        //second is the dispatch ID
        int dispId = (Integer) args.get(1);
        //the rest are arguments
        Value<?>[] argList = new Value<?>[args.length() - 2];
        for (int i = 0; i < argList.length; i++) {
            argList[i] = handler.getValueFromJavaScriptObject(args.get(i + 2));
        }
        InvokeFromClientMessage message = new InvokeFromClientMessage(dispId, thisObj, argList);
        channel.sendMessage(message, this);
        //ok, here's where I want to wait...
        return Fiber.create(new FiberReturningCallback<T>() {
            @Override
            @SuppressWarnings("unchecked")
            public T onCreate(Object param) {
                //meh, no param
                //TODO: do proper setTimeout/nextTick/yield things to check the returnMessage, kthxbai
                while (returnMessage == null) {
                    //blah blah blah
                }
                if (returnMessage.isException()) {
                    throw new JavaScriptException(handler.getJavaScriptObjectFromValue(
                            returnMessage.getReturnValue()));
                } else {
                    return (T) handler.getJavaScriptObjectFromValue(
                            returnMessage.getReturnValue());
                }
            }
        }).run();
    }

    @Override
    public void onMessage(ReturnMessage message) {
        this.returnMessage = message;
    }
}
