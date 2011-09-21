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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.gwtnode.client.JavaScriptUtils;
import org.gwtnode.client.debug.oophm.message.FreeValueMessage;
import org.gwtnode.client.debug.oophm.message.SpecialMethod;
import org.gwtnode.client.debug.oophm.message.Value;
import org.gwtnode.client.debug.oophm.message.ValueType;
import org.gwtnode.client.node.vm.Vm;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * OOHPM session handler
 *
 * @author Chad Retz
 */
public class OophmSessionHandler {
    
    private static final Vm vm = Vm.get();
    
    private final Set<Integer> javaObjectsToFree = new HashSet<Integer>();
    private final OophmChannel channel;
    private final OophmLog log;
    
    public OophmSessionHandler(OophmChannel channel, OophmLog log) {
        this.channel = channel;
        this.log = log;
        //could start a REPL here too...
        //Repl.get().start();
        initContext();
    }
    
    public OophmLog getLog() {
        return log;
    }
    
    @SuppressWarnings("unchecked")
    private <T extends JavaScriptObject> T runInContext(String code) {
        log.debug("Executing code in context:\n%s", code);
        return (T) vm.runInThisContext(code);
    }
    
    private void initContext() {
        try {
            StringBuilder code = new StringBuilder().
                    append("this['window'] = this;\n").
                    append("this['__gwt_node_javaObjectsById'] = {};\n").
                    append("this['__gwt_node_javaIdsByObject'] = {};\n").
                    append("this['__gwt_node_jsObjectsById'] = {};\n").
                    append("this['__gwt_node_jsIdsByObject'] = {};\n").
                    append("this['__gwt_node_jsObjectCounter'] = 0;\n");
            runInContext(code.toString());
        } catch (Exception e) {
            throw new OophmRuntimeException("Error initializing context", e);
        }
    }
    
    public void end() {
        channel.disconnectFromHost();
    }
    
    public void disconnectDetected() {
        try {
            runInContext("__gwt_disconnected();");
        } catch (Exception e) {
            throw new OophmRuntimeException("Error disconnecting", e);
        }
    }
    
    public void fatalError(String message) {
        log.error("Fatal error: " + message);
    }
    
    public void freeJavaObject(int id) {
        try {
            StringBuilder code = new StringBuilder("(function() {\n").
                    append("var toDelete = __gwt_node_javaObjectsById[").append(id).append("];\n").
                    append("if (toDelete) {\n").
                    append("  delete __gwt_node_javaObjectsById[").append(id).append("];\n").
                    append("  delete __gwt_node_javaIdsByObject[toDelete];\n").
                    append("})();");
            runInContext(code.toString());
            javaObjectsToFree.add(id);
        } catch (Exception e) {
            throw new OophmRuntimeException("Error freeing Java object: " + id, e);
        }
    }
    
    public void sendFreeValues() {
        channel.sendMessage(new FreeValueMessage(javaObjectsToFree.toArray(new Integer[0])));
        javaObjectsToFree.clear();
    }
    
    public void freeValues(Integer... ids) {
        try {
            StringBuilder code = new StringBuilder("(function() {\nvar toDelete; \n");
            for (Integer id : ids) {
                code.append("toDelete = __gwt_node_jsObjectsById[").append(id).append("];\n").
                     append("if (toDelete) {\n").
                     append("  delete __gwt_node_jsObjectsById[").append(id).append("];\n").
                     append("  delete __gwt_node_jsIdsByObject[toDelete];\n").
                     append("}\n");
            }
            runInContext(code.append("})();").toString());
        } catch (Exception e) {
            throw new OophmRuntimeException("Error freeing values: " + Arrays.toString(ids), e);
        }
    }
    
    private StringBuilder appendValue(Value<?> val, StringBuilder code) {
        switch (val.getType()) {
        case JAVA_OBJECT:
            code.append("__gwt_node_javaObjectsById[").
                 append((Integer) val.getValue()).append("]");
            break;
        case JAVA_SCRIPT_OBJECT:
            code.append("__gwt_node_jsObjectsById[").
                 append((Integer) val.getValue()).append("]");
            break;
        case STRING:
            code.append(JavaScriptUtils.unescapeJavaScriptString((String) val.getValue()));
            break;
        case NULL:
            code.append("null");
            break;
        case UNDEFINED:
            code.append("undefined");
            break;
        default:
            code.append(val.getValue());
        }
        return code;
    }
    
    public InvokeResult invoke(String methodName, Value<?> thisObj, Value<?>... args) {
        try {
            StringBuilder code = new StringBuilder("(function() {\n").
                    append("var _ret = { 'type' : 12, 'value' : null, 'exception' : false };\n").
                    append("try {\n");
            //gotta loop through and eagerly cache java objects
            for (Value<?> arg : args) {
                if (arg.getType() == ValueType.JAVA_OBJECT) {
                    code.append("if (!__gwt_node_javaObjectsById[").append((Integer) arg.getValue()).
                            append("]) {\n").
                         append("  var _tmp = {};\n").
                         append("  __gwt_node_javaObjectsById[").append((Integer) arg.getValue()).
                            append("] = _tmp;\n").
                         append("  __gwt_node_javaIdsByObject[_tmp] = ").append((Integer) arg.getValue()).
                             append(";\n").
                         append("}\n");
                }
            }
            code.append("  _ret.value = ");
            if (thisObj.getValue() == null) {
                code.append("window");
            } else {
                appendValue(thisObj, code);
            }
            code.append('[').append(JavaScriptUtils.unescapeJavaScriptString(methodName)).append("](");
            for (int i = 0; i < args.length; i++) {
                if (i > 0) {
                    code.append(", ");
                }
                appendValue(args[i], code);
            }
            code.append(");\n").
                 append("} catch (_err) {\n").
                 append("  _ret.exception = true;\n").
                 append("  _ret.value = _err;\n").
                 append("}\n").
                 append("if (_ret.value === undefined) {\n").
                 append("  _ret.type = ").append(ValueType.UNDEFINED.ordinal()).append(";\n").
                 append("} else if (_ret.value === null) {\n").
                 append("  _ret.type = ").append(ValueType.NULL.ordinal()).append(";\n").
                 append("} else if (typeof _ret.value === 'boolean') {\n").
                 append("  _ret.type = ").append(ValueType.BOOLEAN.ordinal()).append(";\n").
                 append("} else if (typeof _ret.value === 'string') {\n").
                 append("  _ret.type = ").append(ValueType.STRING.ordinal()).append(";\n").
                 append("} else if (typeof _ret.value === 'number') {\n").
                 append("  if (_ret.value.toString() != _ret.value.toFixed(0).toString()) {\n").
                 append("    _ret.type = ").append(ValueType.DOUBLE.ordinal()).append(";\n").
                 append("  } else {\n").
                 append("    _ret.type = ").append(ValueType.INT.ordinal()).append(";\n").
                 append("  }\n").
                 append("} else if (typeof _ret.value === 'object') {\n").
                 append("  var _id = __gwt_node_javaIdsByObject[_ret.value];\n").
                 append("  if (_id) {\n").
                 append("    _ret.type = ").append(ValueType.JAVA_OBJECT.ordinal()).append(";\n").
                 append("  } else {\n").
                 append("    _ret.type = ").append(ValueType.JAVA_SCRIPT_OBJECT.ordinal()).append(";\n").
                 append("    _id = __gwt_node_jsIdsByObject[_ret.value];\n").
                 append("    if (!_id) {\n").
                 append("      _id = ++__gwt_node_jsObjectCounter;\n").
                 append("      __gwt_node_jsObjectsById[_id] = _ret.value;\n").
                 append("      __gwt_node_jsIdsByObject[_ret.value] = _id;\n").
                 append("    }\n").
                 append("  }\n").
                 append("  _ret.value = _id;\n").
                 append("} else {\n").
                 append("  _ret.value = new Error('Unrecognized type: ' + typeof(_ret.value));\n").
                 append("  _id = ++__gwt_node_jsObjectCounter;\n").
                 append("  __gwt_node_jsObjectsById[_id] = _ret.value;\n").
                 append("  __gwt_node_jsIdsByObject[_ret.value] = _id;\n").
                 append("  _ret.type = ").append(ValueType.JAVA_SCRIPT_OBJECT.ordinal()).append(";\n").
                 append("  _ret.exception = true;\n").
                 append("  _ret.value = _id;\n").
                 append("}\n").
                 append("return _ret;\n").
                 append("})();");
            InvokeResultNative result = runInContext(code.toString()).cast();
            log.debug("Result of invocation:\n%j", result);
            return new InvokeResult(result);
        } catch (Exception e) {
            log.error("Exception invoking method: " +
                    JavaScriptUtils.appendException(e, new StringBuilder()));
            throw new OophmRuntimeException("Error invoking method: " + methodName, e);
        }
    }
    
    public InvokeResult invokeSpecial(SpecialMethod specialMethod, Value<?>... args) {
        throw new UnsupportedOperationException("InvokeSpecial not implemented");
    }
    
    public void loadJsni(String jsCode) {
        try {
            runInContext(jsCode);
        } catch (Exception e) {
            throw new OophmRuntimeException("Error loading JSNI", e);
        }
    }
    
    public static class InvokeResult {
        private final Value<?> value;
        private final boolean exception;
        
        private InvokeResult(InvokeResultNative result) {
            value = result.getType().createValueFromObject(result.getValue());
            exception = result.isException();
        }
        
        public Value<?> getValue() {
            return value;
        }
        
        public boolean isException() {
            return exception;
        }
    }
    
    private static class InvokeResultNative extends JavaScriptObject {
        protected InvokeResultNative() {
        }
        
        public final native Object getValue() /*-{
            return this.value;
        }-*/;
        
        public final ValueType getType() {
            return ValueType.values()[getTypeNative()];
        }
        
        private final native int getTypeNative() /*-{
            return this.type;
        }-*/;
        
        public final native boolean isException() /*-{
            return this.exception;
        }-*/;
    }
}
