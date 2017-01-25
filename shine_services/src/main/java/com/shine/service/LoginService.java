package com.shine.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录Service
 * Created by hq on 2017/1/25.
 */
public interface LoginService {

    /**
     * 执行管理员登录
     *
     * @param userName  账号
     * @param password 登录密码
     * @param request  当前会话请求
     * @return 成功返回null, 失败返回原因
     */
    String doAdminLogin(String userName, String password, HttpServletRequest request);
}
