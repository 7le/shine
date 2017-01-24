package com.shine.controller.backend;

import com.shine.constant.Backend;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hq on 2016/12/2.
 */
@Controller
public class IndexController extends BackendController {

    /**
     * 登录首页
     */
    @RequestMapping(value = Backend.URL.INDEX.INDEXVIEW)
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.INDEX.INDEXVIEW);

        return modelAndView;
    }

    /**
     * 主页部分
     */
    @RequestMapping(value = Backend.URL.INDEX.INDEX_V5)
    public ModelAndView index_v5(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.INDEX.INDEX_V5);

        return modelAndView;
    }


}
