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
package org.cretz.gwtnode.client.node.crypto;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Details object needed when calling createCredentials in {@link Crypto}
 * 
 * @author Chad Retz
 */
public class CredentialsDetails extends JavaScriptObject {

    public static CredentialsDetails create() {
        return (CredentialsDetails) JavaScriptObject.createObject();
    }
    
    public static native CredentialsDetails create(String key, 
            String cert, String ca) /*-{
        return {
            'key' : key,
            'cert' : cert,
            'ca' : ca
        };
    }-*/;
    
    protected CredentialsDetails() {
    }
    
    public final native String getKey() /*-{
        return this.key;
    }-*/;
    
    public final native void setKey(String key) /*-{
        this.key = key;
    }-*/;
    
    public final native String getCert() /*-{
        return this.cert;
    }-*/;
    
    public final native void setCert(String cert) /*-{
        this.cert = cert;
    }-*/;
    
    public final native String getCa() /*-{
        return this.ca;
    }-*/;
    
    public final native void setCa(String ca) /*-{
        this.ca = ca;
    }-*/;
}
