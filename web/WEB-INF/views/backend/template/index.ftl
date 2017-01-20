<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
<#--    <meta http-equiv="Cache-Control" content="no-siteapp" />-->
    <title>微光 后台 - 主页</title>
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/static/backend/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/static/backend/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/backend/css/animate.min.css" rel="stylesheet">
    <link href="/static/backend/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span><img alt="image" class="img-circle" src="/static/backend/img/pikaqiu1.png"/></span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">silk</strong></span>
                                <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
                                </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a class="J_menuItem" href="/backend/template/form/avatar">修改头像</a>
                            </li>
                            <li><a class="J_menuItem" href="/backend/template/page/profile">个人资料</a>
                            </li>
                            <li><a class="J_menuItem" href="/backend/template/page/contacts">联系我们</a>
                            </li>
                            <li><a class="J_menuItem" href="/backend/template/mailBox">信箱</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="login.html">安全退出</a>
                            </li>
                        </ul>
                    </div>
                    <div class="logo-element">Shine
                    </div>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-home"></i>
                        <span class="nav-label">主页</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="/backend/template/index_v5" data-index="0">主页示例一</a>
                        </li>
                    <#--             <li>
                                     <a class="J_menuItem" href="backend/index_v2.html">主页示例二</a>
                                 </li>
                                 <li>
                                     <a class="J_menuItem" href="backend/index_v3.html">主页示例三</a>
                                 </li>
                                 <li>
                                     <a class="J_menuItem" href="backend/index_v4.html">主页示例四</a>
                                 </li>
                                 <li>
                                     <a href="backend/index_v5.html" target="_blank">主页示例五</a>
                                 </li>-->
                    </ul>

                </li>
                <li>
                    <a href="#">
                        <i class="fa fa fa-bar-chart-o"></i>
                        <span class="nav-label">统计图表</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="/backend/template/graph/echarts">百度ECharts</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="/backend/template/graph/flot">Flot</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="/backend/template/graph/morris">Morris.js</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="/backend/template/graph/rickshaw">Rickshaw</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="/backend/template/graph/peity">Peity</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="/backend/template/graph/sparkline">Sparkline</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="/backend/template/graph/metrics">图表组合</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="mailbox.html"><i class="fa fa-envelope"></i> <span class="nav-label">信箱 </span><span
                            class="label label-warning pull-right">16</span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/backend/template/mailBox">收件箱</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/mailDetail">查看邮件</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/mailCompose">写信</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">表单</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/backend/template/form/basic">基本表单</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/form/validate">表单验证</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/form/advanced">高级插件</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/form/wizard">表单向导</a>
                        </li>
                        <li>
                            <a href="#">文件上传 <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li><a class="J_menuItem" href="/backend/template/form/webuploader">百度WebUploader</a>
                                </li>
                                <li><a class="J_menuItem" href="/backend/template/form/fileUpload">DropzoneJS</a>
                                </li>
                                <li><a class="J_menuItem" href="/backend/template/form/avatar">头像裁剪上传</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">编辑器 <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li><a class="J_menuItem" href="/backend/template/form/editors">富文本编辑器</a>
                                </li>
                                <li><a class="J_menuItem" href="/backend/template/form/simditor">simditor</a>
                                </li>
                                <li><a class="J_menuItem" href="/backend/template/form/markdown">MarkDown编辑器</a>
                                </li>
                                <li><a class="J_menuItem" href="/backend/template/form/editors">代码编辑器</a>
                                </li>
                            </ul>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/form/suggest">搜索自动补全</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/form/layerdate">日期选择器layerDate</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-desktop"></i> <span class="nav-label">页面</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/backend/template/page/contacts">联系人</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/page/profile">个人资料</a>
                        </li>
                        <li>
                            <a href="#">项目管理 <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li><a class="J_menuItem" href="/backend/template/page/projects">项目</a>
                                </li>
                                <li><a class="J_menuItem" href="/backend/template/page/projectDetail">项目详情</a>
                                </li>
                            </ul>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/page/teamsBoard">团队管理</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/page/socialFeed">信息流</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/page/clients">客户管理</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/page/fileManager">文件管理器</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/page/calendar">日历</a>
                        </li>
                        <li>
                            <a href="#">博客 <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li><a class="J_menuItem" href="/backend/template/page/blog">文章列表</a>
                                </li>
                                <li><a class="J_menuItem" href="/backend/template/page/article">文章详情</a>
                                </li>
                            </ul>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/page/faq">FAQ</a>
                        </li>
                        <li>
                            <a href="#">时间轴 <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li><a class="J_menuItem" href="/backend/template/page/timeline">时间轴</a>
                                </li>
                                <li><a class="J_menuItem" href="/backend/template/page/timeline_v2">时间轴v2</a>
                                </li>
                            </ul>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/page/pinBoard">标签墙</a>
                        </li>
                        <li>
                            <a href="#">单据 <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li><a class="J_menuItem" href="/backend/template/page/invoice">单据</a>
                                </li>
                                <li><a class="J_menuItem" href="/backend/template/page/invoicePrint">单据打印</a>
                                </li>
                            </ul>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/page/searchResults">搜索结果</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/page/forumMain">论坛</a>
                        </li>
                        <li>
                            <a href="#">即时通讯 <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li><a class="J_menuItem" href="/backend/template/page/chat">聊天窗口</a>
                                </li>
                                <li><a class="J_menuItem" href="/backend/template/page/webim">layIM</a>
                                </li>
                            </ul>
                        </li>

               <#--         <li><a class="J_menuItem" href="404.html">404页面</a>
                        </li>
                        <li><a class="J_menuItem" href="500.html">500页面</a>
                        </li>
                        <li><a class="J_menuItem" href="empty_page.html">空白页</a>-->
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-flask"></i> <span class="nav-label">UI元素</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/backend/template/ui/typography">排版</a>
                        </li>
                        <li>
                            <a href="#">字体图标 <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li>
                                    <a class="J_menuItem" href="/backend/template/ui/fontawesome">Font Awesome</a>
                                </li>
                                <li>
                                    <a class="J_menuItem" href="/backend/template/ui/glyphicons">Glyphicon</a>
                                </li>
                                <li>
                                    <a class="J_menuItem" href="/backend/template/ui/iconfont">阿里巴巴矢量图标库</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">拖动排序 <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li><a class="J_menuItem" href="/backend/template/ui/draggablePanels">拖动面板</a>
                                </li>
                                <li><a class="J_menuItem" href="/backend/template/ui/agileBoard">任务清单</a>
                                </li>
                            </ul>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/ui/buttons">按钮</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/ui/tabsPanels">选项卡 &amp; 面板</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/ui/notifications">通知 &amp; 提示</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/ui/badgesLabels">徽章，标签，进度条</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/ui/gridOptions">栅格</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/ui/plyr">视频、音频</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/ui/sweetalert">弹窗SweetAlert</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/ui/nestable">树形视图nestable</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/ui/toastr">Toastr通知</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/ui/diff">文本对比</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/ui/spinners">加载动画</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/ui/widgets">小部件</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-table"></i> <span class="nav-label">表格</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/backend/template/tableBasic">基本表格</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/tableDate">DataTables</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/tableJqgrid">jqGrid</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/tableFoo">Foo Tables</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/tableBootstrap">Bootstrap Table
                            <span class="label label-danger pull-right">推荐</span></a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-picture-o"></i> <span class="nav-label">相册</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/backend/template/photo/basic">基本图库</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/photo/carousel">图片切换</a>
                        </li>
                        <li><a class="J_menuItem" href="/backend/template/photo/blueimp">Blueimp相册</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-cutlery"></i> <span class="nav-label">工具 </span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="/backend/template/formBuilder">表单构建器</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="/backend/template/cssAnimation">
                                <i class="fa fa-magic"></i>
                                <span class="nav-label">CSS动画</span>
                            </a>
                        </li>
                    </ul>
                </li>

            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i
                        class="fa fa-bars"></i> </a>

                    <form role="search" class="navbar-form-custom" method="post"
                          action="http://www.zi-han.net/theme/hplus/search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search"
                                   id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-envelope"></i> <span class="label label-warning">16</span>
                        </a>
                        <ul class="dropdown-menu dropdown-messages">
                            <li class="m-t-xs">
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="/static/backend/img/pikaqiu1.png">
                                    </a>

                                    <div class="media-body">
                                        <small class="pull-right">46小时前</small>
                                        <strong>silk</strong> shine正式启动
                                        <br>
                                        <small class="text-muted"> 2016.12.4</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="/static/backend/img/pikaqiu1.png">
                                    </a>

                                    <div class="media-body ">
                                        <small class="pull-right text-navy">25小时前</small>
                                        <strong>silk</strong>shine 后台界面启动开发
                                        <br>
                                        <small class="text-muted">2016.12.5</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a class="J_menuItem" href="mailbox.html">
                                        <i class="fa fa-envelope"></i> <strong> 查看所有消息</strong>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-bell"></i> <span class="label label-primary">8</span>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="mailbox.html">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> 您有16条未读消息
                                        <span class="pull-right text-muted small">4分钟前</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="profile.html">
                                    <div>
                                        <i class="fa fa-qq fa-fw"></i> 3条新回复
                                        <span class="pull-right text-muted small">12分钟钱</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a class="J_menuItem" href="notifications.html">
                                        <strong>查看所有 </strong>
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                <#-- <li class="hidden-xs">
                     <a href="index_v1.html" class="J_menuItem" data-index="0"><i class="fa fa-cart-arrow-down"></i> 购买</a>
                 </li>-->
                    <li class="dropdown hidden-xs">
                        <a class="right-sidebar-toggle" aria-expanded="false">
                            <i class="fa fa-tasks"></i> 主题
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="index_v1.html">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="login.html" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="/backend/template/index_v5" frameborder="0"
                    data-id="index_v1.html" seamless></iframe>
        </div>
        <div class="footer">
            <div class="pull-right">&copy; 2016 <a href="http://www.zi-han.net/" target="_blank">shine</a>
            </div>
        </div>
    </div>
    <!--右侧部分结束-->
    <!--右侧边栏开始-->
    <div id="right-sidebar">
        <div class="sidebar-container">

            <ul class="nav nav-tabs navs-3">

                <li class="active">
                    <a data-toggle="tab" href="#tab-1">
                        <i class="fa fa-gear"></i> 主题
                    </a>
                </li>
                <li class=""><a data-toggle="tab" href="#tab-2">
                    通知
                </a>
                </li>
                <li><a data-toggle="tab" href="#tab-3">
                    项目进度
                </a>
                </li>
            </ul>

            <div class="tab-content">
                <div id="tab-1" class="tab-pane active">
                    <div class="sidebar-title">
                        <h3><i class="fa fa-comments-o"></i> 主题设置</h3>
                        <small><i class="fa fa-tim"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
                    </div>
                    <div class="skin-setttings">
                        <div class="title">主题设置</div>
                        <div class="setings-item">
                            <span>收起左侧菜单</span>

                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox"
                                           id="collapsemenu">
                                    <label class="onoffswitch-label" for="collapsemenu">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span>固定顶部</span>

                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox"
                                           id="fixednavbar">
                                    <label class="onoffswitch-label" for="fixednavbar">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                                <span>
                        固定宽度
                    </span>

                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox"
                                           id="boxedlayout">
                                    <label class="onoffswitch-label" for="boxedlayout">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="title">皮肤选择</div>
                        <div class="setings-item default-skin nb">
                                <span class="skin-name ">
                         <a href="#" class="s-skin-0">
                             默认皮肤
                         </a>
                    </span>
                        </div>
                        <div class="setings-item blue-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-1">
                            蓝色主题
                        </a>
                    </span>
                        </div>
                        <div class="setings-item yellow-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-3">
                            黄色/紫色主题
                        </a>
                    </span>
                        </div>
                    </div>
                </div>
                <div id="tab-2" class="tab-pane">

                    <div class="sidebar-title">
                        <h3><i class="fa fa-comments-o"></i> 最新通知</h3>
                        <small><i class="fa fa-tim"></i> 您当前有10条未读信息</small>
                    </div>

                    <div>

                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="/static/backend/img/a1.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">

                                    据天津日报报道：瑞海公司董事长于学伟，副董事长董社轩等10人在13日上午已被控制。
                                    <br>
                                    <small class="text-muted">今天 4:21</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="/static/backend/img/a2.jpg">
                                </div>
                                <div class="media-body">
                                    HCY48之音乐大魔王会员专属皮肤已上线，快来一键换装拥有他，宣告你对华晨宇的爱吧！
                                    <br>
                                    <small class="text-muted">昨天 2:45</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="/static/backend/img/a3.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">
                                    写的好！与您分享
                                    <br>
                                    <small class="text-muted">昨天 1:10</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="/static/backend/img/a4.jpg">
                                </div>

                                <div class="media-body">
                                    国外极限小子的炼成！这还是亲生的吗！！
                                    <br>
                                    <small class="text-muted">昨天 8:37</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="/static/backend/img/a8.jpg">
                                </div>
                                <div class="media-body">

                                    一只流浪狗被收留后，为了减轻主人的负担，坚持自己觅食，甚至......有些东西，可能她比我们更懂。
                                    <br>
                                    <small class="text-muted">今天 4:21</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="/static/backend/img/a7.jpg">
                                </div>
                                <div class="media-body">
                                    这哥们的新视频又来了，创意杠杠滴，帅炸了！
                                    <br>
                                    <small class="text-muted">昨天 2:45</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="/static/backend/img/a3.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">
                                    最近在补追此剧，特别喜欢这段表白。
                                    <br>
                                    <small class="text-muted">昨天 1:10</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="/static/backend/img/a4.jpg">
                                </div>
                                <div class="media-body">
                                    我发起了一个投票 【你认为下午大盘会翻红吗？】
                                    <br>
                                    <small class="text-muted">星期一 8:37</small>
                                </div>
                            </a>
                        </div>
                    </div>

                </div>
                <div id="tab-3" class="tab-pane">

                    <div class="sidebar-title">
                        <h3><i class="fa fa-cube"></i> 最新任务</h3>
                        <small><i class="fa fa-tim"></i> 您当前有14个任务，10个已完成</small>
                    </div>

                    <ul class="sidebar-list">
                        <li>
                            <a href="#">
                                <div class="small pull-right m-t-xs">9小时以后</div>
                                <h4>市场调研</h4> 按要求接收教材；

                                <div class="small">已完成： 22%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                </div>
                                <div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small pull-right m-t-xs">9小时以后</div>
                                <h4>可行性报告研究报上级批准 </h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对

                                <div class="small">已完成： 48%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 48%;" class="progress-bar"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small pull-right m-t-xs">9小时以后</div>
                                <h4>立项阶段</h4> 东风商用车公司 采购综合综合查询分析系统项目进度阶段性报告武汉斯迪克科技有限公司

                                <div class="small">已完成： 14%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-primary pull-right">NEW</span>
                                <h4>设计阶段</h4>
                                <!--<div class="small pull-right m-t-xs">9小时以后</div>-->
                                项目进度报告(Project Progress Report)
                                <div class="small">已完成： 22%</div>
                                <div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small pull-right m-t-xs">9小时以后</div>
                                <h4>拆迁阶段</h4> 科研项目研究进展报告 项目编号: 项目名称: 项目负责人:

                                <div class="small">已完成： 22%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                </div>
                                <div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small pull-right m-t-xs">9小时以后</div>
                                <h4>建设阶段 </h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对

                                <div class="small">已完成： 48%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 48%;" class="progress-bar"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small pull-right m-t-xs">9小时以后</div>
                                <h4>获证开盘</h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对

                                <div class="small">已完成： 14%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                                </div>
                            </a>
                        </li>

                    </ul>

                </div>
            </div>

        </div>
    </div>
    <!--右侧边栏结束-->
    <!--mini聊天窗口开始-->
    <div class="small-chat-box fadeInRight animated">

        <div class="heading" draggable="true">
            <small class="chat-date pull-right">
                2016.12.2
            </small>
            与 silk 聊天中
        </div>

        <div class="content">

            <div class="left">
                <div class="author-name">
                    silk
                    <small class="chat-date">
                        10:02
                    </small>
                </div>
                <div class="chat-message active">
                    你好，欢迎来到微光
                </div>

            </div>
            <div class="right">
                <div class="author-name">
                    游客
                    <small class="chat-date">
                        10:03
                    </small>
                </div>
                <div class="chat-message">
                    你好，请问我怎么联系到你们呢？
                </div>
            </div>
            <div class="left">
                <div class="author-name">
                    silk
                    <small class="chat-date">
                        10:04
                    </small>
                </div>
                <div class="chat-message active">
                    你可以加QQ747037402
                </div>
            </div>
            <div class="right">
                <div class="author-name">
                    游客
                    <small class="chat-date">
                        10:05
                    </small>
                </div>
                <div class="chat-message">
                    哦~谢谢哈
                </div>
            </div>
            <div class="left">
                <div class="author-name">
                    silk
                    <small class="chat-date">
                        10:05
                    </small>
                </div>
                <div class="chat-message active">
                    不用谢~
                </div>
            </div>


        </div>
        <div class="form-chat">
            <div class="input-group input-group-sm">
                <input type="text" class="form-control"> <span class="input-group-btn"> <button
                    class="btn btn-primary" type="button">发送
            </button> </span>
            </div>
        </div>

    </div>
    <div id="small-chat">
        <span class="badge badge-warning pull-right">5</span>
        <a class="open-small-chat">
            <i class="fa fa-comments"></i>

        </a>
    </div>
</div>
<script src="/static/backend/js/jquery.min.js?v=2.1.4"></script>
<script src="/static/backend/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/static/backend/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="/static/backend/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="/static/backend/js/plugins/layer/layer.min.js"></script>
<script src="/static/backend/js/hplus.min.js?v=4.1.0"></script>
<script type="text/javascript" src="/static/backend/js/contabs.min.js"></script>
<script src="/static/backend/js/plugins/pace/pace.min.js"></script>
</body>
</html>