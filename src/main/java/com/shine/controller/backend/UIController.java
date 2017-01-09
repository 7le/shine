package com.shine.controller.backend;

import com.shine.constant.Backend;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * UI 控制器
 * Created by hq on 2017/1/4.
 */
@Controller
public class UIController {

    /**
     * 排版 typography
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.TYPOGRAPHY)
    public ModelAndView typographyView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.TYPOGRAPHY);
        return modelAndView;
    }

    /**
     * 字体图标 fontawesome
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.FONTAWESOME)
    public ModelAndView fontawesomeView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.FONTAWESOME);
        return modelAndView;
    }

    /**
     * 字形图标 glyphicons
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.GLYPHICONS)
    public ModelAndView glyphiconsView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.GLYPHICONS);
        return modelAndView;
    }

    /**
     * 阿里巴巴矢量图标库 iconfont
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.ICONFONT)
    public ModelAndView iconfontView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.ICONFONT);
        return modelAndView;
    }

    /**
     * 拖动面板 draggable_panels
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.DRAGGABLEPANELS)
    public ModelAndView draggablePanelsView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.DRAGGABLEPANELS);
        return modelAndView;
    }

    /**
     * 任务清单 agile_board
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.AGILEBOARD)
    public ModelAndView agileBoardView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.AGILEBOARD);
        return modelAndView;
    }

    /**
     * 按钮 buttons
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.BUTTONS)
    public ModelAndView buttonsView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.BUTTONS);
        return modelAndView;
    }

    /**
     * 选项卡 & 面板 tabs_panels
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.TABSPANELS)
    public ModelAndView tabsPanelsView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.TABSPANELS);
        return modelAndView;
    }

    /**
     * 通知 & 提示 notifications
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.NOTIFICATIONSS)
    public ModelAndView notificationsView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.NOTIFICATIONSS);
        return modelAndView;
    }

    /**
     * 徽章，标签，进度条 badges_labels
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.BADGESLABELS)
    public ModelAndView badgesLabelsView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.BADGESLABELS);
        return modelAndView;
    }

    /**
     * 栅格 grid_options
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.GRIDOPTIONS)
    public ModelAndView gridOptionsView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.GRIDOPTIONS);
        return modelAndView;
    }

    /**
     * 视频，音频 plyr
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.PLYR)
    public ModelAndView plyrView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.PLYR);
        return modelAndView;
    }

    /**
     * 弹框插件 sweetalert
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.SWEETALERT)
    public ModelAndView sweetAlertView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.SWEETALERT);
        return modelAndView;
    }

    /**
     * 树形视图  nestable
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.NESTABLE)
    public ModelAndView nestableView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.NESTABLE);
        return modelAndView;
    }

    /**
     *   Toastr通知
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.TOASTER)
    public ModelAndView toastrView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.TOASTER);
        return modelAndView;
    }

    /**
     *   diff 文本对比
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.DIFF)
    public ModelAndView diffView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.DIFF);
        return modelAndView;
    }

    /**
     *   spinners 加载动画
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.SPINNERS)
    public ModelAndView spinnersView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.SPINNERS);
        return modelAndView;
    }

    /**
     *   widgets 加载动画
     * @return
     */
    @RequestMapping(value = Backend.URL.UI.WIDGETS)
    public ModelAndView widgetsView(){
        ModelAndView modelAndView=new ModelAndView(Backend.PATH.UI.WIDGETS);
        return modelAndView;
    }
}