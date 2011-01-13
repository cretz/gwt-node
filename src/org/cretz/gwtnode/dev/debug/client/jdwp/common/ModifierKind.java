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
package org.cretz.gwtnode.dev.debug.client.jdwp.common;

public enum ModifierKind {
    
    COUNT,
    CONDITIONAL,
    THREAD_ONLY,
    CLASS_ONLY,
    CLASS_MATCH,
    CLASS_EXCLUDE,
    LOCATION_ONLY,
    EXCEPTION_ONLY,
    FIELD_ONLY,
    STEP,
    INSTANCE_ONLY,
    SOURCE_NAME_MATCH;
    
    public static ModifierKind fromNumber(int number) {
        if (number > values().length) {
            return null;
        } else {
            return values()[number - 1];
        }
    }
    
    public int getNumber() {
        return ordinal() + 1;
    }
}
