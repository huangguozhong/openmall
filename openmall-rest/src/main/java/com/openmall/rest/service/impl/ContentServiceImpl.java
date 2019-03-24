package com.openmall.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.openmall.common.utils.JsonUtils;
import com.openmall.manager.dao.TbContentMapper;
import com.openmall.manager.pojo.TbContent;
import com.openmall.manager.pojo.TbContentExample;
import com.openmall.manager.pojo.TbContentExample.Criteria;
import com.openmall.rest.conf.RedisKeyConfig;
import com.openmall.rest.service.ContentService;

/**
 * 内容管理
 * <p>Title: ContentServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月8日下午3:03:28
 * @version 1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;
//	@Value("${INDEX_CONTENT_REDIS_KEY}")
//	private String INDEX_CONTENT_REDIS_KEY;

	@Autowired
	RedisKeyConfig redisKeyConfig;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TbContent> getContentList(long contentCid) {
		//从缓存中取内容
		try {
			//String result = jedisClient.hget(INDEX_CONTENT_REDIS_KEY, contentCid + "");
			@SuppressWarnings("unchecked")
			String result = (String) redisTemplate.opsForHash().get(redisKeyConfig.getContentKey(), contentCid+"");
			if (!StringUtils.isBlank(result)) {
				//把字符串转换成list
				List<TbContent> resultList = JsonUtils.jsonToList(result, TbContent.class);
				return resultList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//根据内容分类id查询内容列表
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(contentCid);
		//执行查询
		List<TbContent> list = contentMapper.selectByExample(example);
		
		//向缓存中添加内容
		try {
			//把list转换成字符串
			String cacheString = JsonUtils.objectToJson(list);
			//jedisClient.hset(INDEX_CONTENT_REDIS_KEY, contentCid + "", cacheString);
			redisTemplate.opsForHash().put(redisKeyConfig.getContentKey(), contentCid + "", cacheString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
