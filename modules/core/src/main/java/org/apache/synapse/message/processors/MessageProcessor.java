/*
*  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.apache.synapse.message.processors;

import org.apache.synapse.Mediator;
import org.apache.synapse.MessageContext;
import org.apache.synapse.message.store.MessageStore;

import java.util.HashMap;
import java.util.Map;

/**
 *All Synapse Message Processors must implement <code>MessageProcessor</code> interface
 *Message processors will process the Message using a Message Store.
 *Message processing logic and process will depend on the
 *concrete implementation of the MessageStore
 */
public interface MessageProcessor {

    /**
     * Start Message Processor
     */
    public void start();

    /**
     * Stop MessageProcessor
     */
    public void stop();

    /**
     * Set the Message Store that backs the Message processor
     * @param messageStore the underlying MessageStore instance
     */
    public void setMessageStore(MessageStore messageStore);

    /**
     * Get the Message store that backs the Message processor
     * @return   the underlying MessageStore instance
     */
    public MessageStore getMessageStore();

    /**
     * Set the Mediator/Sequence to be invoked just before processing a Message
     * This Mediator or sequence will be invoked just before processing the Message
     * @param mediator   Mediator/sequence instance that will invoked just before
     * processing a Message
     */
    public void setOnProcessSequence(Mediator mediator);


    /**
     * Get the On process Mediator or sequence
     * @return Mediator/sequence instance that will invoked just before processing a Message
     */
    public Mediator getOnProcessSequence();

    /**
     * This sequence/Mediator will be invoked when a Message is submitted to the MessageProcessor
     * @param mediator Mediator/sequence instance that will invoked when a Message
     * is submitted to the Processor
     */
    public void setOnSubmitSequence(Mediator mediator);

    /**
     * Get the OnSubmit Sequence which get invoked when a Message is submitted to
     * the MessageProcessor
     * @return mediator Mediator/sequence instance that will invoked when a Message
     * is submitted to the Processor
     */
    public Mediator getOnSubmitSequence();

    /**
     * Set the Message processor parameters that will be used by the specific implementation
     * @param parameters
     */
    public void setParameters(Map<String,Object> parameters);

    /**
     * Get the Message processor Parameters
     * @return
     */
    public Map<String , Object> getParameters();

    /**
     * Returns weather a Message processor is started or not
     * @return
     */
    public boolean isStarted();
}
