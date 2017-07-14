package com.shaw.blog.redis;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;


/**
 * Copyright (C), 2012-2014, 苏州海云融通有限公司
 * Author:   Wanglei
 * Date:     2015-8-12上午10:21:45
 * Description:Redis 模板
 * <author>      <time>      <version>    <desc>
 * 修改人姓名        修改时间             版本号              描述
 */
public class RedisFunc {

    private static Logger logger = LoggerFactory.getLogger("RedisFunc");

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

 

   
    public byte[] getByte(int index, String key) {
        return execute(new MyRedisCallback<byte[]>() {
            public byte[] call(RedisConnection connection, Object parms) {
                String key = ((Object[]) parms)[1].toString();
                try {
                    return connection.get(key.getBytes("UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    logger.error(e.getMessage(), e);
                }
                return null;
            }
        }, index, key);
    }


    public void set(int index, String key, byte[] value) {
        execute(new MyRedisCallback<String>() {
            public String call(RedisConnection connection, Object parms) {
                String key = ((Object[]) parms)[1].toString();
                byte[] value = (byte[]) ((Object[]) parms)[2];
                try {
                    connection.set(key.getBytes("UTF-8"), value);
                } catch (UnsupportedEncodingException e) {
                    logger.error(e.getMessage(), e);
                }
                return null;
            }
        }, index, key, value);
    }

    /**
     * @param key
     * @param value
     * @param seconds
     * @Description:seconds:过期时间（单位：秒）
     * @author Wanglei
     * Date: 2015-8-12 上午9:32:09
     * @version [版本号1.0.0]
     */
    public void set(int index, String key, String value, int seconds) {
        execute(new MyRedisCallback<String>() {
            public String call(RedisConnection connection, Object parms) {
                String key = ((Object[]) parms)[1].toString();
                String value = ((Object[]) parms)[2].toString();
                String seconds = ((Object[]) parms)[3].toString();
                connection.setEx(key.getBytes(), Integer.parseInt(seconds), value.getBytes());
                return null;
            }
        }, index, key, value, seconds);
    }

    public void set(int index, String key, byte[] value, int seconds) {
        execute(new MyRedisCallback<String>() {
            public String call(RedisConnection connection, Object parms) {
                String key = ((Object[]) parms)[1].toString();
                byte[] value = (byte[]) ((Object[]) parms)[2];
                String seconds = ((Object[]) parms)[3].toString();
                try {
                    connection.setEx(key.getBytes("UTF-8"), Integer.parseInt(seconds), value);
                } catch (UnsupportedEncodingException e) {
                    logger.error(e.getMessage(), e);
                }
                return null;
            }
        }, index, key, value, seconds);
    }

	
	
}
