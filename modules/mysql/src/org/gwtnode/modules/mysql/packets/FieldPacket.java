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
 * <-- FieldPacket
 * { catalog: 'def',
 *   db: '',
 *   table: '',
 *   orgTable: '',
 *   name: 'solution',
 *   orgName: '',
 *   filler1: <Buffer 0c>,
 *   charsetNr: 63,
 *   length: undefined,
 *   type: 8,
 *   flags: 129,
 *   decimals: 0,
 *   filler2: <Buffer 00 00>,
 *   default: undefined,
 *   zeroFill: false,
 *   fieldLength: 3 }
 * </pre>
 */
public class FieldPacket extends JavaScriptObject {

	private final native String getDb() /*-{
    return this.db;
	}-*/;

	private final native String getTable() /*-{
    return this.table;
	}-*/;

	private final native String getName() /*-{
    return this.name;
	}-*/;

	private final native int getType() /*-{
    return this.type;
	}-*/;

	private final native int getCharsetNumber() /*-{
    return this.charsetNr;
	}-*/;

	private final native int getLength() /*-{
    return this.length === undefined ? 0 : this.length;
	}-*/;

	private final native int getDecimals() /*-{
    return this.decimals;
	}-*/;

	protected FieldPacket() {}
}
