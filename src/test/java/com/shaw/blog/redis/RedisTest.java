package com.shaw.blog.redis;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	
	@Autowired
	private StringRedisTemplate template;

	protected <T> T execute(MyRedisCallback<T> callback, Object... args) {
    	RedisConnection connection = (RedisConnection) ((Object[]) args)[0];
        Object index = ((Object[]) args)[1];
        if (null != index && Integer.parseInt(index.toString()) > 0 && Integer.parseInt(index.toString()) < 16) {
        	connection.select((int) index);
        } else {
        	connection.select(0);
        }
        return callback.call(connection, args);
    }

	
	@Test
	public void TestRedis(){
		final int index = 10;
		String pong = template.execute(new TeRedisCallback<String>() {
			
			
			public String doInRedis(RedisConnection connection, Object params) {
				
				return execute(new MyRedisCallback<byte[]>() {
		            public String call(RedisConnection connection, Object parms) {
		                String key = ((Object[]) parms)[1].toString();
		                try {
		                	connection.get(key.getBytes("UTF-8"))
		                    return null;
		                } catch (UnsupportedEncodingException e) {
		                }
		                return null;
		            }
		        }, "", "");
			}

			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		System.out.println("!!!!!!!!!!!!!!!!!!"+pong);
	}

}
