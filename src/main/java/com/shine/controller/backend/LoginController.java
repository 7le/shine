package com.shine.controller.backend;

import com.shine.constant.Backend;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆控制器
 * Created by hq on 2016/12/13.
 */
@Controller
@RequestMapping(value = Backend.URL.LOGIN.LOGIN)
public class LoginController {

    /**
     * 登录页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.LOGIN.LOGINVIEW)
    public ModelAndView loginView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.LOGIN.LOGINVIEW);
        return modelAndView;
    }

    /**
     * 登录页面2
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.LOGIN.LOGINVIEWV)
    public ModelAndView loginVView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.LOGIN.LOGINVIEWV);
        return modelAndView;
    }
}