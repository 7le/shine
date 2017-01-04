package com.shine.controller.backend;

import com.shine.constant.Backend;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 工具控制器
 * Created by hq on 2017/1/4.
 */
@Controller
public class ToolController {

    /**
     * Css动画控制界面
     * @return
     */
    @RequestMapping(value = Backend.URL.TOOL.CSSVIEW)
    public ModelAndView CssView(){
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.TOOL.CSSVIEW);
        return modelAndView;
    }

    /**
     * 表单构建起
     * @return
     */
    @RequestMapping(value = Backend.URL.TOOL.FORMBUILDERVIEW)
    public ModelAndView FormBuilderView(){
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.TOOL.FORMBUILDERVIEW);
        return modelAndView;
    }
}
