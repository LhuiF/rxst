package com.unionx.core.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis 对象操作
 * @author abner
 */
public class RedisBaseTemplate {

	public static final Logger logger = LoggerFactory.getLogger(RedisBaseTemplate.class);

	protected RedisTemplate redisTemplate;

	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void put(final Object key, final Object hashKey, final Object value, final long activeTime) {
		redisTemplate.opsForHash().put(key, hashKey, value);
		if (activeTime > 0) {
			redisTemplate.expire(key, activeTime, TimeUnit.MILLISECONDS);
		}
	}

	public Object get(Object key, Object hashKey) {
		return redisTemplate.opsForHash().get(key, hashKey);
	}

	public void delete(Object key,Object hashKey){
		redisTemplate.opsForHash().delete(key,hashKey);
	}

	public Set<Object> keys(Object key){
		return redisTemplate.opsForHash().keys(key);
	}
}
