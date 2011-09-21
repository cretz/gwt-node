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
package org.gwtnode.core;

import org.gwtnode.core.node.NodeJsError;
import org.gwtnode.core.node.event.ErrorEventHandler;
import org.gwtnode.core.node.event.ParameterlessEventHandler;
import org.gwtnode.core.node.process.Process;
import org.gwtnode.core.node.stdio.Console;
import org.gwtnode.core.node.util.Util;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JsArrayString;

/**
 * Base class for bootstrapping into a node.js program. It is
 * recommended that this class is extended and {@link #main(String...)}
 * implemented to begin a node.js program.
 * 
 * @author Chad Retz
 */
public abstract class GwtNodeBootstrap implements EntryPoint {
    
    @Override
    public final void onModuleLoad() {
        //unhandled errors
        GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void onUncaughtException(Throwable e) {
                GwtNodeBootstrap.this.onUncaughtException(e);
            }
        });
        Process.get().onUncaughtException(new ErrorEventHandler() {
            @Override
            public void onEvent(NodeJsError exception) {
                JavaScriptException e = new JavaScriptException(exception);
                if (e.getStackTrace().length == 0) {
                    e.fillInStackTrace();
                }
                onUncaughtException(e);
            }
        });
        Process.get().nextTick(new ParameterlessEventHandler() {
        @Override
        public void onEvent() {                
            
        try {
            //grab the arguments
            JsArrayString nativeArgs = Process.get().argv();
            //well, the best I can do right now is find the arguments
            //    after the .js argument
            //TODO: be smarter than this
            int jsArgIndex;
            for (jsArgIndex = 0; jsArgIndex < nativeArgs.length(); jsArgIndex++) {
                if (nativeArgs.get(jsArgIndex).endsWith(".js")) {
                    break;
                }
            }
            //make the final native string array
            String[] args;
            if (jsArgIndex == nativeArgs.length()) {
                Util.get().log("Unable to find argument ending with .js");
                args = new String[0];
            } else {
                args = new String[nativeArgs.length() - jsArgIndex - 1];
                for (int i = 0; i < args.length; i++) {
                    args[i] = nativeArgs.get(jsArgIndex + i + 1);
                }
            }
            //call the main method
            Runner runner = GWT.create(Runner.class);
            runner.run(GwtNodeBootstrap.this, new Closure<Integer>() {
                @Override
                public void call(Integer result) {
                    if (result != null) {
                        Process.get().exit(result);
                    }
                }
            }, args);
        } catch (Throwable e) {
            onUncaughtException(e);
        }
        
        }});
    }
    
    protected void onUncaughtException(Throwable e) {
        Console.get().log(JavaScriptUtils.appendException(e, new StringBuilder()).toString());
        Console.get().trace();
        //we have to exit hard...
        Process.get().exit(1);
    }
    
    /**
     * Entry point for the application. The arguments are all the arguments
     * after the .js file is located (by its file extension) in the original 
     * arguments. To get the full, original argument list, use {@link Process#argv()}.
     * 
     * @param args
     * @return Return null to NOT call {@link Process#exit(int)}
     */
    public abstract Integer main(String... args);
}
