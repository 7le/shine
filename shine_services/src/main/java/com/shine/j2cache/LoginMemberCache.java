package com.shine.j2cache;

import com.shine.constant.CacheConst;
import com.shine.util.HttpUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 成员登录信息缓存器
 *
 * @author hq 2016/11/04
 */
public class LoginMemberCache extends BaseCache {


    /**
     * 设置成员登录信息(若原先存在则覆盖,不存在则添加)
     *
     * @param request 当前会话请求
     * @param member  登录成员信息
     */
    public void setLoginMember(HttpServletRequest request, Object member) {
        setCache(CacheConst.LOGIN_MEMBER, HttpUtil.getSessionName(CacheConst.LOGIN_MEMBER, request), member);
    }

    /**
     * 获取成员登录信息
     *
     * @param request 当前会话请求
     * @return Member类型的数据(不存在则返回null)
     */
    public Object getLoginMember(HttpServletRequest request) {
        Object valueObject = getCache(CacheConst.LOGIN_MEMBER, HttpUtil.getSessionName(CacheConst.LOGIN_MEMBER, request));
        if (valueObject == null) {
            return null;
        } else {
            return (Object) valueObject;
        }
    }

    /**
     * 移除成员登录信息
     *
     * @param request 当前会话请求
     */
    public void removeLoginMember(HttpServletRequest request) {
        removeCache(CacheConst.LOGIN_MEMBER, HttpUtil.getSessionName(CacheConst.LOGIN_MEMBER, request));
    }


}
