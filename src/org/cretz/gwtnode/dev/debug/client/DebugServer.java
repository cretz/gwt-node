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

import org.cretz.gwtnode.client.node.buffer.Buffer;
import org.cretz.gwtnode.client.node.event.ParameterlessEventHandler;
import org.cretz.gwtnode.client.node.event.StringOrBufferEventHandler;
import org.cretz.gwtnode.client.node.net.Net;
import org.cretz.gwtnode.client.node.net.Server;
import org.cretz.gwtnode.client.node.net.Socket;
import org.cretz.gwtnode.client.node.net.StreamEventHandler;
import org.cretz.gwtnode.client.node.util.Util;
import org.cretz.gwtnode.dev.debug.client.jdwp.Packet;
import org.cretz.gwtnode.dev.debug.client.jdwp.PacketFactory;

public class DebugServer {

    private static DebugServer instance;
    
    public static DebugServer get() {
        if (instance == null) {
            instance = new DebugServer();
        }
        return instance;
    }
    
    //TODO: Use deferred binding for the log please
    
    private boolean log;
    private Server server;
    private Socket stream;
    private boolean suspended;
    
    private DebugServer() {
    }
    
    public void start(boolean log, int port, String host,
            ParameterlessEventHandler onReady) {
        this.log = log;
        server = Net.get().createServer(new StreamEventHandler() {
            @Override
            protected void onEvent(Socket stream) {
                DebugServer.this.stream = stream;
                //add handlers
                stream.onConnect(new ParameterlessEventHandler() {
                    @Override
                    public void onEvent() {
                        onConnect();
                    }
                });
                stream.onEnd(new ParameterlessEventHandler() {
                    @Override
                    public void onEvent() {
                        onEnd();
                    }
                });
                stream.onData(new StringOrBufferEventHandler() {
                    @Override
                    protected void onEvent() {
                        onData(getBuffer());
                    }
                });
            }
        });
        log("Starting debug server on port " + port);
        if (host != null) {
            server.listen(port, host, onReady);
        } else {
            server.listen(port, onReady);
        }
    }
    
    private void log(String string) {
        if (log) {
            Util.get().log(string);
        }
    }
    
    private void onConnect() {
        log("Connected");
        if (!stream.write("JDWP-Handshake", "ascii")) {
            log("Error");
        }
    }
    
    private void onEnd() {
        log("Connection ended");
    }
    
    private void onData(Buffer buffer) {
        if ("JDWP-Handshake".equals(buffer.toString("ascii"))) {
            log("Received handshake");
        } else {
            Packet pkt = PacketFactory.getPacket(buffer);
            if (log) {
                log("Packet: " + pkt.toString());
            }
        }
    }

    public void stop() {
        if (stream != null) {
            stream.end();
        }
    }
    
    public void suspendUntilOutput() {
        //TODO: this is absolutely unacceptable
        suspended = true;
        while (suspended) { };
    }
    
    public void resume() {
        suspended = false;
    }
}
