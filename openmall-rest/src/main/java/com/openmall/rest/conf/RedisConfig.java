package com.openmall.rest.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * 
 * @author hgz
 *
 */
@Configuration
public class RedisConfig {
	/**
	 * 主要是为了修改序列化器
	 * @param redisConnectionFactory
	 * @return
	 */
	@Bean 
	public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		
		RedisTemplate<Object,Object> template = new RedisTemplate<Object,Object>();
		template.setConnectionFactory(redisConnectionFactory);
		Jackson2JsonRedisSerializer<Object> ser = new Jackson2JsonRedisSerializer<Object>(Object.class);
		template.setDefaultSerializer(ser);
		return template;
		
	}

}
