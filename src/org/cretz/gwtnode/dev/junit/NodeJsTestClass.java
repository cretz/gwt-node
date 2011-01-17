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
package org.cretz.gwtnode.dev.junit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

class NodeJsTestClass {

    private final List<Method> beforeClassMethods;
    private final List<Method> beforeMethods;
    private final List<Method> afterClassMethods;
    private final List<Method> afterMethods;
    private final List<Method> tests;
    private Method parameters;
    private Constructor<?> constructor;
    
    public NodeJsTestClass(Class<?> clazz) {
        //special methods
        beforeClassMethods = new ArrayList<Method>();
        populateMethods(clazz, BeforeClass.class, true, beforeClassMethods);
        beforeMethods = new ArrayList<Method>();
        populateMethods(clazz, Before.class, false, beforeMethods);
        afterClassMethods = new ArrayList<Method>();
        populateMethods(clazz, AfterClass.class, true, afterClassMethods);
        afterMethods = new ArrayList<Method>();
        populateMethods(clazz, After.class, false, afterMethods);
        //tests
        tests = new ArrayList<Method>();
        populateMethods(clazz, Test.class, false, tests);
        //parameters
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Parameters.class)) {
                if (parameters != null) {
                    throw new RuntimeException("More than one method (" + method.getName() +
                            " and " + parameters.getName() + 
                            ") is marked with @Parameters in class " + clazz.getName());
                }
                if (!Modifier.isStatic(method.getModifiers())) {
                    throw new RuntimeException("Parameter method " + method.getName() +
                            " in class " + clazz.getName() + " is not static");
                }
                if (!Iterable.class.isAssignableFrom(method.getReturnType())) {
                    throw new RuntimeException("Parameter method " + method.getName() +
                            " in class " + clazz.getName() + 
                            " does not retun an instance of Iterable");
                }
                parameters = method;
            }
        }
        //constructor
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if (Modifier.isPublic(constructor.getModifiers())) {
                if (parameters != null) {
                    if (this.constructor != null) {
                        throw new RuntimeException("More than one public constructor in class " +
                                clazz.getName() + " that uses @Parameters");
                    }
                    if (constructor.getParameterTypes().length != 0 && parameters != null) {
                        this.constructor = constructor;
                    }
                } else if (constructor.getParameterTypes().length == 0) {
                    this.constructor = constructor;
                }
            }
        }
        if (constructor == null) {
            if (parameters != null) {
                throw new RuntimeException("Cannot find any public constructors for class " +
                        clazz.getName() + " and it has @Parameters");
            } else {
                throw new RuntimeException("Cannot find public, no-arg constructor for class " +
                        clazz.getName());
            }
        }
    }
    
    private void populateMethods(Class<?> clazz, 
            Class<? extends Annotation> annotation, 
            boolean requireStatic, List<Method> list) {
        if (clazz.getSuperclass() != null) {
            populateMethods(clazz.getSuperclass(), annotation, requireStatic, list);
        }
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(annotation)) {
                if (!Modifier.isPublic(method.getModifiers())) {
                    throw new RuntimeException("Method " + method.getName() + " in class " +
                            clazz.getName() + " is not public");
                }
                if (!Void.TYPE.equals(method.getReturnType())) {
                    throw new RuntimeException("Method " + method.getName() + " in class " +
                            clazz.getName() + " returns a value");
                }
                if (requireStatic && !Modifier.isStatic(method.getModifiers())) {
                    throw new RuntimeException("Method " + method.getName() + " in class " +
                            clazz.getName() + " is not static");
                }
                if (!requireStatic && Modifier.isStatic(method.getModifiers())) {
                    throw new RuntimeException("Method " + method.getName() + " in class " +
                            clazz.getName() + " is static");
                }
                list.add(method);
            }
        }
    }
}
