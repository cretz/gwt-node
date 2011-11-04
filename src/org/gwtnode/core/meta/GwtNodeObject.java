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
package org.gwtnode.core.meta;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation defining a gwt-node object
 *
 * @author Chad Retz
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface GwtNodeObject {

    /**
     * The name of the object in node.js. If not present, this is
     * the class's name.
     * 
     * @return
     */
    String value() default "";
    
    /**
     * The name of the module this object belongs to. If not present,
     * this assumes it is whatever module is found in the current
     * package. If there are multiple modules in the current package
     * or no modules in the current package, this defaults to the
     * global module.
     * 
     * @return
     */
    String module() default "";
}
