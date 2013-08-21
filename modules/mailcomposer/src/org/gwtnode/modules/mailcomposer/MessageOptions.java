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

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Options for {@link MailComposer#setMessageOption(MessageOptions)}.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
public class MessageOptions extends JavaScriptObject {

	public final static MessageOptions create() {
		return JavaScriptObject.createObject().<MessageOptions> cast();
	}
	
	public final static MessageOptions create(
			String from, String to, String cc, String bcc, String replyTo, String subject, String body, String html) {
		MessageOptions result = create();
		result.from(from);
		result.to(to);
		result.cc(cc);
		result.bcc(bcc);
		result.replyTo(replyTo);
		result.subject(subject);
		result.body(body);
		result.html(html);
		return result;
	}
	
	protected MessageOptions() {}

	/**
	 * The e-mail address of the sender. All e-mail addresses can be plain <code>sender@server.com</code> or formatted
	 * <code>Sender Name &lt;sender@server.com&gt;</code>
	 */
	public final native String from() /*-{
		return this.from;
	}-*/;

	/**
	 * The e-mail address of the sender. All e-mail addresses can be plain <code>sender@server.com</code> or formatted
	 * <code>Sender Name &lt;sender@server.com&gt;</code>
	 */
	public final native void from(String from) /*-{
		this.from = from;
	}-*/;

	/**
	 * Comma separated list of recipients e-mail addresses that will appear on the <code>To:</code> field
	 */
	public final native String to() /*-{
		return this.to;
	}-*/;

	/**
	 * Comma separated list of recipients e-mail addresses that will appear on the <code>To:</code> field
	 */
	public final native void to(String to) /*-{
		this.to = to;
	}-*/;

	/**
	 * Comma separated list of recipients e-mail addresses that will appear on the <code>Cc:</code> field
	 */
	public final native String cc() /*-{
		return this.cc;
	}-*/;

	/**
	 * Comma separated list of recipients e-mail addresses that will appear on the <code>Cc:</code> field
	 */
	public final native void cc(String cc) /*-{
		this.cc = cc;
	}-*/;

	/**
	 * Comma separated list of recipients e-mail addresses that will appear on the <code>Bcc:</code> field
	 */
	public final native String bcc() /*-{
		return this.bcc;
	}-*/;

	/**
	 * Comma separated list of recipients e-mail addresses that will appear on the <code>Bcc:</code> field
	 */
	public final native void bcc(String bcc) /*-{
		this.bcc = bcc;
	}-*/;

	/**
	 * An e-mail address that will appear on the <code>Reply-To:</code> field
	 */
	public final native String replyTo() /*-{
		return this.replyTo;
	}-*/;

	/**
	 * An e-mail address that will appear on the <code>Reply-To:</code> field
	 */
	public final native void replyTo(String replyTo) /*-{
		this.replyTo = replyTo;
	}-*/;

	/**
	 * The subject of the e-mail
	 */
	public final native String subject() /*-{
		return this.subject;
	}-*/;

	/**
	 * The subject of the e-mail
	 */
	public final native void subject(String subject) /*-{
		this.subject = subject;
	}-*/;

	/**
	 * The plaintext version of the message
	 */
	public final native String body() /*-{
		return this.body;
	}-*/;

	/**
	 * The plaintext version of the message
	 */
	public final native void body(String body) /*-{
		this.body = body;
	}-*/;

	/**
	 * The HTML version of the message
	 */
	public final native String html() /*-{
		return this.html;
	}-*/;

	/**
	 * The HTML version of the message
	 */
	public final native void html(String html) /*-{
		this.html = html;
	}-*/;
}
