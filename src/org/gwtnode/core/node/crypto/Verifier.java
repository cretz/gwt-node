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
 * The node.js verifier object
 * 
 * @author Chad Retz
 */
@GwtNodeObject("Verify")
public class Verifier extends JavaScriptObject {

    protected Verifier() {
    }

    @GwtNodeFunction
    public final native void update(String data) /*-{
        this.update(data);
    }-*/;

    @GwtNodeFunction
    public final native boolean verify(String privateKey, String signature) /*-{
        return this.verify(privateKey, signature);
    }-*/;

    @GwtNodeFunction
    public final native boolean verify(String privateKey, String signature,
            String signatureFormat) /*-{
        return this.verify(privateKey, signature, signatureFormat);
    }-*/;
}
