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

import java.util.Arrays;
import java.util.List;

import org.cretz.gwtnode.client.GwtNodeBootstrap;
import org.cretz.gwtnode.client.node.http.Http;
import org.cretz.gwtnode.client.node.http.Server;
import org.cretz.gwtnode.client.node.sys.Sys;

/**
 * Simple HTTP server. THIS IS NOT A SECURE WEB SERVER
 *
 * @author Chad Retz
 */
public class HttpServer extends GwtNodeBootstrap {

    /**
     * Get the argument from the given list that immediately
     * follows the name given. Returns null if not found.
     * 
     * @param argList
     * @param argName
     * @return
     */
    private static String getArg(List<String> argList, String argName) {
        int index = argList.indexOf(argName);
        if (index != -1 && index < argList.size() - 1) {
            return argList.get(index + 1);
        }
        return null;
    }
    
    @Override
    public Integer main(String... args) {
        //arguments
        List<String> argList = Arrays.asList(args);
        //get the port (required)
        int port;
        try {
            port = Integer.parseInt(getArg(argList, "-port"));
        } catch (Exception e) {
            Sys.get().log("Unable to obtain integer-based -port parameter");
            return 1;
        }
        //get the host (not required)
        String host = getArg(argList, "-host");
        //start it up
        Sys.get().log("Creating server");
        HttpServerListener listener = new HttpServerListener();
        Server server = Http.get().createServer(listener);
        Sys.get().log("Listening");
        if (host != null) {
            server.listen(port, host);
        } else {
            server.listen(port);
        }
        return null;
    }

}
