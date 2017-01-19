package com.shine.controller.backend.edit;

import com.shine.constant.Template;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 注册控制器
 * Created by hq on 2016/12/13.
 */
@Controller
public class RegisterController {

    /**
     * 注册页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.REGISTER.REGISTERVIEW)
    public ModelAndView registerView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.REGISTER.REGISTERVIEW);
        return modelAndView;
    }
}
