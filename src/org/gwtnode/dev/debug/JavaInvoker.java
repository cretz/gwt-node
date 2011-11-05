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

import java.util.Stack;

import org.gwtnode.core.JavaScriptFunctionArguments;
import org.gwtnode.core.JavaScriptReturningFunctionWrapper;
import org.gwtnode.core.JavaScriptUtils;
import org.gwtnode.core.node.process.Process;
import org.gwtnode.dev.debug.HostChannel.ReturnMessageCallback;
import org.gwtnode.dev.debug.message.InvokeFromClientMessage;
import org.gwtnode.dev.debug.message.Message;
import org.gwtnode.dev.debug.message.ReturnMessage;
import org.gwtnode.dev.debug.message.Value;
import org.gwtnode.modules.fibers.Fiber;
import org.gwtnode.modules.fibers.FiberReturningCallback;

import com.google.gwt.core.client.JavaScriptException;

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
    private final Stack<Fiber> waitingForReturn = new Stack<Fiber>();
    
    public JavaInvoker(HostChannel channel, SessionHandler handler, int paramCount) {
        this.channel = channel;
        this.handler = handler;
        this.paramCount = paramCount;
    }

    @Override
    public T call(JavaScriptFunctionArguments args) {
        try {
            handler.getLog().debug("Called java invoker for %d params", paramCount);
            //first is the "this" object
            handler.getLog().debug("dispId type: " + args.get(1).getClass());
            Value<?> thisObj = handler.getValueFromJavaScriptObject(args.get(0));
            //second is the dispatch ID
            int dispId = Integer.valueOf(args.get(1).toString());
            handler.getLog().debug("dispId: " + dispId);
            //the rest are arguments
            Value<?>[] argList = new Value<?>[args.length() - 2];
            for (int i = 0; i < argList.length; i++) {
                argList[i] = handler.getValueFromJavaScriptObject(args.get(i + 2));
            }
            //create the fiber and go with the message
            return Fiber.create(new FiberReturningCallback<T>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public T onCreate(Object param) {
                        //push me on the stack
                        waitingForReturn.push(Fiber.current());
                        handler.getLog().debug("Sending invoke from client");
                        //send message
                        channel.sendMessage((InvokeFromClientMessage) param, JavaInvoker.this);
                        handler.getLog().debug("Waiting for response from server");
                        //wait
                        ReturnMessage returnMessage = Fiber.yield();
                        handler.getLog().debug("Got response from server");
                        //handle message
                        if (returnMessage.isException()) {
                            throw new JavaScriptException(handler.getJavaScriptObjectFromValue(
                                    returnMessage.getReturnValue()));
                        } else {
                            return (T) handler.getJavaScriptObjectFromValue(
                                    returnMessage.getReturnValue());
                        }
                    }
                }).<T>run(new InvokeFromClientMessage(dispId, thisObj, argList));
        } catch (Exception e) {
            handler.getLog().error("Error: %s", JavaScriptUtils.
                    appendException(e, new StringBuilder()));
            Process.get().exit();
            //throw new RuntimeException(e);
            return null;
        }
    }

    @Override
    public void onMessage(ReturnMessage message) {
        if (waitingForReturn.isEmpty()) {
            handler.getLog().error("Unexpected return message");
        } else {
            handler.getLog().debug("Letting fiber know I got response from server");
            waitingForReturn.pop().run(message);
        }
    }
}
