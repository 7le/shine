package com.shine.controller.backend.edit;

import com.shine.constant.Template;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hq on 2017/1/18.
 */
@Controller
public class FormController {

    /**
     * 基本表单
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.FORM.BASIC)
    public ModelAndView basicView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.FORM.BASIC);
        return modelAndView;
    }

    /**
     * 头像裁剪上传
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.FORM.AVATAR)
    public ModelAndView avatarView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.FORM.AVATAR);
        return modelAndView;
    }

    /**
     * 高级插件
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.FORM.ADVANCED)
    public ModelAndView advancedView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.FORM.ADVANCED);
        return modelAndView;
    }

    /**
     * 表单构建器
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.FORM.BUILDER)
    public ModelAndView builderView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.FORM.BUILDER);
        return modelAndView;
    }

    /**
     * 富文本编辑器
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.FORM.EDITORS)
    public ModelAndView editorsView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.FORM.EDITORS);
        return modelAndView;
    }

    /**
     * DropzoneJS
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.FORM.FILEUPLOAD)
    public ModelAndView fileUploadView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.FORM.FILEUPLOAD);
        return modelAndView;
    }

    /**
     * MarkDown编辑器
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.FORM.MARKDOWN)
    public ModelAndView markdownView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.FORM.MARKDOWN);
        return modelAndView;
    }

    /**
     * simditor
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.FORM.SIMDITOR)
    public ModelAndView simditorView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.FORM.SIMDITOR);
        return modelAndView;
    }

    /**
     * 表单验证
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.FORM.VALIDATE)
    public ModelAndView validateView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.FORM.VALIDATE);
        return modelAndView;
    }

    /**
     * 百度WebUploader
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.FORM.WEBUPLOADER)
    public ModelAndView webuploaderView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.FORM.WEBUPLOADER);
        return modelAndView;
    }

    /**
     * 表单向导
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.FORM.WIZARD)
    public ModelAndView wizardView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.FORM.WIZARD);
        return modelAndView;
    }

    /**
     * 搜索自动补全
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.FORM.SUGGEST)
    public ModelAndView suggestView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.FORM.SUGGEST);
        return modelAndView;
    }

    /**
     * 日期选择器layerDate
     * @param request
     * @return
     */
    @RequestMapping(value = Template.URL.FORM.LAYERDATE)
    public ModelAndView layerdateView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Template.PATH.FORM.LAYERDATE);
        return modelAndView;
    }

}
