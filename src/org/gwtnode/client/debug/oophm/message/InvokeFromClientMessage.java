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
public class InvokeFromClientMessage extends InvokeMessage {

    private final int methodDispatchId;
    
    public InvokeFromClientMessage(int methodDispatchId, Value<?> thisValue,
            Value<?>... argValues) {
        super(thisValue, argValues);
        this.methodDispatchId = methodDispatchId;
        length += 4;
    }
    
    public InvokeFromClientMessage(OophmStream stream) {
        super();
        methodDispatchId = stream.readInt();
        length += 4;
        initThisAndArgs(stream);
    }
    
    public int getMethodDispatchId() {
        return methodDispatchId;
    }
    
    @Override
    public String toString() {
        return toString(new StringBuilder()).
                append(", methodDispatchId: ").
                append(methodDispatchId).toString();
    }
    
    @Override
    public Buffer toBuffer() {
        return super.toBuffer(new OophmBufferBuilder().
                append(type).
                append(methodDispatchId)).toBuffer();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + methodDispatchId;
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
        InvokeFromClientMessage other = (InvokeFromClientMessage) obj;
        if (methodDispatchId != other.methodDispatchId) {
            return false;
        }
        return true;
    }
}
