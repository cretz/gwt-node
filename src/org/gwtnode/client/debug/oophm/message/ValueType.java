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
package org.gwtnode.client.debug.oophm.message;

import org.gwtnode.client.debug.oophm.OophmStream;

/**
 * @author Chad Retz
 */
public enum ValueType {
    NULL {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Void> createValue(OophmStream stream) {
            return new Value<Void>(NULL, null, 1);
        }
    },
    BOOLEAN {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Boolean> createValue(OophmStream stream) {
            return new Value<Boolean>(BOOLEAN, stream.readBoolean(), 2);
        }
    },
    BYTE {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Byte> createValue(OophmStream stream) {
            return new Value<Byte>(BYTE, stream.readByte(), 2);
        }
    },
    CHAR {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Character> createValue(OophmStream stream) {
            return new Value<Character>(CHAR, stream.readChar(), 3);
        }
    },
    SHORT {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Short> createValue(OophmStream stream) {
            return new Value<Short>(SHORT, stream.readShort(), 3);
        }
    },
    INT {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Integer> createValue(OophmStream stream) {
            return new Value<Integer>(INT, stream.readInt(), 5);
        }
    },
    LONG {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Long> createValue(OophmStream stream) {
            return new Value<Long>(LONG, stream.readLong(), 9);
        }
    },
    FLOAT {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Float> createValue(OophmStream stream) {
            return new Value<Float>(FLOAT, stream.readFloat(), 5);
        }
    },
    DOUBLE {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Double> createValue(OophmStream stream) {
            return new Value<Double>(DOUBLE, stream.readDouble(), 9);
        }
    },
    STRING {
        @Override
        @SuppressWarnings("unchecked")
        public Value<String> createValue(OophmStream stream) {
            String val = stream.readString();
            return new Value<String>(STRING, val, 
                    OophmStream.getStringByteLength(val));
        }
    },
    JAVA_OBJECT {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Integer> createValue(OophmStream stream) {
            return new Value<Integer>(JAVA_OBJECT, stream.readInt(), 5);
        }
    },
    JAVA_SCRIPT_OBJECT {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Integer> createValue(OophmStream stream) {
            return new Value<Integer>(JAVA_SCRIPT_OBJECT, stream.readInt(), 5);
        }
    },
    UNDEFINED {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Void> createValue(OophmStream stream) {
            return new Value<Void>(UNDEFINED, null, 1);
        }
    };
    
    public static ValueType getValueType(OophmStream stream) {
        return ValueType.values()[(int) stream.readByte()];
    }
    
    public abstract <T> Value<T> createValue(OophmStream stream);
}
