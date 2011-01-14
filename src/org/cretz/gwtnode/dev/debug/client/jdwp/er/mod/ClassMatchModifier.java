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
package org.cretz.gwtnode.dev.debug.client.jdwp.er.mod;

import org.cretz.gwtnode.client.node.buffer.Buffer;
import org.cretz.gwtnode.dev.debug.client.jdwp.BufferUtils;

public class ClassMatchModifier extends Modifier {

    private String classPattern;
    
    public String getClassPattern() {
        return classPattern;
    }
    
    public void setClassPattern(String classPattern) {
        this.classPattern = classPattern;
    }
    
    @Override
    public int buildFromBuffer(Buffer buffer, int startIndex) {
        int len = BufferUtils.toInteger(buffer.slice(startIndex, startIndex + 4));
        classPattern = BufferUtils.toString(buffer.slice(startIndex + 4, startIndex + 4 + len));
        return startIndex + 4 + len;
    }
}
