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
package org.cretz.gwtnode.dev.debug.client.jdwp.er;

import java.util.ArrayList;
import java.util.List;

import org.cretz.gwtnode.client.node.buffer.Buffer;
import org.cretz.gwtnode.dev.debug.client.jdwp.BufferUtils;
import org.cretz.gwtnode.dev.debug.client.jdwp.SimpleCommandPacket;
import org.cretz.gwtnode.dev.debug.client.jdwp.common.EventKind;
import org.cretz.gwtnode.dev.debug.client.jdwp.common.ModifierKind;
import org.cretz.gwtnode.dev.debug.client.jdwp.er.mod.Modifier;

public class SetCommandPacket extends SimpleCommandPacket {

    private EventKind eventKind;
    private byte suspendPolicy;
    private final List<Modifier> modifiers;
    
    public SetCommandPacket() {
        modifiers = new ArrayList<Modifier>();
    }
    
    public SetCommandPacket(Buffer buffer) {
        super(buffer);
        Buffer data = getData();
        eventKind = EventKind.fromNumber(data.get(0));
        suspendPolicy = data.get(1);
        int modCount = BufferUtils.toInteger(buffer.slice(2, 6));
        modifiers = new ArrayList<Modifier>(modCount);
        int cursor = 6;
        for (int i = 0; i < modCount; i++) {
            cursor = ModifierKind.applyNextModifier(buffer, cursor, modifiers);
        }
    }

    public EventKind getEventKind() {
        return eventKind;
    }
    
    public void setEventKind(EventKind eventKind) {
        this.eventKind = eventKind;
    }
    
    public byte getSuspendPolicy() {
        return suspendPolicy;
    }
    
    public void setSuspendPolicy(byte suspendPolicy) {
        this.suspendPolicy = suspendPolicy;
    }
    
    public List<Modifier> getModifiers() {
        return modifiers;
    }
}
