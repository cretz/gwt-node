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
package org.cretz.gwtnode.dev.debug.client.jdwp.er;

import org.cretz.gwtnode.dev.debug.client.jdwp.common.Location;
import org.cretz.gwtnode.dev.debug.client.jdwp.common.ModifierKind;

@SuppressWarnings("unused")
public class Event {

    private ModifierKind modifierKind;
    private int count;
    private int exprId;
    private int threadId;
    private int referenceTypeId;
    private String pattern;
    private Location location;
    private boolean caught;
    private boolean uncaught;
    private int fieldId;
    private int size;
    private int depth;
    private int objectId;
    
    
}
