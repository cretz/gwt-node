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
package org.cretz.gwtnode.dev.debug.client.jdwp.ec.event;

import org.cretz.gwtnode.client.node.buffer.Buffer;
import org.cretz.gwtnode.dev.debug.client.jdwp.BufferBuilder;
import org.cretz.gwtnode.dev.debug.client.jdwp.BufferUtils;
import org.cretz.gwtnode.dev.debug.client.jdwp.common.EventKind;

public abstract class Event implements BufferBuilder {

    private EventKind eventKind;
    private int requestId;
    
    public EventKind getEventKind() {
        return eventKind;
    }
    
    public void setEventKind(EventKind eventKind) {
        this.eventKind = eventKind;
    }
    
    public int getRequestId() {
        return requestId;
    }
    
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
    
    public Buffer buildBuffer() {
        return BufferUtils.concat(Buffer.create(eventKind.getByte()),
                BufferUtils.toBuffer(requestId),
                buildEventBuffer());
    }
    
    /**
     * Without the eventKind or requestId
     * 
     * @return
     */
    protected abstract Buffer buildEventBuffer();
}
