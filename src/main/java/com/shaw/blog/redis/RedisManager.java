package com.shaw.blog.redis;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisManager {

	private static Logger logger = LoggerFactory.getLogger("RedisManager");

	private static JedisPool pool = null;
	private static String IP_ADDRESS = null;
	
	@Autowired
	private RedisProperties properties;
	
	
	
	static {
		try {
			System.out.println("==============>>>> RedisManager redis pool init start");

			Properties props = new Properties();
			props.load(RedisManager.class.getClassLoader().getResourceAsStream("public_system.properties"));
			IP_ADDRESS = props.getProperty("redis.ip");
			// 创建jedis池配置实例
			JedisPoolConfig config = new JedisPoolConfig();

			// 设置池配置项值
			config.setTestWhileIdle(false);
			config.setMaxTotal(Integer.valueOf(props.getProperty("redis.pool.maxTotal")));
			config.setMaxIdle(Integer.valueOf(props.getProperty("redis.pool.maxIdle")));
			config.setMaxWaitMillis(Long.valueOf(props.getProperty("redis.pool.maxWaitMillis")));
			config.setTestOnBorrow(Boolean.valueOf(props.getProperty("redis.pool.testOnBorrow")));
			config.setTestOnReturn(Boolean.valueOf(props.getProperty("redis.pool.testOnReturn")));

			String password = props.getProperty("redis.password");
			logger.info("======>>redis config : ip:" + IP_ADDRESS + ",password:" + password);

			if (StringUtils.isBlank(password)) {
				pool = new JedisPool(config, IP_ADDRESS, Integer.valueOf(props.getProperty("redis.port")), Integer.valueOf(props.getProperty("redis.timeout")));
			} else {
				pool = new JedisPool(config, IP_ADDRESS, Integer.valueOf(props.getProperty("redis.port")), Integer.valueOf(props.getProperty("redis.timeout")), password);
			}

			System.out.println("================>>>> RedisManager  redis pool init end================= ");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Error("IP:" + IP_ADDRESS + ",设置redis服务器出错", e);
		}
	}
	
   static Jedis getRedis() {
        if (pool != null) {
            return pool.getResource();
        }
        return null;
    }

    public static Jedis getRedis(int index) {
        if (pool != null) {
            Jedis jedis = pool.getResource();
            jedis.select(index);
            return jedis;
        }

        return null;
    }
    
    public static void close(Jedis jedis) {
        if (jedis != null) {
        	jedis.close();
        }
    }

}
