package com.openmall.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.openmall.common.pojo.TaotaoResult;
import com.openmall.common.utils.ExceptionUtil;
import com.openmall.rest.conf.RedisKeyConfig;
import com.openmall.rest.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	RedisKeyConfig redisKeyConfig;
	
	@Override
	public TaotaoResult syncContent(long contentCid) {
		try {
			redisTemplate.opsForHash().delete(redisKeyConfig.getContentKey(), contentCid + "");
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return TaotaoResult.ok();
	}

}
