package com.shine.controller.backend.edit;

import com.shine.constant.Template;
import com.shine.controller.backend.BackendController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 图表插件控制器
 * Created by hq on 2016/12/11 0011.
 */
@Controller
public class GraphController extends BackendController {

    /**
     * echarts 图表
     */
    @RequestMapping(value = Template.URL.GRAPH.ECHARTS)
    public ModelAndView echartsView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.GRAPH.ECHARTS);
        return modelAndView;
    }

    /**
     * flot 图表
     */
    @RequestMapping(value = Template.URL.GRAPH.FLOT)
    public ModelAndView flotView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.GRAPH.FLOT);
        return modelAndView;
    }

    /**
     * metrics 图表
     */
    @RequestMapping(value = Template.URL.GRAPH.METRICS)
    public ModelAndView metricsView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.GRAPH.METRICS);
        return modelAndView;
    }

    /**
     * morris 图表
     */
    @RequestMapping(value = Template.URL.GRAPH.MORRIS)
    public ModelAndView morrisView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.GRAPH.MORRIS);
        return modelAndView;
    }

    /**
     * peity 图表
     */
    @RequestMapping(value = Template.URL.GRAPH.PEITY)
    public ModelAndView peityView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.GRAPH.PEITY);
        return modelAndView;
    }

    /**
     * richshaw 图表
     */
    @RequestMapping(value = Template.URL.GRAPH.RICKSHAW)
    public ModelAndView richshawView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.GRAPH.RICKSHAW);
        return modelAndView;
    }

    /**
     * sparkline 图表
     */
    @RequestMapping(value = Template.URL.GRAPH.SPARKLINE)
    public ModelAndView sparklineView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.GRAPH.SPARKLINE);
        return modelAndView;
    }
}
