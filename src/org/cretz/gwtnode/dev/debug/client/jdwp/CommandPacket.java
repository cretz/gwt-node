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

public abstract class CommandPacket extends Packet {
    
    private byte commandSet;
    private byte command;
    
    public byte getCommandSet() {
        return commandSet;
    }
    
    public void setCommandSet(byte commandSet) {
        this.commandSet = commandSet;
    }
    
    public byte getCommand() {
        return command;
    }
    
    public void setCommand(byte command) {
        this.command = command;
    }
    
    @Override
    protected Buffer buildHeaderEnd() {
        return Buffer.create(new byte[] { commandSet, command });
    }
    
    @Override
    protected ToStringHelper toString(ToStringHelper helper) {
        return super.toString(helper).
                add("commandSet", commandSet).
                add("command", command);
    }
}
