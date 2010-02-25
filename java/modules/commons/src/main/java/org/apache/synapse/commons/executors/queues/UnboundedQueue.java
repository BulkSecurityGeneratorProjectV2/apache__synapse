/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.synapse.commons.executors.queues;

import org.apache.synapse.commons.executors.InternalQueue;

import java.util.*;
import java.util.concurrent.locks.Condition;

/**
 * An unbounded queue
 * @param <E>
 */
public class UnboundedQueue<E> extends AbstractQueue<E> implements InternalQueue<E> {

    private List<E> elements = new ArrayList<E>();

     /**
     * Priority of this queue
     */
    private int priority;
    
    /**
     * A waiting queue when this queue is full
     */
    private Condition notFullCond;

    public UnboundedQueue(int priority) {
        this.priority = priority;        
    }

    public Iterator<E> iterator() {
        return elements.iterator();
    }

    public int size() {
        return elements.size();
    }

    public boolean offer(E e) {
        return elements.add(e);
    }

    public E poll() {
        return elements.remove(elements.size() - 1);
    }

    public E peek() {
        return elements.get(elements.size() - 1);
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int p) {
        this.priority = p;
    }    

    public Condition getNotFullCond() {
        return notFullCond;
    }

    public void setNotFullCond(Condition condition) {
        this.notFullCond = condition;
    }

    public int drainTo(Collection<? super E> c) {
        int count = elements.size();
        c.addAll(elements);
        elements.clear();
        return count;
    }

    public int drainTo(Collection<? super E> c, int maxElements) {
        if (maxElements >= elements.size()) {
            return drainTo(c);
        } else {
            elements.subList(elements.size() - maxElements - 1, elements.size());
            return maxElements;
        }
    }

    public int remainingCapacity() {
        return Integer.MAX_VALUE;
    }

    public int getCapacity() {
        return Integer.MAX_VALUE;
    }
}