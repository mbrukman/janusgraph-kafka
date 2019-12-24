/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.kcache.janusgraph.diskstorage.kafka.serialization;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;
import org.janusgraph.diskstorage.StaticBuffer;

import java.util.Map;

public class StaticBufferSerde implements Serde<StaticBuffer> {

    private final Serializer<StaticBuffer> serializer;
    private final Deserializer<StaticBuffer> deserializer;

    public StaticBufferSerde() {
        this.serializer = new StaticBufferSerializer();
        this.deserializer = new StaticBufferDeserializer();
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        serializer.configure(configs, isKey);
        deserializer.configure(configs, isKey);
    }

    @Override
    public void close() {
        serializer.close();
        deserializer.close();
    }

    @Override
    public Serializer<StaticBuffer> serializer() {
        return serializer;
    }

    @Override
    public Deserializer<StaticBuffer> deserializer() {
        return deserializer;
    }
}
