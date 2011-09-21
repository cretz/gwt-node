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
            return createValueFromObject(null);
        }

        @Override
        @SuppressWarnings("unchecked")
        public Value<Void> createValueFromObject(Object object) {
            return new Value<Void>(NULL, null, 1);
        }
    },
    BOOLEAN {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Boolean> createValue(OophmStream stream) {
            return createValueFromObject(stream.readBoolean());
        }

        @Override
        @SuppressWarnings("unchecked")
        public Value<Boolean> createValueFromObject(Object object) {
            return new Value<Boolean>(BOOLEAN, (Boolean) object, 2);
        }
    },
    BYTE {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Byte> createValue(OophmStream stream) {
            return createValueFromObject(stream.readByte());
        }

        @Override
        @SuppressWarnings("unchecked")
        public Value<Byte> createValueFromObject(Object object) {
            return new Value<Byte>(BYTE, (Byte) object, 2);
        }
    },
    CHAR {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Character> createValue(OophmStream stream) {
            return createValueFromObject(stream.readChar());
        }

        @Override
        @SuppressWarnings("unchecked")
        public Value<Character> createValueFromObject(Object object) {
            return new Value<Character>(CHAR, (Character) object, 3);
        }
    },
    SHORT {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Short> createValue(OophmStream stream) {
            return createValueFromObject(stream.readChar());
        }

        @Override
        @SuppressWarnings("unchecked")
        public Value<Short> createValueFromObject(Object object) {
            return new Value<Short>(SHORT, (Short) object, 3);
        }
    },
    INT {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Integer> createValue(OophmStream stream) {
            return createValueFromObject(stream.readInt());
        }

        @Override
        @SuppressWarnings("unchecked")
        public Value<Integer> createValueFromObject(Object object) {
            return new Value<Integer>(INT, (Integer) object, 5);
        }
    },
    LONG {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Long> createValue(OophmStream stream) {
            return createValueFromObject(stream.readLong());
        }

        @Override
        @SuppressWarnings("unchecked")
        public Value<Long> createValueFromObject(Object object) {
            return new Value<Long>(LONG, (Long) object, 9);
        }
    },
    FLOAT {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Float> createValue(OophmStream stream) {
            return createValueFromObject(stream.readFloat());
        }

        @Override
        @SuppressWarnings("unchecked")
        public Value<Float> createValueFromObject(Object object) {
            return new Value<Float>(FLOAT, (Float) object, 5);
        }
    },
    DOUBLE {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Double> createValue(OophmStream stream) {
            return createValueFromObject(stream.readDouble());
        }

        @Override
        @SuppressWarnings("unchecked")
        public Value<Double> createValueFromObject(Object object) {
            return new Value<Double>(DOUBLE, (Double) object, 9);
        }
    },
    STRING {
        @Override
        @SuppressWarnings("unchecked")
        public Value<String> createValue(OophmStream stream) {
            return createValueFromObject(stream.readString());
        }

        @Override
        @SuppressWarnings("unchecked")
        public Value<String> createValueFromObject(Object object) {
            return new Value<String>(STRING, (String) object, 
                    OophmStream.getStringByteLength((String) object) + 1);
        }
    },
    JAVA_OBJECT {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Integer> createValue(OophmStream stream) {
            return createValueFromObject(stream.readInt());
        }

        @Override
        @SuppressWarnings("unchecked")
        public Value<Integer> createValueFromObject(Object object) {
            return new Value<Integer>(JAVA_OBJECT, (Integer) object, 5);
        }
    },
    JAVA_SCRIPT_OBJECT {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Integer> createValue(OophmStream stream) {
            return createValueFromObject(stream.readInt());
        }

        @Override
        @SuppressWarnings("unchecked")
        public Value<Integer> createValueFromObject(Object object) {
            return new Value<Integer>(JAVA_SCRIPT_OBJECT, (Integer) object, 5);
        }
    },
    UNDEFINED {
        @Override
        @SuppressWarnings("unchecked")
        public Value<Void> createValue(OophmStream stream) {
            return createValueFromObject(null);
        }

        @Override
        @SuppressWarnings("unchecked")
        public Value<Void> createValueFromObject(Object object) {
            return new Value<Void>(UNDEFINED, null, 1);
        }
    };
    
    public static ValueType getValueType(OophmStream stream) {
        return ValueType.values()[(int) stream.readByte()];
    }
    
    public abstract <T> Value<T> createValue(OophmStream stream);
    
    public abstract <T> Value<T> createValueFromObject(Object object);
}
