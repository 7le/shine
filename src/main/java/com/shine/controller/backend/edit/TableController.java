package com.shine.controller.backend.edit;

import com.shine.constant.Template;
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
    @RequestMapping(value = Template.URL.TABLE.TABLEBASIC)
    public ModelAndView tableBasicView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.TABLE.TABLEBASIC);
        return modelAndView;
    }

    /**
     * bootstrap
     */
    @RequestMapping(value = Template.URL.TABLE.TABLEBOOTSTRAP)
    public ModelAndView tableBootstrapView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.TABLE.TABLEBOOTSTRAP);
        return modelAndView;
    }

    /**
     * data
     */
    @RequestMapping(value = Template.URL.TABLE.TABLEDATA)
    public ModelAndView tableDataView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.TABLE.TABLEDATA);
        return modelAndView;
    }

    /**
     * foo
     */
    @RequestMapping(value = Template.URL.TABLE.TABLEFOO)
    public ModelAndView tableFooView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.TABLE.TABLEFOO);
        return modelAndView;
    }

    /**
     * jqgrid
     */
    @RequestMapping(value = Template.URL.TABLE.TABLEJQGRID)
    public ModelAndView tableJqgridView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.TABLE.TABLEJQGRID);
        return modelAndView;
    }
}
