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
package org.cretz.gwtnode.client.node.dns;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;

/**
 * Callback for the lookup method in {@link Dns}
 * 
 * @author Chad Retz
 */
public abstract class LookupEventHandler extends JavaScriptFunctionWrapper {

    @Override
    public void call(Object... arguments) {
        onEvent((Error) arguments[0],
                arguments.length > 1 ? (String) arguments[1] : null,
                arguments.length > 2 ? (Integer) arguments[2] : null);
    }
    
    protected abstract void onEvent(Error err, String address, Integer family);

}
