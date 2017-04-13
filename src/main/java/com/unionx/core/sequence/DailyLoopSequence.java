package com.unionx.core.sequence;

import com.unionx.core.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 按照日期生成序列号。格式为yyyyMMdd{seq},其中seq为自增，到第二天后从0开始
 * @author songjunjie
 */
public class DailyLoopSequence {
    public static final Logger logger = LoggerFactory.getLogger(DailyLoopSequence.class);
    private static final String REDIS_KEY = "SEQUENCE";
    private StringRedisTemplate redisTemplate;

    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private String getRedisKey(String seqName,String time) {
        String keyStr = REDIS_KEY+":" + seqName + ":" + time;
        return keyStr;
    }
    /**
     * 根据参数中给定的序列的名字，返回此序列的下一个序列号
     *
     * @param seqName 序列的名字
     * @param prefix  前缀.
     * @param length  流水号的长度（时间后面的数字长度）
     * @return
     */
    public String getNextValue(final String seqName, String prefix, int length) {

        if (StringUtils.isBlank(seqName)) {
            throw new IllegalArgumentException("没有指定seqName参数");
        }
        final String nowDate = DateUtils.format(new Date(), "yyyyMMdd");
        Long incr = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                String keyStr = getRedisKey(seqName,nowDate);
                byte[] key = redisTemplate.getStringSerializer().serialize(keyStr);
                Long incr = connection.incr(key);
                if (incr == 1) {//表示根据给的key没有值.设置超时时间。为了保险起见，超时时间设置的长一点
                    redisTemplate.expire(keyStr, 2, TimeUnit.DAYS);
                }
                return incr;
            }
        });
        int strLen = incr.toString().length();
        if (strLen > length) {
            return prefix + nowDate + incr;
        }
        String no = "";
        for (int i = 0; i < length - strLen; i++) {
            no += "0";
        }
        return prefix + nowDate + no + incr;
    }
}
