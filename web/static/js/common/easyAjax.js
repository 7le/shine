
/**
 * ajax的简单封装
 * @author hq 2017/2/6
 * @type {{doPost: Function}}
 */
var easyAjax = {
    /**
     * 执行post请求
     * @param data 数据
     * @param successFun 请求成功放方法
     * @return 结果为json格式
     */
    doPost: function (url, data, successFun) {
        $.ajax({
            type: 'post',
            url: url,
            data: data,
            cache: false,
            dataType: 'json',
            async: true,
            success: function (jsonData) { //响应数据
                successFun(jsonData);
            },
            error: function () {
                alert("抱歉，网络连接失败，请稍后再试");
            }
        });
    },


    /**
     * ie下的ajax-doget
     * @param url
     * @param callbackFun
     */
    ieDoGetJSON: function (url, callbackFun) {

        var xmlhttp;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        }
        else {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        xmlhttp.onreadystatechange = function () {

            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                callbackFun(eval('(' + xmlhttp.responseText + ')'));
            }
        }
        xmlhttp.open("get", url, true);
        xmlhttp.send();
    }


}





