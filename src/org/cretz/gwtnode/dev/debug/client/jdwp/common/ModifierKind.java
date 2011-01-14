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
package org.cretz.gwtnode.dev.debug.client.jdwp.common;

import java.util.Collection;

import org.cretz.gwtnode.client.node.buffer.Buffer;
import org.cretz.gwtnode.dev.debug.client.jdwp.er.mod.ClassExcludeModifier;
import org.cretz.gwtnode.dev.debug.client.jdwp.er.mod.ClassMatchModifier;
import org.cretz.gwtnode.dev.debug.client.jdwp.er.mod.ClassOnlyModifier;
import org.cretz.gwtnode.dev.debug.client.jdwp.er.mod.ConditionalModifier;
import org.cretz.gwtnode.dev.debug.client.jdwp.er.mod.CountModifier;
import org.cretz.gwtnode.dev.debug.client.jdwp.er.mod.Modifier;
import org.cretz.gwtnode.dev.debug.client.jdwp.er.mod.ExceptionOnlyModifier;
import org.cretz.gwtnode.dev.debug.client.jdwp.er.mod.FieldOnlyModifier;
import org.cretz.gwtnode.dev.debug.client.jdwp.er.mod.InstanceOnlyModifier;
import org.cretz.gwtnode.dev.debug.client.jdwp.er.mod.LocationOnlyModifier;
import org.cretz.gwtnode.dev.debug.client.jdwp.er.mod.SourceNameMatchModifier;
import org.cretz.gwtnode.dev.debug.client.jdwp.er.mod.StepModifier;
import org.cretz.gwtnode.dev.debug.client.jdwp.er.mod.ThreadOnlyModifier;

public enum ModifierKind {
    
    COUNT {
        @Override
        protected Modifier createNewModifier() {
            return new CountModifier();
        }
    },
    CONDITIONAL {
        @Override
        protected Modifier createNewModifier() {
            return new ConditionalModifier();
        }
    },
    THREAD_ONLY {
        @Override
        protected Modifier createNewModifier() {
            return new ThreadOnlyModifier();
        }
    },
    CLASS_ONLY {
        @Override
        protected Modifier createNewModifier() {
            return new ClassOnlyModifier();
        }
    },
    CLASS_MATCH {
        @Override
        protected Modifier createNewModifier() {
            return new ClassMatchModifier();
        }
    },
    CLASS_EXCLUDE {
        @Override
        protected Modifier createNewModifier() {
            return new ClassExcludeModifier();
        }
    },
    LOCATION_ONLY {
        @Override
        protected Modifier createNewModifier() {
            return new LocationOnlyModifier();
        }
    },
    EXCEPTION_ONLY {
        @Override
        protected Modifier createNewModifier() {
            return new ExceptionOnlyModifier();
        }
    },
    FIELD_ONLY {
        @Override
        protected Modifier createNewModifier() {
            return new FieldOnlyModifier();
        }
    },
    STEP {
        @Override
        protected Modifier createNewModifier() {
            return new StepModifier();
        }
    },
    INSTANCE_ONLY {
        @Override
        protected Modifier createNewModifier() {
            return new InstanceOnlyModifier();
        }
    },
    SOURCE_NAME_MATCH {
        @Override
        protected Modifier createNewModifier() {
            return new SourceNameMatchModifier();
        }
    };
    
    public static int applyNextModifier(Buffer buffer, int index, Collection<Modifier> modifiers) {
        ModifierKind modifierKind = fromByte(buffer.get(index));
        Modifier event = modifierKind.createNewModifier();
        event.setModifierKind(modifierKind);
        modifiers.add(event);
        return event.buildFromBuffer(buffer, index + 1);
    }
    
    public static ModifierKind fromByte(byte byt) {
        if (byt > values().length) {
            return null;
        } else {
            return values()[byt - 1];
        }
    }
    
    public int getNumber() {
        return ordinal() + 1;
    }
    
    protected abstract Modifier createNewModifier();
}
