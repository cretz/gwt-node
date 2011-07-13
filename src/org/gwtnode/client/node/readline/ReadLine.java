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
package org.gwtnode.client.node.readline;

import org.gwtnode.client.node.Global;
import org.gwtnode.client.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.0/api/readline.html">readline</a>
 * module.
 *
 * @author Chad Retz
 */
public class ReadLine extends JavaScriptObject implements NodeJsModule {

    private static ReadLine instance;
    
    public static ReadLine get() {
        if (instance == null) {
            instance = Global.get().require("readline");
        }
        return instance;
    }
    
    protected ReadLine() {
    }

    //TODO: wait on docs or read code
}
