<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Dashboard</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="/manage/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/manage/dist/css/AdminLTE.min.css">
    <link href="bower_components/pnotify/src/pnotify.css" rel="stylesheet">
    <link href='http://fonts.useso.com/css?family=Roboto:500,900italic,900,400italic,100,700italic,300,700,500italic,100italic,300italic,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.useso.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href="/manage/logincss.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>

<!-- Content Wrapper. Contains page content -->

<div class="login">
    <h2>后台管理</h2>
    <div class="login-top">
        <h1>登录</h1>
        <form id="loginForm">
            <input type="text" id="username" name="username"
                   placeholder="用户名">
            <input type="password" id="password" name="password"
                   placeholder="密码">
        </form>
        <div class="forgot">
            <#--<a href="#">forgot Password</a>-->
            <button type="button" class="pull-right btn btn-default" id="login">登录
                <i class="fa fa-arrow-circle-right"></i></button>
        </div>
    </div>
    <div class="login-bottom">
        <#--<h3>New User &nbsp;<a href="#">Register</a>&nbsp Here</h3>-->
    </div>
</div>
<#--<div class="container">-->
    <#--<section class="col-lg-12">-->
        <#--<div class="box box-info">-->
            <#--<div class="box-header">-->
                <#--<i class="fa fa-envelope"></i>-->

                <#--<h3 class="box-title">后台管理</h3>-->
            <#--</div>-->
            <#--<div class="box-body">-->
                <#--<form id="loginForm" class="form-horizontal">-->
                    <#--<div class="form-group">-->
                        <#--<label for="username" class="col-sm-2 control-label">帐号</label>-->
                        <#--<div class="col-sm-7">-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="form-group">-->
                        <#--<label for="password" class="col-sm-2 control-label">密码</label>-->
                        <#--<div class="col-sm-7">-->
                            <#--<input type="password" class="form-control" id="password" name="password"-->
                                   <#--placeholder="密码">-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="box-footer clearfix">-->
                        <#--<button type="button" class="pull-right btn btn-default" id="login">登录-->
                            <#--<i class="fa fa-arrow-circle-right"></i></button>-->
                    <#--</div>-->
                <#--</form>-->
            <#--</div>-->
        <#--</div>-->
    <#--</section>-->
<#--</div>-->
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="/manage/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/manage/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/manage/dist/js/adminlte.min.js"></script>
<script src="/manage/bower_components/pnotify/src/pnotify.js"></script>
<script src="/manage/mainjs.js"></script>
<script src="/manage/loginjs.js"></script>
</body>
</html>
