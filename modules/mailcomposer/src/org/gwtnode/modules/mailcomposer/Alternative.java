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

import org.gwtnode.core.node.buffer.Buffer;
import org.gwtnode.modules.mailcomposer.MailOptions.Encoding;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * In addition to text and HTML, any kind of data can be inserted as an alternative content of the main body - for
 * example a word processing document with the same text as in the HTML field. It is the job of the e-mail client to
 * select and show the best fitting alternative to the reader.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
public class Alternative extends JavaScriptObject {

	public final static Alternative create() {
		return JavaScriptObject.createObject().<Alternative> cast();
	}

	public final static Alternative create(String contentType, Encoding contentEncoding, Buffer contents) {
		Alternative result = create();
		result.contentType(contentType);
		result.setContentEncoding(contentEncoding);
		result.contents(contents);
		return result;
	}
	
	protected Alternative() {}

	/**
	 * Optional content type for the attachment, if not set will be set to "application/octet-stream"
	 */
	public final native String contentType() /*-{
		return this.contentType;
	}-*/;

	/**
	 * Optional content type for the attachment, if not set will be set to "application/octet-stream"
	 */
	public final native void contentType(String contentType) /*-{
		this.contentType = contentType;
	}-*/;
	
	/**
	 * Optional value of how the data is encoded, defaults to "base64"
	 */
	public final native String contentEncoding() /*-{
		return this.contentEncoding;
	}-*/;
	
	/**
	 * Optional value of how the data is encoded, defaults to "base64"
	 */
	public final native void contentEncoding(String contentEncoding) /*-{
		this.contentEncoding = contentEncoding;
	}-*/;

	/**
	 * Gets transfer encoding for the textual parts (defaults to {@link Encoding#BASE_64})
	 */
	public final Encoding getContentEncoding() {
		String enc = contentEncoding();
		if (enc != null)
			for (Encoding value : Encoding.values())
				if (value.toString().equalsIgnoreCase(enc))
					return value;
		return Encoding.BASE_64;
	}

	/**
	 * Sets transfer encoding for the textual parts (defaults to {@link Encoding#BASE_64})
	 */
	public final void setContentEncoding(Encoding contentEncoding) {
		if (contentEncoding == null) contentEncoding = Encoding.BASE_64;
		contentEncoding(contentEncoding.toString());
	}
	
	/**
	 * Contents for attachment
	 */
	public final native Buffer contents() /*-{
		return this.contents;
	}-*/;

	/**
	 * Contents for attachment
	 */
	public final native void contents(Buffer contents) /*-{
		this.contents = contents;
	}-*/;
}
