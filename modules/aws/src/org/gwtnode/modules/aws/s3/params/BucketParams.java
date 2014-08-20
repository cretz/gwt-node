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

public class BucketParams extends JavaScriptObject {

	public static BucketParams create(String bucket) {
		BucketParams result = JavaScriptObject.createObject().cast();
		result.bucket(bucket);
		return result;
	}
	
	protected BucketParams() {}
	
	public final native String bucket() /*-{
		return this.Bucket;
	}-*/;

	public final native void bucket(String bucket) /*-{
		this.Bucket = bucket;
	}-*/;
}
