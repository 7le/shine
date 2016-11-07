package com.shine.j2cache;

import com.shine.constant.CacheConst;

/**
 * 手机验证码缓存器
 *
 * @author hq 2016/11/04
 */
public class VerifyCodePhoneCache extends BaseCache {


    /**
     * 设置手机验证码(若原先存在则覆盖,不存在则添加)
     *
     * @param key        缓存单元中的唯一标识
     * @param verifyCode 验证码
     */
    public void setVerifyCode(String key, String verifyCode) {
        setCache(CacheConst.VERIFY_CODE_PHONE, key, verifyCode);
    }

    /**
     * 获取验证码
     *
     * @param key 缓存单元中的唯一标识
     * @return String类型数据(若不存在则返回null)
     */
    public String getVerifyCode(String key) {
        Object valueObject = getCache(CacheConst.VERIFY_CODE_PHONE, key);
        if (valueObject == null) {
            return null;
        } else {
            return (String) valueObject;
        }
    }

    /**
     * 移除缓存
     *
     * @param key 缓存单元中的唯一标识
     */
    public void removeVerifyCode(String key) {
        removeCache(CacheConst.VERIFY_CODE_PHONE, key);
    }


}
