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

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.meta.GwtNodeProperty;
import org.gwtnode.core.node.buffer.Buffer;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

@GwtNodeObject
public class Row extends JavaScriptObject {

	protected Row() {}
	
	@GwtNodeFunction
	public final native int colCount() /*-{
		return this.colCount();
	}-*/;

	@GwtNodeProperty
	public final native Buffer key() /*-{
		return this.key;
	}-*/;
	
//	@GwtNodeProperty
//	public final JsonStringObjectMap<?> colHash() {
//		return new JsonStringObjectMap<Object>(colHash0());
//	}
//	
//	@GwtNodeProperty("colHash")
//	private final native JavaScriptObject colHash0() /*-{
//		return this.colHash;
//	}-*/;
//	
	@GwtNodeProperty
	public final native JsArray<Col> cols() /*-{
		return this.cols;
	}-*/;
	
	public final native Col col(String name) /*-{
		return {
			"name" : name,
			"value" : this.colHash[name]
		};
	}-*/;
}
