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

public class BucketKeyParams extends BucketParams {

	public static BucketKeyParams create(String bucket, String key) {
		BucketKeyParams result = BucketParams.create(bucket).cast();
		result.key(key);
		return result;
	}

	protected BucketKeyParams() {}

	public final native String key() /*-{
		return this.Key;
	}-*/;

	public final native void key(String key) /*-{
		this.Key = key;
	}-*/;
}
