package com.shaw.blog.redis;

import org.springframework.data.redis.connection.RedisConnection;

/**
 * Copyright (C), 2012-2014, 苏州海云融通有限公司
 * Author:   Wanglei
 * Date:     2015-8-12上午11:22:52 
 * Description:回调方法
 * <author>      <time>      <version>    <desc>
 * 修改人姓名        修改时间             版本号              描述
 */
public interface MyRedisCallback<T> {
	public T call(RedisConnection connection,Object params);
}
