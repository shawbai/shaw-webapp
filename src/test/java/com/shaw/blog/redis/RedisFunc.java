package com.shaw.blog.redis;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class RedisFunc {

    private static Logger logger = LoggerFactory.getLogger("RedisFunc");

	@Autowired
	private StringRedisTemplate template;
	
	@Autowired
    private RedisConnectionFactory redisConnectionFactory;
	
	public void set(final int index,String key,String value){
		template.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) {
				connection.select(index);
				return null;
			}
		});
		template.opsForValue().set(key, value);
		template.opsForValue().set(key, value,60*10,TimeUnit.SECONDS);
	}
	
	
	
}
