/*
 * Copyright 2011 Chad Retz
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
package org.cretz.gwtnode.examples.features.client.feature;

import org.cretz.gwtnode.client.node.process.Process;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.inject.Inject;

/**
 * Feature to test the HTTP module
 *
 * @author Chad Retz
 */
public class HttpFeature implements Feature {

    private final Process process;
    
    @Inject
    public HttpFeature(Process process) {
        this.process = process;
    }

    @Override
    public void call() {
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode("/Features.js"));
        try {
            builder.sendRequest(null, new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    process.stdout().write("HTTP request succeeded!");
                }
                
                @Override
                public void onError(Request request, Throwable exception) {
                    process.stdout().write("HTTP request failed");
                }
            });
        } catch (RequestException e) {
            process.stdout().write("Http request failed: " + e);
        }
    }
}
