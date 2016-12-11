package com.shine.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 图片相册控制器
 * Created by hq on 2016/12/11 0011.
 */
@Controller
/*@RequestMapping(value = "/photo")*/
public class PhotoController extends BackendController{

    /**
     * 基本图库页面
     * @param request
     * @return
     */
    @RequestMapping(value = "/basic")
    public ModelAndView basicGalleryView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("photo/basicGallery");
        return modelAndView;
    }

    /**
     * 图库切换页面
     * @param request
     * @return
     */
    @RequestMapping(value = "/carousel")
    public ModelAndView carouselView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("photo/carousel");
        return modelAndView;
    }

    /**
     * 相册插件页面
     * @param request
     * @return
     */
    @RequestMapping(value = "/blueimp")
    public ModelAndView loginView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("photo/blueImp");
        return modelAndView;
    }
}
