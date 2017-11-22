<#include '../cms_common/header.ftl'>

<link href="/cms/css/calendar_page.css" rel="stylesheet"/>
<link href="/cms/css/common.css" rel="stylesheet"/>

<#include 'stockRate.ftl'>


<div class="" style="margin-top:40px; margin-left: 50px;margin-right: 450px;">


    <ul id="myTab" class="nav nav-tabs">
        <li class="active"><a href="#global" data-toggle="tab">宏观</a></li>
        <li><a href="#a_stock" data-toggle="tab">A股</a></li>
        <li><a href="#us_stock" data-toggle="tab">美股</a></li>
        <li><a href="#forex" data-toggle="tab">外汇</a></li>
        <li><a href="#commodity" data-toggle="tab">商品</a></li>
    </ul>

    <div id="myTabContent" class="tab-content">
        <div style="margin-top: 20px"><span class="glyphicon glyphicon-time"></span>
            <span id="curDate"></span>&nbsp;
            <span id="curTime" style="font-size : 1.1em"></span>
        </div>

        <div class="tab-pane fade in active" id="global">
            <table id="global_table"></table>
        </div>

        <div class="tab-pane fade" id="a_stock">
            <table id="a_stock_table"></table>
        </div>

        <div class="tab-pane fade" id="us_stock">
            <table id="us_stock_table"></table>
        </div>

        <div class="tab-pane fade" id="forex">
            <table id="forex_table"></table>
        </div>

        <div class="tab-pane fade" id="commodity">
            <table id="commodity_table"></table>
        </div>
    </div>
    <script type="text/babel">
        //补位 当某个字段不是两位数时补0
        function fnW(str) {
            var num;
            str > 10 ? num = str : num = "0" + str;
            return num;
        }

        $(function () {
            $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
                // 获取已激活的标签页的名称
                var activeTab = $(e.target).text();
                // 获取前一个激活的标签页的名称
                var previousTab = $(e.relatedTarget).text();
                $(".active-tab span").html(activeTab);
                $(".previous-tab span").html(previousTab);
            });


            setInterval(function () {
                var date = new Date();
                var year = date.getFullYear();//当前年份
                var month = date.getMonth();//当前月份
                var data = date.getDate();//天
                var hours = date.getHours();//小时
                var minute = date.getMinutes();//分
                var second = date.getSeconds();//秒
                var curDate = year + "-" + fnW((month + 1)) + "-" + fnW(data);
                var curTime = fnW(hours) + ":" + fnW(minute) + ":" + fnW(second);
                document.getElementById("curDate").innerHTML = curDate;
                document.getElementById("curTime").innerHTML = curTime;
            }, 1000);


        })
        ;


    </script>

</div>


<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:500px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">用户登录</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="box-body">
                        <div class="form-group"></div>
                        <div class="form-group">
                            <label for="userName" class="col-sm-2 control-label">用户名:</label>

                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="userName" placeholder="用户名">
                            </div>
                        </div>
                        <div class="form-group"></div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码:</label>

                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="password" placeholder="密码">
                            </div>
                        </div>
                        <div class="form-group"></div>

                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" id="userSave" class="btn btn-primary">登录</button>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="/cms/js/script/focus_news_page.js"></script>

<#include '../cms_common/footer.ftl'>
