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

import org.gwtnode.client.node.buffer.Buffer;

/**
 * @author Chad Retz
 */
public class BufferStream {
    
    public static int getStringByteLength(String string) {
        return 4 + Buffer.byteLength(string);
    }

    private Buffer buffer;
    private int offset = 0;
    private Integer offsetStart;
    
    public void append(Buffer buffer) {
        if (this.buffer == null) {
            this.buffer = buffer;
        } else {
            Buffer newBuffer = Buffer.create(this.buffer.length() + buffer.length());
            this.buffer.copy(newBuffer);
            buffer.copy(newBuffer, this.buffer.length());
            this.buffer = newBuffer;
        }
    }
    
    public void beginTransaction() {
        offsetStart = offset;
    }
    
    public void commitTransaction() {
        offsetStart = null;
        buffer = this.buffer.slice(offset, this.buffer.length());
        offset = 0;
    }
    
    public void rollbackTransaction() {
        offset = offsetStart;
        offsetStart = null;
    }
    
    private void assertBytesAvailable(int amountNeeded) {
        if (amountNeeded + offset > buffer.length()) {
            throw new StreamIndexOutOfBoundsException();
        }
    }
    
    public boolean readBoolean() {
        assertBytesAvailable(1);
        boolean ret = buffer.get(offset) == ((byte) 1);
        offset++;
        return ret;
    }

    public byte readByte() {
        assertBytesAvailable(1);
        byte ret = buffer.get(offset);
        offset++;
        return ret;
    }
    
    public char readChar() {
        assertBytesAvailable(2);
        char ret = (char) buffer.readInt16BE(offset);
        offset += 2;
        return ret;
    }
    
    public short readShort() {
        assertBytesAvailable(2);
        short ret = buffer.readInt16BE(offset);
        offset += 2;
        return ret;
    }
    
    public int readInt() {
        assertBytesAvailable(4);
        int ret = buffer.readInt32BE(offset);
        offset += 4;
        return ret;
    }
    
    public long readLong() {
        throw new UnsupportedOperationException();
    }
    
    public float readFloat() {
        assertBytesAvailable(4);
        float ret = buffer.readFloatBE(offset);
        offset += 4;
        return ret;
    }
    
    public double readDouble() {
        assertBytesAvailable(8);
        double ret = buffer.readDoubleBE(offset);
        offset += 8;
        return ret;
    }
    
    public String readString() {
        int length = readInt();
        assertBytesAvailable(length);
        String ret = buffer.toString("utf8", offset, offset + length);
        offset += length;
        return ret;
    }
    
    public <T> Value<T> readValue() {
        ValueType type = ValueType.getValueType(this);
        return type.createValue(this);
    }
    
    @SuppressWarnings("serial")
    public static class StreamIndexOutOfBoundsException extends IndexOutOfBoundsException {
        
    }
}
