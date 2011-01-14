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

import com.google.common.base.Objects.ToStringHelper;

public class SimpleCommandPacket extends CommandPacket {

    private Buffer data;
    
    public SimpleCommandPacket() {
    }
    
    public SimpleCommandPacket(Buffer buffer) {
        setPacketId(BufferUtils.toInteger(buffer.slice(4, 8)));
        setFlags(buffer.get(8));
        setCommandSet(buffer.get(9));
        setCommand(buffer.get(10));
        if (buffer.length() == 11) {
            data = Buffer.create(0);
        } else {
            data = buffer.slice(11, buffer.length());
        }
    }
    
    public Buffer getData() {
        return data;
    }
    
    public void setData(Buffer data) {
        this.data = data;
    }
    
    @Override
    protected Buffer buildData() {
        return data;
    }
    
    @Override
    protected ToStringHelper toString(ToStringHelper helper) {
        return super.toString(helper).
                add("length", data.length());
    }
}