package com.shine.controller.backend;

import com.shine.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hq on 2016/12/2.
 */
@Controller
public class LoginController extends BackendController{

    /**
     * 登录页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView loginView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("common/login");
        //    modelAndView.addObject("fresh",fresh);
        return modelAndView;
    }

    /**
     * 登录页面2
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/login_v")
    public ModelAndView loginVView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("common/login_v");
        //    modelAndView.addObject("fresh",fresh);
        return modelAndView;
    }

    /**
     * 注册页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/register")
    public ModelAndView registerView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("common/register");
        return modelAndView;
    }


    /**
     * 登录首页
     */
    @RequestMapping(value = "/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }

    /**
     * 主页部分
     */
    @RequestMapping(value = "/index_v5")
    public ModelAndView index_v5(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("index_v5");

        return modelAndView;
    }


}
