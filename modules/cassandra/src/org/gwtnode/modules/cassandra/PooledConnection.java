/*
 * Copyright 2013 Maxim Dominichenko
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
package org.gwtnode.modules.cassandra;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.meta.GwtNodeEvent;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.node.event.ParameterlessEventHandler;

@GwtNodeObject
public class PooledConnection extends Connection {
	
	@GwtNodeFunction("constructor")
	public static final native PooledConnection create(PoolOptions options) /*-{
		return new (@org.gwtnode.modules.cassandra.Cassandra::get()()).PooledConnection(options);
	}-*/;
	
	protected PooledConnection() {}

	/**
	 * Signal the pool to shutdown. Once called, no new requests ({@link #execute(String, Object[], RowsEventHandler)})
	 * can be made. When all pending requests have terminated, the callback is run.
	 * 
	 * @param callback
	 *          Called when the pool is fully shutdown.
	 */
	@GwtNodeFunction
	public final void shutdown(ParameterlessEventHandler callback) {
		shutdown(callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void shutdown(JavaScriptFunction callback) /*-{
		this.shutdown(callback);
	}-*/;
	
	@GwtNodeEvent
	public final void onDrain(ParameterlessEventHandler handler) {
		on("drain", handler);
	}
}
