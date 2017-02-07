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

            <#list >



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