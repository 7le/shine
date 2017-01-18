package com.shine.controller.backend;

import com.shine.constant.Backend;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hq on 2017/1/18.
 */
@Controller
public class FormController {

    @RequestMapping(value = Backend.URL.FORM.BASIC)
    public ModelAndView basicView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.FORM.BASIC);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.FORM.AVATAR)
    public ModelAndView avatarView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.FORM.AVATAR);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.FORM.ADVANCED)
    public ModelAndView advancedView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.FORM.ADVANCED);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.FORM.BUILDER)
    public ModelAndView builderView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.FORM.BUILDER);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.FORM.EDITORS)
    public ModelAndView editorsView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.FORM.EDITORS);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.FORM.FILEUPLOAD)
    public ModelAndView fileUploadView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.FORM.FILEUPLOAD);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.FORM.MARKDOWN)
    public ModelAndView markdownView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.FORM.MARKDOWN);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.FORM.SIMDITOR)
    public ModelAndView simditorView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.FORM.SIMDITOR);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.FORM.VALIDATE)
    public ModelAndView validateView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.FORM.VALIDATE);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.FORM.WEBUPLOADER)
    public ModelAndView webuploaderView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.FORM.WEBUPLOADER);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.FORM.WIZARD)
    public ModelAndView wizardView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.FORM.WIZARD);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.FORM.SUGGEST)
    public ModelAndView suggestView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.FORM.SUGGEST);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.FORM.LAYERDATE)
    public ModelAndView layerdateView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.FORM.LAYERDATE);
        return modelAndView;
    }

}
