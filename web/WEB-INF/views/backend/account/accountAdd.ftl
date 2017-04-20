<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>小账本 添加</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="/static/backend/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/static/backend/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/backend/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="/static/backend/css/animate.min.css" rel="stylesheet">
    <link href="/static/backend/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="/static/backend/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>小账本
                        <small>添加</small>
                    </h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="form_basic.html#">选项1</a>
                            </li>
                            <li><a href="form_basic.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <form id="accAdd" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">项目名</label>

                            <div class="col-sm-10" style="width:60%">
                                <input type="text" class="form-control" name="name">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">总金额</label>

                            <div class="col-sm-10" style="width:60%">
                                <input type="text" class="form-control" name="totalAmount">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">成本</label>

                            <div class="col-sm-10" style="width:60%">
                                <input type="text" class="form-control" name="cost">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">利润</label>

                            <div class="col-sm-10" style="width:60%">
                                <input type="text" class="form-control" name="profit">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">利润-stone</label>

                            <div class="col-sm-10" style="width:60%">
                                <input type="text" class="form-control" name="profitStone">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">利润-silk</label>

                            <div class="col-sm-10" style="width:60%">
                                <input type="text" class="form-control" name="profitSilk">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">备注</label>

                            <div class="col-sm-10" style="width:60%">
                                <input type="text" class="form-control" name="remark">
                            </div>
                        </div>

                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <a class="btn btn-primary"  onclick="PostData()">保存内容</a>
                                <a class="btn btn-white">取消</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/static/backend/js/jquery.min.js?v=2.1.4"></script>
<script src="/static/backend/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/static/backend/js/content.min.js?v=1.0.0"></script>
<script src="/static/backend/js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function () {
        $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",})
    });

    function PostData() {
        $.ajax({
            type: "POST",
            url: "/backend/account",
            data: $('#accAdd').serialize(),
            success: function (data) {
                console.log(data.msg);
                swal({title: "你的小账本~", text: "添加成功", type: "success"}, function(){
                    //跳转至用户中心界面
                    location.href = "/backend/account/list";
                });
                //window.location.href = '/backend/account/list';
            },
            error: function (data) {
                swal({title: "你的小账本~", text: "不小心，失败了", type: "false"}, function(){
                    //跳转至用户中心界面
                    location.href = "/backend/account/add";
                });
            }
        });
    }
</script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<script src="/static/backend/js/plugins/sweetalert/sweetalert.min.js"></script>
</body>
</html>
