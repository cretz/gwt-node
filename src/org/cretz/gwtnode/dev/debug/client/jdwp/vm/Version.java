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
package org.cretz.gwtnode.dev.debug.client.jdwp.vm;

import org.cretz.gwtnode.client.Closure;
import org.cretz.gwtnode.client.node.buffer.Buffer;
import org.cretz.gwtnode.dev.debug.client.jdwp.BufferUtils;
import org.cretz.gwtnode.dev.debug.client.jdwp.ReceivingCommand;
import org.cretz.gwtnode.dev.debug.client.jdwp.ReplyPacket;
import org.cretz.gwtnode.dev.debug.client.jdwp.SimpleCommandPacket;

public class Version extends ReceivingCommand<SimpleCommandPacket, ReplyPacket> {

    public static final byte COMMAND = 1;
    
    @Override
    protected SimpleCommandPacket buildCommandPacket(Buffer buffer) {
        return new SimpleCommandPacket(buffer);
    }
    
    @Override
    protected void onCommand(SimpleCommandPacket commandPacket, Closure<ReplyPacket> reply) {
        reply.call(new ReplyPacket() {
            @Override
            protected Buffer buildData() {
                return BufferUtils.concat(
                        BufferUtils.toBuffer("gwt-node 1.0"),
                        BufferUtils.toBuffer(1),
                        BufferUtils.toBuffer(6),
                        BufferUtils.toBuffer("1.6"),
                        BufferUtils.toBuffer("node.js"));
            }
        });
    }
}
