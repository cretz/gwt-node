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
package org.gwtnode.core.node.fs;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Chad Retz
 */
public class ReadStreamOptions extends JavaScriptObject {

    public static native ReadStreamOptions create() /*-{
        return { };
    }-*/;
    
    public static native ReadStreamOptions create(int start, int end) /*-{
        return { 'start' : start, 'end' : end };
    }-*/;
    
    protected ReadStreamOptions() {
    }
    
    public final native int getStart() /*-{
        return this.start;
    }-*/;
    
    public final native void setStart(int start) /*-{
        this.start = start;
    }-*/;
    
    public final native int getEnd() /*-{
        return this.end;
    }-*/;
    
    public final native void setEnd(int end) /*-{
        this.end = end;
    }-*/;
}
