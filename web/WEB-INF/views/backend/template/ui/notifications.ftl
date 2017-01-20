<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>Shine - 通知 &amp; 提示</title>

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/static/backend/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/static/backend/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/backend/css/animate.min.css" rel="stylesheet">
    <link href="/static/backend/css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeIn">
    <div class="row">
        <div class="col-sm-6">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>警告框</h5>

                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="notifications.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="notifications.html#">选项1</a>
                            </li>
                            <li><a href="notifications.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div class="alert alert-success">
                        H+是一个很棒的后台UI框架 <a class="alert-link" href="notifications.html#">了解更多</a>.
                    </div>
                    <div class="alert alert-info">
                        H+是一个很棒的后台UI框架 <a class="alert-link" href="notifications.html#">了解更多</a>.
                    </div>
                    <div class="alert alert-warning">
                        H+是一个很棒的后台UI框架 <a class="alert-link" href="notifications.html#">了解更多</a>.
                    </div>
                    <div class="alert alert-danger">
                        H+是一个很棒的后台UI框架 <a class="alert-link" href="notifications.html#">了解更多</a>.
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>带关闭按钮的警告框</h5>

                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="notifications.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="notifications.html#">选项1</a>
                            </li>
                            <li><a href="notifications.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div class="alert alert-success alert-dismissable">
                        <button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button>
                        H+是一个很棒的后台UI框架 <a class="alert-link" href="notifications.html#">了解更多</a>.
                    </div>
                    <div class="alert alert-info alert-dismissable">
                        <button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button>
                        H+是一个很棒的后台UI框架 <a class="alert-link" href="notifications.html#">了解更多</a>.
                    </div>
                    <div class="alert alert-warning alert-dismissable">
                        <button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button>
                        H+是一个很棒的后台UI框架 <a class="alert-link" href="notifications.html#">了解更多</a>.
                    </div>
                    <div class="alert alert-danger alert-dismissable">
                        <button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button>
                        H+是一个很棒的后台UI框架 <a class="alert-link" href="notifications.html#">了解更多</a>.
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>工具提示</h5>

                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="notifications.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="notifications.html#">选项1</a>
                            </li>
                            <li><a href="notifications.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content text-center">
                    <h4>工具提示示例
                        <small>深色背景</small>
                    </h4>
                    <div class="tooltip-demo">
                        <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="left"
                                title="这里是提示内容">左侧提示
                        </button>
                        <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="top"
                                title="这里是提示内容">顶部提示
                        </button>
                        <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="bottom"
                                title="这里是提示内容">底部提示
                        </button>
                        <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="right"
                                title="这里是提示内容">右侧提示
                        </button>
                    </div>
                    <br>
                    <h4>工具提示 - 单击提示</h4>

                    <div class="tooltip-demo">
                        <button type="button" class="btn btn-primary" data-container="body" data-toggle="popover"
                                data-placement="left" data-content="这里是提示内容">
                            左侧提示
                        </button>
                        <button type="button" class="btn btn-primary" data-container="body" data-toggle="popover"
                                data-placement="top" data-content="这里是提示内容">
                            顶部提示
                        </button>
                        <button type="button" class="btn btn-primary" data-container="body" data-toggle="popover"
                                data-placement="bottom" data-content="这里是提示内容">
                            底部提示
                        </button>
                        <button type="button" class="btn btn-primary" data-container="body" data-toggle="popover"
                                data-placement="right" data-content="这里是提示内容">
                            右侧提示
                        </button>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>


<script src="/static/backend/js/jquery.min.js?v=2.1.4"></script>
<script src="/static/backend/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/static/backend/js/content.min.js?v=1.0.0"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>