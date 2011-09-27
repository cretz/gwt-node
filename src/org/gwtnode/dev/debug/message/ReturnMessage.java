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

import org.gwtnode.core.node.buffer.Buffer;
import org.gwtnode.dev.debug.BufferBuilder;
import org.gwtnode.dev.debug.BufferStream;

/**
 * @author Chad Retz
 */
public class ReturnMessage extends Message {

    private final boolean exception;
    private final Value<?> returnValue;
    
    public ReturnMessage(boolean exception, Value<?> returnValue) {
        super(MessageType.RETURN);
        this.exception = exception;
        length++;
        this.returnValue = returnValue;
        length += returnValue.getLength();
    }
    
    public ReturnMessage(BufferStream stream) {
        super(MessageType.RETURN);
        exception = stream.readBoolean();
        length += 1;
        returnValue = stream.readValue();
        length += returnValue.getLength();
    }
    
    public boolean isException() {
        return exception;
    }
    
    public Value<?> getReturnValue() {
        return returnValue;
    }
    
    @Override
    public String toString() {
        return super.toString(new StringBuilder()).
                append("exception: ").
                append(exception).
                append(", returnValue: ").
                append(returnValue).toString();
    }

    @Override
    public Buffer toBuffer() {
        return new BufferBuilder().
                append(type).
                append(exception).
                append(returnValue).toBuffer();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (exception ? 1231 : 1237);
        result = prime * result
                + ((returnValue == null) ? 0 : returnValue.hashCode());
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
        ReturnMessage other = (ReturnMessage) obj;
        if (exception != other.exception) {
            return false;
        }
        if (returnValue == null) {
            if (other.returnValue != null) {
                return false;
            }
        } else if (!returnValue.equals(other.returnValue)) {
            return false;
        }
        return true;
    }
}
