package com.shine.controller.backend;

import com.shine.constant.Backend;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 图片相册控制器
 * Created by hq on 2016/12/11 0011.
 */
@Controller
@RequestMapping(Backend.URL.PHOTO.PHOTO)
public class PhotoController extends BackendController{

    /**
     * 基本图库页面
     * @param request
     * @return
     */
    @RequestMapping(Backend.URL.PHOTO.BASIC)
    public ModelAndView basicGalleryView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PHOTO.BASIC);
        return modelAndView;
    }

    /**
     * 图库切换页面
     * @param request
     * @return
     */
    @RequestMapping(Backend.URL.PHOTO.CAROUSEL)
    public ModelAndView carouselView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PHOTO.CAROUSEL);
        return modelAndView;
    }

    /**
     * 相册插件页面
     * @param request
     * @return
     */
    @RequestMapping(Backend.URL.PHOTO.BLUEIMP)
    public ModelAndView loginView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PHOTO.BLUEIMP);
        return modelAndView;
    }
}
