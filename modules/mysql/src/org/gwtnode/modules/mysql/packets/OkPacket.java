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
package org.gwtnode.modules.mysql.packets;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Sample:
 * <pre>
 * <-- OkPacket
 * { fieldCount: 0,
 *   affectedRows: 0,
 *   insertId: 0,
 *   serverStatus: 2,
 *   warningCount: 0,
 *   message: '',
 *   changedRows: 0 }
 * </pre>
 */
public class OkPacket extends JavaScriptObject {

	protected OkPacket() {}

	public final native int getFieldCount() /*-{
    return this.fieldCount;
	}-*/;

	public final native int getAffectedRows() /*-{
    return this.affectedRows;
	}-*/;

	public final native int getInsertId() /*-{
    return this.insertId;
	}-*/;

	public final native int getServerStatus() /*-{
    return this.serverStatus;
	}-*/;

	public final native int getWarningCount() /*-{
    return this.warningCount;
	}-*/;

	public final native int getChangedRows() /*-{
    return this.changedRows;
	}-*/;

	public final native String getMessage() /*-{
    return this.message;
	}-*/;
}
