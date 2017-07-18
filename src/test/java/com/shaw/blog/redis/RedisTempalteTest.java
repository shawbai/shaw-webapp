package com.shaw.blog.redis;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTempalteTest {

	@Autowired
	private RedisTempalte redisTempalte;
	
	@Test
	public void testSelect() {
		redisTempalte.select(0);
	}

	@Test
	public void testIsConnected() {
		Boolean pong = redisTempalte.isConnected(0);
		assert(pong==true);
	}

	@Test
	public void testFlushDB() {
		fail("Not yet implemented");
	}

	@Test
	public void testExists() {
		fail("Not yet implemented");
	}

	@Test
	public void testHexists() {
		fail("Not yet implemented");
	}

	@Test
	public void testHget() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeys() {
		fail("Not yet implemented");
	}

	@Test
	public void testHgetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testHdel() {
		fail("Not yet implemented");
	}

	@Test
	public void testHset() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByte() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIntStringString() {
		redisTempalte.set(1,"testkey","testvlaue");
	}

	@Test
	public void testSetIntStringByteArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIntStringStringInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIntStringByteArrayInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testExpire() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPipeLine() {
		fail("Not yet implemented");
	}

	@Test
	public void testDel() {
		fail("Not yet implemented");
	}

	@Test
	public void testLlen() {
		fail("Not yet implemented");
	}

	@Test
	public void testLpush() {
		fail("Not yet implemented");
	}

	@Test
	public void testLpushPipeLine() {
		fail("Not yet implemented");
	}

	@Test
	public void testLrange() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncr() {
		fail("Not yet implemented");
	}

	@Test
	public void testSadd() {
		fail("Not yet implemented");
	}

	@Test
	public void testSmembers() {
		fail("Not yet implemented");
	}

	@Test
	public void testScard() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrpop() {
		fail("Not yet implemented");
	}

	@Test
	public void testBatchDel() {
		fail("Not yet implemented");
	}

	@Test
	public void testZaddIntStringDoubleString() {
		fail("Not yet implemented");
	}

	@Test
	public void testZremrangebyscore() {
		fail("Not yet implemented");
	}

	@Test
	public void testZaddIntStringMapOfStringDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testZrangeByScore() {
		fail("Not yet implemented");
	}

	@Test
	public void testZrange() {
		fail("Not yet implemented");
	}

	@Test
	public void testSinter() {
		fail("Not yet implemented");
	}

}
