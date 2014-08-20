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
package org.gwtnode.modules.cassandra;

import java.util.Date;

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.node.buffer.Buffer;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsDate;

/**
 * UUID object for use in node-cassandra-client.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class UUID extends JavaScriptObject {
	
	@GwtNodeFunction("constructor")
	private static final native UUID create(JavaScriptObject bytes) /*-{
		return new (@org.gwtnode.modules.cassandra.Cassandra::get()()).UUID(bytes);
  }-*/;

	/**
	 * Factory method that returns a UUID object.
	 * 
	 * @param bytes
	 *          The 16 bytes of a UUID
	 * @return UUID
	 */
	@GwtNodeFunction
	public static final native UUID fromBytes(Buffer bytes) /*-{
		return (@org.gwtnode.modules.cassandra.Cassandra::get()()).UUID.fromBytes(bytes);
	}-*/;
	
	/**
	 * Factory method that returns a UUID object.
	 * 
	 * @param bytes
	 *          The 16 bytes of a UUID
	 * @return UUID
	 */
	@GwtNodeFunction
	public static final native UUID fromBytes(JsArrayInteger bytes) /*-{
		return (@org.gwtnode.modules.cassandra.Cassandra::get()()).UUID.fromBytes(bytes);
	}-*/;
	
	/**
	 * Factory method that returns a UUID object.
	 * 
	 * @param bytes
	 *          The 16 bytes of a UUID
	 * @return UUID
	 */
	@GwtNodeFunction
	public static final UUID fromBytes(byte[] bytes) {
		JsArrayInteger jsBytes = JavaScriptObject.createArray().cast();
		if (bytes != null) 
			for (int b : bytes)
				jsBytes.push(b);
		return fromBytes(jsBytes);
	}

	/**
	 * Factory method that returns a UUID object.
	 * 
	 * @param string
	 *          UUID in hyphen-separated string-notation
	 * @return UUID
	 */
	@GwtNodeFunction
	public static final native UUID fromString(String string) /*-{
		return (@org.gwtnode.modules.cassandra.Cassandra::get()()).UUID.fromString(string);
	}-*/;
	
	/**
	 * Factory method that generates a v1 UUID for a given timestamp.<br>
	 * Successive calls using the same timestamp will generate incrementally different UUIDs that sort appropriately.
	 * 
	 * @param timestamp
	 *          Unix-timestamp
	 * @return UUID
	 */
	@GwtNodeFunction
	public static final native UUID fromTime(double timestamp) /*-{
		return (@org.gwtnode.modules.cassandra.Cassandra::get()()).UUID.fromTime(timestamp);
	}-*/;
	
	/**
	 * Factory method that generates a v1 UUID for a given timestamp.<br>
	 * Successive calls using the same timestamp will generate incrementally different UUIDs that sort appropriately.
	 * 
	 * @param timestamp
	 *          JS-related Date object
	 * @return UUID
	 */
	@GwtNodeFunction
	public static final native UUID fromTime(JsDate timestamp) /*-{
		return (@org.gwtnode.modules.cassandra.Cassandra::get()()).UUID.fromTime(timestamp != null ? timestamp.getTime() : 0);
	}-*/;
	
	/**
	 * Factory method that generates a v1 UUID for a given timestamp.<br>
	 * Successive calls using the same timestamp will generate incrementally different UUIDs that sort appropriately.
	 * 
	 * @param timestamp
	 *          Java-related Date object
	 * @return UUID
	 */
	@GwtNodeFunction
	public static final UUID fromTime(Date timestamp) {
		return fromTime(timestamp != null ? timestamp.getTime() : 0);
	}
	
	/**
	 * Factory method generates the minimum (first) UUID for a given ms-timestamp.<br>
	 * Opposite of {@link #maxUUID(double)}.
	 * 
	 * @param timestamp
	 *          Unix-timestamp
	 * @return UUID
	 */
	@GwtNodeFunction
	public static final native UUID minUUID(double timestamp) /*-{
		return (@org.gwtnode.modules.cassandra.Cassandra::get()()).UUID.minUUID(timestamp);
	}-*/;
	
	/**
	 * Factory method generates the minimum (first) UUID for a given ms-timestamp.<br>
	 * Opposite of {@link #maxUUID(JsDate)}.
	 * 
	 * @param timestamp
	 *          JS-related Date object
	 * @return UUID
	 */
	@GwtNodeFunction
	public static final native UUID minUUID(JsDate timestamp) /*-{
		return (@org.gwtnode.modules.cassandra.Cassandra::get()()).UUID.minUUID(timestamp != null ? timestamp.getTime() : 0);
	}-*/;
	
	/**
	 * Factory method generates the minimum (first) UUID for a given ms-timestamp.<br>
	 * Opposite of {@link #maxUUID(Date)}.
	 * 
	 * @param timestamp
	 *          Java-related Date object
	 * @return UUID
	 */
	@GwtNodeFunction
	public static final UUID minUUID(Date timestamp) {
		return minUUID(timestamp != null ? timestamp.getTime() : 0);
	}
	
	/**
	 * Factory method generates the maximum (last) UUID for a given ms-timestamp.<br>
	 * Opposite of {@link #minUUID(double)}.
	 * 
	 * @param timestamp
	 *          Unix-timestamp
	 * @return UUID
	 */
	@GwtNodeFunction
	public static final native UUID maxUUID(double timestamp) /*-{
		return (@org.gwtnode.modules.cassandra.Cassandra::get()()).UUID.maxUUID(timestamp);
	}-*/;
	
	/**
	 * Factory method generates the maximum (last) UUID for a given ms-timestamp.<br>
	 * Opposite of {@link #minUUID(JsDate)}.
	 * 
	 * @param timestamp
	 *          JS-related Date object
	 * @return UUID
	 */
	@GwtNodeFunction
	public static final native UUID maxUUID(JsDate timestamp) /*-{
		return (@org.gwtnode.modules.cassandra.Cassandra::get()()).UUID.maxUUID(timestamp != null ? timestamp.getTime() : 0);
	}-*/;
	
	/**
	 * Factory method generates the maximum (last) UUID for a given ms-timestamp.<br>
	 * Opposite of {@link #minUUID(Date)}.
	 * 
	 * @param timestamp
	 *          Java-related Date object
	 * @return UUID
	 */
	@GwtNodeFunction
	public static final UUID maxUUID(Date timestamp) {
		return maxUUID(timestamp != null ? timestamp.getTime() : 0);
	}
	
	protected UUID() {}
	
	/**
	 * Compare a given UUID-object with the current UUID object.
	 * 
	 * @param other
	 *          UUID object to compare with
	 * @return {@code true} if string representation of both UUIDs are equal. {@code false} otherwise.
	 */
	@GwtNodeFunction("equals")
	public final native boolean isEqual(UUID other) /*-{
		return this.equals(other);
	}-*/;
}
