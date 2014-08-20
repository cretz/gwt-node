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
package org.gwtnode.modules.aws.core;

import java.util.List;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.core.meta.GwtNodeEvent;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.node.stream.ReadableStream;
import org.gwtnode.modules.aws.core.events.BufferResponseEventHandler;
import org.gwtnode.modules.aws.core.events.ErrorResponseEventHandler;
import org.gwtnode.modules.aws.core.events.RequestEventHandler;
import org.gwtnode.modules.aws.core.events.ResponseEventHandler;
import org.gwtnode.modules.aws.core.events.StatusHeadersResponseEventHandler;
import org.gwtnode.modules.aws.s3.Client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * <p>
 * All requests made through the SDK are asynchronous and use a callback interface. Each service method that kicks off a
 * request returns an {@code Request} object that you can use to register callbacks.
 * </p>
 * <p>
 * When a request is ready to be sent, the {@link #send()} method should be called.
 * </p>
 * <p>
 * See <a href="http://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/Request.html">AWS.Request</a> for details.
 * </p>
 * 
 * @see Response
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class Request extends EventEmitter {
	
	/**
	 * Creates a request for an operation on a given client with a set of input parameters.
	 */
	@GwtNodeFunction("constructor")
	public static final native Request create(Client client, String operation, JavaScriptObject params) /*-{
		return new (@org.gwtnode.modules.aws.AWS::get()()).Request(client, operation, params);
	}-*/;

	protected Request() {}

	/**
	 * <p>
	 * Converts the request object into a readable stream that can be read from or piped into a writable stream.
	 * </p>
	 * 
	 * <h3>Examples:</h3>
	 * 
	 * <h4>Manually reading from a stream</h4>
	 * 
	 * <pre>
	 * <code>
	 * request.createReadStream().onData(new StringOrBufferEventHandler() {
	 *   protected void onEvent() {
	 *     String data = this.getString();
	 *     if (data == null) data = this.getBuffer().toString("UTF-8");
	 *     Util.get().log("Got data: " + data);
	 *   }
	 * });
	 * </code>
	 * </pre>
	 * 
	 * <h4>Piping a request body into a file</h4>
	 * 
	 * <pre>
	 * <code>
	 * WritableStream out = fs.createWriteStream("/path/to/outfile.jpg");
	 * s3.client().getObject(params).createReadStream().pipe(out);
	 * </code>
	 * </pre>
	 */
	@GwtNodeFunction
	public final native ReadableStream createReadStream() /*-{
		return this.createReadStream();
	}-*/;
	
	@GwtNodeFunction
	public final void emitEvents(List<String> eventNames, Response response, JavaScriptFunctionWrapper doneCallback) {
		JsArrayString jsEventNames = JavaScriptObject.createArray().cast();
		if (eventNames != null)
			for (String eventName : eventNames)
				jsEventNames.push(eventName);
		emitEvents(jsEventNames, response, doneCallback.getNativeFunction());
	}
	
	@GwtNodeFunction
	private final native void emitEvents(JsArrayString eventNames, Response response, JavaScriptFunction doneCallback) /*-{
		this.emitEvents(eventNames, response, doneCallback);
	}-*/;
	
	/**
	 * Sends the request object.
	 */
	public final native void send() /*-{
		this.send();
	}-*/;

	/**
	 * Triggered when a request is being validated. Listeners should throw an error if the request should not be sent.
	 */
	@GwtNodeEvent
	public final void onValidate(RequestEventHandler handler) {
		on("validate", handler);
	}

	/**
	 * Triggered when the request payload is being built. Listeners should fill the necessary information to send the
	 * request over HTTP.
	 */
	@GwtNodeEvent
	public final void onBuild(RequestEventHandler handler) {
		on("build", handler);
	}
	
	/**
	 * Triggered when the request is being signed. Listeners should add the correct authentication headers and/or adjust
	 * the body, depending on the authentication mechanism being used.
	 */
	@GwtNodeEvent
	public final void onSign(RequestEventHandler handler) {
		on("sign", handler);
	}
	
	/**
	 * Triggered when the request is ready to be sent. Listeners should call the underlying transport layer to initiate
	 * the sending of the request.
	 */
	@GwtNodeEvent
	public final void onSend(ResponseEventHandler handler) {
		on("send", handler);
	}
	
	/**
	 * Triggered when a request failed and might need to be retried. Listeners are responsible for checking to see if the
	 * request is retryable, and if so, re-signing and re-sending the request. Information about the failure is set in the
	 * response.error property.<br>
	 * 
	 * If a listener decides that a request should not be retried, that listener should throw an error to cancel the event
	 * chain. Unsetting response.error will have no effect.
	 */
	@GwtNodeEvent
	public final void onRetry(ResponseEventHandler handler) {
		on("retry", handler);
	}

	/**
	 * Triggered on all non-2xx requests so that listeners can extract error details from the response body. Listeners to
	 * this event should set the response.error property.
	 */
	@GwtNodeEvent
	public final void onExtractError(ResponseEventHandler handler) {
		on("extractError", handler);
	}
	
	/**
	 * Triggered in successful requests to allow listeners to de-serialize the response body into response.data.
	 */
	@GwtNodeEvent
	public final void onExtractData(ResponseEventHandler handler) {
		on("extractData", handler);
	}
	
	/**
	 * Triggered when the request completed successfully. response.data will contain the response data and response.error
	 * will be null.
	 */
	@GwtNodeEvent
	public final void onSuccess(ResponseEventHandler handler) {
		on("success", handler);
	}
	
	/**
	 * Triggered when an error occurs at any point during the request. response.error will contain details about the error
	 * that occurred. response.data will be null.
	 */
	@GwtNodeEvent
	public final void onError(ErrorResponseEventHandler handler) {
		on("error", handler);
	}

	/**
	 * Triggered whenever a request cycle completes. response.error should be checked, since the request may have failed.
	 */
	@GwtNodeEvent
	public final void onComplete(ResponseEventHandler handler) {
		on("complete", handler);
	}

	/**
	 * Triggered when headers are sent by the remote server.
	 */
	@GwtNodeEvent
	public final void onHttpHeaders(StatusHeadersResponseEventHandler handler) {
		on("httpHeaders", handler);
	}

	/**
	 * Triggered when data is sent by the remote server.
	 */
	@GwtNodeEvent
	public final void onHttpData(BufferResponseEventHandler handler) {
		on("httpData", handler);
	}

	/**
	 * Triggered when the HTTP request failed.
	 */
	@GwtNodeEvent
	public final void onHttpError(ErrorResponseEventHandler handler) {
		on("httpError", handler);
	}

	/**
	 * Triggered when the server is finished sending data.
	 */
	@GwtNodeEvent
	public final void onHttpDone(ResponseEventHandler handler) {
		on("httpDone", handler);
	}
}
