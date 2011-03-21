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
package org.cretz.gwtnode.dev.debug.client;

import java.util.ArrayList;
import java.util.List;

import org.cretz.gwtnode.client.Closure;
import org.cretz.gwtnode.client.GwtNodeBootstrap;
import org.cretz.gwtnode.client.Runner;
import org.cretz.gwtnode.client.node.event.ParameterlessEventHandler;
import org.cretz.gwtnode.client.node.util.Util;

class DebugRunnerImpl implements Runner {

    private boolean debugSuspend;
    
    @Override
    public void run(final GwtNodeBootstrap bootstrap, final Closure<Integer> callback,
            String... args) {
        Integer debugPort = null;
        String debugHost = null;
        boolean debugLogged = false;
        final List<String> listArgs = new ArrayList<String>();
        boolean skipNext = false;
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if ("-gwt-node-debug-port".equals(arg) && i != args.length - 1) {
                skipNext = true;
                try {
                    debugPort = Integer.parseInt(args[i + 1]);
                } catch (NumberFormatException e) {
                    Util.get().log("Invalid debug port: " + args[i + 1]);
                }
            } else if ("-gwt-node-debug-host".equals(arg) && i != args.length - 1) {
                skipNext = true;
                debugHost = args[i + 1];
            } else if ("-gwt-node-debug-log".equals(arg)) {
                debugLogged = true;
            } else if ("-gwt-node-debug-suspend".equals(arg)) {
                debugSuspend = true;
            } else if (skipNext) {
                skipNext = false;
            } else {
                listArgs.add(arg);
            }
        }
        if (debugPort != null) {
            DebugServer.get().start(debugLogged, debugPort, debugHost, 
                    new ParameterlessEventHandler() {
                        @Override
                        public void onEvent() {
                            if (debugSuspend) {
                                DebugServer.get().suspendUntilOutput();
                            }
                            callback.call(bootstrap.main(listArgs.toArray(new String[0])));
                        }
            });
        } else {
            callback.call(bootstrap.main(listArgs.toArray(new String[0])));
        }
    }
}
