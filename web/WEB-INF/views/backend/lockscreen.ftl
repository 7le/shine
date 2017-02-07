<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>Shine - 登录超时</title>

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/static/backend/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/static/backend/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/backend/css/animate.min.css" rel="stylesheet">
    <link href="/static/backend/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="/static/backend/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>

</head>

<body class="gray-bg">

    <div class="lock-word animated fadeInDown">
    </div>
    <div class="middle-box text-center lockscreen animated fadeInDown">
        <div>
            <div class="m-b-md">
                <img alt="image" class="img-circle circle-border" src="/static/backend/img/pikaqiu.jpg">
            </div>
            <h3>Silk</h3>
            <p>您需要再次输入密码</p>

                <div class="form-group">
                    <input type="password" class="form-control" id="again-password" placeholder="******" required="">
                </div>
                <button type="submit" onclick="submitAgain()" class="btn btn-primary block full-width">登录到Shine</button>

        </div>
    </div>
    <script src="/static/backend/js/jquery.min.js?v=2.1.4"></script>
    <script src="/static/backend/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="/static/js/common/validate.js"></script>
    <script src="/static/js/common/easyAjax.js"></script>
    <script src="/static/backend/js/plugins/sweetalert/sweetalert.min.js"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

    <script>
        function submitAgain() {

            var $password = $("#again-password");


            if ($password.val() == "") {
                swal({title: "欢迎使用Shine", text: "请输入密码"});
                return;
            }

            easyAjax.doPost(
                    "/backend/doLogin",
                    {
                        password: $password.val()
                    },
                    function (result) {
                        if (result.success) {

                            //跳转至用户中心界面
                            window.location.href = "/backend/index";
                        }
                        else {
                            //重新获取验证码
                            /*  $("#verifyCode-img").click();*/
                            swal({title: "欢迎使用Shine", text: result.message});
                        }
                    }
            );

        }
    </script>
</body>
</html>
