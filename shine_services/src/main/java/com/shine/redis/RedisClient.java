package com.shine.redis;

import com.shine.util.SerializableUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
    protected void setStringObjectValue(String key, Object value, int liveSeconds) {
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
    protected Object getStringObjectValue(String key) {
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
     * 设置Hash
     */
    public static void setHash(String key, Map<String,String> hash) {
        Jedis jedis1 = null;
        try {

            //获得客户端
            jedis1 = jedisPool.getResource();
            if (hash == null) {
                return;
            }

            jedis1.hmset(key, hash);
        }finally {
            if(jedis1 != null)
                jedis1.close();
        }
    }

    /**
     * 获取hash中全部的域和值,以Map<String, String> 的形式返回
     */
    public static Map getHashALL(String key) {
        Jedis jedis1 = null;
        try {

            //获得客户端
            jedis1 = jedisPool.getResource();

            return jedis1.hgetAll(key);
        }finally {
            if(jedis1 != null)
                jedis1.close();
        }
    }

    /**
     * 获取hash的所有元素(key值)
     */
    public static Set<String> getHashAllKey(String key) {
        Jedis jedis1 = null;
        try {
            //获得客户端
            jedis1 = jedisPool.getResource();
            return jedis1.hkeys(key);
        }finally {
            if(jedis1 != null)
                jedis1.close();
        }
    }

    /**
     * 获取hash中所有的key对应的value值
     */
    public static List<String> getHashAllValue(String key) {
        Jedis jedis1 = null;
        try {
            //获得客户端
            jedis1 = jedisPool.getResource();
            return jedis1.hvals(key);
        }finally {
            if(jedis1 != null)
                jedis1.close();
        }
    }

    /**
     * 获取hash里所有元素的数量
     */
    public static Long getHashNum(String key) {
        Jedis jedis1 = null;
        try {
            //获得客户端
            jedis1 = jedisPool.getResource();
            return jedis1.hlen(key);
        }finally {
            if(jedis1 != null)
                jedis1.close();
        }
    }

    /**
     * 判断给定key值是否存在于哈希集中
     */
    public static Boolean hexists(String key,String field) {
        Jedis jedis1 = null;
        try {
            //获得客户端
            jedis1 = jedisPool.getResource();
            return jedis1.hexists(key,field);
        }finally {
            if(jedis1 != null)
                jedis1.close();
        }
    }

    /**
     * 获取hash里面指定字段对应的值
     */
    public static List<String> hmget(String key,String... field ) {
        Jedis jedis1 = null;
        try {
            //获得客户端
            jedis1 = jedisPool.getResource();
            return jedis1.hmget(key,field);
        }finally {
            if(jedis1 != null)
                jedis1.close();
        }
    }

    /**
     * 获取hash里面指定字段对应的值
     */
    public static String getHashValue(String key,String field) {
        Jedis jedis1 = null;
        try {
            //获得客户端
            jedis1 = jedisPool.getResource();
            return jedis1.hget(key,field);
        }finally {
            if(jedis1 != null)
                jedis1.close();
        }
    }

    /**
     * 删除指定的值
     */
    public static Long delHashValue(String key,String... value) {
        Jedis jedis1 = null;
        try {
            //获得客户端
            jedis1 = jedisPool.getResource();
            return jedis1.hdel(key, value);
        }finally {
            if(jedis1 != null)
                jedis1.close();
        }
    }

    /**
     * 为key中的域 field 的值加上增量 increment value为String的时候不适用
     */
    public static Long setHashValueLive(String key,String field,long increment) {
        Jedis jedis1 = null;
        try {
            //获得客户端
            jedis1 = jedisPool.getResource();
            return jedis1.hincrBy(key,field,increment);
        }finally {
            if(jedis1 != null)
                jedis1.close();
        }
    }

    /**
     * 为key设置过期时间
     */
    public static Long expire(String key,Integer liveSeconds) {
        Jedis jedis1 = null;
        try {
            //获得客户端
            jedis1 = jedisPool.getResource();
            return jedis1.expire(key, liveSeconds);
        }finally {
            if(jedis1 != null)
                jedis1.close();
        }
    }


    /**
     * 清空数据库
     */
    public void clearDatabase() {
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
