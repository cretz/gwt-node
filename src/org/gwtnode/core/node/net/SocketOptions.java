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
package org.gwtnode.core.node.net;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Chad Retz
 */
public class SocketOptions extends JavaScriptObject {

    public static final SocketOptions create() {
        return JavaScriptObject.createObject().cast();
    }
    
    protected SocketOptions() {
    }
    
    public final native Integer fd() /*-{
        return this.fd;
    }-*/;
    
    public final native void fd(Integer fd) /*-{
        this.fd = fd;
    }-*/;
    
    public final native Integer type() /*-{
        return this.type;
    }-*/;
    
    public final native void type(Integer type) /*-{
        this.type = type;
    }-*/;
    
    public final native boolean allowHalfOpen() /*-{
        return this.allowHalfOpen;
    }-*/;
    
    public final native void allowHalfOpen(boolean allowHalfOpen) /*-{
        this.allowHalfOpen = allowHalfOpen;
    }-*/;
}
