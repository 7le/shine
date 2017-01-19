package com.shine.constant;

/**
 * Created by hq on 2016/12/11 0011.
 */
public interface Backend {
    interface URL {
        String BASE = "/backend";

        /**
         * 主页
         */
        interface INDEX {
            String INDEX = BASE;
            String INDEXVIEW = "/index";
            String INDEX_V5 = "/index_v5";
        }

        /**
         * 注册
         */
        interface REGISTER {
            String REGISTER = BASE;
            String REGISTERVIEW = "/register";
        }

        /**
         * 登陆
         */
        interface LOGIN {
            String LOGIN = BASE;
            String LOGINVIEW = "/login";
            String LOGINVIEWV = "/login_v";
            String LOCKSCREEN = "/lockscreen";
        }

        /**
         * 图表
         */
        interface GRAPH {
            String GRAPH = BASE + "/graph";
            String ECHARTS = "/echarts";
            String FLOT = "/flot";
            String METRICS = "/metrics";
            String MORRIS = "/morris";
            String PEITY = "/peity";
            String RICKSHAW = "/rickshaw";
            String SPARKLINE = "/sparkline";
        }

        /**
         * 相册
         */
        interface PHOTO {
            String PHOTO = BASE + "/photo";
            String BASIC = "/basic";
            String CAROUSEL = "/carousel";
            String BLUEIMP = "/blueimp";
        }

        /**
         * 邮箱
         */
        interface MAIL {
            String MAIL = BASE;
            String MAILBOX = MAIL + "/mailBox";
            String MAILDETAIL = MAIL + "/mailDetail";
            String MAILCOMPOSE = MAIL + "/mailCompose";
        }

        /**
         * 表格
         */
        interface TABLE {
            String TABLE = BASE;
            String TABLEBASIC = TABLE + "/tableBasic";
            String TABLEBOOTSTRAP = TABLE + "/tableBootstrap";
            String TABLEDATA = TABLE + "/tableDate";
            String TABLEFOO = TABLE + "/tableFoo";
            String TABLEJQGRID = TABLE + "/tableJqgrid";
        }

        /**
         * 表单
         */
        interface FORM {
            String FORM = BASE+"/form";
            String BASIC = FORM + "/basic";
            String AVATAR = FORM + "/avatar";
            String ADVANCED = FORM + "/advanced";
            String BUILDER = FORM + "/builder";
            String EDITORS = FORM + "/editors";
            String FILEUPLOAD = FORM + "/fileUpload";
            String MARKDOWN = FORM + "/markdown";
            String SIMDITOR = FORM + "/simditor";
            String VALIDATE = FORM + "/validate";
            String WEBUPLOADER = FORM + "/webuploader";
            String WIZARD = FORM + "/wizard";
            String SUGGEST = FORM + "/suggest";
            String LAYERDATE = FORM + "/layerdate";
        }

        /**
         * 工具
         */
        interface TOOL {
            String TOOL = BASE;
            String CSSVIEW = TOOL + "/cssAnimation";
            String FORMBUILDERVIEW = TOOL + "/formBuilder";
        }

        /**
         * UI
         */
        interface UI {
            String UI = BASE + "/ui";
            String TYPOGRAPHY = UI + "/typography";
            String FONTAWESOME = UI + "/fontawesome";
            String GLYPHICONS = UI + "/glyphicons";
            String ICONFONT = UI + "/iconfont";
            String DRAGGABLEPANELS = UI + "/draggablePanels";
            String AGILEBOARD = UI + "/agileBoard";
            String BUTTONS = UI + "/buttons";
            String TABSPANELS = UI + "/tabsPanels";
            String NOTIFICATIONSS = UI + "/notifications";
            String BADGESLABELS = UI + "/badgesLabels";
            String GRIDOPTIONS = UI + "/gridOptions";
            String PLYR = UI + "/plyr";
            String SWEETALERT = UI + "/sweetalert";
            String NESTABLE = UI + "/nestable";
            String TOASTER = UI + "/toastr";
            String DIFF = UI + "/diff";
            String SPINNERS = UI + "/spinners";
            String WIDGETS = UI + "/widgets";
        }

        /**
         * Page
         */
        interface PAGE {
            String PAGE = BASE + "/page";
            String CONTACTS = PAGE + "/contacts";
            String ARTICLE = PAGE + "/article";
            String BLOG = PAGE + "/blog";
            String CALENDAR = PAGE + "/calendar";
            String CLIENTS = PAGE + "/clients";
            String FILEMANAGER = PAGE + "/fileManager";
            String PROFILE = PAGE + "/profile";
            String PROJECTDETAIL = PAGE + "/projectDetail";
            String PROJECTS = PAGE + "/projects";
            String SOCIALFEED = PAGE + "/socialFeed";
            String TEAMSBOARD = PAGE + "/teamsBoard";
            String FAQ = PAGE + "/faq";
            String TIMELINE = PAGE + "/timeline";
            String TIMELINE2 = PAGE + "/timeline_v2";
            String PINBOARD = PAGE + "/pinBoard";
            String INVOICE = PAGE + "/invoice";
            String INVOICEPRINT = PAGE + "/invoicePrint";
            String SEARCHRESULTS = PAGE + "/searchResults";
            String FORUMMAIN = PAGE + "/forumMain";
            String CHAT = PAGE + "/chat";
            String WEBIM = PAGE + "/webim";
        }
    }

    interface PATH {
        String BASE = "/backend";

        /**
         * 主页
         */
        interface INDEX {
            String INDEXVIEW = BASE + "/index";
            String INDEX_V5 = BASE + "/index_v5";
        }

        /**
         * 注册
         */
        interface REGISTER {
            String REGISTER = BASE + "/common";
            String REGISTERVIEW = REGISTER + "/register";
        }

        /**
         * 登陆
         */
        interface LOGIN {
            String LOGIN = BASE + "/common";
            String LOGINVIEW = LOGIN + "/login";
            String LOGINVIEWV = LOGIN + "/login_v";
            String LOCKSCREEN=LOGIN+"/lockscreen";
        }

        /**
         * 图表
         */
        interface GRAPH {
            String GRAPH = BASE + "/graph";
            String ECHARTS = GRAPH + "/echarts";
            String FLOT = GRAPH + "/flot";
            String METRICS = GRAPH + "/metrics";
            String MORRIS = GRAPH + "/morris";
            String PEITY = GRAPH + "/peity";
            String RICKSHAW = GRAPH + "/rickshaw";
            String SPARKLINE = GRAPH + "/sparkline";
        }

        /**
         * 相册
         */
        interface PHOTO {
            String PHOTO = BASE + "/photo";
            String BASIC = PHOTO + "/basicGallery";
            String CAROUSEL = PHOTO + "/carousel";
            String BLUEIMP = PHOTO + "/blueImp";
        }

        /**
         * 邮箱
         */
        interface MAIL {
            String MAIL = BASE + "/mail";
            String MAILBOX = MAIL + "/mailBoxs";
            String MAILDETAIL = MAIL + "/mailDetail";
            String MAILCOMPOSE = MAIL + "/mailCompose";
        }

        /**
         * 表格
         */
        interface TABLE {
            String TABLE = BASE + "/table";
            String TABLEBASIC = TABLE + "/tableBasic";
            String TABLEBOOTSTRAP = TABLE + "/tableBootstrap";
            String TABLEDATA = TABLE + "/tableData";
            String TABLEFOO = TABLE + "/tableFoo";
            String TABLEJQGRID = TABLE + "/tableJqgrid";
        }

        /**
         * 表单
         */
        interface FORM {
            String FORM = BASE+"/form";
            String BASIC = FORM + "/basic";
            String AVATAR = FORM + "/avatar";
            String ADVANCED = FORM + "/advanced";
            String BUILDER = FORM + "/builder";
            String EDITORS = FORM + "/editors";
            String FILEUPLOAD = FORM + "/fileUpload";
            String MARKDOWN = FORM + "/markdown";
            String SIMDITOR = FORM + "/simditor";
            String VALIDATE = FORM + "/validate";
            String WEBUPLOADER = FORM + "/webuploader";
            String WIZARD = FORM + "/wizard";
            String SUGGEST = FORM + "/suggest";
            String LAYERDATE = FORM + "/layerdate";
        }

        /**
         * 工具
         */
        interface TOOL {
            String TOOL = BASE;
            String CSSVIEW = TOOL + "/cssAnimation";
            String FORMBUILDERVIEW = TOOL + "/formBuilder";
        }

        /**
         * UI
         */
        interface UI {
            String UI = BASE + "/ui";
            String TYPOGRAPHY = UI + "/typography";
            String FONTAWESOME = UI + "/fontawesome";
            String GLYPHICONS = UI + "/glyphicons";
            String ICONFONT = UI + "/iconfont";
            String DRAGGABLEPANELS = UI + "/draggablePanels";
            String AGILEBOARD = UI + "/agileBoard";
            String BUTTONS = UI + "/buttons";
            String TABSPANELS = UI + "/tabsPanels";
            String NOTIFICATIONSS = UI + "/notifications";
            String BADGESLABELS = UI + "/badgesLabels";
            String GRIDOPTIONS = UI + "/gridOptions";
            String PLYR = UI + "/plyr";
            String SWEETALERT = UI + "/sweetalert";
            String NESTABLE = UI + "/nestable";
            String TOASTER = UI + "/toastr";
            String DIFF = UI + "/diff";
            String SPINNERS = UI + "/spinners";
            String WIDGETS = UI + "/widgets";
        }

        /**
         * Page
         */
        interface PAGE {
            String PAGE = BASE + "/page";
            String CONTACTS = PAGE + "/contacts";
            String ARTICLE = PAGE + "/article";
            String BLOG = PAGE + "/blog";
            String CALENDAR = PAGE + "/calendar";
            String CLIENTS = PAGE + "/clients";
            String FILEMANAGER = PAGE + "/fileManager";
            String PROFILE = PAGE + "/profile";
            String PROJECTDETAIL = PAGE + "/projectDetail";
            String PROJECTS = PAGE + "/projects";
            String SOCIALFEED = PAGE + "/socialFeed";
            String TEAMSBOARD = PAGE + "/teamsBoard";
            String FAQ = PAGE + "/faq";
            String TIMELINE = PAGE + "/timeline";
            String TIMELINE2 = PAGE + "/timeline_v2";
            String PINBOARD = PAGE + "/pinBoard";
            String INVOICE = PAGE + "/invoice";
            String INVOICEPRINT = PAGE + "/invoicePrint";
            String SEARCHRESULTS = PAGE + "/searchResults";
            String FORUMMAIN = PAGE + "/forumMain";
            String CHAT = PAGE + "/chat";
            String WEBIM = PAGE + "/webim";
        }
    }
}
