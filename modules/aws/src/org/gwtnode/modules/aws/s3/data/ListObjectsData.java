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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * The de-serialized data returned from the request.
 * 
 * @see ListObjectsDataContent
 * @see ListObjectsDataPrefix
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
public class ListObjectsData extends JavaScriptObject {

	protected ListObjectsData() {}
	
	/**
	 * A flag that indicates whether or not Amazon S3Try returned all of the results that satisfied the search criteria.
	 */
	public final native boolean isTruncated() /*-{
		return this.IsTruncated;
	}-*/;

	/**
	 * A flag that indicates whether or not Amazon S3Try returned all of the results that satisfied the search criteria.
	 */
	public final native void isTruncated(boolean isTruncated) /*-{
		this.IsTruncated = isTruncated;
	}-*/;
	
	public final native String marker() /*-{
		return this.Marker;
	}-*/;

	public final native void marker(String marker) /*-{
		this.Marker = marker;
	}-*/;
	
	public final native JsArray<ListObjectsDataContent> contents() /*-{
		return this.Contents;
	}-*/;

	public final native void contents(JsArray<ListObjectsDataContent> contents) /*-{
		this.Contents = contents;
	}-*/;
	
	public final native String name() /*-{
		return this.Name;
	}-*/;

	public final native void name(String name) /*-{
		this.Name = name;
	}-*/;
	
	public final native String prefix() /*-{
		return this.Prefix;
	}-*/;

	public final native void prefix(String prefix) /*-{
		this.Prefix = prefix;
	}-*/;
	
	public final native int maxKeys() /*-{
		return this.MaxKeys;
	}-*/;

	public final native void maxKeys(int maxKeys) /*-{
		this.MaxKeys = maxKeys;
	}-*/;
	
	public final native JsArray<ListObjectsDataPrefix> commonPrefixes() /*-{
		return this.CommonPrefixes;
	}-*/;

	public final native void commonPrefixes(JsArray<ListObjectsDataPrefix> commonPrefixes) /*-{
		this.CommonPrefixes = commonPrefixes;
	}-*/;
}
