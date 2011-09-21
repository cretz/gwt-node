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
public class UserAgentIconMessage extends Message {

    private final Byte[] iconBytes;
    
    public UserAgentIconMessage(Byte... iconBytes) {
        super(MessageType.USER_AGENT_ICON);
        this.iconBytes = iconBytes;
        length += 4 + iconBytes.length;
    }
    
    public UserAgentIconMessage(OophmStream stream) {
        super(MessageType.USER_AGENT_ICON);
        iconBytes = new Byte[stream.readInt()];
        length += 4;
        for (int i = 0; i < iconBytes.length; i++) {
            iconBytes[i] = stream.readByte();
        }
        length += iconBytes.length;
    }
    
    public Byte[] getIconBytes() {
        return iconBytes;
    }

    @Override
    public String toString() {
        return super.toString(new StringBuilder()).
                append("iconByteLength: ").
                append(iconBytes.length).toString();
    }

    @Override
    public Buffer toBuffer() {
        return new OophmBufferBuilder().
                append(type).
                append(iconBytes).toBuffer();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Arrays.hashCode(iconBytes);
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
        UserAgentIconMessage other = (UserAgentIconMessage) obj;
        if (!Arrays.equals(iconBytes, other.iconBytes)) {
            return false;
        }
        return true;
    }
}
