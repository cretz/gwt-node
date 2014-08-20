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

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.node.event.ErrorEventHandler;
import org.gwtnode.modules.mailcomposer.MessageOptions;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Transport object that can be used to deliver e-mail.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class Transport extends JavaScriptObject {
	
	public enum Type {
		SMTP, SES, SENDMAIL, STUB
	}
	
	protected Transport() {}

	/**
	 * Sends given {@code emailMessage} using corresponding transport that was defined in
	 * {@link Nodemailer#createTransport()}
	 */
	@GwtNodeFunction
	public final void sendMail(MessageOptions emailMessage, ResponseEventHandler callback) {
		sendMail(emailMessage, callback != null ? callback.getNativeFunction() : null);
	}
	
	/**
	 * Sends given {@code emailMessage} using corresponding transport that was defined in
	 * {@link Nodemailer#createTransport()}
	 */
	@GwtNodeFunction
	public final native void sendMail(MessageOptions emailMessage, JavaScriptFunction callback) /*-{
		this.sendMail(emailMessage, callback);
	}-*/;

	/**
	 * Closes the transport when needed, useful with SMTP (which uses connection pool) but not so much with SES or
	 * Sendmail
	 */
	@GwtNodeFunction
	public final void close(ErrorEventHandler callback) {
		close(callback != null ? callback.getNativeFunction() : null);
	}
	
	/**
	 * Closes the transport when needed, useful with SMTP (which uses connection pool) but not so much with SES or
	 * Sendmail
	 */
	@GwtNodeFunction
	public final native void close(JavaScriptFunction callback) /*-{
		this.close(callback);
	}-*/;
}
