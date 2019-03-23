package com.openmall.common.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ftp服务器的相关配置
 * @ConfigurationProperties：告诉Springboot将本来中的所有属性和配置文件中相关的属性进行绑定
 */
@Component
@ConfigurationProperties(prefix = "ftp")
public class FtpBean {
	
	private String ip;
	
	private int port;
	
	private String username;
	
	private String password;
	
	private String basePath;
	
	private String imagerUrl;

	public String getImagerUrl() {
		return imagerUrl;
	}

	public void setImagerUrl(String imagerUrl) {
		this.imagerUrl = imagerUrl;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	
	


}
