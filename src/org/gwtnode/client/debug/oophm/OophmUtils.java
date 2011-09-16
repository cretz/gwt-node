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
package org.gwtnode.client.debug.oophm;

import java.util.HashMap;
import java.util.Map;

import org.gwtnode.client.debug.oophm.message.InvokeToClientMessage;
import org.gwtnode.client.debug.oophm.message.ReturnMessage;
import org.gwtnode.client.debug.oophm.message.Value;
import org.gwtnode.client.debug.oophm.message.ValueType;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;

/**
 * @author Chad Retz
 */
public class OophmUtils {
    
    private static final Map<Integer, JavaObjectWrapper> JAVA_OBJECT_CACHE =
            new HashMap<Integer, JavaObjectWrapper>();
    private static final Map<JavaScriptObject, JavaObjectWrapper> REVERSE_JAVA_OBJECT_CACHE =
            new HashMap<JavaScriptObject, JavaObjectWrapper>();
    private static final Map<Integer, JavaScriptObject> JS_OBJECT_CACHE =
            new HashMap<Integer, JavaScriptObject>();
    private static final Map<JavaScriptObject, Integer> REVERSE_JS_OBJECT_CACHE =
            new HashMap<JavaScriptObject, Integer>();

    public static ReturnMessage invokeJavaScript(InvokeToClientMessage message) {
        //create the mixed array
        JsArrayMixed args = JavaScriptObject.createArray().cast();
        args.setLength(message.getArgValues().length);
        for (int i = 0; i < message.getArgValues().length; i++) {
            Value<?> value = message.getArgValues()[i];
            if (value.getType() == ValueType.JAVA_OBJECT) {
                setValueInMixedArray(args, i, getCachedJavaObject(
                        (Integer) value.getValue(), true));
            } else if (value.getType() == ValueType.JAVA_SCRIPT_OBJECT) {
                setValueInMixedArray(args, i, getCachedJavaScriptObject(
                        (Integer) value.getValue(), true));
            } else {
                setValueInMixedArray(args, i, value.getValue());
            }
        }
        //handle the "this" properly
        Object thisObject;
        switch (message.getThisValue().getType()) {
        case NULL:
            thisObject = null;
            break;
        case JAVA_OBJECT:
            thisObject = getCachedJavaObject((Integer) message.getThisValue().getValue(), true);
            break;
        case JAVA_SCRIPT_OBJECT:
            thisObject = getCachedJavaScriptObject((Integer) message.getThisValue().getValue(), true);
            break;
        default:
            throw new IllegalArgumentException("Unrecognized 'this' type " + 
                    message.getThisValue().getType());
        }
        InvocationResult result = invokeJavaScriptFunction(thisObject, message.getMethodName(), args);
        return new ReturnMessage(result.isException(), 
                convertJavaScriptValue(result.getValue(), result.isUndefined()));
    }
    
    public static Value<?> convertJavaScriptValue(Object value, boolean undefined) {
        if (value == null) {
            if (undefined) {
                return new Value<Void>(ValueType.UNDEFINED, null, 1);
            } else {
                return new Value<Void>(ValueType.NULL, null, 1);
            }
        } else if (value.getClass().equals(Integer.class)) {
            return new Value<Integer>(ValueType.INT, (Integer) value, 5);
        } else if (value.getClass().equals(Double.class)) {
            return new Value<Double>(ValueType.DOUBLE, ((Double) value), 9);
        } else if (value.getClass().equals(Boolean.class)) {
            return new Value<Boolean>(ValueType.BOOLEAN, ((Boolean) value), 2);
        } else if (value.getClass().equals(JavaScriptObject.class)) {
            //is it a java object?
            Integer refId = getCachedJavaObjectId((JavaScriptObject) value, false);
            if (refId != null) {
                return new Value<Integer>(ValueType.JAVA_OBJECT, refId, 5);
            } else {
                //nope, JS
                refId = getCachedJavaScriptObjectId((JavaScriptObject) value, false);
                if (refId == null) {
                    //cache it then
                    refId = cacheJavaScriptObject((JavaScriptObject) value);
                }
                return new Value<Integer>(ValueType.JAVA_SCRIPT_OBJECT, refId, 5);
            }
        } else {
            throw new IllegalArgumentException("Unrecognized value class " + value.getClass());
        }
    }
    
    public static native void setValueInMixedArray(JsArrayMixed array, int index, Object value) /*-{
        array[index] = value;
    }-*/;
    
    public static native InvocationResult invokeJavaScriptFunction(Object thisValue, 
            String functionName, JsArrayMixed args) /*-{
        var result = {
            'exception' : false,
            'undefined' : false,
            'value' : null
        };
        try {
            if (thisValue != null) {
                result.value = thisValue[methodName].apply(thisValue, args);
            } else {
                result.value = global[methodName].apply(null, args);
            }
            result.undefined = result.value === undefined;
        } catch (err) {
            result.exception = true;
            result.undefined = err === undefined;
            result.value = err;
        }
        return result;
    }-*/;
    
    public static JavaScriptObject getCachedJavaObject(int refId, boolean required) {
        JavaObjectWrapper wrapper = JAVA_OBJECT_CACHE.get(refId);
        if (required && wrapper == null) {
            throw new IllegalArgumentException("Unable to find cached java object " + refId);
        }
        return wrapper == null ? null : wrapper.object;
    }
    
    public static Integer getCachedJavaObjectId(JavaScriptObject object, boolean required) {
        JavaObjectWrapper wrapper = REVERSE_JAVA_OBJECT_CACHE.get(object);
        if (required && wrapper == null) {
            throw new IllegalArgumentException("Unable to find cached java object " + object);
        }
        return wrapper == null ? null : wrapper.refId;
    }
    
    public static JavaScriptObject getCachedJavaScriptObject(int refId, boolean required) {
        JavaScriptObject object = JS_OBJECT_CACHE.get(refId);
        if (required && object == null) {
            throw new IllegalArgumentException("Unable to find cached javascript object " + refId);
        }
        return object;
    }
    
    public static Integer getCachedJavaScriptObjectId(JavaScriptObject object, boolean required) {
        Integer refId = REVERSE_JS_OBJECT_CACHE.get(object);
        if (required && refId == null) {
            throw new IllegalArgumentException("Unable to find cached javascript object " + object);
        }
        return refId;
    }
    
    public static Integer cacheJavaScriptObject(JavaScriptObject object) {
        Integer refId = JS_OBJECT_CACHE.size();
        if (JS_OBJECT_CACHE.put(refId, object) != null) {
            throw new IllegalStateException("Reference already set!");
        }
        REVERSE_JS_OBJECT_CACHE.put(object, refId);
        return refId;
    }
    
    private OophmUtils() {
    }
    
    public static class InvocationResult extends JavaScriptObject {
        
        protected InvocationResult() {
        }
        
        public final native boolean isException() /*-{
            return this.exception;
        }-*/;
        
        public final native boolean isUndefined() /*-{
            return this.undefined;
        }-*/;
        
        public final native Object getValue() /*-{
            return this.value;
        }-*/;
    }
    
    private static class JavaObjectWrapper {
        private final int refId;
        private final JavaScriptObject object;
        
        private JavaObjectWrapper(int refId) {
            this.refId = refId;
            this.object = JavaScriptObject.createObject();
        }
    }
}
