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
public class TableController {
    /**
     * 基本表格
     */
    @RequestMapping(value = Backend.URL.TABLE.TABLEBASIC)
    public ModelAndView tableBasicView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.TABLE.TABLEBASIC);
        return modelAndView;
    }

    /**
     * bootstrap
     */
    @RequestMapping(value = Backend.URL.TABLE.TABLEBOOTSTRAP)
    public ModelAndView tableBootstrapView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.TABLE.TABLEBOOTSTRAP);
        return modelAndView;
    }

    /**
     * data
     */
    @RequestMapping(value = Backend.URL.TABLE.TABLEDATA)
    public ModelAndView tableDataView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.TABLE.TABLEDATA);
        return modelAndView;
    }

    /**
     * foo
     */
    @RequestMapping(value = Backend.URL.TABLE.TABLEFOO)
    public ModelAndView tableFooView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.TABLE.TABLEFOO);
        return modelAndView;
    }

    /**
     * jqgrid
     */
    @RequestMapping(value = Backend.URL.TABLE.TABLEJQGRID)
    public ModelAndView tableJqgridView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.TABLE.TABLEJQGRID);
        return modelAndView;
    }
}
