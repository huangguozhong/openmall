package com.openmall.rest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {
	
	@Autowired
	RedisTemplate redisTemplate;
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Test
	public void test() {
		redisTemplate.opsForHash().put("testHash01", "key001", "value001");
		redisTemplate.opsForHash().put("testHash01", "key002", "value001");
		redisTemplate.opsForHash().put("testHash01", "key003", "value001");
		redisTemplate.opsForHash().put("testHash01", "key004", "value001");
	}

}
