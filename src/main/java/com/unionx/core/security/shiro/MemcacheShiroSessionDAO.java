package com.unionx.core.security.shiro;

import com.unionx.core.cache.RedisShiroTemplate;
import com.unionx.core.util.JsonUtils;
import org.apache.shiro.cache.MapCache;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.SerializationUtils;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用memcache来存储session信息
 *
 * @author songjunjie
 */
public class MemcacheShiroSessionDAO extends CachingSessionDAO {
    private static final Logger logger = LoggerFactory.getLogger(MemcacheShiroSessionDAO.class);
    /**
     * 缓存项前缀
     */
    private String sessionPrefix = "session:";
    private boolean useMemCache = false;
    private RedisShiroTemplate redisShiroTemplate;

    public void setRedisShiroTemplate(RedisShiroTemplate redisShiroTemplate) {
        this.redisShiroTemplate = redisShiroTemplate;
    }

    public MemcacheShiroSessionDAO() {
        System.out.print("MemcacheShiroSessionDAO");
    }

    public MemcacheShiroSessionDAO(boolean useMemCache) {
        this.useMemCache = useMemCache;
        if (useMemCache) {
            setActiveSessionsCache(
                    new MapCache<>(ACTIVE_SESSION_CACHE_NAME, new ConcurrentHashMap<Serializable, Session>())
            );
        }
    }
    /**
     * session更新
     *
     * @param session
     * @throws UnknownSessionException
     */
    @Override
    public void update(Session session) throws UnknownSessionException {
        if (session == null || session.getId() == null) {
//            logger.error("session argument cannot be null.");
        }
//        if (logger.isDebugEnabled()) {
//            String json = JsonUtils.writeValueAsString(session, null, true);
//            logger.debug(">>>>>> 更新session[ID={}]\n{}", session.getId(),json);
//        }
        saveSession(session);
    }

    @Override
    protected void doUpdate(Session session) {
        System.out.print("doUpdate");
    }

    /**
     * session删除
     *
     * @param session
     */
    @Override
    public void delete(Session session) {
        if (session == null || session.getId() == null) {
//            logger.error("session argument cannot be null.");
            return;
        }
//        logger.debug(">>>>>> 删除session[ID={}]", session.getId());
        this.redisShiroTemplate.delete(sessionPrefix,session.getId().toString());
        if (useMemCache) {
            this.uncache(session);
        }
    }

    @Override
    protected void doDelete(Session session) {
        System.out.print("doDelete");
    }

    /**
     * 创建session, 用户登录
     *
     * @param session
     * @return
     */
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
//        if (logger.isDebugEnabled()) {
//            String json = JsonUtils.writeValueAsString(session, null, true);
//            logger.debug(">>>>>> 创建session[ID={}]\n{}", session.getId(),json);
//        }

        saveSession(session);
        return sessionId;
    }

    /**
     * session读取
     *
     * @param id
     * @return
     */
    @Override
    protected Session doReadSession(Serializable id) {
        if (id == null) {
//            logger.error("id is null!");
            return null;
        }

        Session session;
        byte[] byteData = this.redisShiroTemplate.get(sessionPrefix, id.toString());
        if (byteData != null && byteData.length > 0) {
            session = (Session) SerializationUtils.deserialize(byteData);
            if (useMemCache) {
                this.cache(session, id);
//                logger.debug("缓存key为{}的session到本地", getKey(id));
            }
//            if (logger.isDebugEnabled()) {
//                String json = JsonUtils.writeValueAsString(session, null, true);
//                logger.debug(">>>>>> 读取session[ID={}]\n{}", getKey(id),json);
//            }
            return session;
        } else {
            return null;
        }
    }

    /**
     * 获取当前活跃的session, 当前在线数量
     *
     * @return
     */
   /* @Override
    public Collection<Session> getActiveSessions() {
        ZNode zNode = new ZNode();
        zNode.setPath(shiroSessionZKPath);
        Set<Session> sessions = new HashSet<Session>();
        //读取所有SessionID  , 返回形如: session-9e3b5707-fa80-4d32-a6c9-f1c3685263a5
        List<String> ss = zookeeperTemplate.getChildren(zNode);
        this.memCachedClient.
        for (String id : ss) {
            if (id.startsWith(sessionPrefix)) {
                String noPrefixId = id.replace(sessionPrefix, "");
                Session session = doReadSession(noPrefixId);
                if (session != null) sessions.add(session);
            }
        }
        logger.debug("shiro getActiveSessions. size: {}", sessions.size());
        return sessions;
    }*/

    /**
     * session读取或更新
     *
     * @param session
     */
    private void saveSession(Session session) {
        this.redisShiroTemplate.put(sessionPrefix, session.getId().toString(), SerializationUtils.serialize(session), session.getTimeout() / 1000);
    }
}
