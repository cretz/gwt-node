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
import org.gwtnode.core.JsonStringObjectMap;
import org.gwtnode.core.meta.GwtNodeEvent;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.node.event.EventEmitter;
import org.gwtnode.core.node.event.ParameterlessEventHandler;

import com.google.gwt.core.client.JavaScriptObject;

@GwtNodeObject
public class System extends EventEmitter {

	@GwtNodeFunction("constructor")
	public static final native System create(String urn) /*-{
		return new (@org.gwtnode.modules.cassandra.Cassandra::get()()).System(urn);
	}-*/;

	protected System() {}
	
	@GwtNodeFunction
	public final void addKeyspace(JsonStringObjectMap<?> ksDef, ThriftConnectionEventHandler callback) {
		addKeyspace(ksDef != null ? ksDef.getNativeObject() : null,
				callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void addKeyspace(JavaScriptObject ksDef, JavaScriptFunction callback) /*-{
		this.addKeyspace(ksDef, callback);
	}-*/;
	
	@GwtNodeFunction
	public final void describeKeyspace(String ksName, ThriftConnectionEventHandler callback) {
		describeKeyspace(ksName, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void describeKeyspace(String ksName, JavaScriptFunction callback) /*-{
		this.describeKeyspace(ksName, callback);
	}-*/;
	
	@GwtNodeFunction
	public final void close(ParameterlessEventHandler callback) {
		close(callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void close(JavaScriptFunction callback) /*-{
		this.close(callback);
	}-*/;
	
	@GwtNodeEvent
	public final void onCheckq(ParameterlessEventHandler handler) {
		on("checkq", handler);
	}
}
