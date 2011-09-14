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
public class ChooseTransportMessage extends Message {

    private final String[] transports;
    
    public ChooseTransportMessage(String... transports) {
        super(MessageType.CHOOSE_TRANSPORT);
        this.transports = transports;
        length += 4;
        for (String transport : transports) {
            length += OophmStream.getStringByteLength(transport);
        }
    }
    
    public ChooseTransportMessage(OophmStream stream) {
        super(MessageType.CHOOSE_TRANSPORT);
        transports = new String[stream.readInt()];
        length += 4;
        for (int i = 0; i < transports.length; i++) {
            transports[i] = stream.readString();
            length += OophmStream.getStringByteLength(transports[i]);
        }
    }
    
    public String[] getTransports() {
        return transports;
    }

    @Override
    public String toString() {
        return super.toString(new StringBuilder()).
                append("transports: ").
                append(Arrays.toString(transports)).toString();
    }
    
    @Override
    public Buffer toBuffer() {
        return new OophmBufferBuilder().
                append(type).
                appendArray(transports).toBuffer();
    }

}
