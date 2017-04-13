package com.unionx.core.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.*;
import java.util.Set;

/**
 * shiro session集中缓存redis操作类
 * @author abner
 */
public class RedisShiroTemplate {

	public static final Logger logger = LoggerFactory.getLogger(RedisShiroTemplate.class);

	protected static RedisTemplate<String, Object> redisTemplate;

	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void put(final String key, final String hashKey, final byte[] value, final long activeTime) {
		redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] keyb = (key + hashKey).getBytes();
				byte[] valueb = value;
				connection.set(keyb, valueb);
				if (activeTime > 0) {
					connection.expire(keyb, activeTime);
				}
				return 1L;
			}
		});
	}

	public byte[] get(final String key, final String hashKey) {
		byte[] object;
		object = redisTemplate.execute(new RedisCallback<byte[]>() {
			public byte[] doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] keyb = (key + hashKey).getBytes();
				byte[] value = connection.get(keyb);
				if (value == null) {
					return null;
				}
				return value;
			}
		});
		return (object != null ? object : null);
	}

	public byte[] get(final String hashKey) {
		byte[] object;
		object = redisTemplate.execute(new RedisCallback<byte[]>() {
			public byte[] doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] keyb = hashKey.getBytes();
				byte[] value = connection.get(keyb);
				if (value == null) {
					return null;
				}
				return value;
			}
		});
		return (object != null ? object : null);
	}

	public void delete(final String key,final String hashKey){
		redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] keyb = (key + hashKey).getBytes();
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


//	private byte[] toByteArray(Object obj) {
//		byte[] bytes = null;
//		ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		try {
//			ObjectOutputStream oos = new ObjectOutputStream(bos);
//			oos.writeObject(obj);
//			oos.flush();
//			bytes = bos.toByteArray();
//			oos.close();
//			bos.close();
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
//		return bytes;
//	}
//
//	private Object toObject(byte[] bytes) {
//		Object obj = null;
//		try {
//			ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
//			ObjectInputStream ois = new ObjectInputStream(bis);
//			obj = ois.readObject();
//			ois.close();
//			bis.close();
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		} catch (ClassNotFoundException ex) {
//			ex.printStackTrace();
//		}
//		return obj;
//	}
}
