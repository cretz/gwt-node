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
package org.gwtnode.examples.junit.client;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class AnnotationBaseTestClass {

    protected static boolean baseAfterClassRan = false;
    protected static boolean baseAfterRan = false;
    
    protected static boolean baseBeforeClassRan = false;
    protected static boolean baseBeforeRan = false;
    
    @BeforeClass
    public static void baseSetupOnce() {
        baseBeforeClassRan = true;
    }
    
    @AfterClass
    public static void baseTeardownOnce() {
        baseAfterClassRan = true;
    }
    
    @Before
    public void baseSetup() {
        baseBeforeRan = true;
    }
    
    @After
    public void baseTeardown() {
        baseAfterRan = true;
    }
}
