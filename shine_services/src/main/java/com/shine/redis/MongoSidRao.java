package com.shine.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  mongo sid
 * Created by hq on 2016/9/1 0001.
 */
@Component
public class MongoSidRao {

    @Autowired
    private RedisClient redisClient;

    /**
     * 根据手机号和Id获取sid
     */
    public String getMmsSid(String phone, String msgId) {

        Object value = redisClient.getStringObjectValue("MMSSID" + phone + msgId);
        if (value != null) {
            return value.toString();
        } else {
            return null;
        }

    }

    /**
     * 设置Sid(有则覆盖)
     */
    public void setMmsSid(String phone, String msgId, String sid) {

        if (sid == null) {
            return;
        }
        redisClient.setStringObjectValue("MMSSID" + phone + msgId, sid, 86400);
    }


    /**
     * 清空Sid
     */
    public void clearMmsSid(String phone, String msgId) {

        redisClient.clearValue("MMSSID" + phone + msgId);
    }
}
