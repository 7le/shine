package com.shine.service;

import com.shine.dao.model.AdminUser;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录Service
 * Created by hq on 2017/1/25.
 */
public interface AdminService {

    /**
     * 执行管理员登录
     *
     * @param loginName  账号
     * @param password 登录密码
     * @param request  当前会话请求
     * @return 成功返回null, 失败返回原因
     */
    String doAdminLogin(String loginName, String password, HttpServletRequest request);

    /**
     * 执行管理员登录
     *
     * @param adminUser
     * @return 成功返回null, 失败返回原因
     */
    String doAdminRegister(AdminUser adminUser);
}
