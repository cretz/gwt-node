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
import org.cretz.gwtnode.dev.debug.client.jdwp.BufferUtils;
import org.cretz.gwtnode.dev.debug.client.jdwp.common.ClassStatus;
import org.cretz.gwtnode.dev.debug.client.jdwp.common.EventKind;
import org.cretz.gwtnode.dev.debug.client.jdwp.common.TypeTag;

public class ClassPrepareEvent extends Event {
    
    private int threadId;
    private TypeTag typeTag;
    private int referenceTypeId;
    private String signature;
    private ClassStatus status;
    
    {
        setEventKind(EventKind.CLASS_PREPARE);
    }
    
    public int getThreadId() {
        return threadId;
    }
    
    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }
    
    public TypeTag getTypeTag() {
        return typeTag;
    }
    
    public void setTypeTag(TypeTag typeTag) {
        this.typeTag = typeTag;
    }
    
    public int getReferenceTypeId() {
        return referenceTypeId;
    }
    
    public void setReferenceTypeId(int referenceTypeId) {
        this.referenceTypeId = referenceTypeId;
    }
    
    public String getSignature() {
        return signature;
    }
    
    public void setSignature(String signature) {
        this.signature = signature;
    }
    
    public ClassStatus getStatus() {
        return status;
    }
    
    public void setStatus(ClassStatus status) {
        this.status = status;
    }

    @Override
    protected Buffer buildEventBuffer() {
        return BufferUtils.concat(
                BufferUtils.toBuffer(threadId),
                Buffer.create(typeTag.getByte()),
                BufferUtils.toBuffer(referenceTypeId),
                BufferUtils.toBuffer(signature),
                BufferUtils.toBuffer(status.getNumber()));
    }

}
