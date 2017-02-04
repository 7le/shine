package com.shine.controller.backend;

import com.shine.bean.ResultBean;
import com.shine.constant.Backend;
import com.shine.controller.BaseController;
import com.shine.dao.model.AdminUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hq on 2017/1/22.
 */
@Controller
public class LoginController extends BaseController{

    /**
     * 登录界面
     */
    @RequestMapping(value = Backend.URL.LOGIN.LOGINVIEW)
    public ModelAndView loginView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.LOGIN.LOGINVIEW);
        return modelAndView;
    }


    /**
     * 登录超时
     */
    @RequestMapping(value = Backend.URL.LOGIN.LOCKSCREEN)
    public ModelAndView lockscreenView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.LOGIN.LOCKSCREEN);
        return modelAndView;
    }

    /**
     * 帐号密码登录
     */
    @RequestMapping(value = Backend.URL.LOGIN.DOLOGIN)
    public ResultBean doLogin(HttpServletRequest request,String userName,String password){
        //执行登录
        String errorReport = adminService.doAdminLogin(userName, password, request);
        if (errorReport != null) {
            return new ResultBean(false, errorReport);
        } else {
            return new ResultBean(true, "登录成功");
        }
    }

    /**
     * 注册页面
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.REGISTER.REGISTERVIEW)
    public String registerView(HttpServletRequest request) {
        return Backend.PATH.REGISTER.REGISTERVIEW;
    }

    /**
     * 注册帐号密码登录
     */
    @RequestMapping(value = Backend.URL.REGISTER.DOREGISTERVIEW)
    public ResultBean doRegister(HttpServletRequest request,AdminUser adminUser){
        //执行登录
        String errorReport = adminService.doAdminRegister(adminUser);
        if (errorReport != null) {
            return new ResultBean(false, errorReport);
        } else {
            return new ResultBean(true, "注册成功");
        }
    }

}
