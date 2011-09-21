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

import org.gwtnode.core.node.buffer.Buffer;
import org.gwtnode.dev.debug.OophmBufferBuilder;
import org.gwtnode.dev.debug.OophmStream;

/**
 * @author Chad Retz
 */
public class InvokeSpecialMessage extends Message {

    private final SpecialMethod specialMethod;
    private final Value<?>[] argValues;
    
    public InvokeSpecialMessage(SpecialMethod specialMethod, Value<?>... argValues) {
        super(MessageType.INVOKE_SPECIAL);
        this.specialMethod = specialMethod;
        length++;
        this.argValues = argValues;
        length += 4;
        for (Value<?> argValue : argValues) {
            length += argValue.getLength();
        }
    }
    
    public InvokeSpecialMessage(OophmStream stream) {
        super(MessageType.INVOKE_SPECIAL);
        specialMethod = SpecialMethod.values()[(int) stream.readByte()];
        length += 1;
        argValues = new Value<?>[stream.readInt()];
        length += 4;
        for (int i = 0; i < argValues.length; i++) {
            argValues[i] = stream.readValue();
            length += argValues[i].getLength();
        }
    }
    
    public SpecialMethod getSpecialMethod() {
        return specialMethod;
    }
    
    public Value<?>[] getArgValues() {
        return argValues;
    }

    @Override
    public String toString() {
        return super.toString(new StringBuilder()).
                append("specialMethod: ").
                append(specialMethod).
                append(", args: ").
                append(Arrays.toString(argValues)).toString();
    }

    @Override
    public Buffer toBuffer() {
        return new OophmBufferBuilder().
                append(type).
                append(specialMethod).
                appendArray(argValues).toBuffer();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Arrays.hashCode(argValues);
        result = prime * result
                + ((specialMethod == null) ? 0 : specialMethod.hashCode());
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
        InvokeSpecialMessage other = (InvokeSpecialMessage) obj;
        if (!Arrays.equals(argValues, other.argValues)) {
            return false;
        }
        if (specialMethod != other.specialMethod) {
            return false;
        }
        return true;
    }
}
