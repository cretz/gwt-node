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
package org.gwtnode.client.node.event;

import org.gwtnode.client.JavaScriptFunctionArguments;
import org.gwtnode.client.JavaScriptFunctionWrapper;
import org.gwtnode.client.node.buffer.Buffer;

public abstract class StringOrBufferEventHandler extends JavaScriptFunctionWrapper {
    
    private Buffer buffer;
    private String string;

    @Override
    public void call(JavaScriptFunctionArguments args) {
        if (args.get(0) instanceof String) {
            string = (String) args.get(0);
        } else {
            buffer = (Buffer) args.get(0);
        }
        onEvent();
    }
    
    public Buffer getBuffer() {
        return buffer;
    }
    
    public String getString() {
        return string;
    }
    
    protected abstract void onEvent();
}