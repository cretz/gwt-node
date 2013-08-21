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
package org.gwtnode.modules.mailcomposer;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.meta.GwtNodeEvent;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeModule;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;
import org.gwtnode.core.node.event.BufferEventHandler;
import org.gwtnode.core.node.event.EventEmitter;
import org.gwtnode.core.node.event.ParameterlessEventHandler;
import org.gwtnode.core.node.event.StringEventHandler;

/**
 * <p>The node.js <a href="https://github.com/andris9/mailcomposer">mailcomposer</a> module.</p>
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeModule
public class MailComposer extends EventEmitter implements NodeJsModule {

	private static MailComposer instance;

	private static MailComposer getInstance() {
		if (instance == null) instance = Global.get().require("mailcomposer");
		return instance;
	}

	@GwtNodeFunction("constructor")
	public static final native MailComposer create() /*-{
		return new (@org.gwtnode.modules.mailcomposer.MailComposer::getInstance()()).MailComposer();
	}-*/;
	
	@GwtNodeFunction("constructor")
	public static final native MailComposer create(MailOptions mailOptions) /*-{
		return new (@org.gwtnode.modules.mailcomposer.MailComposer::getInstance()()).MailComposer(mailOptions);
	}-*/;
	
	protected MailComposer() {}
	
	/**
	 * Adds a header field to the headers object
	 * 
	 * @param key
	 *          Key name
	 * @param value
	 *          Header value
	 * @param formatted
	 *          If set to true, the value is not modified and passed to output as is
	 */
	@GwtNodeFunction
	public final native void addHeader(String key, String value, boolean formatted) /*-{
		this.addHeader(key, value, formatted);
	}-*/;

	/**
	 * Resets and initializes MailComposer. Setting an option overwrites an earlier setup for the same keys.
	 */
	@GwtNodeFunction
	public final native void setMessageOption(MessageOptions messageOptions) /*-{
		this.setMessageOption(messageOptions);
	}-*/;

	/**
	 * Adds an alternative to the list.
	 */
	@GwtNodeFunction
	public final native void addAlternative(Alternative alternative) /*-{
		this.addAlternative(alternative);
	}-*/;
	
	/**
	 * Adds an attachment to the list.<br>
	 * One of {@link Attachment#contents()} or {@link Attachment#filePath()} or {@link Attachment#stream()} must be
	 * specified, otherwise the attachment is not included.
	 */
	@GwtNodeFunction
	public final native void addAttachment(Attachment attachment) /*-{
		this.addAttachment(attachment);
	}-*/;

	/**
	 * Starts streaming the message.
	 */
	@GwtNodeFunction
	public final native void streamMessage() /*-{
		this.streamMessage();
	}-*/;

	/**
	 * Builds the entire message and returns it as a string.
	 */
	@GwtNodeFunction
	public final void buildMessage(StringEventHandler callback) {
		buildMessage(callback != null ? callback.getNativeFunction() : null);
	}

	/**
	 * Builds the entire message and returns it as a string.
	 */
	@GwtNodeFunction
	public final native void buildMessage(JavaScriptFunction callback) /*-{
		this.buildMessage(callback);
	}-*/;
	
	/**
	 * Emits a chunk of data.
	 */
	@GwtNodeEvent
	public final void onData(BufferEventHandler handler) {
		on("data", handler);
	}
	
	/**
	 * Composing the message has ended
	 */
	@GwtNodeEvent
	public final void onEnd(ParameterlessEventHandler handler) {
		on("end", handler);
	}
}
