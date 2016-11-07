package com.shine.redis;

import com.shine.util.SerializableUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis访问
 *
 * @author hq 2016/11/04
 */
public class RedisClient {

    //-------------------------
    //--------redis接入参数------
    //-------------------------

    private String password = null;
    private String ip = null;
    private int port = 0;
    private int timeOut = 0;
    private int maxIdle = 0;
    private int maxWait = 0;
    private int maxActive = 0;
    private int database = 0;//选择数据库

    //    private Jedis jedis;//非切片额客户端连接
    private static JedisPool jedisPool;//非切片连接池

    public void destroy(){
        if(jedisPool != null && !jedisPool.isClosed()){
            jedisPool.close();
        }
    }
    public RedisClient(String password, String ip,int database, int port, int timeOut, int maxIdle, int maxWait,int maxActive) {
        this.password = password;
        this.ip = ip;
        this.port = port;
        this.timeOut = timeOut;
        this.maxIdle = maxIdle;
        this.maxWait = maxWait;
        this.maxActive = maxActive;
        this.database = database;

        initialPool();

        //获得客户端
//        jedis = jedisPool.getResource();
    }


    /**
     * 初始化非切片池
     */
    private void initialPool() {

        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMaxTotal(-1);
        config.setMaxWaitMillis(maxWait);
        config.setTestOnBorrow(true);

        if (password == null || password.length() == 0) {
            jedisPool = new JedisPool(config, ip, port);
        } else {
            jedisPool = new JedisPool(config, ip, port, timeOut, password,database);
        }
    }


    /**
     * 设置字符串值(有则覆盖)
     *
     * @param key         键
     * @param value       值
     * @param liveSeconds 生命周期
     */
    protected static void setStringValue(String key, String value, int liveSeconds) {
        Jedis jedis1 = null;
        try {

            //获得客户端
            jedis1 = jedisPool.getResource();
            if (value == null) {
                return;
            }

            jedis1.setex(key, liveSeconds, value);
        }finally {
            if(jedis1 != null)
                jedis1.close();
        }

    }


    /**
     * 获取key对应的特定字符串值
     *
     * @param key
     * @return
     */
    protected static String getStringValue(String key) {
        Jedis jedis1 = null;
        try {

            //获得客户端
            jedis1 = jedisPool.getResource();
            return jedis1.get(key);
        }finally {
            if(jedis1 != null)
                jedis1.close();
        }
    }


    /**
     * 设置java对象值(有则覆盖)
     *
     * @param key         键
     * @param value       值
     * @param liveSeconds 生命周期
     */
    protected void setObjectValue(String key, Object value, int liveSeconds) {
        Jedis jedis1 = null;
        try {

            //获得客户端
            jedis1 = jedisPool.getResource();

            if (value == null) {
                return;
            }

            byte[] bytes = SerializableUtil.serialize(value);
            jedis1.setex(key.getBytes(), liveSeconds, bytes);

        }finally {
            if(jedis1 != null)
                jedis1.close();
        }

//        if (jedis.get(key.getBytes()) == null) {
//            jedis.set(key.getBytes(), bytes, "NX".getBytes(), "EX".getBytes(), liveSeconds);
//        } else {
//            jedis.set(key.getBytes(), bytes, "XX".getBytes(), "EX".getBytes(), liveSeconds);
//        }

    }


    /**
     * 获取key对应的特定java对象值
     *
     * @param key
     * @return
     */
    protected Object getObjectValue(String key) {
        Jedis jedis1 = null;
        try {

            //获得客户端
            jedis1 = jedisPool.getResource();

            byte[] bytes = jedis1.get(key.getBytes());
            if (bytes == null) {
                return null;
            } else {
                return SerializableUtil.unserialize(bytes);
            }

        }finally {
            if(jedis1 != null)
                jedis1.close();
        }


    }


    /**
     * 清空key对应的值
     *
     * @param key
     */
    protected void clearValue(String key) {
        Jedis jedis1 = null;
        try {

            //获得客户端
            jedis1 = jedisPool.getResource();

            jedis1.del(key);
        }finally {
            if(jedis1 != null)
                jedis1.close();
        }
    }


    /**
     * 清空数据库
     */
    protected void clearDatabase() {
        Jedis jedis1 = null;
        try {

            //获得客户端
            jedis1 = jedisPool.getResource();
            jedis1.flushDB();
        }finally {
            if(jedis1 != null)
                jedis1.close();
        }
    }


}
