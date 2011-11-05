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

import java.util.HashMap;
import java.util.Map;

import org.gwtnode.core.JavaScriptReturningFunction;
import org.gwtnode.core.JavaScriptUtils;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsError;
import org.gwtnode.core.node.vm.Vm;
import org.gwtnode.dev.debug.message.FreeValueMessage;
import org.gwtnode.dev.debug.message.SpecialMethod;
import org.gwtnode.dev.debug.message.Value;
import org.gwtnode.dev.debug.message.ValueType;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * OOHPM session handler
 *
 * @author Chad Retz
 */
class SessionHandler {
    
    private final Vm vm = Vm.get();
    private final Map<Integer, JavaScriptReturningFunction<?>> javaInvokeFunctions =
            new HashMap<Integer, JavaScriptReturningFunction<?>>();
    private final Map<Integer, JavaScriptReturningFunction<?>> tearOffs =
            new HashMap<Integer, JavaScriptReturningFunction<?>>();
    private final ObjectCache objectCache = new ObjectCache();
    private final HostChannel channel;
    private final DebugLog log;
    
    public SessionHandler(HostChannel channel, DebugLog log) {
        this.channel = channel;
        this.log = log;
        //could start a REPL here too...
        //Repl.get().start();
        initContext();
    }
    
    public DebugLog getLog() {
        return log;
    }
    
    @SuppressWarnings("unchecked")
    private <T extends JavaScriptObject> T runInContext(String code) {
        log.debug("Executing code in context:\n%s", code);
        return (T) vm.runInThisContext(code);
    }
    
    private void initContext() {
        try {
            initGlobalContext();
            initJavaInvokeMethods();
        } catch (Exception e) {
            log.debug("Error initializing");
            throw new DebugRuntimeException("Error initializing context", e);
        }
    }
    
    private native void initGlobalContext() /*-{
        global['window'] = global;
    }-*/;

    private native void initJavaInvokeMethods() /*-{
        //TODO: fix this...I hate this
        global['__gwtnode_sessionHandler'] = this;
        global['__gwt_makeJavaInvoke'] = function(paramCount) {
            var thisRef = global['__gwtnode_sessionHandler'];
            return thisRef.@org.gwtnode.dev.debug.SessionHandler::makeJavaInvoke(I)(paramCount);
        };
        global['__gwt_makeTearOff'] = function(proxy, dispId, paramCount) {
            var thisRef = global['__gwtnode_sessionHandler'];
            return thisRef.@org.gwtnode.dev.debug.SessionHandler::makeTearOff(II)(dispId, paramCount);
        };
    }-*/;
    
    @SuppressWarnings("rawtypes")
    private JavaScriptReturningFunction<?> makeJavaInvoke(int paramCount) {
        JavaScriptReturningFunction<?> ret = javaInvokeFunctions.get(paramCount);
        if (ret == null) {
            ret = new JavaInvoker(channel, this, paramCount).getNativeFunction();
            javaInvokeFunctions.put(paramCount, ret);
        }
        return ret;
    }
    
    @SuppressWarnings("rawtypes")
    private JavaScriptReturningFunction<?> makeTearOff(
            int dispId, int paramCount) {
        JavaScriptReturningFunction<?> ret = tearOffs.get(paramCount);
        if (ret == null) {
            ret = new TearOff(channel, this, paramCount).getNativeFunction();
            tearOffs.put(paramCount, ret);
        }
        return ret;
    }
    
    public void end() {
        channel.disconnectFromHost();
    }
    
    public void disconnectDetected() {
        try {
            runInContext("__gwt_disconnected();");
        } catch (Exception e) {
            throw new DebugRuntimeException("Error disconnecting", e);
        }
    }
    
    public void fatalError(String message) {
        log.error("Fatal error: " + message);
    }
    
    public void freeJavaObject(int id) {
        objectCache.freeJavaObject(id);
    }
    
    public void sendFreeValues() {
        channel.sendMessage(new FreeValueMessage(objectCache.getJavaObjectsToFree().toArray(new Integer[0])));
        objectCache.clearJavaObjectsToFree();
    }
    
    public void freeValues(Integer... ids) {
        for (int id : ids) {
            objectCache.freeJavaScriptObject(id);
        }
    }
    
    Value<?> getValueFromJavaScriptObject(Object jsObject) {
        ValueType type = ValueType.values()[getValueTypeOrdinalFromJavaScriptObject(jsObject)];
        if (type == ValueType.JAVA_OBJECT) {
            Integer val = objectCache.getJavaObjectId((JavaScriptObject) jsObject);
            if (val != null) {
                return type.createValueFromObject(val);
            } else {
                return ValueType.JAVA_SCRIPT_OBJECT.createValueFromObject(
                        objectCache.getJavaScriptObjectId((JavaScriptObject) jsObject, true));
            }
        } else {
            return type.createValueFromObject(jsObject);
        }
    }
    
    Object getJavaScriptObjectFromValue(Value<?> val) {
        switch (val.getType()) {
        case JAVA_OBJECT:
            log.debug("Getting Java object reference");
            return objectCache.getJavaObjectReference((Integer) val.getValue(), true);
        case JAVA_SCRIPT_OBJECT:
            log.debug("Getting JavaScript object reference");
            return objectCache.getJavaScriptObject((Integer) val.getValue());
        default:
            return val.getValue();
        }
    }
    
    private native int getValueTypeOrdinalFromJavaScriptObject(Object obj) /*-{
        if (obj === undefined) {
            return 12;
        } else if (obj === null) {
            return 0;
        } else {
            var typ = typeof obj;
            switch(typ) {
                case 'boolean':
                    return 1;
                case 'string':
                    return 9;
                case 'number':
                    if (obj.toString() != obj.toFixed(0).toString()) {
                        return 8;
                    } else {
                        return 5;
                    }
                case 'object':
                case 'function':
                    return 10;
                default:
                    throw new Error('Unrecognized type: ' + typ);
            }
        }
    }-*/;
    
    public InvokeResult invoke(String methodName, Value<?> thisObj, Value<?>... args) {
        JavaScriptReturningFunction<Object> function;
        log.debug("Getting 'this'");
        Object nativeThis = getJavaScriptObjectFromValue(thisObj);
        if (nativeThis != null) {
            function = JavaScriptUtils.getProperty((JavaScriptObject) nativeThis, methodName).cast();
        } else {
            log.debug("Using global object");
            function = JavaScriptUtils.getProperty(Global.get(), methodName).cast();
        }
        log.debug("Got object");
        log.debug("Got function: ", function);
        Object result;
        boolean exception = false;
        try {
            log.debug("Loading %d native arguments", args.length);
            Object[] nativeArgs = new Object[args.length];
            for (int i = 0; i < args.length; i++) {
                nativeArgs[i] = getJavaScriptObjectFromValue(args[i]);
            }
            log.debug("Getting make invoke");
            log.debug("Invoking function");
            result = function.apply(nativeArgs);
            log.debug("Invocation complete: " + result);
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("Exception occurred %s", JavaScriptUtils.
                        appendException(e, new StringBuilder()));
            }
            if (e instanceof JavaScriptException) {
                result = ((JavaScriptException) e).getException();
            } else {
                result = NodeJsError.create("Ahh!");
            }
            exception = true;
        }
        return new InvokeResult(getValueFromJavaScriptObject(result), exception);
    }

    public InvokeResult invokeSpecial(SpecialMethod specialMethod, Value<?>... args) {
        throw new UnsupportedOperationException("InvokeSpecial not implemented");
    }
    
    public void loadJsni(String jsCode) {
        try {
            runInContext(jsCode);
        } catch (Exception e) {
            throw new DebugRuntimeException("Error loading JSNI", e);
        }
    }
    
    public static class InvokeResult {
        private final Value<?> value;
        private final boolean exception;
        
        private InvokeResult(Value<?> value, boolean exception) {
            this.value = value;
            this.exception = exception;
        }
        
        public Value<?> getValue() {
            return value;
        }
        
        public boolean isException() {
            return exception;
        }
    }
}
