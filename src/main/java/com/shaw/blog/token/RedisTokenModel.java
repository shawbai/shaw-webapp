package com.shaw.blog.token;

import java.io.Serializable;
import java.util.Map;

public class RedisTokenModel implements Serializable{
	private static final long serialVersionUID = 6260769227766098340L;

	private String token;							//标识
	private long creationTime = 0L;				//创建时间
	private long lastAccessedTime = 0L;			// 最后一次更新session的时间
	private Map<String, Object> data; 			// 本地Session缓存，需要注意同远程Redis的数据同步
	
	public RedisTokenModel() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}



	public long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}

	public long getLastAccessedTime() {
		return lastAccessedTime;
	}

	public void setLastAccessedTime(long lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
}
