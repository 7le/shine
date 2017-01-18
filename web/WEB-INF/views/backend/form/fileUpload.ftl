<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>Shine - 文件上传</title>

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/static/backend/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/static/backend/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/backend/css/animate.min.css" rel="stylesheet">
    <link href="/static/backend/css/plugins/dropzone/basic.css" rel="stylesheet">
    <link href="/static/backend/css/plugins/dropzone/dropzone.css" rel="stylesheet">
    <link href="/static/backend/css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeIn">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>文件上传</h5>

                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="form_file_upload.fileUpload.ftl#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="form_file_upload.fileUpload.ftl#">选项1</a>
                            </li>
                            <li><a href="form_file_upload.fileUpload.ftl#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <form id="my-awesome-dropzone" class="dropzone"
                          action="http://www.zi-han.net/theme/hplus/form_file_upload.html#">
                        <div class="dropzone-previews"></div>
                        <button type="submit" class="btn btn-primary pull-right">提交</button>
                    </form>
                    <div>
                        <div class="m">
                            <small>DropzoneJS是一个开源库，提供拖放文件上传与图片预览：<a href="https://github.com/enyo/dropzone"
                                                                     target="_blank">https://github.com/enyo/dropzone</a>
                            </small>
                            ，百度前端团队提供的<a href="http://fex.baidu.com/webuploader/" target="_blank">Web Uploader</a>也是一个非常不错的选择，值得一试！
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/static/backend/js/jquery.min.js?v=2.1.4"></script>
<script src="/static/backend/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/static/backend/js/content.min.js?v=1.0.0"></script>
<script src="/static/backend/js/plugins/dropzone/dropzone.js"></script>
<script>
    $(document).ready(function () {
        Dropzone.options.myAwesomeDropzone = {
            autoProcessQueue: false,
            uploadMultiple: true,
            parallelUploads: 100,
            maxFiles: 100,
            init: function () {
                var myDropzone = this;
                this.element.querySelector("button[type=submit]").addEventListener("click", function (e) {
                    e.preventDefault();
                    e.stopPropagation();
                    myDropzone.processQueue()
                });
                this.on("sendingmultiple", function () {
                });
                this.on("successmultiple", function (files, response) {
                });
                this.on("errormultiple", function (files, response) {
                })
            }
        }
    });
</script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>
