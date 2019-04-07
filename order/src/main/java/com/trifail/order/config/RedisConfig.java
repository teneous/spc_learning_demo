package com.trifail.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by syoka on 2019/3/17.
 */
@Configuration
//@EnableCaching
public class RedisConfig {//extends CachingConfigurerSupport {

    @Autowired
    private ExtraSrouceConfig extraSrouceConfig;

    @Bean
    public RedisTemplate<String, Object> redisTemplate(@Qualifier("jedisConnectionFactory") RedisConnectionFactory factory) {
        final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new GenericToStringSerializer<>(Object.class));
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

//    @Bean(name = "jedisConnectionFactory")
//    public RedisConnectionFactory jedisConnectionFactory() {
//        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration()
////                .master(extraSrouceConfig.redisMasterIp);
//                .master("47.75.133.109");
////                .sentinel("127.0.0.1", 26379)
////                .sentinel("127.0.0.1", 26380);
//        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().build();
////        configuration.setPassword(extraSrouceConfig.redisPassword);
//        configuration.setPassword("trifail");
//        return new JedisConnectionFactory(configuration, jedisClientConfiguration);
//    }

    @Bean(name = "jedisConnectionFactory")
    public RedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(extraSrouceConfig.redisMasterIp);
        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().build();
        configuration.setPassword(RedisPassword.of(extraSrouceConfig.redisPassword));
        return new JedisConnectionFactory(configuration, jedisClientConfiguration);
    }


    @Bean
    public RedisRepository redisRepository(RedisTemplate<String, String> redisTemplate) {
        return new RedisRepository(redisTemplate);
    }
}
