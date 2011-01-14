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

public enum ErrorConstant {
    
    NONE(0),
    INVALID_THREAD(10),
    INVALID_THREAD_GROUP(11),
    INVALID_PRIORITY(12),
    THREAD_NOT_SUSPENDED(13),
    THREAD_SUSPENDED(14),
    THREAD_NOT_ALIVE(15),
    INVALID_OBJECT(20),
    INVALID_CLASS(21),
    CLASS_NOT_PREPARED(22),
    INVALID_METHODID(23),
    INVALID_LOCATION(24),
    INVALID_FIELDID(25),
    INVALID_FRAMEID(30),
    NO_MORE_FRAMES(31),
    OPAQUE_FRAME(32),
    NOT_CURRENT_FRAME(33),
    TYPE_MISMATCH(34),
    INVALID_SLOT(35),
    DUPLICATE(40),
    NOT_FOUND(41),
    INVALID_MONITOR(50),
    NOT_MONITOR_OWNER(51),
    INTERRUPT(52),
    INVALID_CLASS_FORMAT(60),
    CIRCULAR_CLASS_DEFINITION(61),
    FAILS_VERIFICATION(62),
    ADD_METHOD_NOT_IMPLEMENTED(63),
    SCHEMA_CHANGE_NOT_IMPLEMENTED(64),
    INVALID_TYPESTATE(65),
    HIERARCHY_CHANGE_NOT_IMPLEMENTED(66),
    DELETE_METHOD_NOT_IMPLEMENTED(67),
    UNSUPPORTED_VERSION(68),
    NAMES_DONT_MATCH(69),
    CLASS_MODIFIERS_CHANGE_NOT_IMPLEMENTED(70),
    METHOD_MODIFIERS_CHANGE_NOT_IMPLEMENTED(71),
    NOT_IMPLEMENTED(99),
    NULL_POINTER(100),
    ABSENT_INFORMATION(101),
    INVALID_EVENT_TYPE(102),
    ILLEGAL_ARGUMENT(103),
    OUT_OF_MEMORY(110),
    ACCESS_DENIED(111),
    VM_DEAD(112),
    INTERNAL(113),
    UNATTACHED_THREAD(115),
    INVALID_TAG(500),
    ALREADY_INVOKING(502),
    INVALID_INDEX(503),
    INVALID_LENGTH(504),
    INVALID_STRING(506),
    INVALID_CLASS_LOADER(507),
    INVALID_ARRAY(508),
    TRANSPORT_LOAD(509),
    TRANSPORT_INIT(510),
    NATIVE_METHOD(511),
    INVALID_COUNT(512); 
    
    private static final Map<Integer, ErrorConstant> errors =
        new HashMap<Integer, ErrorConstant>(values().length);
    
    static {
        for (ErrorConstant error : values()) {
            errors.put(error.number, error);
        }
    }
    
    public static ErrorConstant fromNumber(int number) {
        return errors.get(number);
    }
    
    private int number;
    
    private ErrorConstant(int number) {
        this.number = number;
    }
    
    public int getNumber() {
        return number;
    }
}
