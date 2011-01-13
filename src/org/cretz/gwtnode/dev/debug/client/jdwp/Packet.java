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
package org.cretz.gwtnode.dev.debug.client.jdwp;

import org.cretz.gwtnode.client.node.buffer.Buffer;

import com.google.common.base.Objects;

public abstract class Packet {
    
    public static final byte FLAG_REPLY_PACKET = (byte) 0x80;
    
    private static int packetCounter = 0;
    
    public static int getNewPacketId() {
        if (packetCounter == Integer.MAX_VALUE) {
            packetCounter = -1;
        }
        return ++packetCounter;
    }
    
    private int packetId;
    private byte flags;
    
    public int getPacketId() {
        return packetId;
    }
    
    public void setPacketId(int packetId) {
        this.packetId = packetId;
    }
    
    public byte getFlags() {
        return flags;
    }
    
    public void setFlags(byte flags) {
        this.flags = flags;
    }
    
    public Buffer buildBuffer() {
        Buffer data = buildData();
        return BufferUtils.concat(
                BufferUtils.toBuffer(11 + data.length()),
                BufferUtils.toBuffer(packetId),
                BufferUtils.toBuffer(flags),
                buildHeaderEnd(),
                data);
    }
    
    /**
     * Must be two byte array
     * 
     * @return
     */
    protected abstract Buffer buildHeaderEnd();
    
    protected abstract Buffer buildData();
    
    protected Objects.ToStringHelper toString(Objects.ToStringHelper helper) {
        return helper.add("id", packetId).
            add("flags", flags);
    }
    
    @Override
    public String toString() {
        return toString(Objects.toStringHelper(this)).toString();
    }
}
