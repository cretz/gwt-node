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

import org.gwtnode.client.node.assertion.Assert;
import org.gwtnode.dev.junit.NodeJsTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(NodeJsTestRunner.class)
public class NativeTest {

    @Test
    public native void testNativeSuccess() /*-{
        require('assert').ok(true);
    }-*/;
    
    @Test
    public native void testNativeFailure() /*-{
        require('assert').equal(1, 2, 'I expected failure');
    }-*/;
    
    @Test
    public void testGwtNodeAssertWrapperSuccess() {
        Assert.get().equal(1, 2);
    }
    
    @Test
    public void testGwtNodeAssertWrapperFailure() {
        Assert.get().equal(1, 2, "I expected failure");
    }
}
