<#include '../cms_common/header.ftl'>
<#include 'bankRate.ftl'>

<link href="/cms/css/calendar_page.css" rel="stylesheet"/>
<link href="/cms/css/common.css" rel="stylesheet"/>

<div id="main" style="margin-top: 40px">
    <div id="topSection" >
        <ul id="myTab" class="nav nav-tabs" style="width: 70%;margin: 0 0 20px 26%">
            <li class="active">
                <a href="#fr" data-toggle="tab">
                    美联储
                </a>
            </li>
            <li>
                <a href="#ecb" data-toggle="tab">
                    欧洲央行
                </a>
            </li>
            <li>
                <a href="#boe" data-toggle="tab">
                    英国央行
                </a>
            </li>
            <li>
                <a href="#boj" data-toggle="tab">
                    日本央行
                </a>
            </li>
            <li>
                <a href="#rba" data-toggle="tab">
                    澳大利亚联储
                </a>
            </li>
            <li>
                <a href="#rzbn" data-toggle="tab">
                    新西兰联储
                </a>
            </li>
            <li>
                <a href="#snb" data-toggle="tab">
                    瑞士央行
                </a>
            </li>
            <li>
                <a href="#boc" data-toggle="tab">
                    加拿大央行
                </a>
            </li>

        </ul>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade in active" id="fr">
                <div id="fr_calendar" style="width: 70%;margin: 0 0 0 26%;"></div>
                <#include 'calendar_event_list.ftl'>
            </div>
            <div class="tab-pane fade" id="ecb">
                <div id="ecb_calendar" style="width: 70%;margin: 0 0 0 26%;"></div>
                <#include 'calendar_event_list.ftl'>
            </div>
            <div class="tab-pane fade" id="boe">
                <div id="boe_calendar" style="width: 70%;margin: 0 0 0 26%;"></div>
                <#include 'calendar_event_list.ftl'>
            </div>
            <div class="tab-pane fade" id="boj">
                <div id="boj_calendar" style="width: 70%;margin: 0 0 0 26%;"></div>
                <#include 'calendar_event_list.ftl'>
            </div>
            <div class="tab-pane fade" id="rba">
                <div id="rba_calendar" style="width: 70%;margin: 0 0 0 26%;"></div>
                <#include 'calendar_event_list.ftl'>
            </div>
            <div class="tab-pane fade" id="rzbn">
                <div id="rzbn_calendar" style="width: 70%;margin: 0 0 0 26%;"></div>
                <#include 'calendar_event_list.ftl'>
            </div>
            <div class="tab-pane fade" id="snb">
                <div id="snb_calendar" style="width: 70%;margin: 0 0 0 26%;"></div>
                <#include 'calendar_event_list.ftl'>
            </div>
            <div class="tab-pane fade" id="boc">
                <div id="boc_calendar" style="width: 70%;margin: 0 0 0 26%;"></div>
                <#include 'calendar_event_list.ftl'>
            </div>
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
                <form class="form-horizontal" id="loginForm">
                    <div class="box-body">
                        <div class="form-group"></div>
                        <div class="form-group">
                            <label for="userName" class="col-sm-2 control-label">用户名:</label>

                            <div class="col-sm-10">
                                <input type="email" class="form-control" name="userName" placeholder="用户名">
                            </div>
                        </div>
                        <div class="form-group"></div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码:</label>

                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="password" placeholder="密码">
                            </div>
                        </div>
                        <div class="form-group"></div>

                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" id="loginBtn" class="btn btn-primary">登录</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:600px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">用户注册</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="registerForm">
                    <div class="box-body">
                        <div class="form-group"></div>
                        <div class="form-group">
                            <label for="userName" class="col-sm-2 control-label">用户名:</label>

                            <div class="col-sm-10">
                                <input type="email" class="form-control" name="userName" placeholder="用户名">
                            </div>
                        </div>
                        <div class="form-group"></div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码:</label>

                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="password" placeholder="密码">
                            </div>
                        </div>
                        <div class="form-group"></div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">确认密码:</label>

                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="repassword" placeholder="重复密码">
                            </div>
                        </div>

                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" id="registerBtn" class="btn btn-primary">注册</button>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="/cms/js/script/calendar_page.js"></script>
<script type="text/javascript" src="/cms/js/lib/timebar.js"></script>
<script>
    $(function(){
        $("#registerBtn").on('click',function(){
            $.ajax({
                url : "saveUser",
                type : "post",
                data : $("#registerForm").serialize(),
                dataType : "json",
                success : function(data){
                    $("#registerModal").modal('hide');

                    alert("注册成功");

                },
                error : function(){
                    $("#registerModal").modal('hide');
                    alert("注册失败")

                }
            });
        });

        $("#loginBtn").on('click',function () {
            $.ajax({
                url : "doLogin",
                type : "post",
                data : $("#loginForm").serialize(),
                dataType : "json",
                success : function(data){
                    $("#loginModal").modal('hide');
                    if(data == "true"){
                        alert("登录成功");
                    }else{
                        alert("登录成功");
                    }
                },
                error : function(){
                    $("#loginModal").modal('hide');
                    alert("登录失败")

                }
            });
        });

        $("#loginModal").on("hidden.bs.modal", function() {
            $('#loginForm')[0].reset();
        });

        $("#registerModal").on("hidden.bs.modal", function() {
            $('#registerForm')[0].reset();
        });









    });



</script>