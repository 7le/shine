package com.shine.controller.backend;

import com.shine.constant.Backend;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 图表插件控制器
 * Created by hq on 2016/12/11 0011.
 */
@Controller
@RequestMapping(value = Backend.URL.GRAPH.GRAPH)
public class GraphController extends BackendController {

    /**
     * echarts 图表
     */
    @RequestMapping(value = Backend.URL.GRAPH.ECHARTS)
    public ModelAndView echartsView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.GRAPH.ECHARTS);
        return modelAndView;
    }

    /**
     * flot 图表
     */
    @RequestMapping(value = Backend.URL.GRAPH.FLOT)
    public ModelAndView flotView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.GRAPH.FLOT);
        return modelAndView;
    }

    /**
     * metrics 图表
     */
    @RequestMapping(value = Backend.URL.GRAPH.METRICS)
    public ModelAndView metricsView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.GRAPH.METRICS);
        return modelAndView;
    }

    /**
     * morris 图表
     */
    @RequestMapping(value = Backend.URL.GRAPH.MORRIS)
    public ModelAndView morrisView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.GRAPH.MORRIS);
        return modelAndView;
    }

    /**
     * peity 图表
     */
    @RequestMapping(value = Backend.URL.GRAPH.PEITY)
    public ModelAndView peityView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.GRAPH.PEITY);
        return modelAndView;
    }

    /**
     * richshaw 图表
     */
    @RequestMapping(value = Backend.URL.GRAPH.RICKSHAW)
    public ModelAndView richshawView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.GRAPH.RICKSHAW);
        return modelAndView;
    }

    /**
     * sparkline 图表
     */
    @RequestMapping(value = Backend.URL.GRAPH.SPARKLINE)
    public ModelAndView sparklineView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.GRAPH.SPARKLINE);
        return modelAndView;
    }
}
