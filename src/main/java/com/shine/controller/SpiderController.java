package com.shine.controller;

import com.shine.bean.ResultBean;
import com.shine.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hq on 2016/11/15.
 * 爬虫接口
 */
@Controller
@RequestMapping(value ="/spider" )
public class SpiderController {


    @Autowired
    SpiderService spiderService;

    @RequestMapping(value ="/xlp")
    public ModelAndView xlpSpider(){
        ModelAndView modelAndView = new ModelAndView("/spider/xlpSpider.jsp");

        return modelAndView;
    }

    @RequestMapping(value ="/xlpOpen")
    @ResponseBody
    public ResultBean xlpSpiderOpen(){
        ResultBean resultBean=spiderService.xlpspider();
        return resultBean;
    }
}
