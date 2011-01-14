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
package org.cretz.gwtnode.dev.debug.client.jdwp.common;

import java.util.HashMap;
import java.util.Map;

public enum EventKind {

    SINGLE_STEP(1),
    BREAKPOINT(2),
    FRAME_POP(3),
    EXCEPTION(4),
    USER_DEFINED(5),
    THREAD_START(6),
    THREAD_DEATH(7),
    CLASS_PREPARE(8),
    CLASS_UNLOAD(9),
    CLASS_LOAD(10),
    FIELD_ACCESS(20),
    FIELD_MODIFICATION(21),
    EXCEPTION_CATCH(30),
    METHOD_ENTRY(40),  
    METHOD_EXIT(41),
    METHOD_EXIT_WITH_RETURN_VALUE(42),
    MONITOR_CONTENDED_ENTER(43),
    MONITOR_CONTENDED_ENTERED(44),
    MONITOR_WAIT(45),
    MONITOR_WAITED(46),
    VM_START(90),
    VM_DEATH(99),
    VM_DISCONNECTED(100);
    
    private static final Map<Byte, EventKind> kinds = 
        new HashMap<Byte, EventKind>(values().length);
    
    static {
        for (EventKind kind : values()) {
            kinds.put(kind.byt, kind);
        }
    }
    
    public static EventKind fromNumber(byte byt) {
        return kinds.get(byt);
    }
    
    private final byte byt;
    
    private EventKind(int byt) {
        this.byt = (byte) byt;
    }
    
    public byte getByte() {
        return byt;
    }
}
