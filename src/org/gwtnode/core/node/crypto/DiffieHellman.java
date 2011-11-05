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
package org.gwtnode.core.node.crypto;

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js Diffie-Hellman object
 *
 * @author Chad Retz
 */
@GwtNodeObject
public class DiffieHellman extends JavaScriptObject {

    protected DiffieHellman() {
    }
    
    //TODO: should be string returns/inputs?

    @GwtNodeFunction
    public final native String generateKeys() /*-{
        return this.generateKeys();
    }-*/;

    @GwtNodeFunction
    public final native String generateKeys(String encoding) /*-{
        return this.generateKeys(encoding);
    }-*/;

    @GwtNodeFunction
    public final native String computeSecret(String otherPublicKey) /*-{
        return this.computeSecret(otherPublicKey);
    }-*/;

    @GwtNodeFunction
    public final native String computeSecret(String otherPublicKey, String inputEncoding) /*-{
        return this.computeSecret(otherPublicKey, inputEncoding);
    }-*/;

    @GwtNodeFunction
    public final native String computeSecret(String otherPublicKey,
            String inputEncoding, String outputEncoding) /*-{
        return this.computeSecret(otherPublicKey, inputEncoding, outputEncoding);
    }-*/;

    @GwtNodeFunction
    public final native String getPrime() /*-{
        return this.getPrime();
    }-*/;

    @GwtNodeFunction
    public final native String getPrime(String encoding) /*-{
        return this.getPrime(encoding);
    }-*/;

    @GwtNodeFunction
    public final native String getGenerator() /*-{
        return this.getGenerator();
    }-*/;

    @GwtNodeFunction
    public final native String getGenerator(String encoding) /*-{
        return this.getGenerator(encoding);
    }-*/;

    @GwtNodeFunction
    public final native String getPublicKey() /*-{
        return this.getPublicKey();
    }-*/;

    @GwtNodeFunction
    public final native String getPublicKey(String encoding) /*-{
        return this.getPublicKey(encoding);
    }-*/;

    @GwtNodeFunction
    public final native String getPrivateKey() /*-{
        return this.getPrivateKey();
    }-*/;

    @GwtNodeFunction
    public final native String getPrivateKey(String encoding) /*-{
        return this.getPrivateKey(encoding);
    }-*/;

    @GwtNodeFunction
    public final native void setPublicKey(String publicKey) /*-{
        this.setPublicKey(publicKey);
    }-*/;

    @GwtNodeFunction
    public final native void setPublicKey(String publicKey, String encoding) /*-{
        this.setPublicKey(publicKey, encoding);
    }-*/;

    @GwtNodeFunction
    public final native void setPrivateKey(String privateKey) /*-{
        this.setPrivateKey(privateKey);
    }-*/;

    @GwtNodeFunction
    public final native void setPrivateKey(String privateKey, String encoding) /*-{
        this.setPrivateKey(privateKey, encoding);
    }-*/;
}
