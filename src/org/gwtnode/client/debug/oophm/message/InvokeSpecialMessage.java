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

import java.util.Arrays;

import org.gwtnode.client.debug.oophm.OophmBufferBuilder;
import org.gwtnode.client.debug.oophm.OophmStream;
import org.gwtnode.client.node.buffer.Buffer;

/**
 * @author Chad Retz
 */
public class InvokeSpecialMessage extends Message {

    private final byte specialMethod;
    private final Value<?>[] argValues;
    
    public InvokeSpecialMessage(byte specialMethod, Value<?>... argValues) {
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
        specialMethod = stream.readByte();
        length += 1;
        argValues = new Value<?>[stream.readInt()];
        length += 4;
        for (int i = 0; i < argValues.length; i++) {
            argValues[i] = stream.readValue();
            length += argValues[i].getLength();
        }
    }
    
    public byte getSpecialMethod() {
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
}
