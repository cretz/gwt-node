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
import org.gwtnode.core.node.stream.Stream;

import com.google.gwt.core.client.JavaScriptObject;

public class Attachment extends JavaScriptObject {

	public final static Attachment create() {
		return JavaScriptObject.createObject().<Attachment> cast();
	}

	public final static Attachment create(
			String fileName, String contentType, String cid, Buffer contents, String contentDisposition) {
		Attachment result = create();
		result.fileName(fileName);
		result.contentType(contentType);
		result.cid(cid);
		result.contents(contents);
		result.contentDisposition(contentDisposition);
		return result;
	}

	public final static Attachment create(
			String fileName, String contentType, String cid, String filePath, String contentDisposition) {
		Attachment result = create();
		result.fileName(fileName);
		result.contentType(contentType);
		result.cid(cid);
		result.filePath(filePath);
		result.contentDisposition(contentDisposition);
		return result;
	}

	public final static Attachment create(
			String fileName, String contentType, String cid, Stream streamSource, String contentDisposition) {
		Attachment result = create();
		result.fileName(fileName);
		result.contentType(contentType);
		result.cid(cid);
		result.streamSource(streamSource);
		result.contentDisposition(contentDisposition);
		return result;
	}
	
	protected Attachment() {}

	/**
	 * Filename to be reported as the name of the attached file, use of unicode is allowed (except when using Amazon SES
	 * which doesn't like it)
	 */
	public final native String fileName() /*-{
		return this.fileName;
	}-*/;

	/**
	 * Filename to be reported as the name of the attached file, use of unicode is allowed (except when using Amazon SES
	 * which doesn't like it)
	 */
	public final native void fileName(String fileName) /*-{
		this.fileName = fileName;
	}-*/;

	/**
	 * Optional content type for the attachment (default will be derived from the {@link #fileName()})
	 */
	public final native String contentType() /*-{
		return this.contentType;
	}-*/;

	/**
	 * Optional content type for the attachment (default will be derived from the {@link #fileName()})
	 */
	public final native void contentType(String contentType) /*-{
		this.contentType = contentType;
	}-*/;

	/**
	 * Optional content id for using inline images in HTML message source
	 */
	public final native String cid() /*-{
		return this.cid;
	}-*/;

	/**
	 * Optional content id for using inline images in HTML message source
	 */
	public final native void cid(String cid) /*-{
		this.cid = cid;
	}-*/;

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

	/**
	 * Path to a file or an URL if you want to stream the file instead of including it (better for larger attachments)
	 */
	public final native String filePath() /*-{
		return this.filePath;
	}-*/;

	/**
	 * Path to a file or an URL if you want to stream the file instead of including it (better for larger attachments)
	 */
	public final native void filePath(String filePath) /*-{
		this.filePath = filePath;
	}-*/;

	/**
	 * {@link Stream} object for arbitrary binary streams if you want to stream the contents (needs to support
	 * pause/resume)
	 */
	public final native Stream streamSource() /*-{
		return this.streamSource;
	}-*/;

	/**
	 * {@link Stream} object for arbitrary binary streams if you want to stream the contents (needs to support
	 * pause/resume)
	 */
	public final native void streamSource(Stream streamSource) /*-{
		this.streamSource = streamSource;
	}-*/;
	
	/**
	 * Optional content disposition type for the attachment, defaults to "attachment"
	 */
	public final native String contentDisposition() /*-{
		return this.contentDisposition;
	}-*/; 
	
	/**
	 * Optional content disposition type for the attachment, defaults to "attachment"
	 */
	public final native void contentDisposition(String contentDisposition) /*-{
		this.contentDisposition = contentDisposition;
	}-*/; 
}
