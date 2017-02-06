
/**
 * ajax�ļ򵥷�װ
 * @author hq 2017/2/6
 * @type {{doPost: Function}}
 */
var easyAjax = {
    /**
     * ִ��post����
     * @param data ����
     * @param successFun ����ɹ��ŷ���
     * @return ���Ϊjson��ʽ
     */
    doPost: function (url, data, successFun) {
        $.ajax({
            type: 'post',
            url: url,
            data: data,
            cache: false,
            dataType: 'json',
            async: true,
            success: function (jsonData) { //��Ӧ����
                successFun(jsonData);
            },
            error: function () {
                alert("��Ǹ����������ʧ�ܣ����Ժ�����");
            }
        });
    },


    /**
     * ie�µ�ajax-doget
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





