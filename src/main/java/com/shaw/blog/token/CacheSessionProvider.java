package com.shaw.blog.token;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.shaw.blog.redis.RedisTempalte;
import com.shaw.common.constant.ConstantsUtil;

public class CacheSessionProvider implements SessionProvider {
    private static Logger logger = LoggerFactory.getLogger(CacheSessionProvider.class);
    private String cookie_token = "_bk_sid";
    private String session_domain = "_bk_session:";


    private int expiry = 30;                                            // 分钟
    private static int cache_index = ConstantsUtil.REDIS_SESSION_INDEX;
    private int expirationUpdateInterval;                                // Session最大更新间隔时间

    @Autowired
    private RedisTempalte redisTempalte;

    @Override
    public void setAttribute(HttpServletRequest request, HttpServletResponse response, String key, Serializable value) {
        Map<String, Object> sessionMap = null;

		/*modify by wanglei 2016-5-6 修复会覆盖key的情况*/
        //先取出原来session中的值 添加到map中
        String token = getToken(request, response);
        // logger.info("token is {}", token);
        String old_session_json = redisGetWithtoken(token);
        if (null != old_session_json) {
            RedisTokenModel oldSession = JSON.parseObject(old_session_json, RedisTokenModel.class);
            sessionMap = oldSession.getData();
        }
        sessionMap = null != sessionMap ? sessionMap : new HashMap<String, Object>();
        sessionMap.put(key, value);

        RedisTokenModel session = new RedisTokenModel();
        session.setCreationTime(System.currentTimeMillis());
        session.setLastAccessedTime(System.currentTimeMillis());
        session.setData(sessionMap);
        session.setToken(token);

        String redisSessionValue = JSON.toJSONString(session);
        this.redisSetWithDomain(token, redisSessionValue, expiry * 60);
    }

    private void redisSetWithDomain(String token, String value, int seconds) {
        redisTempalte.set(cache_index, session_domain.concat(token), value, seconds);
    }


    private String redisGetWithtoken(String token) {
        return redisTempalte.get(cache_index, session_domain.concat(token));
    }


    @Override
    public Serializable getAttribute(HttpServletRequest request, HttpServletResponse response, String key) {
        String token = getToken(request, response);
        // logger.info("token is {}", token);
        String session_json = redisGetWithtoken(token);
        if (null != session_json) {
            RedisTokenModel session = JSON.parseObject(session_json, RedisTokenModel.class);
            /* modify by wanglei session 延长 */
            this.syncSessionAccessTimeToCache(token, session);
            return (Serializable) session.getData().get(key);
        }
        return null;
    }


    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        String token = getToken(request, response);
        if (redisTempalte.exists(cache_index, session_domain.concat(token))) {
            redisTempalte.del(cache_index, session_domain.concat(token));
        }
    }

    @Override
    public void casLogout(String token) {
        if (redisTempalte.exists(cache_index, session_domain.concat(token))) {
            redisTempalte.del(cache_index, session_domain.concat(token));
        }
    }

    @Override
    public String getToken(HttpServletRequest request, HttpServletResponse response) {
    	
//        String cktoken = CookieUtils.getCookieValue(request, cookie_token);
//        if (!ShawStringUtils.isNullString(cktoken)) {
//            return cktoken;
//        }

        // 生成一个
    	String cktoken = UUID.randomUUID().toString().replaceAll("-", "");
//        CookieUtils.setCookie(true, request, response, cookie_token, cktoken); // httpOnly true
        return cktoken;
    }


    private void syncSessionAccessTimeToCache(String token, RedisTokenModel session) {
        if (session == null)
            return;

        Long iter = System.currentTimeMillis() - session.getLastAccessedTime();
        dodgyCode(token, session, iter);
    }

    private void dodgyCode(String token, RedisTokenModel session, Long iter) {
        Long i = expirationUpdateInterval * 60000L;
        if (iter.compareTo(i) >= 0) {// 更新缓存 session 时间 session延长
            session.setLastAccessedTime(System.currentTimeMillis());
            this.redisSetWithDomain(token, JSON.toJSONString(session), expiry * 60000);
        }
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    public void setExpirationUpdateInterval(int expirationUpdateInterval) {
        this.expirationUpdateInterval = expirationUpdateInterval;
    }

    public void setSession_domain(String session_domain) {
        this.session_domain = session_domain;
    }

    public void setCookie_token(String cookie_token) {
        this.cookie_token = cookie_token;
    }

    @Override
    public Serializable getUserByToken(String token) {
        String session_json = redisGetWithtoken(token);
        RedisTokenModel session = JSON.parseObject(session_json, RedisTokenModel.class);
        if (null != session) {
            Serializable serializable = (Serializable) session.getData().get(ConstantsUtil.LOGIN_USER_SESSION_KEY);
            this.syncSessionAccessTimeToCache(token, session);
            return serializable;
        }
        return null;
    }

}
