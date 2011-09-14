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
public class RequestIconMessage extends Message {

    public RequestIconMessage() {
        super(MessageType.REQUEST_ICON);
    }
    
    public RequestIconMessage(OophmStream stream) {
        super(MessageType.REQUEST_ICON);
    }

    @Override
    public String toString() {
        return super.toString(new StringBuilder()).toString();
    }

    @Override
    public Buffer toBuffer() {
        return new OophmBufferBuilder().
                append(type).toBuffer();
    }
}
