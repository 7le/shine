package com.shine.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 图表插件控制器
 * Created by hq on 2016/12/11 0011.
 */
@Controller
@RequestMapping(value = "/graph")
public class GraphController extends BackendController{

    /**
     * echarts 图表
     */
    @RequestMapping(value = "/echarts")
    public ModelAndView echartsView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("graph/echarts");
        return modelAndView;
    }

    /**
     * flot 图表
     */
    @RequestMapping(value = "/flot")
    public ModelAndView flotView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("graph/flot");
        return modelAndView;
    }

    /**
     * metrics 图表
     */
    @RequestMapping(value = "/metrics")
    public ModelAndView metricsView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("graph/metrics");
        return modelAndView;
    }

    /**
     * morris 图表
     */
    @RequestMapping(value = "/morris")
    public ModelAndView morrisView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("graph/morris");
        return modelAndView;
    }

    /**
     * peity 图表
     */
    @RequestMapping(value = "/peity")
    public ModelAndView peityView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("graph/peity");
        return modelAndView;
    }

    /**
     * richshaw 图表
     */
    @RequestMapping(value = "/richshaw")
    public ModelAndView richshawView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("graph/richshaw");
        return modelAndView;
    }

    /**
     * sparkline 图表
     */
    @RequestMapping(value = "/sparkline")
    public ModelAndView sparklineView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("graph/sparkline");
        return modelAndView;
    }
}
