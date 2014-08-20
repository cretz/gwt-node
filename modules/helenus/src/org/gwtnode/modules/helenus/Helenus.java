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
package org.gwtnode.modules.helenus;

import org.gwtnode.core.meta.GwtNodeModule;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * <p>The node.js <a href="https://github.com/simplereach/helenus">helenus</a> module.</p>
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeModule
public class Helenus extends JavaScriptObject implements NodeJsModule {

	private static Helenus instance;
	
	public static Helenus get() {
		if (instance == null) instance = Global.get().require("helenus");
		return instance;
	}
	
	protected Helenus() {}
}
