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
package org.gwtnode.modules.fibers;

import org.gwtnode.core.JavaScriptFunctionArguments;
import org.gwtnode.core.JavaScriptFunctionWrapper;

/**
* Creation callback for a fiber that doesn't return.
*
* @author Chad Retz
*/
public abstract class FiberCallback extends JavaScriptFunctionWrapper {

    @Override
    public final void call(JavaScriptFunctionArguments args) {
        if (args.length() > 0) {
            onCreate(args.get(0));
        } else {
            onCreate(null);
        }
    }

    public abstract void onCreate(Object param);
}
