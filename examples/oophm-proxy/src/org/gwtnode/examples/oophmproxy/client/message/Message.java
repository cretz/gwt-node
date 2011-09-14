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
package org.gwtnode.examples.oophmproxy.client.message;

/**
 * @author Chad Retz
 */
public abstract class Message {

    private final MessageType type;
    protected int length = 0;
    
    public Message(MessageType type) {
        this.type = type;
        length += 1;
    }
    
    public MessageType getType() {
        return type;
    }
    
    public int getLength() {
        return length;
    }
    
    public abstract String toString();
    
    protected StringBuilder toString(StringBuilder builder) {
        return builder.append(type).append(" - ");
    }
    
}
