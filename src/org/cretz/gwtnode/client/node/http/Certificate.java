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
package org.cretz.gwtnode.client.node.http;

import com.google.gwt.core.client.JavaScriptObject;

public class Certificate extends JavaScriptObject {

    protected Certificate() {
    }
    
    public final native String subject() /*-{
        return this.subject;
    }-*/;
    
    public final native String issuer() /*-{
        return this.issuer;
    }-*/;
    
    public final native String validFrom() /*-{
        return this.valid_from;
    }-*/;
    
    public final native String validTo() /*-{
        return this.valid_to;
    }-*/;
}
