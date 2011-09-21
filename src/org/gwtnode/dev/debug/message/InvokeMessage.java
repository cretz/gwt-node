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
package org.gwtnode.dev.debug.message;

import java.util.Arrays;

import org.gwtnode.dev.debug.OophmBufferBuilder;
import org.gwtnode.dev.debug.OophmStream;

/**
 * @author Chad Retz
 */
public abstract class InvokeMessage extends Message {

    private Value<?> thisValue;
    private Value<?>[] argValues;
    
    public InvokeMessage(Value<?> thisValue, Value<?>... argValues) {
        super(MessageType.INVOKE);
        this.thisValue = thisValue;
        length += thisValue.getLength();
        this.argValues = argValues;
        length += 4;
        for (Value<?> argValue : argValues) {
            length += argValue.getLength();
        }
    }
    
    public InvokeMessage() {
        super(MessageType.INVOKE);
    }
    
    protected void initThisAndArgs(OophmStream stream) {
        thisValue = stream.readValue();
        length += thisValue.getLength();
        int argCount = stream.readInt();
        length += 4;
        argValues = new Value<?>[argCount];
        for (int i = 0; i < argCount; i++) {
            argValues[i] = stream.readValue();
            length += argValues[i].getLength();
        }
    }

    public Value<?> getThisValue() {
        return thisValue;
    }
    
    public Value<?>[] getArgValues() {
        return argValues;
    }
    
    protected StringBuilder toString(StringBuilder builder) {
        return super.toString(builder).
                append("this: ").
                append(thisValue).
                append(", args: ").
                append(Arrays.toString(argValues));
    }
    
    public OophmBufferBuilder toBuffer(OophmBufferBuilder builder) {
        return builder.
                append(thisValue).
                appendArray(argValues);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Arrays.hashCode(argValues);
        result = prime * result
                + ((thisValue == null) ? 0 : thisValue.hashCode());
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
        InvokeMessage other = (InvokeMessage) obj;
        if (!Arrays.equals(argValues, other.argValues)) {
            return false;
        }
        if (thisValue == null) {
            if (other.thisValue != null) {
                return false;
            }
        } else if (!thisValue.equals(other.thisValue)) {
            return false;
        }
        return true;
    }
}
