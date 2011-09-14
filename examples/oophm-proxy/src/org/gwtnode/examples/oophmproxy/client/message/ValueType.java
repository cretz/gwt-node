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
public enum ValueType {
    NULL {
        @Override
        @SuppressWarnings("unchecked")
        Value<Void> createValue(BufferStream stream) {
            return new Value<Void>(NULL, null, 1);
        }
    },
    BOOLEAN {
        @Override
        @SuppressWarnings("unchecked")
        Value<Boolean> createValue(BufferStream stream) {
            return new Value<Boolean>(BOOLEAN, stream.readBoolean(), 2);
        }
    },
    BYTE {
        @Override
        @SuppressWarnings("unchecked")
        Value<Byte> createValue(BufferStream stream) {
            return new Value<Byte>(BYTE, stream.readByte(), 2);
        }
    },
    CHAR {
        @Override
        @SuppressWarnings("unchecked")
        Value<Character> createValue(BufferStream stream) {
            return new Value<Character>(CHAR, stream.readChar(), 3);
        }
    },
    SHORT {
        @Override
        @SuppressWarnings("unchecked")
        Value<Short> createValue(BufferStream stream) {
            return new Value<Short>(SHORT, stream.readShort(), 3);
        }
    },
    INT {
        @Override
        @SuppressWarnings("unchecked")
        Value<Integer> createValue(BufferStream stream) {
            return new Value<Integer>(INT, stream.readInt(), 5);
        }
    },
    LONG {
        @Override
        @SuppressWarnings("unchecked")
        Value<Long> createValue(BufferStream stream) {
            return new Value<Long>(LONG, stream.readLong(), 9);
        }
    },
    FLOAT {
        @Override
        @SuppressWarnings("unchecked")
        Value<Float> createValue(BufferStream stream) {
            return new Value<Float>(FLOAT, stream.readFloat(), 5);
        }
    },
    DOUBLE {
        @Override
        @SuppressWarnings("unchecked")
        Value<Double> createValue(BufferStream stream) {
            return new Value<Double>(DOUBLE, stream.readDouble(), 9);
        }
    },
    STRING {
        @Override
        @SuppressWarnings("unchecked")
        Value<String> createValue(BufferStream stream) {
            String val = stream.readString();
            return new Value<String>(STRING, val, 
                    BufferStream.getStringByteLength(val));
        }
    },
    JAVA_OBJECT {
        @Override
        @SuppressWarnings("unchecked")
        Value<Integer> createValue(BufferStream stream) {
            return new Value<Integer>(JAVA_OBJECT, stream.readInt(), 5);
        }
    },
    JAVA_SCRIPT_OBJECT {
        @Override
        @SuppressWarnings("unchecked")
        Value<Integer> createValue(BufferStream stream) {
            return new Value<Integer>(JAVA_SCRIPT_OBJECT, stream.readInt(), 5);
        }
    },
    UNDEFINED {
        @Override
        @SuppressWarnings("unchecked")
        Value<Void> createValue(BufferStream stream) {
            return new Value<Void>(UNDEFINED, null, 1);
        }
    };
    
    public static ValueType getValueType(BufferStream stream) {
        return ValueType.values()[(int) stream.readByte()];
    }
    
    abstract <T> Value<T> createValue(BufferStream stream);
}
