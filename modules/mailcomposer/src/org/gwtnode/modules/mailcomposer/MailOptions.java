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

public class MailOptions extends JavaScriptObject {

	public enum Encoding {
		
		QUOTED_PRINTABLE {
			@Override
			public String toString() {
				return "quoted-printable";
			}
		},
		BASE_64 {
			@Override
			public String toString() {
				return "base64";
			}
		},
		SEVEN_BIT {
			@Override
			public String toString() {
				return "7bit";
			}
		},
		EIGHT_BIT {
			@Override
			public String toString() {
				return "8bit";
			}
		}
	}
	
	public final static MailOptions create() {
		return JavaScriptObject.createObject().<MailOptions> cast();
	}
	
	public final static MailOptions create(
			boolean escapeSMTP, Encoding encoding, String charset, boolean keepBcc, boolean forceEmbeddedImages) {
		MailOptions result = create();
		result.escapeSMTP(escapeSMTP);
		result.setEncoding(encoding);
		result.charset(charset);
		result.keepBcc(keepBcc);
		result.forceEmbeddedImages(forceEmbeddedImages);
		return result;
	}
	
	protected MailOptions() {}
	
	/**
	 * If set replaces dots in the beginning of a line with double dots
	 */
	public final native boolean escapeSMTP() /*-{
		return this.escapeSMTP;
	}-*/;
	
	/**
	 * If set replaces dots in the beginning of a line with double dots
	 */
	public final native void escapeSMTP(boolean escapeSMTP) /*-{
		this.escapeSMTP = escapeSMTP;
	}-*/;
	
	/**
	 * Sets transfer encoding for the textual parts (defaults to "quoted-printable")
	 */
	public final native String encoding() /*-{
		return this.encoding;
	}-*/;
	
	/**
	 * Sets transfer encoding for the textual parts (defaults to "quoted-printable")
	 */
	public final native void encoding(String encoding) /*-{
		this.encoding = encoding;
	}-*/;

	/**
	 * Gets transfer encoding for the textual parts (defaults to {@link Encoding#QUOTED_PRINTABLE})
	 */
	public final Encoding getEncoding() {
		String enc = encoding();
		if (enc != null)
			for (Encoding value : Encoding.values())
				if (value.toString().equalsIgnoreCase(enc))
					return value;
		return Encoding.QUOTED_PRINTABLE;
	}

	/**
	 * Sets transfer encoding for the textual parts (defaults to {@link Encoding#QUOTED_PRINTABLE})
	 */
	public final void setEncoding(Encoding encoding) {
		if (encoding == null) encoding = Encoding.QUOTED_PRINTABLE;
		encoding(encoding.toString());
	}
	
	/**
	 * Sets output character set for strings (defaults to "utf-8")
	 */
	public native String charset() /*-{
		return this.charset;
	}-*/;
	
	/**
	 * Sets output character set for strings (defaults to "utf-8")
	 */
	public native void charset(String charset) /*-{
		this.charset = charset;
	}-*/;
	
	/**
	 * If set to true, includes Bcc: field in the message headers. Useful for sendmail command.
	 */
	public native boolean keepBcc() /*-{
		return this.keepBcc;
	}-*/;
	
	/**
	 * If set to true, includes Bcc: field in the message headers. Useful for sendmail command.
	 */
	public native void keepBcc(boolean keepBcc) /*-{
		this.keepBcc = keepBcc;
	}-*/;
	
	/**
	 * Convert image urls and absolute paths in HTML to embedded attachments.
	 */
	public native boolean forceEmbeddedImages() /*-{
		return this.forceEmbeddedImages;
	}-*/;
	
	/**
	 * Convert image urls and absolute paths in HTML to embedded attachments.
	 */
	public native void forceEmbeddedImages(boolean forceEmbeddedImages) /*-{
		this.forceEmbeddedImages = forceEmbeddedImages;
	}-*/;
}
