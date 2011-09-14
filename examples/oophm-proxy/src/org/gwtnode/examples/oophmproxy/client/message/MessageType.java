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
package org.gwtnode.examples.oophmproxy.client.message;

/**
 * @author Chad Retz
 */
public enum MessageType {
    INVOKE {
        @Override
        public InvokeMessage createMessage(BufferStream stream, boolean fromClient) {
            return fromClient ? 
                    new InvokeFromClientMessage(INVOKE, stream) :
                    new InvokeToClientMessage(INVOKE, stream);
        }
    },
    RETURN {
        @Override
        public ReturnMessage createMessage(BufferStream stream, boolean fromClient) {
            return new ReturnMessage(RETURN, stream);
        }
    },
    OLD_LOAD_MODULE {
        @Override
        public OldLoadModuleMessage createMessage(BufferStream stream, boolean fromClient) {
            return new OldLoadModuleMessage(OLD_LOAD_MODULE, stream);
        }
    },
    QUIT {
        @Override
        public QuitMessage createMessage(BufferStream stream, boolean fromClient) {
            return new QuitMessage(QUIT, stream);
        }
    },
    LOAD_JSNI {
        @Override
        public LoadJsniMessage createMessage(BufferStream stream, boolean fromClient) {
            return new LoadJsniMessage(LOAD_JSNI, stream);
        }
    },
    INVOKE_SPECIAL {
        @Override
        public InvokeSpecialMessage createMessage(BufferStream stream, boolean fromClient) {
            return new InvokeSpecialMessage(INVOKE_SPECIAL, stream);
        }
    },
    FREE_VALUE {
        @Override
        public FreeValueMessage createMessage(BufferStream stream, boolean fromClient) {
            return new FreeValueMessage(FREE_VALUE, stream);
        }
    },
    FATAL_ERROR {
        @Override
        public FatalErrorMessage createMessage(BufferStream stream, boolean fromClient) {
            return new FatalErrorMessage(FATAL_ERROR, stream);
        }
    },
    CHECK_VERSIONS {
        @Override
        public CheckVersionsMessage createMessage(BufferStream stream, boolean fromClient) {
            return new CheckVersionsMessage(CHECK_VERSIONS, stream);
        }
    },
    PROTOCOL_VERSION {
        @Override
        public ProtocolVersionMessage createMessage(BufferStream stream, boolean fromClient) {
            return new ProtocolVersionMessage(PROTOCOL_VERSION, stream);
        }
    },
    CHOOSE_TRANSPORT {
        @Override
        public ChooseTransportMessage createMessage(BufferStream stream, boolean fromClient) {
            return new ChooseTransportMessage(CHOOSE_TRANSPORT, stream);
        }
    },
    SWITCH_TRANSPORT {
        @Override
        public SwitchTransportMessage createMessage(BufferStream stream, boolean fromClient) {
            return new SwitchTransportMessage(SWITCH_TRANSPORT, stream);
        }
    },
    LOAD_MODULE {
        @Override
        public LoadModuleMessage createMessage(BufferStream stream, boolean fromClient) {
            return new LoadModuleMessage(LOAD_MODULE, stream);
        }
    },
    REQUEST_ICON {
        @Override
        public RequestIconMessage createMessage(BufferStream stream, boolean fromClient) {
            return new RequestIconMessage(REQUEST_ICON, stream);
        }
    },
    USER_AGENT_ICON {
        @Override
        public UserAgentIconMessage createMessage(BufferStream stream, boolean fromClient) {
            return new UserAgentIconMessage(USER_AGENT_ICON, stream);
        }
    },
    REQUEST_PLUGIN {
        @Override
        public Message createMessage(BufferStream stream, boolean fromClient) {
            throw new UnsupportedOperationException();
        }
    };

    public static MessageType getMessageType(BufferStream stream) {
        return MessageType.values()[(int) stream.readByte()];
    }
    
    public abstract Message createMessage(BufferStream stream, boolean fromClient);
}
