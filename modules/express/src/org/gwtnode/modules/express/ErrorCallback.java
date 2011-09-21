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

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.JavaScriptFunctionArguments;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.core.node.NodeJsError;

/**
 * @author Chad Retz
 */
public abstract class ErrorCallback extends JavaScriptFunctionWrapper {

    @Override
    public void call(JavaScriptFunctionArguments args) {
        onError((NodeJsError) args.get(0), (Request) args.get(1), 
                (Response) args.get(2), (NextCall) args.get(3));
    }
    
    protected abstract void onError(NodeJsError error, Request request, 
            Response response, NextCall call);

    protected static class NextCall extends JavaScriptFunction {
        
        private NextCall() {
        }
        
        public final void next(NodeJsError error) {
            apply(error);
        }
    }
}
