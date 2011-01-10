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
package org.cretz.gwtnode.client.node.process;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.UnsafeNativeLong;

/**
 * A node.js memory usage object as returned by
 * {@link Process#memoryUsage()}
 * 
 * @author Chad Retz
 */
public class MemoryUsage extends JavaScriptObject {

    protected MemoryUsage() {
    }
    
    @UnsafeNativeLong
    public final native long rss() /*-{
        return this.rss;
    }-*/;

    @UnsafeNativeLong
    public final native long vsize() /*-{
        return this.vsize;
    }-*/;

    @UnsafeNativeLong
    public final native long heapTotal() /*-{
        return this.heapTotal;
    }-*/;

    @UnsafeNativeLong
    public final native long heapUsed() /*-{
        return this.heapUsed;
    }-*/;
}
