package org.cretz.gwtnode.client.node.http;

import org.cretz.gwtnode.client.node.Global;
import org.cretz.gwtnode.client.node.NodeJsModule;

public class Http extends NodeJsModule {

    private static Http instance;
    
    public static Http get() {
        if (instance == null) {
            instance = Global.get().require("http");
        }
        return instance;
    }

    protected Http() {
    }
}
