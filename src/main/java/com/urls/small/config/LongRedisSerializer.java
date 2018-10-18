package com.urls.small.config;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;

import java.util.Objects;

/**
 * 序列化
 * @author YI
 * @date 2018-10-18 17:57:36
 */
public class LongRedisSerializer implements RedisSerializer<Long> {

    private StringRedisSerializer stringSerializer = new StringRedisSerializer();

    @Override
    public byte[] serialize(@Nullable Long aLong) throws SerializationException {
        assert aLong != null;
        return stringSerializer.serialize(aLong.toString());

    }

    @Override
    public Long deserialize(@Nullable byte[] bytes) throws SerializationException {
        return Long.parseLong(Objects.requireNonNull(stringSerializer.deserialize(bytes)));
    }
}
