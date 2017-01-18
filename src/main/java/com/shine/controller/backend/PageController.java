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

    @RequestMapping(value = Backend.URL.PAGE.CONTACTS)
    public ModelAndView contactsView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.CONTACTS);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.ATRICLE)
    public ModelAndView articleView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.ATRICLE);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.CALENDAR)
    public ModelAndView calendarView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.CALENDAR);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.BLOG)
    public ModelAndView blogView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.BLOG);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.CLIENTS)
    public ModelAndView clientsView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.CLIENTS);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.FILEMANAGER)
    public ModelAndView fileManagerView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.FILEMANAGER);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.PROFILE)
    public ModelAndView profileView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.PROFILE);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.PROJECTDETAIL)
    public ModelAndView projectDetailView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.PROJECTDETAIL);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.PROJECTS)
    public ModelAndView projectsView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.PROJECTS);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.SOCIALFEED)
    public ModelAndView socialFeedView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.SOCIALFEED);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.TEAMSBOARD)
    public ModelAndView teamsBoardView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.TEAMSBOARD);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.FAQ)
    public ModelAndView faqView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.FAQ);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.TIMELINE)
    public ModelAndView timelineView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.TIMELINE);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.TIMELINE2)
    public ModelAndView timeline2View(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.TIMELINE2);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.PINBOARD)
    public ModelAndView pinBoardView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.PINBOARD);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.INVOICE)
    public ModelAndView invoiceView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.INVOICE);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.INVOICEPRINT)
    public ModelAndView invoicePrintView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.INVOICEPRINT);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.SEARCHRESULTS)
    public ModelAndView searchResultsView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.SEARCHRESULTS);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.FORUMMAIN)
    public ModelAndView forumMainView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.FORUMMAIN);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.CHAT)
    public ModelAndView chatView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.CHAT);
        return modelAndView;
    }

    @RequestMapping(value = Backend.URL.PAGE.WEBIM)
    public ModelAndView webimView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(Backend.PATH.PAGE.WEBIM);
        return modelAndView;
    }

}
