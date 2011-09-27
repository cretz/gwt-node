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
public class SwitchTransportMessage extends Message {

    private final String transport;
    private final String transportArgs;
    
    public SwitchTransportMessage(String transport, String transportArgs) {
        super(MessageType.SWITCH_TRANSPORT);
        this.transport = transport;
        length += BufferStream.getStringByteLength(transport);
        this.transportArgs = transportArgs;
        length += BufferStream.getStringByteLength(transportArgs);
    }
    
    public SwitchTransportMessage(BufferStream stream) {
        super(MessageType.SWITCH_TRANSPORT);
        transport = stream.readString();
        length += BufferStream.getStringByteLength(transport);
        transportArgs = stream.readString();
        length += BufferStream.getStringByteLength(transportArgs);
    }
    
    public String getTransport() {
        return transport;
    }
    
    public String getTransportArgs() {
        return transportArgs;
    }

    @Override
    public String toString() {
        return super.toString(new StringBuilder()).
                append("transport: ").
                append(transport).
                append(", transportArgs: ").
                append(transportArgs).toString();
    }

    @Override
    public Buffer toBuffer() {
        return new BufferBuilder().
                append(type).
                append(transport).
                append(transportArgs).toBuffer();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((transport == null) ? 0 : transport.hashCode());
        result = prime * result
                + ((transportArgs == null) ? 0 : transportArgs.hashCode());
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
        SwitchTransportMessage other = (SwitchTransportMessage) obj;
        if (transport == null) {
            if (other.transport != null) {
                return false;
            }
        } else if (!transport.equals(other.transport)) {
            return false;
        }
        if (transportArgs == null) {
            if (other.transportArgs != null) {
                return false;
            }
        } else if (!transportArgs.equals(other.transportArgs)) {
            return false;
        }
        return true;
    }
}
