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
import com.google.gwt.core.client.JsArray;

public class CompleteMultipartUploadParams extends AbortMultipartUploadParams {
	
	public static CompleteMultipartUploadParams create(String bucket, String key, String uploadId) {
		return AbortMultipartUploadParams.create(bucket, key, uploadId).cast();
	}
	
	protected CompleteMultipartUploadParams() {}

	public final native JsArray<JavaScriptObject> uploadParts() /*-{
  	return this.MultipartUpload != null ? this.MultipartUpload.Parts : null;
	}-*/;
	
	public final native void uploadParts(JsArray<JavaScriptObject> uploadParts) /*-{
		if (this.MultipartUpload == null) this.MultipartUpload = {};
		this.MultipartUpload.Parts = uploadParts;
	}-*/;
	
	/**
	 * Entity tag returned when the part was uploaded.
	 */
	public final native String uploadETag() /*-{
  	return this.MultipartUpload != null ? this.MultipartUpload.ETag : null;
	}-*/;
	
	/**
	 * Entity tag returned when the part was uploaded.
	 */
	public final native void uploadETag(String uploadETag) /*-{
		if (this.MultipartUpload == null) this.MultipartUpload = {};
		this.MultipartUpload.ETag = uploadETag;
	}-*/;
	
	/**
	 * Part number that identifies the part.
	 */
	public final native int uploadPartNumber() /*-{
  	return this.MultipartUpload != null ? this.MultipartUpload.PartNumber : null;
	}-*/;
	
	/**
	 * Part number that identifies the part.
	 */
	public final native void uploadPartNumber(int uploadPartNumber) /*-{
		if (this.MultipartUpload == null) this.MultipartUpload = {};
		this.MultipartUpload.PartNumber = uploadPartNumber;
	}-*/;
}
