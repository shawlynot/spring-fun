package io.shawlynot.springfun.kafka;

import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.ByteBuffer;
import java.util.Map;

public class ProtobufDeserializer<T> implements Deserializer<T> {
// TODO generate protobuf classes
    @Override
    public T deserialize(String s, byte[] bytes) {
        return null;
    }
}
