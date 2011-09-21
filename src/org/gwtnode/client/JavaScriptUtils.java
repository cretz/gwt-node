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
package org.gwtnode.client;

import org.gwtnode.client.node.util.Util;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsArrayString;

/**
 * JavaScript utility methods
 * 
 * @author Chad Retz
 */
public class JavaScriptUtils {
    
    public static JsArrayInteger toIntegerArray(byte... bytes) {
        JsArrayInteger ret = JavaScriptObject.createArray().cast();
        for (byte byt : bytes) {
            ret.push(byt);
        }
        return ret;
    }
    
    public static JsArrayString toStringArray(String... strings) {
        JsArrayString ret = JavaScriptObject.createArray().cast();
        for (String string : strings) {
            ret.push(string);
        }
        return ret;
    }
    
    public static void addToArray(JsArrayMixed array, Object value) {
        if (value == null) {
            array.push((JavaScriptObject) null);
        } else if (value instanceof Boolean) {
            array.push((Boolean) value);
        } else if (value instanceof Integer) {
            array.push((Integer) value);
        } else if (value instanceof Double) {
            array.push((Double) value);
        } else if (value instanceof Float) {
            array.push((Float) value);
        } else if (value instanceof Byte) {
            array.push((Byte) value);
        } else if (value instanceof Character) {
            array.push((Character) value);
        } else if (value instanceof Short) {
            array.push((Short) value);
        } else if (value instanceof String) {
            array.push((String) value);
        } else if (value instanceof JavaScriptObject) {
            array.push((JavaScriptObject) value);
        } else {
            throw new RuntimeException("Unrecognized type to translate: " + value.getClass());
        }        
    }
    
    public static JsArrayMixed toMixedArray(Object... values) {
        JsArrayMixed ret = JavaScriptObject.createArray().cast();
        for (Object value : values) {
            addToArray(ret, value);
        }
        return ret;
    }

    public static StringBuilder appendException(Throwable throwable, StringBuilder builder) {
        return appendException(throwable, true, builder);
    }
    
    private static StringBuilder appendException(Throwable throwable, 
            boolean topLevel, StringBuilder builder) {
        if (topLevel) {
            builder.append("Exception: ").append(throwable).append('\n');
        } else {
            builder.append("Caused by: ").append(throwable).append('\n');
        }
        if (throwable instanceof JavaScriptException) {
            if (throwable.getStackTrace().length == 0) {
                throwable.fillInStackTrace();
            }
            builder.append("    JS Error: ").append(Util.get().inspect(
                    ((JavaScriptException) throwable).getException(), true)).append('\n');
        }
        StackTraceElement[] stackTraceElements = throwable.getStackTrace();
        if (stackTraceElements != null && stackTraceElements.length > 0) {
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                builder.append("    ").append(stackTraceElement).append('\n');
            }
        } else {
            builder.append("[no stacktrace]\n");
        }
        if (throwable.getCause() != null && throwable.getCause() != throwable) {
            return appendException(throwable.getCause(), false, builder);
        } else {
            return builder;
        }
    }
    
    /**
     * Unescape JS strings and return them, surrounded by single quotes
     * 
     * @param string
     * @return
     */
    public static String unescapeJavaScriptString(String string) {
        StringBuilder ret = new StringBuilder(string.length()).append('\'');
        for (int i = 0; i < string.length(); i++) {
            char chr = string.charAt(i);
            switch (chr) {
            case '\b':
                ret.append("\\b");
                break;
            case '\f':
                ret.append("\\f");
                break;
            case '\n':
                ret.append("\\n");
                break;
            case '\0':
                //TODO: does this even work?
                ret.append("\\0");
                break;
            case '\r':
                ret.append("\\r");
                break;
            case '\t':
                ret.append("\\t");
                break;
            case '\'':
                ret.append("\\'");
                break;
            default:
                ret.append(chr);
            }
        }
        return ret.append('\'').toString();
    }

    private JavaScriptUtils() {
    }
}
