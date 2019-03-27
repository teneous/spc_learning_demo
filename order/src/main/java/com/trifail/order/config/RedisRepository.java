package com.trifail.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;

/**
 * Created by syoka on 2019/3/26.
 */
public class RedisRepository {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public RedisRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public String get(String key) {
        String s = redisTemplate.opsForValue().get(key);
        return s;
    }


}
