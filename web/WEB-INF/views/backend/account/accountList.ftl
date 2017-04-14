<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shine - Bootstrap Table</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="/static/backend/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/static/backend/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/backend/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="/static/backend/css/animate.min.css" rel="stylesheet">
    <link href="/static/backend/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <!-- Panel Other -->
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>Shine记账</h5>

            <div class="ibox-tools">
                <a class="collapse-link">
                    <i class="fa fa-chevron-up"></i>
                </a>
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-wrench"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#">选项1</a>
                    </li>
                    <li><a href="#">选项2</a>
                    </li>
                </ul>
                <a class="close-link">
                    <i class="fa fa-times"></i>
                </a>
            </div>
        </div>
        <div class="ibox-content">
            <div class="row row-lg">
                <!-- Example Toolbar -->
                <div class="example-wrap">
                    <h4 class="example-title">小账本</h4>

                    <div class="example">
                        <div class="btn-group hidden-xs" id="exampleToolbar" role="group">
                            <a class="btn btn-outline btn-default J_menuItem" href="/backend/account/add" >
                                <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
                            </a>
                            <button type="button" class="btn btn-outline btn-default">
                                <i class="glyphicon glyphicon-heart" aria-hidden="true"></i>
                            </button>
                            <button type="button" class="btn btn-outline btn-default">
                                <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
                            </button>
                        </div>
                        <table id="exampleTableToolbar" data-mobile-responsive="true">
                            <thead>
                            <tr>
                                <th data-field="name">名称</th>
                                <th data-field="star">Star</th>
                                <th data-field="license">许可</th>
                                <th data-field="description">描述</th>
                                <th data-field="url">地址</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>
                <!-- End Example Toolbar -->
            </div>
        </div>
    </div>
</div>
<script src="/static/backend/js/jquery.min.js?v=2.1.4"></script>
<script src="/static/backend/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/static/backend/js/content.min.js?v=1.0.0"></script>
<script src="/static/backend/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="/static/backend/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="/static/backend/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="/static/backend/js/demo/bootstrap-table-demo.min.js"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>
