<#include '../cms_common/header.ftl'>
<#include '../cms_common/bankRate.ftl'>
<#include '../cms_common/stockRate.ftl'>

<link href="/cms/css/calendar_page.css" rel="stylesheet"/>
<link href="/cms/css/common.css" rel="stylesheet"/>

<div id="main" style="margin-top: 40px">
    <div id="topSection" >
        <div id="calendar" style="width: 70%;margin: 0 0 0 27%;"></div>
    </div>
    <div id="eventList" style="width: 70%;margin: 0 0 0 27%;">
        <div class="container-fluid" style="margin-top: 0.5%">
            <div class="list_header row" style="margin:0">
                <div style="border-right: 1px solid #f0f0f0" class="col-lg-1">时间</div>
                <div style="border-right: 1px solid #f0f0f0" class="col-lg-2">地区</div>
                <div style="border-right: 1px solid #f0f0f0" class="col-lg-5">事件</div>
                <div style="border-right: 1px solid #f0f0f0" class="col-lg-1">重要性</div>
                <div style="border-right: 1px solid #f0f0f0" class="col-lg-1">今值</div>
                <div style="border-right: 1px solid #f0f0f0" class="col-lg-1">预期</div>
                <div class="col-lg-1">前值</div>
            </div>
            <div class="list_body" style="text-align: left;color: #333"></div>
        </div>
    </div>

</div>


<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:500px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
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


<script type="text/javascript" src="/cms/js/script/calendar_page.js"></script>
<script type="text/javascript" src="/cms/js/lib/timebar.js"></script>