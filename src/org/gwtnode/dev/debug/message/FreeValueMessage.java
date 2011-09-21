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
public class FreeValueMessage extends Message {

    private final Integer[] refIds;
    
    public FreeValueMessage(Integer... refIds) {
        super(MessageType.FREE_VALUE);
        this.refIds = refIds;
        length += 4 + (4 * refIds.length);
    }
    
    public FreeValueMessage(OophmStream stream) {
        super(MessageType.FREE_VALUE);
        refIds = new Integer[stream.readInt()];
        length += 4;
        for (int i = 0; i < refIds.length; i++) {
            refIds[i] = stream.readInt();
            length += 4;
        }
    }
    
    public Integer[] getRefIds() {
        return refIds;
    }

    @Override
    public String toString() {
        return super.toString(new StringBuilder()).
                append("refIds: ").
                append(Arrays.toString(refIds)).toString();
    }

    @Override
    public Buffer toBuffer() {
        return new OophmBufferBuilder().
                append(type).
                appendArray(refIds).toBuffer();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Arrays.hashCode(refIds);
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
        FreeValueMessage other = (FreeValueMessage) obj;
        if (!Arrays.equals(refIds, other.refIds)) {
            return false;
        }
        return true;
    }
}
