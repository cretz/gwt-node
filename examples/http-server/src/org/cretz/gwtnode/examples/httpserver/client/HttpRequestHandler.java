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
package org.cretz.gwtnode.examples.httpserver.client;

import org.cretz.gwtnode.client.JsonStringObjectMap;
import org.cretz.gwtnode.client.node.Global;
import org.cretz.gwtnode.client.node.NodeJsError;
import org.cretz.gwtnode.client.node.buffer.Buffer;
import org.cretz.gwtnode.client.node.event.BooleanEventHandler;
import org.cretz.gwtnode.client.node.fs.BufferEventHandler;
import org.cretz.gwtnode.client.node.fs.Fs;
import org.cretz.gwtnode.client.node.http.ServerRequest;
import org.cretz.gwtnode.client.node.http.ServerResponse;
import org.cretz.gwtnode.client.node.path.Path;
import org.cretz.gwtnode.client.node.url.Url;
import org.cretz.gwtnode.client.node.util.Util;

/**
 * Handler for an individual request
 *
 * @author Chad Retz
 */
class HttpRequestHandler {
    
    /**
     * Get the mime type of the given extension (w/ '.' prepended)
     * 
     * @param ext
     * @return
     */
    private static String getMimeType(String ext) {
        if (".html".equalsIgnoreCase(ext)) {
            return "text/html";
        } else if (".png".equalsIgnoreCase(ext)) {
            return "image/png";
        } else {
            return "application/octet-stream";
        }
    }

    private final ServerRequest request;
    private final ServerResponse response;
    private String path;
    private String ext;
    
    /**
     * Instantiate this handler
     * 
     * @param request
     * @param response
     */
    public HttpRequestHandler(ServerRequest request, ServerResponse response) {
        this.request = request;
        this.response = response;
    }
    
    /**
     * Call the handler
     */
    public void call() {
        try {
            path = resolveProperPath();
            //if there isn't an extension, add index.html
            ext = Path.get().extname(path);
            if (ext == null || ext.isEmpty()) {
                ext = ".html";
                path = Path.get().join(path, "index.html");
            }
            //if it exists, we can add it
            Path.get().exists(path, new BooleanEventHandler() {
                @Override
                protected void onEvent(boolean value) {
                    if (!value) {
                        Util.get().log("Can't find path: " + path);
                        handleException(new HttpServerException(404, "Not found"));
                    } else {
                        //oh it does exist? word...
                        sendFile();
                    }
                }
            });
        } catch (Exception e) {
            handleException(e);
        }
    }

    private void sendFile() {
        //let's start the writing
        Util.get().log("Writing file: " + path);
        Fs.get().readFile(path, new BufferEventHandler() {
            @Override
            public void onEvent(NodeJsError error, Buffer buffer) {
                if (error != null) {
                    //uh oh
                    handleException(new HttpServerException(500, "Failure during read"));
                } else {
                    JsonStringObjectMap<String> responseHeaders = new JsonStringObjectMap<String>();
                    responseHeaders.put("Content-Type", getMimeType(ext));
                    response.writeHead(200, responseHeaders);
                    response.end(buffer);
                }
            }
        });
    }
    
    /**
     * Get the proper path from the requested path
     * 
     * @return
     * @throws HttpServerException
     */
    private String resolveProperPath() throws HttpServerException {
        //find the resource
        String properPath = Path.get().normalize(Url.get().parse(request.url()).pathname());
        //better not have a dot at the beginning
        if (properPath.startsWith(".")) {
            throw new HttpServerException(403, 
                    "User tried to go to another directory or access hidden file");
        } else if (properPath.endsWith(".js")) {
            throw new HttpServerException(403, "User tried trying to access server side code");
        }
        //join it w/ my current directory
        return Path.get().join(Global.get().dirname(), properPath);
    }

    private void handleException(Exception e) {
        Util.get().log("Error: " + e);
        int code;
        String message;
        if (e instanceof HttpServerException) {
            code = ((HttpServerException) e).getCode();
            message = e.getMessage();
        } else {
            code = 500;
            message = "Internal Server Error";
        }
        response.writeHead(code, message);
        response.end();
    }
}
