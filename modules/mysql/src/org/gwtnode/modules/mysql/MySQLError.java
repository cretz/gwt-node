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

import org.gwtnode.core.node.NodeJsError;

public class MySQLError extends NodeJsError {
	
	public static final native MySQLError create(String code, boolean fatal) /*-{
    var err = new Error();
    err.code = code;
    err.fatal = fatal;
	}-*/;
	
	public static final MySQLError create(String code) {
		return create(code, false);
	}

	protected MySQLError() {}

	/**
	 * Gets either a MySQL server error (e.g. 'ER_ACCESS_DENIED_ERROR'), 
	 * a node.js error (e.g. 'ECONNREFUSED') or an internal error (e.g. 'PROTOCOL_CONNECTION_LOST').
	 * @return Error code
	 */
	public final native String getCode() /*-{
		return this.code;
	}-*/;

	/**
	 * Indicates if this error is terminal to the connection object.
	 * @return {@code true} if error is fatal.
	 */
	public final native boolean isFatal() /*-{
		return this.fatal;
	}-*/;

	/**
	 * Takes Node.js full message and removes error code from there.
	 * @return Error description.
	 */
	public final String getMessage() {
		String result = message();
		if (result != null && getCode() != null)
			result = result.replaceFirst("^" + getCode() + ":\\s*", "");
		return result;
	}

	private final native String message() /*-{
    return this.message;
	}-*/;
}
