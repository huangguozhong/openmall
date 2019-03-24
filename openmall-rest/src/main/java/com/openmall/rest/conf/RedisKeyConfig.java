package com.openmall.rest.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "redisKey")
public class RedisKeyConfig {

	private String contentKey;
	private String itemKey;
	private Long itemExpire;

	public String getContentKey() {
		return contentKey;
	}

	public void setContentKey(String contentKey) {
		this.contentKey = contentKey;
	}

	public String getItemKey() {
		return itemKey;
	}

	public void setItemKey(String itemKey) {
		this.itemKey = itemKey;
	}

	public Long getItemExpire() {
		return itemExpire;
	}

	public void setItemExpire(Long itemExpire) {
		this.itemExpire = itemExpire;
	}

	

}
