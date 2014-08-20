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
package org.gwtnode.modules.aws.s3.data;

import java.util.Map;

import org.gwtnode.core.JsonStringObjectMap;
import org.gwtnode.core.node.buffer.Buffer;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The de-serialized data returned from the request.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
public class GetObjectData extends JavaScriptObject {

	protected GetObjectData() {}
	
	/**
	 * Object data.
	 */
	public final native Buffer body() /*-{
		return this.Body;
	}-*/;

	/**
	 * Object data.
	 */
	public final native void body(Buffer body) /*-{
		this.Body = body;
	}-*/;
	
	/**
	 * Specifies whether the object retrieved was (true) or was not (false) a Delete Marker. If false, this response
	 * header does not appear in the response.
	 */
	public final native String deleteMarker() /*-{
		return this.DeleteMarker;
	}-*/;

	/**
	 * Specifies whether the object retrieved was (true) or was not (false) a Delete Marker. If false, this response
	 * header does not appear in the response.
	 */
	public final native void deleteMarker(String deleteMarker) /*-{
		this.DeleteMarker = deleteMarker;
	}-*/;
	
	public final native String acceptRanges() /*-{
		return this.AcceptRanges;
	}-*/;

	public final native void acceptRanges(String acceptRanges) /*-{
		this.AcceptRanges = acceptRanges;
	}-*/;
	
	/**
	 * If the object expiration is configured (see PUT Bucket lifecycle), the response includes this header. It includes
	 * the expiry-date and rule-id key value pairs providing object expiration information. The value of the rule-id is
	 * URL encoded.
	 */
	public final native String expiration() /*-{
		return this.Expiration;
	}-*/;

	/**
	 * If the object expiration is configured (see PUT Bucket lifecycle), the response includes this header. It includes
	 * the expiry-date and rule-id key value pairs providing object expiration information. The value of the rule-id is
	 * URL encoded.
	 */
	public final native void expiration(String expiration) /*-{
		this.Expiration = expiration;
	}-*/;
	
	/**
	 * Provides information about object restoration operation and expiration time of the restored object copy.
	 */
	public final native String restore() /*-{
		return this.Restore;
	}-*/;

	/**
	 * Provides information about object restoration operation and expiration time of the restored object copy.
	 */
	public final native void restore(String restore) /*-{
		this.Restore = restore;
	}-*/;

	/**
	 * Last modified date of the object
	 */
	public final native String lastModified() /*-{
		return this.LastModified;
	}-*/;

	/**
	 * Last modified date of the object
	 */
	public final native void lastModified(String lastModified) /*-{
		this.LastModified = lastModified;
	}-*/;
	
	/**
	 * Size of the body in bytes.
	 */
	public final native int contentLength() /*-{
		return this.ContentLength;
	}-*/;

	/**
	 * Size of the body in bytes.
	 */
	public final native void contentLength(int contentLength) /*-{
		this.ContentLength = contentLength;
	}-*/;

	/**
	 * An ETag is an opaque identifier assigned by a web server to a specific version of a resource found at a URL
	 */
	public final native String eTag() /*-{
  	return this.ETag;
	}-*/;
	
	/**
	 * An ETag is an opaque identifier assigned by a web server to a specific version of a resource found at a URL
	 */
	public final native void eTag(String eTag) /*-{
		this.ETag = eTag;
	}-*/;
	
	/**
	 * This is set to the number of metadata entries not returned in x-amz-meta headers. This can happen if you create
	 * metadata using an API like SOAP that supports more flexible metadata than the REST API. For example, using SOAP,
	 * you can create metadata whose values are not legal HTTP headers.
	 */
	public final native int missingMeta() /*-{
		return this.MissingMeta;
	}-*/;

	/**
	 * This is set to the number of metadata entries not returned in x-amz-meta headers. This can happen if you create
	 * metadata using an API like SOAP that supports more flexible metadata than the REST API. For example, using SOAP,
	 * you can create metadata whose values are not legal HTTP headers.
	 */
	public final native void missingMeta(int missingMeta) /*-{
		this.MissingMeta = missingMeta;
	}-*/;

	/**
	 * Version of the object.
	 */
	public final native String versionId() /*-{
		return this.VersionId;
	}-*/;

	/**
	 * Version of the object.
	 */
	public final native void versionId(String versionId) /*-{
		this.VersionId = versionId;
	}-*/;

	/**
	 * Specifies caching behavior along the request/reply chain.
	 */
	public final native String cacheControl() /*-{
		return this.CacheControl;
	}-*/;

	/**
	 * Specifies caching behavior along the request/reply chain.
	 */
	public final native void cacheControl(String cacheControl) /*-{
		this.CacheControl = cacheControl;
	}-*/;

	/**
	 * Specifies presentational information for the object.
	 */
	public final native String contentDisposition() /*-{
		return this.ContentDisposition;
	}-*/;

	/**
	 * Specifies presentational information for the object.
	 */
	public final native void contentDisposition(String contentDisposition) /*-{
		this.ContentDisposition = contentDisposition;
	}-*/;

	/**
	 * Specifies what content encodings have been applied to the object and thus what decoding mechanisms must be applied
	 * to obtain the media-type referenced by the Content-Type header field.
	 */
	public final native String contentEncoding() /*-{
		return this.ContentEncoding;
	}-*/;

	/**
	 * Specifies what content encodings have been applied to the object and thus what decoding mechanisms must be applied
	 * to obtain the media-type referenced by the Content-Type header field.
	 */
	public final native void contentEncoding(String contentEncoding) /*-{
		this.ContentEncoding = contentEncoding;
	}-*/;

	/**
	 * The language the content is in.
	 */
	public final native String contentLanguage() /*-{
		return this.ContentLanguage;
	}-*/;

	/**
	 * The language the content is in.
	 */
	public final native void contentLanguage(String contentLanguage) /*-{
		this.ContentLanguage = contentLanguage;
	}-*/;

	/**
	 * A standard MIME type describing the format of the object data.
	 */
	public final native String contentType() /*-{
		return this.ContentType;
	}-*/;

	/**
	 * A standard MIME type describing the format of the object data.
	 */
	public final native void contentType(String contentType) /*-{
		this.ContentType = contentType;
	}-*/;
	
	/**
	 * The date and time at which the object is no longer cacheable.
	 */
	public final native String expires() /*-{
		return this.Expires;
	}-*/;

	/**
	 * The date and time at which the object is no longer cacheable.
	 */
	public final native void expires(String expires) /*-{
		this.Expires = expires;
	}-*/;

	/**
	 * If the bucket is configured as a website, redirects requests for this object to another object in the same bucket
	 * or to an external URL. Amazon S3 stores the value of this header in the object metadata.
	 */
	public final native String websiteRedirectLocation() /*-{
		return this.WebsiteRedirectLocation;
	}-*/;

	/**
	 * If the bucket is configured as a website, redirects requests for this object to another object in the same bucket
	 * or to an external URL. Amazon S3 stores the value of this header in the object metadata.
	 */
	public final native void websiteRedirectLocation(String websiteRedirectLocation) /*-{
		this.WebsiteRedirectLocation = websiteRedirectLocation;
	}-*/;

	/**
	 * The Server-side encryption algorithm used when storing this object in S3.
	 */
	public final native String serverSideEncryption() /*-{
		return this.ServerSideEncryption;
	}-*/;

	/**
	 * The Server-side encryption algorithm used when storing this object in S3.
	 */
	public final native void serverSideEncryption(String serverSideEncryption) /*-{
		this.ServerSideEncryption = serverSideEncryption;
	}-*/;
	
	/**
	 * A map of metadata to store with the object in S3.
	 */
	public final Map<String, JavaScriptObject> metadata() {
		JavaScriptObject metadata = metadata0();
		if (metadata == null) metadata = JavaScriptObject.createObject();
		return new JsonStringObjectMap<JavaScriptObject>(metadata);
	}
	
	private final native JavaScriptObject metadata0() /*-{
		return this.Metadata;
	}-*/;
	
	/**
	 * A map of metadata to store with the object in S3.
	 */
	public final void metadata(Map<String, JavaScriptObject> metadata) {
		JsonStringObjectMap<JavaScriptObject> jsom = new JsonStringObjectMap<JavaScriptObject>();
		jsom.putAll(metadata);
		metadata0(jsom.getNativeObject());
	}

	private final native void metadata0(JavaScriptObject metadata) /*-{
		this.Metadata = metadata;
	}-*/;
}
