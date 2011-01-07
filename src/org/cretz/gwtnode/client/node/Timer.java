package org.cretz.gwtnode.client.node;

import org.cretz.gwtnode.client.JavaScriptFunction;
import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.JavaScriptReturningFunction;

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
