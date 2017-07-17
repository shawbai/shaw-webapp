package com.shaw.blog.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	
	@Autowired
	private testRedisTempalte redisFunc;
	
	@Test
	public void TestRedis(){
		redisFunc.set(1,"2","33");
	}
	
	
	

}
