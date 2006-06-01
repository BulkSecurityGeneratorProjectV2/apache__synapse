/*
 * Copyright 2004,2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.synapse.core.axis2;

import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.engine.MessageReceiver;
import org.apache.synapse.Constants;

/**
 * <p>Does nothing! Used as an endpoint so we can engage modules
 */
public class EmptyMessageReceiver implements MessageReceiver {

    public void receive(MessageContext mc) throws AxisFault {
        mc.setProperty(Constants.MEDIATOR_RESPONSE_PROPERTY, Boolean
            .valueOf(true));
    }

}
