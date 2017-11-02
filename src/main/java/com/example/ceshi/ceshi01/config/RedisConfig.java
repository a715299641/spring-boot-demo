package com.example.ceshi.ceshi01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig {

    @Bean
    StringRedisTemplate getStringRedisTemplate(RedisConnectionFactory factory) {
        return new StringRedisTemplate(factory);
    }


}
