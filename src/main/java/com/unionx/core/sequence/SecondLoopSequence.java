package com.unionx.core.sequence;

import com.unionx.core.util.DateUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 根据时间(yyyyMMddHHmmss)周期性的生成序列号，每秒都从头开始。
 *
 * @author songjunjie
 */

public class SecondLoopSequence {

    private StringRedisTemplate redisTemplate;

    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 返回下一个序列号
     *
     * @param seqName 序列的名字
     * @param prefix  前缀
     * @param length  流水号的长度（时间后面的数字长度）
     * @return
     */
    public String getNextValue(final String seqName, String prefix, int length) {
        final String nowDate = DateUtils.format(new Date(), "yyyyMMddHHmmss");
        Long incr = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                String keyStr = "Sequence:" + seqName + ":" + nowDate;
                byte[] key = redisTemplate.getStringSerializer().serialize(keyStr);
                Long incr = connection.incr(key);
                if (incr == 1) {
                    redisTemplate.expire(keyStr, 2, TimeUnit.SECONDS);
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
