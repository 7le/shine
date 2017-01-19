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
public class PageController {

    /**
     * 联系人
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.CONTACTS)
    public ModelAndView contactsView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.CONTACTS);
        return modelAndView;
    }

    /**
     * 文章详情
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.ARTICLE)
    public ModelAndView articleView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.ARTICLE);
        return modelAndView;
    }

    /**
     * 日历
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.CALENDAR)
    public ModelAndView calendarView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.CALENDAR);
        return modelAndView;
    }

    /**
     * 文章列表
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.BLOG)
    public ModelAndView blogView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.BLOG);
        return modelAndView;
    }

    /**
     * 客户管理
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.CLIENTS)
    public ModelAndView clientsView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.CLIENTS);
        return modelAndView;
    }

    /**
     * 文件管理器
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.FILEMANAGER)
    public ModelAndView fileManagerView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.FILEMANAGER);
        return modelAndView;
    }

    /**
     * 个人资料
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.PROFILE)
    public ModelAndView profileView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.PROFILE);
        return modelAndView;
    }

    /**
     * 项目详情
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.PROJECTDETAIL)
    public ModelAndView projectDetailView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.PROJECTDETAIL);
        return modelAndView;
    }

    /**
     * 项目
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.PROJECTS)
    public ModelAndView projectsView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.PROJECTS);
        return modelAndView;
    }

    /**
     * 信息流
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.SOCIALFEED)
    public ModelAndView socialFeedView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.SOCIALFEED);
        return modelAndView;
    }

    /**
     * 团队管理
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.TEAMSBOARD)
    public ModelAndView teamsBoardView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.TEAMSBOARD);
        return modelAndView;
    }

    /**
     * FAQ
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.FAQ)
    public ModelAndView faqView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.FAQ);
        return modelAndView;
    }

    /**
     * 时间轴
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.TIMELINE)
    public ModelAndView timelineView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.TIMELINE);
        return modelAndView;
    }

    /**
     * 时间轴v2
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.TIMELINE2)
    public ModelAndView timeline2View(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.TIMELINE2);
        return modelAndView;
    }

    /**
     *
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.PINBOARD)
    public ModelAndView pinBoardView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.PINBOARD);
        return modelAndView;
    }

    /**
     * 标签墙
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.INVOICE)
    public ModelAndView invoiceView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.INVOICE);
        return modelAndView;
    }

    /**
     * 单据打印
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.INVOICEPRINT)
    public ModelAndView invoicePrintView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.INVOICEPRINT);
        return modelAndView;
    }

    /**
     * 搜索结果
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.SEARCHRESULTS)
    public ModelAndView searchResultsView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.SEARCHRESULTS);
        return modelAndView;
    }

    /**
     * 论坛
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.FORUMMAIN)
    public ModelAndView forumMainView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.FORUMMAIN);
        return modelAndView;
    }

    /**
     * 聊天窗口
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.CHAT)
    public ModelAndView chatView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.CHAT);
        return modelAndView;
    }

    /**
     * layIM
     *
     * @param request
     * @return
     */
    @RequestMapping(value = Backend.URL.PAGE.WEBIM)
    public ModelAndView webimView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.WEBIM);
        return modelAndView;
    }

}
