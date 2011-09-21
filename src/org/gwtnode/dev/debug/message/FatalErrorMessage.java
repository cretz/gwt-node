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
import org.gwtnode.dev.debug.OophmBufferBuilder;
import org.gwtnode.dev.debug.OophmStream;

/**
 * @author Chad Retz
 */
public class FatalErrorMessage extends Message {

    private final String error;
    
    public FatalErrorMessage(String error) {
        super(MessageType.FATAL_ERROR);
        this.error = error;
        length += OophmStream.getStringByteLength(error);
    }
    
    public FatalErrorMessage(OophmStream stream) {
        super(MessageType.FATAL_ERROR);
        error = stream.readString();
        length += OophmStream.getStringByteLength(error);
    }
    
    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return super.toString(new StringBuilder()).
                append("error: ").
                append(error).toString();
    }

    @Override
    public Buffer toBuffer() {
        return new OophmBufferBuilder().
                append(type).
                append(error).toBuffer();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((error == null) ? 0 : error.hashCode());
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
        FatalErrorMessage other = (FatalErrorMessage) obj;
        if (error == null) {
            if (other.error != null) {
                return false;
            }
        } else if (!error.equals(other.error)) {
            return false;
        }
        return true;
    }
}
