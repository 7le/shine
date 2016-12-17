package com.shine.controller.backend;

import com.shine.constant.Backend;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hq on 2016/12/17 0017.
 */
@Controller
public class MailController {

    /**
     * 收件箱
     */
    @RequestMapping(value = Backend.URL.MAIL.MAILBOX)
    public ModelAndView mailBoxView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.MAIL.MAILBOX);
        return modelAndView;
    }

    /**
     * 详细消息
     */
    @RequestMapping(value = Backend.URL.MAIL.MAILDETAIL)
    public ModelAndView mailDetailView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.MAIL.MAILDETAIL);
        return modelAndView;
    }

    /**
     * 写信
     */
    @RequestMapping(value = Backend.URL.MAIL.MAILCOMPOSE)
    public ModelAndView mailComposeView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.MAIL.MAILCOMPOSE);
        return modelAndView;
    }
}
