package com.shine.controller.backend.edit;

import com.shine.constant.Template;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆控制器
 * Created by hq on 2016/12/13.
 */
@Controller
public class EditLoginController {

    /**
     * 登录页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.LOGIN.LOGINVIEW)
    public ModelAndView loginView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.LOGIN.LOGINVIEW);
        return modelAndView;
    }

    /**
     * 登录页面2
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.LOGIN.LOGINVIEWV)
    public ModelAndView loginVView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.LOGIN.LOGINVIEWV);
        return modelAndView;
    }

    /**
     * 登录超时
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.LOGIN.LOCKSCREEN)
    public ModelAndView lockscreenView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.LOGIN.LOCKSCREEN);
        return modelAndView;
    }
}
