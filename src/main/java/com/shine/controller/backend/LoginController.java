package com.shine.controller.backend;


import com.shine.constant.Backend;
import com.shine.constant.HttpSessionAttrNameConst;

import com.shine.util.validate.ValidateCode;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.word.RandomWordFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ���÷���������
 * Created by hq on 2017/1/19.
 */
@Controller
public class LoginController {

    /**
     * ��¼ҳ��
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
     * ��¼ҳ��2
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
     * ��¼��ʱ
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
