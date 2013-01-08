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
package org.gwtnode.modules.mysql;

import org.gwtnode.core.meta.GwtNodeEvent;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.meta.GwtNodeProperty;
import org.gwtnode.core.node.event.EventEmitter;
import org.gwtnode.core.node.event.ParameterlessEventHandler;
import org.gwtnode.modules.mysql.events.FieldsEventHandler;
import org.gwtnode.modules.mysql.events.MySQLErrorEventHandler;
import org.gwtnode.modules.mysql.events.OkEventHandler;
import org.gwtnode.modules.mysql.events.RowEventHandler;

@GwtNodeObject
public class Query extends EventEmitter {

	protected Query() {}

	@GwtNodeProperty
	public final native String sql() /*-{
    return this.sql;
	}-*/;

	@GwtNodeProperty
	public final native boolean typeCast() /*-{
    return this.typeCast;
	}-*/;

	@GwtNodeEvent
	public final void onError(MySQLErrorEventHandler handler) {
		on("error", handler);
	}

	@GwtNodeEvent
	public final void onFields(FieldsEventHandler handler) {
		on("fields", handler);
	}

	@GwtNodeEvent
	public final void onResult(RowEventHandler handler) {
		on("result", handler);
	}

	@GwtNodeEvent
	public final void onResult(OkEventHandler handler) {
		on("result", handler);
	}

	@GwtNodeEvent
	public final void onEnd(ParameterlessEventHandler handler) {
		on("end", handler);
	}
}
