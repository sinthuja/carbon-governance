/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.governance.lcm.tasks.events;

import org.wso2.carbon.registry.common.eventing.RegistryEvent;

/**
 * THis Event class holds the events when a checkpoint needs to send notifications.
 */
public class LifecycleNotificationEvent<T> extends RegistryEvent<T> {

    /**
     * Notification event resource path.
     */
    private String resourcePath = null;

    /**
     * Notification event name.
     */
    public static final String EVENT_NAME = "CheckpointNotification";

    /**
     * This method is used to create Checkpoint objects.
     *
     * @param message  Transient message.
     */
    public LifecycleNotificationEvent(T message) {
        super(message);
    }

    /**
     * Set event notification path.
     *
     * @param resourcePath  String resource path.
     */
    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
        setTopic(TOPIC_SEPARATOR + EVENT_NAME + resourcePath);
        setOperationDetails(resourcePath, EVENT_NAME, RegistryEvent.ResourceType.UNKNOWN);
    }

    /**
     * This method is used to get event resource path.
     *
     * @return String event resource path.
     */
    public String getResourcePath() {
        return resourcePath;
    }
}
