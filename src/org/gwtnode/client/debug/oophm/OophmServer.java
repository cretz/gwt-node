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
package org.gwtnode.client.debug.oophm;

import org.gwtnode.client.JavaScriptUtils;
import org.gwtnode.client.debug.oophm.OophmStream.StreamIndexOutOfBoundsException;
import org.gwtnode.client.debug.oophm.message.CheckVersionsMessage;
import org.gwtnode.client.debug.oophm.message.InvokeToClientMessage;
import org.gwtnode.client.debug.oophm.message.LoadJsniMessage;
import org.gwtnode.client.debug.oophm.message.LoadModuleMessage;
import org.gwtnode.client.debug.oophm.message.Message;
import org.gwtnode.client.debug.oophm.message.MessageType;
import org.gwtnode.client.debug.oophm.message.ProtocolVersionMessage;
import org.gwtnode.client.node.buffer.Buffer;
import org.gwtnode.client.node.event.ParameterlessEventHandler;
import org.gwtnode.client.node.event.StringOrBufferEventHandler;
import org.gwtnode.client.node.fs.Fs;
import org.gwtnode.client.node.net.Socket;
import org.gwtnode.client.node.stdio.Console;
import org.gwtnode.client.node.stream.WritableStream;
import org.gwtnode.client.node.vm.Vm;

/**
 * Server for communicating with GWT's OOPHM server
 * 
 * @author Chad Retz
 */
public class OophmServer {

    //TODO: finish this
    
    private final String moduleName;
    private final String host;
    private final int port;
    private final WritableStream debugLog;
    private Socket socket;
    private final OophmStream stream = new OophmStream();
    private MessageCallback nextCallback;
    
    public OophmServer(String moduleName, String host, int port) {
        this(moduleName, host, port, null);
    }
    
    public OophmServer(String moduleName, String host, int port, String logFile) {
        this.moduleName = moduleName;
        this.host = host == null ? "127.0.0.1" : host;
        this.port = port;
        if (logFile != null) {
            debugLog = Fs.get().createWriteStream(logFile);
        } else {
            debugLog = null;
        }
    }
    
    public void start() {
        socket = Socket.create();
        socket.onData(new StringOrBufferEventHandler() {
            @Override
            protected void onEvent() {
                stream.append(getBuffer());
                //try to grab a message
                Message message = getNextMessage();
                if (message != null) {
                    if (debugLog != null) {
                        //log receipt
                        debugLog.write("Received: " + message.toString() + '\n');
                    }
                    try {
                        //do we have something waiting?
                        if (nextCallback != null) {
                            MessageCallback callback = nextCallback;
                            nextCallback = null;
                            callback.onReceive(message);
                        } else {
                            //nope? ok, just do what's best for the type of message
                            switch (message.getType()) {
                            case LOAD_JSNI:
                                //load JSNI? just grab the code and execute it
                                Vm.get().runInThisContext(((LoadJsniMessage) message).getJsCode());
                                break;
                            case INVOKE:
                                //invoke and send back return
                                sendMessage(OophmUtils.invokeJavaScript((InvokeToClientMessage) message));
                                break;
                            case QUIT:
                                stop();
                            default:
                                throw new IllegalArgumentException("Unrecognized message type: " + 
                                        message.getType());
                            }
                        }
                    } catch (Exception e) {
                        //failure
                        Console.get().log("Failure: " + 
                                JavaScriptUtils.appendException(e, new StringBuilder()));
                        stop();
                    }
                }
            }
        });
        ParameterlessEventHandler onConnect = new ParameterlessEventHandler() {
            @Override
            public void onEvent() {
                if (debugLog != null) {
                    debugLog.write("Connected");
                }
                //let's send a check versions
                sendMessage(new CheckVersionsMessage(2, 2, "2.1"), new MessageCallback() {
                    @Override
                    public void onReceive(Message message) {
                        //it better be a protocol versions message
                        if (message.getType() != MessageType.PROTOCOL_VERSION) {
                            throw new IllegalStateException("Expected protocol version message, got: " +
                                    message.getType());
                        }
                        //it better be version 2
                        if (((ProtocolVersionMessage) message).getProtocolVersion() != 2) {
                            throw new IllegalArgumentException("Unexpected protocol version: " +
                                    ((ProtocolVersionMessage) message).getProtocolVersion());
                        }
                        //good, good, now let's load the module
                        //my session and my tab are one based on the current ms and a random number
                        String keyPrefix = Long.toHexString(System.currentTimeMillis()) +
                                "_" + Integer.toHexString((int) (Math.random() * Integer.MAX_VALUE));
                        sendMessage(new LoadModuleMessage(
                                //the URL is not really a URL, but rather my host and port
                                "gwt-node-debug://" + host + ":" + port, 
                                "tab_" + keyPrefix, 
                                "session_" + keyPrefix,
                                moduleName,
                                "gwt-node/0.0.1"));
                    }
                });
            }
        };
        socket.connect(port, host, onConnect);
    }
    
    public void stop() {
        if (socket != null) {
            socket.end();
        }
        if (debugLog != null) {
            debugLog.end();
        }
    }
    
    private Message getNextMessage() {
        try {
            stream.beginTransaction();
            MessageType type = MessageType.getMessageType(stream);
            Message message = type.createMessage(stream, false);
            stream.commitTransaction();
            return message;
        } catch (StreamIndexOutOfBoundsException e) {
            stream.rollbackTransaction();
            return null;
        }
    }
    
    private void sendMessage(Message message) {
        sendMessage(message, null);
    }
    
    private void sendMessage(Message message, MessageCallback callback) {
        try {
            Buffer buffer = message.toBuffer();
            if (debugLog != null) {
                //log send
                debugLog.write("Sending: " + message.toString() + " (length " + buffer.length() + ")\n");
            }
            socket.write(buffer);
            nextCallback = callback;
        } catch (Exception e) {
            Console.get().log("Failure: " + 
                    JavaScriptUtils.appendException(e, new StringBuilder()));
            stop();
        }
    }
    
    private static interface MessageCallback {
        void onReceive(Message message);
    }
}
