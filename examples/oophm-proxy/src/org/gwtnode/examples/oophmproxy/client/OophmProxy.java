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
package org.gwtnode.examples.oophmproxy.client;

import java.util.Arrays;
import java.util.List;

import org.gwtnode.client.GwtNodeBootstrap;
import org.gwtnode.client.node.util.Util;

/**
 * Inspired by <a href="http://delog.wordpress.com/2011/04/08/a-simple-tcp-proxy-in-node-js/">this</a>
 * 
 * @author Chad Retz
 */
public class OophmProxy extends GwtNodeBootstrap {

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
        int proxyPort;
        try {
            proxyPort = Integer.parseInt(getArg(argList, "-proxyPort"));
        } catch (Exception e) {
            Util.get().log("Unable to obtain integer-based -proxyPort parameter");
            return 1;
        }
        int gwtCodePort;
        try {
            gwtCodePort = Integer.parseInt(getArg(argList, "-gwtCodePort"));
        } catch (Exception e) {
            Util.get().log("Unable to obtain integer-based -gwtCodePort parameter");
            return 1;
        }
        String gwtCodeHost = getArg(argList, "-gwtCodeHost");
        if (gwtCodeHost == null) {
            gwtCodeHost = "127.0.0.1";
        }
        new OophmProxyServer(proxyPort, gwtCodeHost, gwtCodePort).listen();
        return null;
    }

}
