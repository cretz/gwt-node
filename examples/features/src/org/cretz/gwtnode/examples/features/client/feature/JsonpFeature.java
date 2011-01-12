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
import org.cretz.gwtnode.client.node.sys.Sys;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

/**
 * Feature to test the Jsonp module
 *
 * @author Chad Retz
 */
public class JsonpFeature implements Feature {

    //I hope the dude at http://www.geocities.jp/stormriders999/jsontest.html
    //  doesn't mind if I use his key :-)
    private static final String URL = "http://www.google.com/uds/GwebSearch?lstkp=0&context=0&rsz=large&key=ABQIAAAAYtWO2s_klJQZgGk9oArIARTB9suGdOarCoAGySaRlJcFzsJRGxTWO1LlmU6_G0RYEf8P0-y3hppdfQ&v=0.1&q=node.js";
    
    private final Sys sys;
    private final Process process;
    
    @Inject
    public JsonpFeature(Sys sys, Process process) {
        this.sys = sys;
        this.process = process;
    }

    @Override
    public void call() {
        JsonpRequestBuilder jsonp = new JsonpRequestBuilder();
        jsonp.requestObject(URL, new AsyncCallback<JavaScriptObject>() {
            @Override
            public void onFailure(Throwable caught) {
                process.stdout().write("JSONP request failed: " + caught);
            }

            @Override
            public void onSuccess(JavaScriptObject result) {
                process.stdout().write("JSONP request succeeded: " + sys.inspect(result));
            }
        });
    }
}
