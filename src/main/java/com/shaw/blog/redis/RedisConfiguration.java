package com.shaw.blog.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.shaw.common.util.ShawStringUtils;

@Configuration
public class RedisConfiguration {

	@Value("${redis.host}")
	private String host;

	@Value("${redis.port}")
	private int port;

	@Value("${redis.timeout}")
	private int timeout;

	@Value("${redis.pool.maxIdle}")
	private int maxIdle;

	@Value("${redis.pool.maxWaitMillis}")
	private int maxWaitMillis;
	
	@Value("${redis.pool.maxTotal}")
	private int maxTotal;

	@Value("${redis.password}")
	private String password;

	@Bean
	public JedisPool jedisPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(maxTotal);
		config.setMaxIdle(maxIdle);
		config.setMaxWaitMillis(maxWaitMillis);
		if (ShawStringUtils.isBlank(password)) {
			return new JedisPool(config, host, port,timeout);
		} else {
			return new JedisPool(config, host, port,timeout,password);
		}
		
	}


}