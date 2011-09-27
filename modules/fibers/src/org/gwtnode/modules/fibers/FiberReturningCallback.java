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
import org.gwtnode.core.JavaScriptReturningFunctionWrapper;

/**
* Fiber callback that returns a value.
*
* @author Chad Retz
*/
public abstract class FiberReturningCallback<T> extends JavaScriptReturningFunctionWrapper<T> {

    @Override
    public final T call(JavaScriptFunctionArguments args) {
        if (args.length() > 0) {
            return onCreate(args.get(0));
        } else {
            return onCreate(null);
        }
    }

    public abstract T onCreate(Object param);
}
