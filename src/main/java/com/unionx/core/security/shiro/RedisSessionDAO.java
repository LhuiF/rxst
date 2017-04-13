package com.unionx.core.security.shiro;

import java.io.Serializable;
import java.util.*;

import com.unionx.core.cache.RedisShiroTemplate;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.SerializationUtils;

/**
 * 基于Redis的Shiro持久化
 * @author abner
 */
public class RedisSessionDAO extends AbstractSessionDAO {

	private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);

	private RedisShiroTemplate redisShiroTemplate;
	
	/**
	 * The Redis key prefix for the sessions 
	 */
	private String keyPrefix = "shiro_redis_session:";
	
	@Override
	public void update(Session session) throws UnknownSessionException {
		this.saveSession(session);
	}

	/**
	 * save session
	 * @param session
	 * @throws UnknownSessionException
	 */
	private void saveSession(Session session) throws UnknownSessionException{
		if(session == null || session.getId() == null){
			logger.error("session or session id is null");
			return;
		}
		this.redisShiroTemplate.put(this.keyPrefix,session.getId().toString(), SerializationUtils.serialize(session), session.getTimeout()/1000);
//		map.put(this.keyPrefix+session.getId().toString(), session);
	}

	@Override
	public void delete(Session session) {
		if(session == null || session.getId() == null){
			logger.error("session or session id is null");
			return;
		}
		this.redisShiroTemplate.delete(this.keyPrefix,session.getId().toString());
	}

	@Override
	public Collection<Session> getActiveSessions() {
//		Set<Session> sessions = new HashSet<>();
//		Set<byte[]> keys = this.redisShiroTemplate.keys(this.keyPrefix+"*");
//		if(keys != null && keys.size()>0){
//			for(byte[] key : keys){
//				Session s = (Session)SerializationUtils.deserialize((byte[])this.redisShiroTemplate.get(new String(key)));
//				sessions.add(s);
//			}
//		}
//		return sessions;
		return null;
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = this.generateSessionId(session);  
        this.assignSessionId(session, sessionId);
        this.saveSession(session);
		return sessionId;
	}

//	private Map map = new HashMap();

	@Override
	protected Session doReadSession(Serializable sessionId) {
		if(sessionId == null){
			logger.error("session id is null");
			return null;
		}
//		Session s1 = (Session)map.get(this.keyPrefix + sessionId.toString());
//		if (s1 != null) {
//			return s1;
//		}
		Session s = (Session) SerializationUtils.deserialize(this.redisShiroTemplate.get(this.keyPrefix,sessionId.toString()));
//		map.put(this.keyPrefix + sessionId.toString(), s);
		return s;
	}
	
	/**
	 * 获得byte[]型的key
	 * @param sessionId
	 * @return
	 */
	private byte[] getByteKey(Serializable sessionId){
		String preKey = this.keyPrefix + sessionId;
		return preKey.getBytes();
	}

	/**
	 * Returns the Redis session keys
	 * prefix.
	 * @return The prefix
	 */
	public String getKeyPrefix() {
		return keyPrefix;
	}

	/**
	 * Sets the Redis sessions key 
	 * prefix.
	 * @param keyPrefix The prefix
	 */
	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}

	public RedisShiroTemplate getRedisShiroTemplate() {
		return redisShiroTemplate;
	}

	public void setRedisShiroTemplate(RedisShiroTemplate redisShiroTemplate) {
		this.redisShiroTemplate = redisShiroTemplate;
	}
}
