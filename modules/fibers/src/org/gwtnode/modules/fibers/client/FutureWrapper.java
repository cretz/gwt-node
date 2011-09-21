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
package org.gwtnode.modules.fibers.client;

import org.gwtnode.client.JavaScriptFunction;
import org.gwtnode.client.JavaScriptFunctionArguments;

/**
 * The result of Future.wrap()
 * 
 * @author Chad Retz
 */
public class FutureWrapper<T> {

    private final JavaScriptFunction func;
    
    FutureWrapper(JavaScriptFunction func) {
        this.func = func;
    }
    
    public final native T callAndWait(JavaScriptFunctionArguments args) /*-{
        var func = this.@org.gwtnode.modules.fibers.client.FutureWrapper::func;
        return func(args).wait();
    }-*/;
}
