package com.shine.controller.backend;


import com.shine.constant.Backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;


/**
 * 常用方法控制器
 * Created by hq on 2017/1/19.
 */
@Controller
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
    @RequestMapping(value = Backend.URL.LOGIN.LOGINVIEWS)
    public ModelAndView loginVView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.LOGIN.LOGINVIEWS);
        return modelAndView;
    }

    /**
     * 登录超时
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.LOGIN.LOCKSCREEN)
    public ModelAndView lockscreenView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.LOGIN.LOCKSCREEN);
        return modelAndView;
    }

}
