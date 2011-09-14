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

import org.gwtnode.client.node.buffer.Buffer;
import org.gwtnode.client.node.event.BooleanEventHandler;
import org.gwtnode.client.node.event.StringOrBufferEventHandler;
import org.gwtnode.client.node.net.Net;
import org.gwtnode.client.node.net.Server;
import org.gwtnode.client.node.net.Socket;
import org.gwtnode.client.node.net.StreamEventHandler;
import org.gwtnode.client.node.stdio.Console;
import org.gwtnode.examples.oophmproxy.client.message.BufferStream;
import org.gwtnode.examples.oophmproxy.client.message.BufferStream.StreamIndexOutOfBoundsException;
import org.gwtnode.examples.oophmproxy.client.message.Message;
import org.gwtnode.examples.oophmproxy.client.message.MessageType;

/**
 * @author Chad Retz
 */
class OophmProxyServer {
    
    private final Server server;
    private final int proxyPort;
    private Socket proxySocket;
    private Socket gwtCodeSocket;
    private final BufferStream proxyStream = new BufferStream();
    private final BufferStream gwtCodeStream = new BufferStream();
    
    public OophmProxyServer(int proxyPort, final String gwtCodeHost, final int gwtCodePort) {
        server = Net.get().createServer(new StreamEventHandler() {
            @Override
            protected void onEvent(Socket stream) {
                proxySocket = stream;
                gwtCodeSocket = Socket.create();
                gwtCodeSocket.connect(gwtCodePort, gwtCodeHost);
                proxySocket.onData(new StringOrBufferEventHandler() {
                    @Override
                    protected void onEvent() {
                        Buffer buffer = getBuffer();
                        proxyStream.append(buffer);
                        logMessage(proxyStream, true);
                        gwtCodeSocket.write(buffer);
                    }
                });
                gwtCodeSocket.onData(new StringOrBufferEventHandler() {
                    @Override
                    protected void onEvent() {
                        Buffer buffer = getBuffer();
                        gwtCodeStream.append(buffer);
                        logMessage(gwtCodeStream, false);
                        proxySocket.write(buffer);
                    }
                });
                proxySocket.onClose(new BooleanEventHandler() {
                    @Override
                    protected void onEvent(boolean value) {
                        gwtCodeSocket.end();
                    }
                });
                gwtCodeSocket.onClose(new BooleanEventHandler() {
                    @Override
                    protected void onEvent(boolean value) {
                        proxySocket.end();
                    }
                });
            }
        });
        this.proxyPort = proxyPort;
    }
    
    private void logMessage(BufferStream stream, boolean fromClient) {
        try {
            stream.beginTransaction();
            MessageType type = MessageType.getMessageType(stream);
            Message message = type.createMessage(stream, fromClient);
            Console.get().info(message.toString());
            stream.commitTransaction();
        } catch (StreamIndexOutOfBoundsException e) {
            stream.rollbackTransaction();
        }
    }
    
    public void listen() {
        Console.get().info("Listening on port: " + proxyPort);
        server.listen(proxyPort);
    }
}
