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
package org.gwtnode.modules.aws;

import org.gwtnode.core.meta.GwtNodeModule;
import org.gwtnode.core.meta.GwtNodeProperty;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;
import org.gwtnode.modules.aws.core.Config;
import org.gwtnode.modules.aws.core.EventEmitter;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * <p>The node.js <a href="http://docs.aws.amazon.com/AWSJavaScriptSDK/latest/">aws-sdk</a> module.</p>
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeModule
public class AWS extends JavaScriptObject implements NodeJsModule {

	private static AWS instance;
	
	public static AWS get() {
		if (instance == null) instance = Global.get().require("aws-sdk");
		return instance;
	}
	
	/**
	 * The global configuration object singleton instance.
	 */
	@GwtNodeProperty
	public static final native Config config() /*-{
		return @org.gwtnode.modules.aws.AWS::get()().config;
	}-*/;

	/**
	 * A collection of global event listeners that are attached to every sent request.
	 */
	@GwtNodeProperty
	public static final native EventEmitter events() /*-{
		return @org.gwtnode.modules.aws.AWS::get()().events;
	}-*/;
	
	protected AWS() {}
}
