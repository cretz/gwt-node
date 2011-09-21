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
package org.gwtnode.core.node.process;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A node.js memory usage object as returned by
 * {@link Process#memoryUsage()}
 * 
 * @author Chad Retz
 */
public class MemoryUsage extends JavaScriptObject {

    protected MemoryUsage() {
    }
    
    public final native double rss() /*-{
        return this.rss;
    }-*/;

    public final native double vsize() /*-{
        return this.vsize;
    }-*/;

    public final native double heapTotal() /*-{
        return this.heapTotal;
    }-*/;

    public final native double heapUsed() /*-{
        return this.heapUsed;
    }-*/;
}
