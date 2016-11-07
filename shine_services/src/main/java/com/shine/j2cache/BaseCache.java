package com.shine.j2cache;

import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import net.oschina.j2cache.J2Cache;

/**
 * 基本缓存器
 *
 * Created by hq on 2016/11/04.
 */
public class BaseCache {

    /**
     * j2cache渠道
     */
    private CacheChannel cacheChannel = J2Cache.getChannel();


    /**
     * 设置缓存(若原先存在则覆盖,不存在则添加)
     *
     * @param cacheName 缓存单元名称
     * @param key       缓存单元中唯一标识
     * @param value     缓存单元中的数据
     */
    protected void setCache(String cacheName, String key, Object value) {
        cacheChannel.set(cacheName, key, value);
    }

    /**
     * 获得缓存
     *
     * @param cacheName 缓存单元名称
     * @param key       缓存单元中唯一标识
     * @return Object类型得缓存数据(若不存在则返回null)
     */
    protected Object getCache(String cacheName, String key) {
        CacheObject cacheObject = cacheChannel.get(cacheName, key);
        if (cacheObject == null || cacheObject.getValue() == null) {
            return null;
        } else {
            return cacheObject.getValue();
        }
    }

    /**
     * 移除缓存
     *
     * @param cacheName 缓存单元名称
     * @param key       缓存单元中唯一标识
     */
    protected void removeCache(String cacheName, String key) {
        cacheChannel.set(cacheName, key, null);
    }

}
