package com.trifail.order.config.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Created by syoka on 2019/3/26.
 */
public class RedisRepository {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisRepository.class);


    public RedisRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public void setExpire(final byte[] key, final byte[] value, final long time) {
        redisTemplate.execute((RedisCallback<Long>) connection -> {
            connection.set(key, value);
            connection.expire(key, time);
            LOGGER.info("[redisTemplate redis]放入 缓存  url:{} ========缓存时间为{}秒", key, time);
            return 1L;
        });
    }

    /**
     * 跟新过期时间
     * @param key
     * @param second
     */
    public void refreshExpireTime(String key, long second) {
        redisTemplate.expire(key, second, TimeUnit.SECONDS);
    }

    public void set(final byte[] key, final byte[] value) {
        redisTemplate.execute((RedisCallback<Long>) connection -> {
            connection.set(key, value);
            return 1L;
        });
    }

    public byte[] get(final byte[] key) {
        byte[] result = redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.get(key));
        LOGGER.info("[redisTemplate redis]取出 缓存  url:{} ", key);
        return result;
    }

}
