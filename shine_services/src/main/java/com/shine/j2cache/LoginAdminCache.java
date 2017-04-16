package com.shine.j2cache;

import com.shine.constant.CacheConst;
import com.shine.dao.model.AdminUser;
import com.shine.util.HttpUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 管理员登录信息缓存器
 *
 * @author hq 2016/11/04
 */
public class LoginAdminCache extends BaseCache {


    /**
     * 设置管理员登录信息(若原先存在则覆盖,不存在则添加)
     *
     * @param request 当前会话请求
     */
    public void setLoginAdmin(HttpServletRequest request, AdminUser admin) {
        setCache(CacheConst.LOGIN_ADMIN, HttpUtil.getSessionName(CacheConst.LOGIN_ADMIN, request), admin);
    }

    /**
     * 获取管理员登录信息
     *
     * @param request 当前会话请求
     * @return Admin类型的数据(不存在则返回null)
     */
    public AdminUser getLoginAdmin(HttpServletRequest request) {
        Object valueObject = getCache(CacheConst.LOGIN_ADMIN, HttpUtil.getSessionName(CacheConst.LOGIN_ADMIN, request));
        if (valueObject == null) {
            return null;
        } else {
            return (AdminUser) valueObject;
        }
    }

    /**
     * 移除管理员登录信息
     *
     * @param request 当前会话请求
     */
    public void removeLoginAdmin(HttpServletRequest request) {
        removeCache(CacheConst.LOGIN_ADMIN, HttpUtil.getSessionName(CacheConst.LOGIN_ADMIN, request));
    }


}
