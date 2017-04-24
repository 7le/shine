<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shine记账</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="/static/backend/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/static/backend/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/backend/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="/static/backend/css/animate.min.css" rel="stylesheet">
    <link href="/static/backend/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <script src="/static/backend/js/jquery.min.js?v=2.1.4"></script>
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
                            <a class="btn btn-outline btn-default J_menuItem" href="/backend/account/add">
                                <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
                            </a>
                            <a class="btn btn-outline btn-default J_menuItem">
                                <i class="glyphicon glyphicon-heart" aria-hidden="true"></i>
                            </a>
                            <a class="btn btn-outline btn-default J_menuItem"
                               href="/backend/account/58f8b70ad7207c583855e927">
                                <i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>
                            </a>
                            <a class="btn btn-outline btn-default">
                                <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
                            </a>
                        </div>
                        <table id="exampleTableToolbar" data-mobile-responsive="true">
                            <thead>
                            <tr>
                                <th class="check-header hidden-xs">
                                    <label>
                                        <input id="checkAll" name="checkAll" type="checkbox" readonly>
                                    </label>
                                </th>
                                <th data-field="name">项目名</th>
                                <th data-field="totalAmount">总金额</th>
                                <th data-field="cost">成本</th>
                                <th data-field="profit">利润</th>
                                <th data-field="profit_silk">利润-stone</th>
                                <th data-field="profit_stone">利润-silk</th>
                                <th data-field="remark">备注</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list accountList.rows as item>
                            <input type="text" style="display:none" value="${(item.sid)!''}"/>
                            <tr>
                                <td><input type="checkbox" value="${(item.sid)!''}"></td>
                                <td>${(item.name)!''}</td>
                                <td>${(item.totalAmount)!''}</td>
                                <td>${(item.cost)!''}</td>
                                <td>${(item.profit)!''}</td>
                                <td>${(item.profitStone)!''}</td>
                                <td>${(item.profitSilk)!''}</td>
                                <td>${(item.remark)!''}</td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                        <table id="mytab" class="table table-hover"></table>
                    </div>
                </div>
                <!-- End Example Toolbar -->
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function() {
        //根据窗口调整表格高度
        $(window).resize(function() {
            $('#mytab').bootstrapTable('resetView', {
                height: tableHeight()
            })
        })

        $('#mytab').bootstrapTable({
            url: "/backend/account",//数据源
            dataField: "rows",//服务端返回数据键值 就是说记录放的键值是rows，分页时使用总记录数的键值为total
            height: tableHeight(),//高度调整
            search: true,//是否搜索
            pagination: true,//是否分页
            pageSize: 1,//单页记录数
            pageList: [5, 10, 20, 50],//分页步进值
            sidePagination: "server",//服务端分页
            contentType: "application/x-www-form-urlencoded",//请求数据内容格式 默认是 application/json 自己根据格式自行服务端处理
            dataType: "json",//期待返回数据类型
            method: "get",//请求方式
            searchAlign: "left",//查询框对齐方式
            queryParamsType: "limit",//查询参数组织方式
            queryParams: function getParams(params) {
                //params obj
                params.other = "otherInfo";
                return params;
            },
            searchOnEnterKey: false,//回车搜索
            showRefresh: true,//刷新按钮
            showColumns: true,//列选择按钮
            buttonsAlign: "left",//按钮对齐方式
            toolbar: "#toolbar",//指定工具栏
            toolbarAlign: "right",//工具栏对齐方式
            columns: [
                {
                    title: "全选",
                    field: "select",
                    checkbox: true,
                    width: 20,//宽度
                    align: "center",//水平
                    valign: "middle"//垂直
                },
                {
                    title: "项目名",//标题
                    field: "name",//键名
                    sortable: true,//是否可排序
                    order: "desc"//默认排序方式
                },
                {
                    title: "总金额",
                    field: "totalAmount",
                    sortable: true
                    //titleTooltip: "this is name"
                },
                {
                    title: "成本",
                    field: "cost",
                    sortable: true
                },
                {
                    title: "利润",
                    field: "profit",
                    sortable: true
                },
                {
                    title: "利润-stone",
                    field: "profit_stone",
                    sortable: true
                },
                {
                    title: "利润_silk",
                    field: "profit-silk",
                    sortable: true
                },
                {
                    title: "备注",
                    field: "remark",
                    sortable: true
                }
                /*{
                    field: "info",
                    title: "INFO[using-formatter]",
                    formatter: 'infoFormatter'  //对本列数据做格式化
                }*/
            ],
            onClickRow: function(row, $element) {
                //$element是当前tr的jquery对象
                $element.css("background-color", "green");
            },//单击row事件
            locale: "zh-CN",//中文支持
            detailView: false, //是否显示详情折叠
            detailFormatter: function(index, row, element) {
                var html = '';
                $.each(row, function(key, val){
                    html += "<p>" + key + ":" + val +  "</p>"
                });
                return html;
            }
        });

        $("#addRecord").click(function(){
            alert("name:" + $("#name").val() + " age:" +$("#age").val());
        });
    });

    function tableHeight() {
        return $(window).height() - 50;
    }
    /**
     * 列的格式化函数 在数据从服务端返回装载前进行处理
     * @param  {[type]} value [description]
     * @param  {[type]} row   [description]
     * @param  {[type]} index [description]
     * @return {[type]}       [description]
     */
    function infoFormatter(value, row, index)
    {
        return "id:" + row.id + " name:" + row.name + " age:" + row.age;
    }
</script>

<!--分页插件-->
<script src="/static/backend/js/jquery.pagination.js"></script>


<script src="/static/backend/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/static/backend/js/content.min.js?v=1.0.0"></script>
<script src="/static/backend/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="/static/backend/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="/static/backend/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="/static/backend/js/demo/bootstrap-table-demo.min.js"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>
