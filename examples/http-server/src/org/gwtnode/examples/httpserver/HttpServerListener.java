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
package org.gwtnode.examples.httpserver;

import java.util.Map.Entry;

import org.gwtnode.core.node.http.ServerRequest;
import org.gwtnode.core.node.http.ServerRequestEventHandler;
import org.gwtnode.core.node.http.ServerResponse;
import org.gwtnode.core.node.util.Util;

/**
 * A crude listener for HTTP requests. THIS IS NOT A SECURE WEB SERVER!
 *
 * @author Chad Retz
 */
class HttpServerListener extends ServerRequestEventHandler {

    /**
     * Log the given request
     * 
     * @param request
     */
    private static void logRequest(ServerRequest request) {
        StringBuilder builder = new StringBuilder("New Request:\n");
        builder.append("Method: ").append(request.method()).append('\n').
                append("URL: ").append(request.url()).append('\n').
                append("HTTP Version: ").append(request.httpVersion()).append('\n').
                append("Headers:\n");
        for (Entry<String, String> header : request.headerMap().entrySet()) {
            builder.append("  ").append(header.getKey()).append(" : ").
                    append(header.getValue()).append('\n');
        }
        Util.get().log(builder.toString());
    }

    @Override
    protected void onEvent(ServerRequest request, ServerResponse response) {
        //let's log all this stuff
        logRequest(request);
        //now let the handler do its work
        new HttpRequestHandler(request, response).call();
    }
}
