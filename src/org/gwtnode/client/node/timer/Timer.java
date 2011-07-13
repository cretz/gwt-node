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
package org.gwtnode.client.node.timer;

import org.gwtnode.client.JavaScriptFunction;
import org.gwtnode.client.JavaScriptFunctionWrapper;
import org.gwtnode.client.JavaScriptReturningFunction;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.0/api/timers.html">timer</a>
 * functions.
 *
 * @author Chad Retz
 */
public class Timer {
    
    public static String setTimeout(JavaScriptFunctionWrapper wrapper, int delay,
            Object... arguments) {
        return setTimeout(wrapper.getNativeFunction(), delay, arguments);
    }

    public static String setTimeout(JavaScriptFunction callback, int delay,
            Object... arguments) {
        JavaScriptReturningFunction<String> timeoutFunc = getSetTimeoutFunction();
        Object[] newArguments = new Object[2 + arguments.length];
        newArguments[0] = callback;
        newArguments[1] = delay;
        if (arguments.length > 0) {
            System.arraycopy(arguments, 0, newArguments, 2, arguments.length);
        }
        return timeoutFunc.apply(newArguments);
    }
    
    private static native JavaScriptReturningFunction<String> getSetTimeoutFunction() /*-{
        return setTimeout;
    }-*/;
    
    public static native void clearTimeout(String timeoutId) /*-{
        clearTimeout(timeoutId);
    }-*/;

    public static String setInterval(JavaScriptFunctionWrapper wrapper, int delay,
            Object... arguments) {
        return setInterval(wrapper.getNativeFunction(), delay, arguments);
    }

    public static String setInterval(JavaScriptFunction callback, int delay,
            Object... arguments) {
        JavaScriptReturningFunction<String> intervalFunc = getSetIntervalFunction();
        Object[] newArguments = new Object[2 + arguments.length];
        newArguments[0] = callback;
        newArguments[1] = delay;
        if (arguments.length > 0) {
            System.arraycopy(arguments, 0, newArguments, 2, arguments.length);
        }
        return intervalFunc.apply(newArguments);
    }
    
    private static native JavaScriptReturningFunction<String> getSetIntervalFunction() /*-{
        return setInterval;
    }-*/;
    
    public static native void clearInterval(String intervalId) /*-{
        clearInterval(intervalId);
    }-*/;
    
    private Timer() {
    }
}
