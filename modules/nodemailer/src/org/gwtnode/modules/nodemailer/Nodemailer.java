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

import static org.gwtnode.modules.nodemailer.Transport.Type.SENDMAIL;
import static org.gwtnode.modules.nodemailer.Transport.Type.SES;
import static org.gwtnode.modules.nodemailer.Transport.Type.SMTP;
import static org.gwtnode.modules.nodemailer.Transport.Type.STUB;

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeModule;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * <p>The node.js <a href="http://www.nodemailer.com/">nodemaile</a> module.</p>
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeModule
public class Nodemailer extends JavaScriptObject implements NodeJsModule {
	
	private static Nodemailer instance;
	
	public static Nodemailer get() {
		if (instance == null) instance = Global.get().require("nodemailer");
		return instance;
	}
	
	protected Nodemailer() {}

	@GwtNodeFunction
	public final Transport createTransport(SMTPOptions options) {
		return createTransport(SMTP.toString(), options);
	}

	@GwtNodeFunction
	public final Transport createTransport(SESOptions options) {
		return this.createTransport(SES.toString(), options);
	}

	@GwtNodeFunction
	public final Transport createTransport(SendmailOptions options) {
		return this.createTransport(SENDMAIL.toString(), options);
	}

	@GwtNodeFunction
	public final Transport createTransport(StubOptions options) {
		return this.createTransport(STUB.toString(), options);
	}
	
	@GwtNodeFunction
	public final native Transport createTransport(String type, JavaScriptObject options) /*-{
		return this.createTransport(type, options);
	}-*/;
}
