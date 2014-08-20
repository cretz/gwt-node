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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

public class CopyObjectParams extends BucketKeyParams {

	public static CopyObjectParams create(String bucket, String key, String copySource) {
		CopyObjectParams result = BucketKeyParams.create(bucket, key).cast();
		result.copySource(copySource);
		return result;
	}

	protected CopyObjectParams() {}

	/**
	 * The name of the source bucket and key name of the source object, separated by a slash (/). Must be URL-encoded.
	 */
	public final native String copySource() /*-{
		return this.CopySource;
	}-*/;

	/**
	 * The name of the source bucket and key name of the source object, separated by a slash (/). Must be URL-encoded.
	 */
	public final native void copySource(String copySource) /*-{
		this.CopySource = copySource;
	}-*/;

	/**
	 * The canned ACL to apply to the object.
	 */
	public final native String acl() /*-{
		return this.ACL;
	}-*/;

	/**
	 * The canned ACL to apply to the object.
	 */
	public final native void acl(String acl) /*-{
		this.ACL = acl;
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
		return ContentEncoding;
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
	 * Copies the object if its entity tag (ETag) matches the specified tag.
	 */
	public final native JsDate copySourceIfMatch() /*-{
		return this.CopySourceIfMatch;
	}-*/;

	/**
	 * Copies the object if its entity tag (ETag) matches the specified tag.
	 */
	public final native void copySourceIfMatch(JsDate copySourceIfMatch) /*-{
		this.CopySourceIfMatch = copySourceIfMatch;
	}-*/;

	/**
	 * Copies the object if it has been modified since the specified time.
	 */
	public final native JsDate copySourceIfModifiedSince() /*-{
		return this.CopySourceIfModifiedSince;
	}-*/;

	/**
	 * Copies the object if it has been modified since the specified time.
	 */
	public final native void copySourceIfModifiedSince(JsDate copySourceIfModifiedSince) /*-{
		this.CopySourceIfModifiedSince = copySourceIfModifiedSince;
	}-*/;

	/**
	 * Copies the object if its entity tag (ETag) is different than the specified ETag.
	 */
	public final native JsDate copySourceIfNoneMatch() /*-{
		return this.CopySourceIfNoneMatch;
	}-*/;

	/**
	 * Copies the object if its entity tag (ETag) is different than the specified ETag.
	 */
	public final native void copySourceIfNoneMatch(JsDate copySourceIfNoneMatch) /*-{
		this.CopySourceIfNoneMatch = copySourceIfNoneMatch;
	}-*/;

	/**
	 * Copies the object if it hasn't been modified since the specified time.
	 */
	public final native JsDate copySourceIfUnmodifiedSince() /*-{
		return this.CopySourceIfUnmodifiedSince;
	}-*/;

	/**
	 * Copies the object if it hasn't been modified since the specified time.
	 */
	public final native void copySourceIfUnmodifiedSince(JsDate copySourceIfUnmodifiedSince) /*-{
		this.CopySourceIfUnmodifiedSince = copySourceIfUnmodifiedSince;
	}-*/;

	/**
	 * The date and time at which the object is no longer cacheable.
	 */
	public final native JsDate expires() /*-{
		return this.Expires;
	}-*/;

	/**
	 * The date and time at which the object is no longer cacheable.
	 */
	public final native void expires(JsDate expires) /*-{
		this.Expires = expires;
	}-*/;

	/**
	 * Gives the grantee READ, READ_ACP, and WRITE_ACP permissions on the object.
	 */
	public final native String grantFullControl() /*-{
		return this.GrantFullControl;
	}-*/;

	/**
	 * Gives the grantee READ, READ_ACP, and WRITE_ACP permissions on the object.
	 */
	public final native void grantFullControl(String grantFullControl) /*-{
		this.GrantFullControl = grantFullControl;
	}-*/;

	/**
	 * Allows grantee to read the object data and its metadata.
	 */
	public final native String grantRead() /*-{
		return this.GrantRead;
	}-*/;

	/**
	 * Allows grantee to read the object data and its metadata.
	 */
	public final native void grantRead(String grantRead) /*-{
		this.GrantRead = grantRead;
	}-*/;

	/**
	 * Allows grantee to read the object ACL.
	 */
	public final native String grantReadACP() /*-{
		return this.GrantReadACP;
	}-*/;

	/**
	 * Allows grantee to read the object ACL.
	 */
	public final native void grantReadACP(String grantReadACP) /*-{
		this.GrantReadACP = grantReadACP;
	}-*/;

	/**
	 * Allows grantee to write the ACL for the applicable object.
	 */
	public final native String grantWriteACP() /*-{
		return this.GrantWriteACP;
	}-*/;

	/**
	 * Allows grantee to write the ACL for the applicable object.
	 */
	public final native void grantWriteACP(String grantWriteACP) /*-{
		this.GrantWriteACP = grantWriteACP;
	}-*/;

	/**
	 * A map of metadata to store with the object in S3Try.
	 */
	public final native JavaScriptObject metadata() /*-{
		return this.Metadata;
	}-*/;

	/**
	 * A map of metadata to store with the object in S3Try.
	 */
	public final native void metadata(JavaScriptObject metadata) /*-{
		this.Metadata = metadata;
	}-*/;

	/**
	 * Specifies whether the metadata is copied from the source object or replaced with metadata provided in the request.
	 */
	public final native String metadataDirective() /*-{
		return this.MetadataDirective;
	}-*/;

	/**
	 * Specifies whether the metadata is copied from the source object or replaced with metadata provided in the request.
	 */
	public final native void metadataDirective(String metadataDirective) /*-{
		this.MetadataDirective = metadataDirective;
	}-*/;

	/**
	 * The Server-side encryption algorithm used when storing this object in S3Try.
	 */
	public final native String serverSideEncryption() /*-{
		return this.ServerSideEncryption;
	}-*/;

	/**
	 * The Server-side encryption algorithm used when storing this object in S3Try.
	 */
	public final native void serverSideEncryption(String serverSideEncryption) /*-{
		this.ServerSideEncryption = serverSideEncryption;
	}-*/;

	/**
	 * The type of storage to use for the object. Defaults to "STANDARD".
	 */
	public final native String storageClass() /*-{
		return this.StorageClass;
	}-*/;

	/**
	 * The type of storage to use for the object. Defaults to "STANDARD".
	 */
	public final native void storageClass(String storageClass) /*-{
		this.StorageClass = storageClass;
	}-*/;

	/**
	 * If the bucket is configured as a website, redirects requests for this object to another object in the same bucket
	 * or to an external URL. Amazon S3Try stores the value of this header in the object metadata.
	 */
	public final native String websiteRedirectLocation() /*-{
		return this.WebsiteRedirectLocation;
	}-*/;

	/**
	 * If the bucket is configured as a website, redirects requests for this object to another object in the same bucket
	 * or to an external URL. Amazon S3Try stores the value of this header in the object metadata.
	 */
	public final native void websiteRedirectLocation(String websiteRedirectLocation) /*-{
		this.WebsiteRedirectLocation = websiteRedirectLocation;
	}-*/;
}
