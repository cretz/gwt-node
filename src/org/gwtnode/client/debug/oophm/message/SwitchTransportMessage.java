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
public class SwitchTransportMessage extends Message {

    private final String transport;
    private final String transportArgs;
    
    public SwitchTransportMessage(String transport, String transportArgs) {
        super(MessageType.SWITCH_TRANSPORT);
        this.transport = transport;
        length += OophmStream.getStringByteLength(transport);
        this.transportArgs = transportArgs;
        length += OophmStream.getStringByteLength(transportArgs);
    }
    
    public SwitchTransportMessage(OophmStream stream) {
        super(MessageType.SWITCH_TRANSPORT);
        transport = stream.readString();
        length += OophmStream.getStringByteLength(transport);
        transportArgs = stream.readString();
        length += OophmStream.getStringByteLength(transportArgs);
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
        return new OophmBufferBuilder().
                append(type).
                append(transport).
                append(transportArgs).toBuffer();
    }
}
