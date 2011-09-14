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
package org.gwtnode.client.debug.oophm.message;

import org.gwtnode.client.debug.oophm.OophmBufferBuilder;
import org.gwtnode.client.debug.oophm.OophmStream;
import org.gwtnode.client.node.buffer.Buffer;

/**
 * @author Chad Retz
 */
public class InvokeToClientMessage extends InvokeMessage {

    private final String methodName;
    
    public InvokeToClientMessage(String methodName, Value<?> thisValue,
            Value<?>... argValues) {
        super(thisValue, argValues);
        this.methodName = methodName;
        length += OophmStream.getStringByteLength(methodName);
    }
    
    public InvokeToClientMessage(OophmStream stream) {
        super();
        methodName = stream.readString();
        length += OophmStream.getStringByteLength(methodName);
        initThisAndArgs(stream);
    }
    
    public String getMethodName() {
        return methodName;
    }
    
    @Override
    public String toString() {
        return super.toString(new StringBuilder()).
                append(", methodName: ").
                append(methodName).toString();
    }
    
    @Override
    public Buffer toBuffer() {
        return toBuffer(new OophmBufferBuilder().
                append(type).
                append(methodName)).toBuffer();
    }
}
