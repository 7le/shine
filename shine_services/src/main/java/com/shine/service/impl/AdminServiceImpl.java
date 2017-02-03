package com.shine.service.impl;

import com.shine.dao.model.AdminUser;
import com.shine.service.AdminService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hq on 2017/1/25.
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl implements AdminService {

    @Override
    public String doAdminLogin(String loginName, String password, HttpServletRequest request) {

        AdminUser adminUser =adminUserMapper.selectByLoginName(loginName);

        if(adminUser == null){
            return "用户不存在";
        }

        return null;
    }

    @Override
    public String doAdminRegister(AdminUser adminUser) {

        AdminUser adminUser1 =adminUserMapper.selectByLoginName(adminUser.getLoginname());

        if(adminUser1 != null){
            return "用户已存在";
        }

        int flag=adminUserMapper.insertSelective(adminUser);

        if(flag==1){
            return "注册失败";
        }

        return null;
    }

}
