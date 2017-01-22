package com.shine.controller.backend;

import com.shine.constant.Backend;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hq on 2017/1/22.
 */
@Controller
public class LoginController {

    /**
     * 登录界面1
     */
    @RequestMapping(value = Backend.URL.LOGIN.LOGINVIEW)
    public ModelAndView loginView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.LOGIN.LOGINVIEW);
        return modelAndView;
    }

    /**
     *登录界面2
     */
    @RequestMapping(value = Backend.URL.LOGIN.LOGINVIEWS)
    public ModelAndView loginVView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.LOGIN.LOGINVIEWS);
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

}
