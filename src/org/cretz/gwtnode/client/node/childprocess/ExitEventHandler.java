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
package org.cretz.gwtnode.client.node.childprocess;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;

/**
 * Event handler for the exit event on {@link Child}
 * 
 * @author Chad Retz
 */
public abstract class ExitEventHandler extends JavaScriptFunctionWrapper {
    
    @Override
    public void call(Object... arguments) {
        Integer code = null;
        String signal = null;
        if (arguments.length > 0) {
            code = (Integer) arguments[0];
            if (arguments.length > 1) {
                signal = (String) arguments[1];
            }
        }
        onEvent(code, signal);
    }
    
    protected abstract void onEvent(Integer code, String signal);
}