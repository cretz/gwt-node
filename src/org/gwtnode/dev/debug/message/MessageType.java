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
package org.gwtnode.dev.debug.message;

import org.gwtnode.dev.debug.BufferStream;

/**
 * @author Chad Retz
 */
public enum MessageType {
    INVOKE {
        @Override
        public InvokeMessage createMessage(BufferStream stream, boolean fromClient) {
            return fromClient ? 
                    new InvokeFromClientMessage(stream) :
                    new InvokeToClientMessage(stream);
        }
    },
    RETURN {
        @Override
        public ReturnMessage createMessage(BufferStream stream, boolean fromClient) {
            return new ReturnMessage(stream);
        }
    },
    OLD_LOAD_MODULE {
        @Override
        public OldLoadModuleMessage createMessage(BufferStream stream, boolean fromClient) {
            return new OldLoadModuleMessage(stream);
        }
    },
    QUIT {
        @Override
        public QuitMessage createMessage(BufferStream stream, boolean fromClient) {
            return new QuitMessage(stream);
        }
    },
    LOAD_JSNI {
        @Override
        public LoadJsniMessage createMessage(BufferStream stream, boolean fromClient) {
            return new LoadJsniMessage(stream);
        }
    },
    INVOKE_SPECIAL {
        @Override
        public InvokeSpecialMessage createMessage(BufferStream stream, boolean fromClient) {
            return new InvokeSpecialMessage(stream);
        }
    },
    FREE_VALUE {
        @Override
        public FreeValueMessage createMessage(BufferStream stream, boolean fromClient) {
            return new FreeValueMessage(stream);
        }
    },
    FATAL_ERROR {
        @Override
        public FatalErrorMessage createMessage(BufferStream stream, boolean fromClient) {
            return new FatalErrorMessage(stream);
        }
    },
    CHECK_VERSIONS {
        @Override
        public CheckVersionsMessage createMessage(BufferStream stream, boolean fromClient) {
            return new CheckVersionsMessage(stream);
        }
    },
    PROTOCOL_VERSION {
        @Override
        public ProtocolVersionMessage createMessage(BufferStream stream, boolean fromClient) {
            return new ProtocolVersionMessage(stream);
        }
    },
    CHOOSE_TRANSPORT {
        @Override
        public ChooseTransportMessage createMessage(BufferStream stream, boolean fromClient) {
            return new ChooseTransportMessage(stream);
        }
    },
    SWITCH_TRANSPORT {
        @Override
        public SwitchTransportMessage createMessage(BufferStream stream, boolean fromClient) {
            return new SwitchTransportMessage(stream);
        }
    },
    LOAD_MODULE {
        @Override
        public LoadModuleMessage createMessage(BufferStream stream, boolean fromClient) {
            return new LoadModuleMessage(stream);
        }
    },
    REQUEST_ICON {
        @Override
        public RequestIconMessage createMessage(BufferStream stream, boolean fromClient) {
            return new RequestIconMessage(stream);
        }
    },
    USER_AGENT_ICON {
        @Override
        public UserAgentIconMessage createMessage(BufferStream stream, boolean fromClient) {
            return new UserAgentIconMessage(stream);
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
