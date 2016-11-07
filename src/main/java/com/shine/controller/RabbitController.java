package com.shine.controller;


import com.shine.bean.ResultBean;
import com.shine.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by hq on 2016/10/6.
 */
@Controller
@RequestMapping(value = "/rabbitmq")
public class RabbitController {

    @Autowired
    RabbitService rabbitService;

    @RequestMapping(value ="/producerView")
    public ModelAndView producerView(){
        ModelAndView modelAndView = new ModelAndView("producerView");

        return modelAndView;
    }

    @RequestMapping(value ="/mqProducer")
    @ResponseBody
    public ResultBean mqproducer(){
        ResultBean resultBean=rabbitService.producer();
        return resultBean;
    }
}
