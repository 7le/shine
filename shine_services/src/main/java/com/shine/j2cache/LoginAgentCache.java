package com.shine.j2cache;

import com.shine.constant.CacheConst;
import com.shine.util.HttpUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 代理登录
 * Created by hq on 2016/11/4.
 */
public class LoginAgentCache extends BaseCache {

    /**
     * 设置成员登录信息(若原先存在则覆盖,不存在则添加)
     *
     * @param request 当前会话请求
     */
    public void setLoginAgent(HttpServletRequest request, Object agent) {
        setCache(CacheConst.LOGIN_AGENT, HttpUtil.getSessionName(CacheConst.LOGIN_AGENT, request), agent);
    }


    /**
     * 获取管理员登录信息
     *
     * @param request 当前会话请求
     * @return Admin类型的数据(不存在则返回null)
     */
    public Object getLoginAgent(HttpServletRequest request) {
        Object valueObject = getCache(CacheConst.LOGIN_AGENT, HttpUtil.getSessionName(CacheConst.LOGIN_AGENT, request));
        if (valueObject == null) {
            return null;
        } else {
            return (Object) valueObject;
        }
    }

    /**
     * 移除管理员登录信息
     *
     * @param request 当前会话请求
     */
    public void removeLoginAgent(HttpServletRequest request) {
        removeCache(CacheConst.LOGIN_AGENT, HttpUtil.getSessionName(CacheConst.LOGIN_AGENT, request));
    }

}
