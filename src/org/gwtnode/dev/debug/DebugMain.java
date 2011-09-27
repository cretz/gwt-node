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
package org.gwtnode.dev.debug;

import java.util.Arrays;
import java.util.List;

import org.gwtnode.core.GwtNodeBootstrap;
import org.gwtnode.core.node.fs.Fs;
import org.gwtnode.core.node.process.Process;
import org.gwtnode.core.node.util.Util;
import org.gwtnode.dev.debug.DebugLog.Level;

/**
 * An OOPHM debugger
 * 
 * @author Chad Retz
 */
public class DebugMain extends GwtNodeBootstrap {

    private static String getArg(List<String> argList, String argName) {
        int index = argList.indexOf(argName);
        if (index != -1 && index < argList.size() - 1) {
            return argList.get(index + 1);
        }
        return null;
    }
    
    @Override
    public Integer main(String... args) {
        //grab params
        List<String> argList = Arrays.asList(args);
        int port;
        try {
            port = Integer.parseInt(getArg(argList, "-port"));
        } catch (Exception e) {
            Util.get().log("Unable to obtain integer-based -port parameter");
            return 1;
        }
        String host = getArg(argList, "-host");
        if (host == null) {
            host = "127.0.0.1";
        }
        String module = getArg(argList, "-module");
        if (module == null) {
            Util.get().log("Unable to obtain module name");
            return 1;
        }
        String logFile = getArg(argList, "-logFile");
        String logLevel = getArg(argList, "-logLevel");
        //create log
        DebugLog log = new DebugLog(
                logFile == null ? Process.get().stdout() : Fs.get().createWriteStream(logFile),
                logLevel == null ? Level.INFO : Level.valueOf(logLevel));
        //create the channel
        HostChannel channel = new HostChannel(module, host, port);
        //create session handler
        SessionHandler session = new SessionHandler(channel, log);
        //start the channel
        channel.start(session);
        return null;
    }

}
