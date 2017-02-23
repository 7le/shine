package com.shine.service.impl;

import com.shine.dao.model.AdminUser;
import com.shine.service.AdminService;
import com.shine.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hq on 2017/1/25.
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl implements AdminService {

    @Override
    public String doAdminLogin(String loginName, String password, HttpServletRequest request) {

        AdminUser adminUser =adminUserMapper.selectByLoginNameAndPassword(loginName, MD5Util.doImaoMd5(loginName, password));

        if(adminUser == null){
            return "用户名或密码错误";
        }

        //将管理员信息放入缓存
        loginAdminCache.setLoginAdmin(request, adminUser);

        return null;
    }

    @Override
    public String doAdminRegister(AdminUser adminUser) {

        AdminUser adminUser1 =adminUserMapper.selectByLoginName(adminUser.getLoginName());

        if(adminUser1 != null){
            return "用户已存在";
        }

        int flag=adminUserMapper.insertSelective(adminUser);

        if(flag==0){
            return "注册失败";
        }

        return null;
    }

}
