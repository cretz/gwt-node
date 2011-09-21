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
package org.gwtnode.dev.symbol;

import java.util.Collections;
import java.util.Map;

import org.gwtnode.core.JsonStringObjectMap;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Chad Retz
 */
public class ClientSymbolStore extends JavaScriptObject {

    public static final String GLOBAL_JS_OBJECT_NAME = "__gwt_node_ClientSymbolStore";
    public static final String CLASSES_MAP_NAME = "classes";
    public static final String METHODS_MAP_NAME = "methods";
    public static final String FIELDS_MAP_NAME = "fields";
    
    static native ClientSymbolStore get() /*-{
        return global[@org.gwtnode.dev.symbol.ClientSymbolStore::GLOBAL_JS_OBJECT_NAME];
    }-*/;

    protected ClientSymbolStore() {
    }
    
    final native ClientClass getClass(String className) /*-{
        return this.classes[className];
    }-*/;
    
    final Map<String, ClientMethod> getMethods(String className) {
        JavaScriptObject methods = getMethodsNative(className);
        if (methods == null) {
            return Collections.emptyMap();
        } else {
            return Collections.unmodifiableMap(new JsonStringObjectMap<ClientMethod>(methods));
        }
    }
    
    private final native JavaScriptObject getMethodsNative(String className) /*-{
        return this.methods[className];
    }-*/;
    
    final Map<String, ClientField> getFields(String className) {
        JavaScriptObject fields = getFieldsNative(className);
        if (fields == null) {
            return Collections.emptyMap();
        } else {
            return Collections.unmodifiableMap(new JsonStringObjectMap<ClientField>(fields));
        }
    }
    
    private final native JavaScriptObject getFieldsNative(String className) /*-{
        return this.fields[className];
    }-*/;

}
