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
package org.gwtnode.dev.debug;

import java.util.ArrayList;
import java.util.List;

import org.gwtnode.core.node.buffer.Buffer;
import org.gwtnode.dev.debug.message.Value;

/**
 * Builder for a buffer for OOPHM
 * 
 * @author Chad Retz
 */
public class OophmBufferBuilder {
    
    private final List<Object> objects = new ArrayList<Object>();
    private int length = 0;
    
    public <T> OophmBufferBuilder appendArray(T[] values) {
        append(values.length);
        for (int i = 0; i < values.length; i++) {
            append(values[i]);
        }
        return this;
    }
    
    public OophmBufferBuilder append(Object object) {
        if (object == null) {
            return this;
        } else if (object.getClass() == Boolean.class || "boolean".equals(object.getClass().getName())) {
            length++;
        } else if (object.getClass() == Byte.class || "byte".equals(object.getClass().getName())) {
            length++;
        } else if (object.getClass() == Character.class || "char".equals(object.getClass().getName())) {
            length += 2;
        } else if (object.getClass() == Short.class || "short".equals(object.getClass().getName())) {
            length += 2;
        } else if (object.getClass() == Integer.class || "int".equals(object.getClass().getName())) {
            length += 4;
        } else if (object.getClass() == Float.class || "float".equals(object.getClass().getName())) {
            length += 4;
        } else if (object.getClass() == Double.class || "double".equals(object.getClass().getName())) {
            length += 8;
        } else if (object.getClass() == String.class) {
            length += OophmStream.getStringByteLength((String) object);
        } else if (object.getClass() == Value.class) {
            append(((Value<?>) object).getType());
            if (((Value<?>) object).getValue() != null) {
                return append(((Value<?>) object).getValue());
            } else {
                return this;
            }
        } else if (object instanceof Enum) {
            length++;
        } else {
            throw new IllegalArgumentException("Unknown object type: " + object.getClass());
        }
        objects.add(object);
        return this;
    }
    
    public Buffer toBuffer() {
        Buffer buffer = Buffer.create(length);
        int offset = 0;
        for (Object object : objects) {
            if (object.getClass() == Boolean.class || "boolean".equals(object.getClass().getName())) {
                buffer.set(offset, (byte) (((Boolean) object) ? 1 : 0));
                offset++;
            } else if (object.getClass() == Byte.class || "byte".equals(object.getClass().getName())) {
                buffer.set(offset, (Byte) object);
                offset++;
            } else if (object.getClass() == Character.class || "char".equals(object.getClass().getName())) {
                buffer.writeInt16BE((short) ((Character) object).charValue(), offset);
                offset += 2;
            } else if (object.getClass() == Short.class || "short".equals(object.getClass().getName())) {
                buffer.writeInt16BE((Short) object, offset);
                offset += 2;
            } else if (object.getClass() == Integer.class || "int".equals(object.getClass().getName())) {
                buffer.writeInt32BE((Integer) object, offset);
                offset += 4;
            } else if (object.getClass() == Float.class || "float".equals(object.getClass().getName())) {
                buffer.writeFloatBE((Float) object, offset);
                offset += 4;
            } else if (object.getClass() == Double.class || "double".equals(object.getClass().getName())) {
                buffer.writeDoubleBE((Double) object, offset);
                offset += 8;
            } else if (object.getClass() == String.class) {
                buffer.writeInt32BE(Buffer.byteLength((String) object), offset);
                buffer.write((String) object, offset + 4);
                offset += OophmStream.getStringByteLength((String) object);
            } else if (object instanceof Enum) {
                buffer.set(offset, (byte) ((Enum<?>) object).ordinal());
                offset++;
            } else {
                throw new IllegalArgumentException("Unknown object type: " + object.getClass());
            }
        }
        return buffer;
    }
}
