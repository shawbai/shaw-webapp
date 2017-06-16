package com.shaw.blog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 只提供了常用的属性，如果有需要，自己添加
 *
 */
@ConfigurationProperties(prefix = "my")
public class MyProperties {
    private String serverName;

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
    

}
