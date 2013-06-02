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
package org.gwtnode.modules.aws.s3.params;

import com.google.gwt.core.client.JsDate;

public class GetObjectParams extends BucketKeyParams {

	public static GetObjectParams create(String bucket, String key) {
		return BucketKeyParams.create(bucket, key).cast();
	}

	protected GetObjectParams() {}

	/**
	 * Return the object only if its entity tag (ETag) is the same as the one specified, otherwise return a 412
	 * (precondition failed).
	 */
	public final native String ifMatch() /*-{
		return this.IfMatch;
	}-*/;

	/**
	 * Return the object only if its entity tag (ETag) is the same as the one specified, otherwise return a 412
	 * (precondition failed).
	 */
	public final native void ifMatch(String ifMatch) /*-{
		this.IfMatch = ifMatch;
	}-*/;

	/**
	 * Return the object only if it has been modified since the specified time, otherwise return a 304 (not modified).
	 */
	public final native JsDate ifModifiedSince() /*-{
		return this.IfModifiedSince;
	}-*/;

	/**
	 * Return the object only if it has been modified since the specified time, otherwise return a 304 (not modified).
	 */
	public final native void ifModifiedSince(JsDate ifModifiedSince) /*-{
		this.IfModifiedSince = ifModifiedSince;
	}-*/;

	/**
	 * Return the object only if its entity tag (ETag) is different from the one specified, otherwise return a 304 (not
	 * modified).
	 */
	public final native String ifNoneMatch() /*-{
		return this.IfNoneMatch;
	}-*/;

	/**
	 * Return the object only if its entity tag (ETag) is different from the one specified, otherwise return a 304 (not
	 * modified).
	 */
	public final native void ifNoneMatch(String ifNoneMatch) /*-{
		this.IfNoneMatch = ifNoneMatch;
	}-*/;

	/**
	 * Return the object only if it has not been modified since the specified time, otherwise return a 412 (precondition
	 * failed).
	 */
	public final native JsDate ifUnmodifiedSince() /*-{
		return this.IfUnmodifiedSince;
	}-*/;

	/**
	 * Return the object only if it has not been modified since the specified time, otherwise return a 412 (precondition
	 * failed).
	 */
	public final native void ifUnmodifiedSince(JsDate ifUnmodifiedSince) /*-{
		this.IfUnmodifiedSince = ifUnmodifiedSince;
	}-*/;

	/**
	 * Downloads the specified range bytes of an object. For more information about the HTTP Range header, go to <a
	 * href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.35"
	 * >http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.35.</a>
	 */
	public final native String range() /*-{
		return this.Range;
	}-*/;

	/**
	 * Downloads the specified range bytes of an object. For more information about the HTTP Range header, go to <a
	 * href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.35"
	 * >http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.35.</a>
	 */
	public final native void range(String range) /*-{
		this.Range = range;
	}-*/;

	/**
	 * Sets the Cache-Control header of the response.
	 */
	public final native String responseCacheControl() /*-{
		return this.ResponseCacheControl;
	}-*/;

	/**
	 * Sets the Cache-Control header of the response.
	 */
	public final native void responseCacheControl(String responseCacheControl) /*-{
		this.ResponseCacheControl = responseCacheControl;
	}-*/;

	/**
	 * Sets the Content-Disposition header of the response
	 */
	public final native String responseContentDisposition() /*-{
		return this.ResponseContentDisposition;
	}-*/;

	/**
	 * Sets the Content-Disposition header of the response
	 */
	public final native void responseContentDisposition(String responseContentDisposition) /*-{
		this.ResponseContentDisposition = responseContentDisposition;
	}-*/;

	/**
	 * Sets the Content-Encoding header of the response.
	 */
	public final native String responseContentEncoding() /*-{
		return this.ResponseContentEncoding;
	}-*/;

	/**
	 * Sets the Content-Encoding header of the response.
	 */
	public final native void responseContentEncoding(String responseContentEncoding) /*-{
		this.ResponseContentEncoding = responseContentEncoding;
	}-*/;

	/**
	 * Sets the Content-Language header of the response.
	 */
	public final native String responseContentLanguage() /*-{
		return this.ResponseContentLanguage;
	}-*/;

	/**
	 * Sets the Content-Language header of the response.
	 */
	public final native void responseContentLanguage(String responseContentLanguage) /*-{
		this.ResponseContentLanguage = responseContentLanguage;
	}-*/;

	/**
	 * Sets the Content-Type header of the response.
	 */
	public final native String responseContentType() /*-{
		return this.ResponseContentType;
	}-*/;

	/**
	 * Sets the Content-Type header of the response.
	 */
	public final native void responseContentType(String responseContentType) /*-{
		this.ResponseContentType = ResponseContentType;
	}-*/;

	/**
	 * Sets the Expires header of the response.
	 */
	public final native JsDate responseExpires() /*-{
		return this.ResponseExpires;
	}-*/;

	/**
	 * Sets the Expires header of the response.
	 */
	public final native void responseExpires(JsDate responseExpires) /*-{
		this.ResponseExpires = responseExpires;
	}-*/;

	/**
	 * VersionId used to reference a specific version of the object.
	 */
	public final native String versionId() /*-{
		return this.VersionId;
	}-*/;

	/**
	 * VersionId used to reference a specific version of the object.
	 */
	public final native void versionId(String versionId) /*-{
		this.VersionId = versionId;
	}-*/;
}
