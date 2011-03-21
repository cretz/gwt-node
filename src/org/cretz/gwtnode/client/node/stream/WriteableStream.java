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
package org.cretz.gwtnode.client.node.stream;

import org.cretz.gwtnode.client.node.buffer.Buffer;
import org.cretz.gwtnode.client.node.event.ParameterlessEventHandler;

/**
 * A node.js
 * <a href="http://nodejs.org/docs/v0.4.3/api/streams.html#writeable_Stream">WriteableStream</a>
 * @author Chad Retz
 */
public class WriteableStream extends Stream {
    
    protected WriteableStream() {
    }
    
    public final void onDrain(ParameterlessEventHandler handler) {
        on("drain", handler);
    }
    
    /**
     * @param handler
     * @since 0.2.0
     */
    public final void onPipe(PipeEventHandler handler) {
        on("pipe", handler);
    }
    
    public final native boolean writeable() /*-{
        return this.writeable;
    }-*/;
    
    public final native boolean write(String string) /*-{
        return this.write(string);
    }-*/;
    
    public final native boolean write(String string, String encoding) /*-{
        return this.write(string, encoding);
    }-*/;
    
    public final native boolean write(String string, String encoding, int fd) /*-{
        return this.write(string, encoding, fd);
    }-*/;
    
    public final native boolean write(Buffer buffer) /*-{
        return this.write(buffer);
    }-*/;
    
    public final native void end() /*-{
        this.end();
    }-*/;
    
    public final native void end(String string) /*-{
        this.end(string);
    }-*/;
    
    public final native void end(String string, String encoding) /*-{
        this.end(string, encoding);
    }-*/;
    
    public final native void end(Buffer buffer) /*-{
        this.end(buffer);
    }-*/;
}
