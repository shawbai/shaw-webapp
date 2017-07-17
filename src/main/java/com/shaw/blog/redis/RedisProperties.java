package com.shaw.blog.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 只提供了常用的属性，如果有需要，自己添加
 *
 */
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {
    private String ip;
    private String password;
    private String port;
    private String timeout;
    private Pool pool;
    
    class Pool{
		private int     maxActive;
	    private int     maxIdle;
	    private int     maxWaitMillis;
	    private boolean testOnBorrow;
	    private boolean testOnReturn;
		public int getMaxActive() {
			return maxActive;
		}
		public void setMaxActive(int maxActive) {
			this.maxActive = maxActive;
		}
		public int getMaxIdle() {
			return maxIdle;
		}
		public void setMaxIdle(int maxIdle) {
			this.maxIdle = maxIdle;
		}
		public int getMaxWaitMillis() {
			return maxWaitMillis;
		}
		public void setMaxWaitMillis(int maxWaitMillis) {
			this.maxWaitMillis = maxWaitMillis;
		}
		public boolean isTestOnBorrow() {
			return testOnBorrow;
		}
		public void setTestOnBorrow(boolean testOnBorrow) {
			this.testOnBorrow = testOnBorrow;
		}
		public boolean isTestOnReturn() {
			return testOnReturn;
		}
		public void setTestOnReturn(boolean testOnReturn) {
			this.testOnReturn = testOnReturn;
		}
    }

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	public Pool getPool() {
		return pool;
	}

	public void setPool(Pool pool) {
		this.pool = pool;
	}
    
    
    
}
