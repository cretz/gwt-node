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
package org.cretz.gwtnode.dev.debug.client.jdwp;

import org.cretz.gwtnode.client.node.buffer.Buffer;

public class BufferUtils {

    public static Buffer toBuffer(long val) {
        Buffer buff = Buffer.create(8);
        buff.set(7, (byte) (val & 255));
        val = val >> 8;
        buff.set(6, (byte) (val & 255));
        val = val >> 8;
        buff.set(5, (byte) (val & 255));
        val = val >> 8;
        buff.set(4, (byte) (val & 255));
        val = val >> 8;
        buff.set(3, (byte) (val & 255));
        val = val >> 8;
        buff.set(2, (byte) (val & 255));
        val = val >> 8;
        buff.set(1, (byte) (val & 255));
        val = val >> 8;
        buff.set(0, (byte) (val & 255));
        return buff;
    }
    
    public static long toLong(Buffer buffer) {
        return Long.parseLong(getLongHex(buffer), 16);
    }
    
    private static native String getLongHex(Buffer buffer) /*-{
        return buffer[0].toString(16) +
                buffer[1].toString(16) +
                buffer[2].toString(16) +
                buffer[3].toString(16) +
                buffer[4].toString(16) +
                buffer[5].toString(16) +
                buffer[6].toString(16) +
                buffer[7].toString(16);
    }-*/;

    public static Buffer toBuffer(int val) {
        //from: http://bytes.com/topic/javascript/answers/157858-convert-integer-value-4-byte-array
        Buffer buff = Buffer.create(4);
        buff.set(3, (byte) (val & 255));
        val = val >> 8;
        buff.set(2, (byte) (val & 255));
        val = val >> 8;
        buff.set(1, (byte) (val & 255));
        val = val >> 8;
        buff.set(0, (byte) (val & 255));
        return buff;
    }
    
    public static native int toInteger(Buffer buffer) /*-{
        return parseInt(
                buffer[0].toString(16) +
                buffer[1].toString(16) +
                buffer[2].toString(16) +
                buffer[3].toString(16), 16);
    }-*/;
    
    public static Buffer toBuffer(short val) {
        Buffer buff = Buffer.create(2);
        int intVal = val;
        buff.set(1, (byte) (intVal & 255));
        intVal = intVal >> 8;
        buff.set(0, (byte) (intVal & 255));
        return buff;
    }
    
    public static native short toShort(Buffer buffer) /*-{
        return parseInt(
                buffer[0].toString(16) +
                buffer[1].toString(16), 16);
    }-*/;
    
    public static Buffer toBuffer(String string) {
        Buffer length = toBuffer(Buffer.byteLength(string, "utf8"));
        return concat(length, Buffer.create(string, "utf8"));
    }
    
    public static String toString(Buffer buffer) {
        return buffer.toString("utf8");
    }
    
    public static Buffer toBuffer(boolean bool) {
        return Buffer.create(bool ? 1 : 0);
    }
    
    public static boolean toBoolean(byte byt) {
        return byt != 0;
    }
    
    public static Buffer concat(Buffer... buffers) {
        int count = 0;
        for (Buffer buffer : buffers) {
            count += buffer.length();
        }
        Buffer buff = Buffer.create(count);
        int pos = 0;
        for (Buffer buffer : buffers) {
            buffer.copy(buff, pos, 0);
            pos += buffer.length();
        }
        return buff;
    }
    
    private BufferUtils() {
    }
}
