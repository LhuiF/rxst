package com.unionx.core.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

/**
 * 缓存操作类
 * @author abner
 */
public class RedisStringTemplate {

	public static final Logger logger = LoggerFactory.getLogger(RedisStringTemplate.class);

	protected static RedisTemplate<String, Object> redisTemplate;

	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void put(final String key,final byte[] value, final long activeTime) {
		redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] keyb = key.getBytes();
				byte[] valueb = value;
				connection.set(keyb, valueb);
				if (activeTime > 0) {
					connection.expire(keyb, activeTime);
				}
				return 1L;
			}
		});
	}

	public byte[] get(final String key) {
		byte[] object;
		object = redisTemplate.execute(new RedisCallback<byte[]>() {
			public byte[] doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] keyb = key.getBytes();
				byte[] value = connection.get(keyb);
				if (value == null) {
					return null;
				}
				return value;
			}
		});
		return (object != null ? object : null);
	}

	public void delete(final String key){
		redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] keyb = key.getBytes();
				return connection.del(keyb);
			}
		});
	}

	public Set<byte[]> keys(final String key){
		Set<byte[]> set;
		set = redisTemplate.execute(new RedisCallback<Set<byte[]>>() {
			public Set<byte[]> doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] keyb = key.getBytes();
				return connection.keys(keyb);
			}
		});
		return (set != null ? set : null);
	}

}
