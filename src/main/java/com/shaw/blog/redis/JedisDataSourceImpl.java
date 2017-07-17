package com.shaw.blog.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Repository("jedisDS")
public class JedisDataSourceImpl {
	private static Logger logger = LoggerFactory.getLogger(JedisDataSourceImpl.class);

	 @Autowired  
	 private JedisPool jedisPool;  

    public Jedis getRedisClient() {
        Jedis shardJedis = null;
        try {
            shardJedis = jedisPool.getResource();
            return shardJedis;
        } catch (Exception e) {
        	logger.error("[JedisDS] getRedisClent error:" + e.getMessage());
            if (null != shardJedis)
                shardJedis.close();
        }
        return null;
    }

    public void returnResource(Jedis shardedJedis) {
        shardedJedis.close();
    }
}