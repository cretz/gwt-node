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
        return super.toBuffer(new OophmBufferBuilder().
                append(type).
                append(methodName)).toBuffer();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((methodName == null) ? 0 : methodName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        InvokeToClientMessage other = (InvokeToClientMessage) obj;
        if (methodName == null) {
            if (other.methodName != null) {
                return false;
            }
        } else if (!methodName.equals(other.methodName)) {
            return false;
        }
        return true;
    }
}
