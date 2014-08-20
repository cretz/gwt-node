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

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeModule;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * <p>The node.js <a href="https://github.com/felixge/node-mysql">node-mysql</a> module.</p>
 * <p>Sample usage:</p>
 * <pre>
 * connection = MySQL.get().createConnection("mysql://scott:secret@localhost/test?debug=true");
 * connection.connect(new MySQLErrorEventHandler() {
 *   {@literal @}Override
 *   public void onEvent(MySQLError error) {
 *     if (error != null)
 *       Util.get().debug("error.code=" + error.getCode() + "; error.message=" error.getMessage());
 *   }
 * });
 * 
 * final JsArray&lt;Invoice> results = JavaScriptObject.createArray().cast();
 * Query q = connection.query("SELECT * FROM invoice WHERE group=?", 5);
 * q.onError(new MySQLErrorEventHandler() {
 *   {@literal @}Override
 *   public void onEvent(MySQLError error) {
 *     Util.get().debug("error=" + Util.get().inspect(error));
 *   }
 * });
 * q.onResult(new RowEventHandler() {
 *   {@literal @}Override
 *   public void onEvent(RowDataPacket rowDataPacket) {
 *     Invoice item = rowDataPacket.getJavaScriptObject().cast();
 *     results.push(item);
 *   }
 * });
 * q.onEnd(new ParameterlessEventHandler() {
 *   {@literal @}Override
 *   public void onEvent() {
 *     Util.get().log("results=" + Util.get().inspect(results));
 *   }
 * });
 * </pre>
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeModule
public class MySQL extends JavaScriptObject implements NodeJsModule {

	private static MySQL instance;

	public static MySQL get() {
		if (instance == null) instance = Global.get().require("mysql");
		return instance;
	}
	
	protected MySQL() {}
	
	@GwtNodeFunction
	public final native Connection createConnection(ConnectionOptions options) /*-{
		return this.createConnection(options);
	}-*/;
	
	@GwtNodeFunction
	public final native Connection createConnection(String url) /*-{
		return this.createConnection(url);
	}-*/;
}
