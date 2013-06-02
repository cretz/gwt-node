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
import com.google.gwt.core.client.JsDate;

/**
 * Used as an item in {@link ListObjectsData#contents()} property.
 * 
 * @see ListObjectsData
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
public class ListObjectsDataContent extends JavaScriptObject {

	protected ListObjectsDataContent() {}
	
	public final native String key() /*-{
		return this.Key;
	}-*/;

	public final native void key(String key) /*-{
		this.Key = key;
	}-*/;
	
	/**
	 * Last modified date of the object
	 */
	public final native JsDate lastModified() /*-{
		return this.LastModified;
	}-*/;

	/**
	 * Last modified date of the object
	 */
	public final native void lastModified(JsDate lastModified) /*-{
		this.LastModified = lastModified;
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
	
	public final native int size() /*-{
		return this.Size;
	}-*/;

	public final native void size(int size) /*-{
		this.Size = size;
	}-*/;

	/**
	 * The class of storage used to store the object.
	 */
	public final native String storageClass() /*-{
		return this.StorageClass;
	}-*/;

	/**
	 * The class of storage used to store the object.
	 */
	public final native void storageClass(String storageClass) /*-{
		this.StorageClass = storageClass;
	}-*/;

	public final native ListObjectsDataOwner owner() /*-{
		return this.Owner;
	}-*/;

	public final native void owner(ListObjectsDataOwner owner) /*-{
		this.Owner = owner;
	}-*/;
	
	public final native String id() /*-{
		return this.ID;
	}-*/;

	public final native void id(String id) /*-{
		this.ID = id;
	}-*/;
	
	public final native String displayName() /*-{
		return this.DisplayName;
	}-*/;

	public final native void displayName(String displayName) /*-{
		this.DisplayName = displayName;
	}-*/;
}
