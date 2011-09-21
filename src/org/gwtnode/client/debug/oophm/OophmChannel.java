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

import org.gwtnode.client.debug.oophm.OophmSessionHandler.InvokeResult;
import org.gwtnode.client.debug.oophm.OophmStream.StreamIndexOutOfBoundsException;
import org.gwtnode.client.debug.oophm.message.CheckVersionsMessage;
import org.gwtnode.client.debug.oophm.message.FatalErrorMessage;
import org.gwtnode.client.debug.oophm.message.FreeValueMessage;
import org.gwtnode.client.debug.oophm.message.InvokeToClientMessage;
import org.gwtnode.client.debug.oophm.message.LoadJsniMessage;
import org.gwtnode.client.debug.oophm.message.LoadModuleMessage;
import org.gwtnode.client.debug.oophm.message.Message;
import org.gwtnode.client.debug.oophm.message.MessageType;
import org.gwtnode.client.debug.oophm.message.ProtocolVersionMessage;
import org.gwtnode.client.debug.oophm.message.QuitMessage;
import org.gwtnode.client.debug.oophm.message.ReturnMessage;
import org.gwtnode.client.node.buffer.Buffer;
import org.gwtnode.client.node.event.ParameterlessEventHandler;
import org.gwtnode.client.node.event.StringOrBufferEventHandler;
import org.gwtnode.client.node.net.Socket;

/**
 * Channel for communicating w/ GWT code server
 *
 * @author Chad Retz
 */
public class OophmChannel {

    private static final int MINIMUM_PROTOCOL_VERSION = 2;
    private static final int MAXIMUM_PROTOCOL_VERSION = 2;
    private static final String HOSTED_HTML_VERSION = "2.1";

    private final String moduleName;
    private final String host;
    private final int port;
    private Socket socket;
    private final OophmStream stream = new OophmStream();
    private OophmSessionHandler session;
    private MessageCallback nextMessageCallback;
    
    public OophmChannel(String moduleName, String host, int port) {
        this.moduleName = moduleName;
        this.host = host;
        this.port = port;
    }
    
    public void start(OophmSessionHandler sess) {
        this.session = sess;
        if (socket != null) {
            session.getLog().debug("Disconnecting previous channel");
            disconnectFromHost();
        }
        socket = Socket.create();
        socket.onData(new StringOrBufferEventHandler() {
            @Override
            protected void onEvent() {
                stream.append(getBuffer());
                //grab a message
                Message message = getNextMessage();
                if (message != null) {
                    if (session.getLog().isDebugEnabled()) {
                        session.getLog().debug("Received message: %s", message.toString());
                    }
                    handleMessage(message);
                }
            }
        });
        socket.connect(port, host, new ParameterlessEventHandler() {
            @Override
            public void onEvent() {
                session.getLog().debug("Channel connection complete");
                init();
            }
        });
    }
    
    private void init() {
        session.getLog().debug("Initializing...");
        sendMessage(new CheckVersionsMessage(MINIMUM_PROTOCOL_VERSION, 
                MAXIMUM_PROTOCOL_VERSION, HOSTED_HTML_VERSION), new MessageCallback() {
                    @Override
                    public void onMessage(Message message) {
                        if (message instanceof FatalErrorMessage) {
                            session.fatalError(((FatalErrorMessage) message).getError());
                            end();
                        } else if (message instanceof ProtocolVersionMessage) {
                            //yay!
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
                        } else {
                            throw new IllegalStateException("Unexpected message type: " + message.getType());
                        }
                    }
                });
    }
    
    private void handleMessage(Message message) {
        if (nextMessageCallback != null) {
            MessageCallback callback = nextMessageCallback;
            nextMessageCallback = null;
            callback.onMessage(message);
        } else {
            switch (message.getType()) {
            case LOAD_JSNI:
                session.loadJsni(((LoadJsniMessage) message).getJsCode());
                break;
            case FREE_VALUE:
                session.freeValues(((FreeValueMessage) message).getRefIds());
                break;
            case INVOKE:
                InvokeToClientMessage msg = (InvokeToClientMessage) message;
                InvokeResult result = session.invoke(
                        msg.getMethodName(), msg.getThisValue(), msg.getArgValues());
                sendMessage(new ReturnMessage(result.isException(), result.getValue()));
                break;
            case FATAL_ERROR:
                session.fatalError(((FatalErrorMessage) message).getError());
                end();
            case QUIT:
                end();
                break;
            default:
                throw new IllegalArgumentException("Unrecognized message type: " + 
                        message.getType());
            }
        }
    }
    
    private void end() {
        if (socket != null) {
            session.getLog().debug("Ending connection");
            socket.end();
            socket = null;
        }
    }

    public void disconnectFromHost() {
        if (socket != null) {
            sendMessage(new QuitMessage());
            end();
        }
    }
    public void sendMessage(Message message) {
        if (session.getLog().isDebugEnabled()) {
            session.getLog().debug("Sending message: %s", message.toString());
        }
        Buffer buffer = message.toBuffer();
        socket.write(buffer);
    }
    
    public void sendMessage(Message message, MessageCallback callback) {
        if (session.getLog().isDebugEnabled()) {
            session.getLog().debug("Sending message: %s", message.toString());
        }
        Buffer buffer = message.toBuffer();
        socket.write(buffer);
        nextMessageCallback = callback;
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
    
    private static interface MessageCallback {
        void onMessage(Message message);
    }
}
