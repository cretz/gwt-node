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

public class ListObjectsParams extends BucketParams {

	public static ListObjectsParams create(String bucket) {
		return BucketParams.create(bucket).cast();
	}

	protected ListObjectsParams() {}

	/**
	 * A delimiter is a character you use to group keys.
	 */
	public final native String delimiter() /*-{
		return this.Delimiter;
	}-*/;

	/**
	 * A delimiter is a character you use to group keys.
	 */
	public final native void delimiter(String delimiter) /*-{
		this.Delimiter = delimiter;
	}-*/;

	/**
	 * Specifies the key to start with when listing objects in a bucket.
	 */
	public final native String marker() /*-{
		return this.Marker;
	}-*/;

	/**
	 * Specifies the key to start with when listing objects in a bucket.
	 */
	public final native void marker(String marker) /*-{
		this.Marker = marker;
	}-*/;

	/**
	 * Sets the maximum number of keys returned in the response. The response might contain fewer keys but will never
	 * contain more.
	 */
	public final native int maxKeys() /*-{
		return this.MaxKeys;
	}-*/;

	/**
	 * Sets the maximum number of keys returned in the response. The response might contain fewer keys but will never
	 * contain more.
	 */
	public final native void maxKeys(int maxKeys) /*-{
		this.MaxKeys = maxKeys;
	}-*/;

	/**
	 * Limits the response to keys that begin with the specified prefix.
	 */
	public final native String prefix() /*-{
		return this.Prefix;
	}-*/;

	/**
	 * Limits the response to keys that begin with the specified prefix.
	 */
	public final native void prefix(String prefix) /*-{
		this.Prefix = prefix;
	}-*/;
}
