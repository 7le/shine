package com.shine.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hq on 2016/12/2.
 */
@Controller
@RequestMapping(value = "/backend")
public class LoginController {

    /**
     * 登录首页
     */
    @RequestMapping(value = "/login")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }

    /**
     * 主页部分
     */
    @RequestMapping(value = "/indx_v5")
    public ModelAndView index_v5(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("indx_v5");

        return modelAndView;
    }
}
