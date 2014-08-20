/*
 * Copyright 2011 Chad Retz, 2013 Maxim Dominichenko
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
package org.gwtnode.modules.express;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeProperty;
import org.gwtnode.core.node.http.Server;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The {@link Application} object returned by {@link Express#app()} is in fact a JavaScript Function, designed to be
 * passed to node's http servers as a callback to handle requests. This allows you to provide both HTTP and HTTPS
 * versions of your app with the same codebase easily, as the app does not inherit from these, it is simply a callback:
 * <pre>
 * <code>
 *   Application app = Express.get().app();
 *   Http.get().createServer(app).listen(80);
 *   Https.get().createServer(app).listen(443);
 * </code>
 * </pre>
 * 
 * @author Chad Retz
 * @author Maxim Dominichenko
 */
public class Application extends JavaScriptFunction {

	protected Application() {}

	/**
	 * Assigns setting {@code name} to {@code value}.<br>
	 * 
	 * The following settings are provided to alter how Express will behave:
	 * <ul>
	 * <li>{@code env} - Environment mode, defaults to process.env.NODE_ENV or "development"
	 * <li>{@code trust proxy} - Enables reverse proxy support, disabled by default
	 * <li>{@code jsonp callback name} - Changes the default callback name of ?callback=
	 * <li>{@code json replacer} - JSON replacer callback, null by default
	 * <li>{@code json spaces} - JSON response spaces for formatting, defaults to 2 in development, 0 in production
	 * <li>{@code case sensitive routing} - Enable case sensitivity, disabled by default, treating "/Foo" and "/foo" as
	 * the same
	 * <li>{@code strict routing} - Enable strict routing, by default "/foo" and "/foo/" are treated the same by the
	 * router
	 * <li>{@code view cache} - Enables view template compilation caching, enabled in production by default
	 * <li>{@code view engine} - The default engine extension to use when omitted
	 * <li>{@code views} - The view directory path, defaulting to "./views"
	 * </ul>
	 */
	@GwtNodeFunction
	public final native <T> void set(String name, T value) /*-{
		this.set(name, value);
	}-*/;

	/**
	 * Get setting {@code name} value.
	 * 
	 * @see #set(String, Object)
	 */
	@GwtNodeFunction
	public final native <T> T get(String name) /*-{
		return this.get(name);
	}-*/;

	/**
	 * Set setting {@code name} to {@code true}.
	 */
	@GwtNodeFunction
	public final native void enable(String name) /*-{
		this.enable(name);
	}-*/;

	/**
	 * Check if setting {@code name} is enabled.
	 */
	@GwtNodeFunction
	public final native boolean enabled(String name) /*-{
		return this.enabled(name);
	}-*/;

	/**
	 * Set setting {@code name} to {@code false}.
	 */
	@GwtNodeFunction
	public final native void disable(String name) /*-{
		this.disable(name);
	}-*/;

	/**
	 * Check if setting {@code name} is disabled.
	 */
	@GwtNodeFunction
	public final native boolean disabled(String name) /*-{
		return this.disabled(name);
	}-*/;

	/**
	 * Use the given {@code middleware} function, with specified mount {@code path}.
	 */
	@GwtNodeFunction
	public final void use(String path, Middleware middleware) {
		use(path, middleware != null ? middleware.get() : null);
	}
	
	/**
	 * Use the given {@code middleware} function, with specified mount {@code path}.
	 */
	@GwtNodeFunction
	public final native void use(String path, JavaScriptFunction middleware) /*-{
		this.use(path, middleware);
	}-*/;

	/**
	 * Use the given {@code middleware} function, with default mount {@code path} "/".
	 */
	@GwtNodeFunction
	public final void use(Middleware middleware) {
		use(middleware != null ? middleware.get() : null);
	}
	
	/**
	 * Use the given {@code middleware} function, with default mount {@code path} "/".
	 */
	@GwtNodeFunction
	public final native void use(JavaScriptFunction middleware) /*-{
		this.use(middleware);
	}-*/;


	/**
	 * The routes object houses all of the routes defined mapped by the associated HTTP verb. This object may be used for
	 * introspection capabilities, for example Express uses this internally not only for routing but to provide default
	 * OPTIONS behaviour unless {@link #options()} is used. Your application or framework may also remove routes simply by
	 * removing them from this object.
	 */
	@GwtNodeProperty
	public final native JavaScriptObject routes() /*-{
		return this.routes;
	}-*/;
	
	/**
	 * Bind and listen for connections on the port. This method is identical to {@link Server#listen(int)}.
	 */
	@GwtNodeFunction
	public final native Server listen(int port) /*-{
		return this.listen(port);
	}-*/;

	/**
	 * Bind and listen for connections on the given host name and port.<br>
	 * This method is identical to {@link Server#listen(int, String)}.
	 */
	@GwtNodeFunction
	public final native Server listen(int port, String hostname) /*-{
		return this.listen(port, hostname);
	}-*/;

	/**
	 * Bind and listen for connections on the given host name and port.<br>
	 * This method is identical to {@link Server#listen(int, String, JavaScriptFunctionWrapper)}.
	 */
	@GwtNodeFunction
	public final Server listen(int port, String hostname, JavaScriptFunctionWrapper callback) {
		return listen(port, hostname, callback != null ? callback.getNativeFunction() : null);
	}

	/**
	 * Bind and listen for connections on the given host name and port.<br>
	 * This method is identical to {@link Server#listen(int, String, JavaScriptFunction)}.
	 */
	@GwtNodeFunction
	public final native Server listen(int port, String hostname, JavaScriptFunction callback) /*-{
		return this.listen(port, hostname, callback);
	}-*/;

	/**
	 * Bind and listen for connections on the given path.<br>
	 * This method is identical to {@link Server#listen(String)}.
	 */
	@GwtNodeFunction
	public final native Server listen(String path) /*-{
		return this.listen(path);
	}-*/;

	/**
	 * Bind and listen for connections on the given path.<br>
	 * This method is identical to {@link Server#listen(String, JavaScriptFunctionWrapper)}.
	 */
	@GwtNodeFunction
	public final Server listen(String path, JavaScriptFunctionWrapper callback) {
		return listen(path, callback != null ? callback.getNativeFunction() : null);
	}

	/**
	 * Bind and listen for connections on the given path.<br>
	 * This method is identical to {@link Server#listen(String, JavaScriptFunction)}.
	 */
	@GwtNodeFunction
	public final native Server listen(String path, JavaScriptFunction callback) /*-{
		return this.listen(path, callback);
	}-*/;
}
