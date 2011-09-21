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
package org.gwtnode.core.node.http;

import org.gwtnode.core.node.event.EventEmitter;
import org.gwtnode.core.node.event.ParameterlessEventHandler;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

/**
 * @author Chad Retz
 */
public class Agent extends EventEmitter {

    protected Agent() {
    }
    
    public final void onUpgrade(ServerUpgradeEventHandler handler) {
        on("upgrade", handler);
    }
    
    public final void onContinue(ParameterlessEventHandler handler) {
        on("continue", handler);
    }

    public final native int maxSockets() /*-{
        return this.maxSockets;
    }-*/;
    
    public final native void maxSockets(int maxSockets) /*-{
        this.maxSockets = maxSockets;
    }-*/;
    
    public final native JsArrayString sockets() /*-{
        return this.sockets;
    }-*/;
    
    public final native JsArray<ClientRequest> requests() /*-{
        return this.requests;
    }-*/;
}
