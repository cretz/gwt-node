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

    private JavaScriptUtils() {
    }
}
