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

/**
 * @author Chad Retz
 */
public class ClientClass extends ClientSymbol {

    public static ClientClass get(String className) {
        return ClientSymbolStore.get().getClass(className);
    }
    
    protected ClientClass() {
    }
    
    public final String getName() {
        return getClassName();
    }
    
    private final native void setLocalMethodsMap(Map<String, ClientMethod> map) /*-{
        this._methods = map;
    }-*/;
    
    private final native Map<String, ClientMethod> getLocalMethodsMap() /*-{
        return this._methods;
    }-*/;
    
    @SuppressWarnings("unchecked")
    public final Map<String, ClientMethod> getMethods() {
        if (getLocalMethodsMap() == null) {
            Map<String, ClientMethod> methods = 
                ClientSymbolStore.get().getMethods(getClassName());
            if (methods == null) {
                setLocalMethodsMap(Collections.EMPTY_MAP);
            } else {
                setLocalMethodsMap(methods);
            }
        }
        return getLocalMethodsMap();
    }
    
    private final native void setLocalFieldsMap(Map<String, ClientField> map) /*-{
        this._fields = map;
    }-*/;
    
    private final native Map<String, ClientField> getLocalFieldsMap() /*-{
        return this._fields;
    }-*/;
    
    @SuppressWarnings("unchecked")
    public final Map<String, ClientField> getFields() {
        if (getLocalFieldsMap() == null) {
            Map<String, ClientField> fields = 
                ClientSymbolStore.get().getFields(getClassName());
            if (fields == null) {
                setLocalFieldsMap(Collections.EMPTY_MAP);
            } else {
                setLocalFieldsMap(fields);
            }
        }
        return getLocalFieldsMap();
    }
}
