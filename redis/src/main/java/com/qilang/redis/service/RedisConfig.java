package com.qilang.redis.service;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * @author shengyayun
 */
@Configuration
public class RedisConfig {

  @Resource
  private RedisConnectionFactory redisConnectionFactory;

  @Bean
  public RedisTemplate<Object, Object> redisTemplate() {
      RedisTemplate<Object, Object> template = new RedisTemplate<>();
      //使用fastjson序列化
      FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
      // value值的序列化采用fastJsonRedisSerializer
      template.setValueSerializer(fastJsonRedisSerializer);
      template.setHashValueSerializer(fastJsonRedisSerializer);
      // key的序列化采用StringRedisSerializer
      template.setKeySerializer(new StringRedisSerializer());
      template.setHashKeySerializer(new StringRedisSerializer());
      template.setConnectionFactory(redisConnectionFactory);
      return template;
  }
}