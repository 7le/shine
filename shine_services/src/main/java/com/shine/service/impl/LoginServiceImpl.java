package com.shine.service.impl;

import com.shine.dao.model.AdminUser;
import com.shine.service.LoginService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hq on 2017/1/25.
 */
@Service
public class LoginServiceImpl extends BaseServiceImpl implements LoginService {

    @Override
    public String doAdminLogin(String loginName, String password, HttpServletRequest request) {

        AdminUser adminUser =adminUserMapper.selectByLoginName(loginName);

        return null;
    }

}
