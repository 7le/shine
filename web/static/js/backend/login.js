/**
 * 用户登录
 * Created by hq on 2017/2/6.
 */



/*
 $(function () {

 //图片验证码事件注册
 new ImgVerifyCodeHandler("verifyCode-img");

 });
 */


/**
 * 提交
 */
function submit() {

    var $loginName = $("#login-loginName");
    var $password = $("#login-password");

    if ($loginName.val() == "") {
        swal("欢迎使用Shine", "请输入用户名","error");
        return;
    }
    if ($password.val() == "") {
        swal("欢迎使用Shine", "请输入密码","error");
        return;
    }

    easyAjax.doPost(
        "/backend/doLogin",
        {
            loginName: $loginName.val(),
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
                swal("欢迎使用Shine", result.message,"error");
            }
        }
    );

}


//回车登录
document.onkeydown = function (event) {
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if (e && e.keyCode == 13) { // enter 键

        //信息检查
        var loginName = $("#loginName").val();
        var password = $("#password").val();

        if (loginName == "" || password == "") {
        } else {
            // enter 键
            $('#btn-login-submit').click();
        }
    }
};