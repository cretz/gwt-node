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
package org.gwtnode.modules.nodemailer;

import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.meta.GwtNodeProperty;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An object with some information about the status on success.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class ResponseStatus extends JavaScriptObject {

	/**
	 * Message ID used with the message
	 */
	@GwtNodeProperty
	public final native String messageId() /*-{
		return this.messageId;
	}-*/;

	/**
	 * Message ID used with the message
	 */
	@GwtNodeProperty
	public final native void messageId(String messageId) /*-{
		this.messageId = messageId;
	}-*/;

	/**
	 * Response from the server
	 */
	@GwtNodeProperty
	public final native String message() /*-{
		return this.message;
	}-*/;

	/**
	 * Response from the server
	 */
	@GwtNodeProperty
	public final native void message(String message) /*-{
		this.message = message;
	}-*/;
	
	protected ResponseStatus() {}
}
