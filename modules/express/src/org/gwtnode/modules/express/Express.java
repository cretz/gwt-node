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
package org.gwtnode.modules.express;

import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;
import org.gwtnode.core.node.https.CreateServerOptions;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Express JS module. See 
 * <a href="http://expressjs.com/">the website</a>.
 *
 * @author Chad Retz
 */
public class Express extends JavaScriptObject implements NodeJsModule {

    private static Express instance;
    
    public static Express get() {
        if (instance == null) {
            instance = Global.get().require("express");
        }
        return instance;
    }

    protected Express() {
    }
    
    public final native Server createServer(CreateServerOptions options) /*-{
        return this.createServer(options);
    }-*/;
    
    //TODO: this module
}
