$(document).ready(function () {
    $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",})
});

/**
 * 注册信息提交
 */
function reg_submit() {

    //获取元素
    var $loginName = $("#reg-loginName");
    var $password = $("#reg-password");
    var $password_again = $("#reg-rePassword");

    if ($loginName.val() == "") {
        swal("欢迎使用Shine", "请输入用户名", "error");
        return;
    }

    if ($password.val() == "") {
        swal("欢迎使用Shine", "请输入密码", "error");
        return;
    }
    if ($password.val().length < 6) {
        swal("欢迎使用Shine", "密码长度至少为6位", "error");
        return;
    }
    if (!validateRegex($password.val(), "password")) {
        swal("欢迎使用Shine", "密码格式错误", "error");
        return;
    }

    if ($password_again.val() == "") {
        swal("欢迎使用Shine", "请输入确认密码", "error");
        return;
    }
    if ($password_again.val() != $password.val()) {
        swal("欢迎使用Shine", "两次密码输入不一致", "error");
        return;
    }

    //验证通过
    easyAjax.doPost("/backend/doRegister",
        {
            loginName: $loginName.val(),
            password: $password.val()
        }
        ,
        function (result) {
            //成功
            if (result.success) {

                swal({title: "欢迎使用Shine", text: "注册成功", type: "success"}, function () {
                    //跳转至用户中心界面
                    location.href = "/backend/login";
                });

            }

            //失败
            else {
                /*   //重新获取图形验证码
                 $("#verifyCode-img").click();
                 $("#regInfo-verifycodeImg").val("");

                 //验证码原因
                 if (result.message.indexOf("图形验证码") != -1) {
                 layer.msg(result.message, layer_option);
                 $verifyCode.val();
                 return;
                 }
                 //手机验证码原因
                 else if (result.message.indexOf("手机验证码") != -1) {
                 $phoneCode.val("");
                 layer.msg(result.message, layer_option);
                 return;
                 }*/

                //其他原因
                swal("欢迎使用Shine", result.msg, "error");
            }
        }
    );
}