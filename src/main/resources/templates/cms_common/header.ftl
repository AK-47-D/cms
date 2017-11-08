<#include '../cms_common/login.ftl'>

<link href="/cms/css/bootstrap.css" rel="stylesheet"/>
<link href="/cms/css/wallStreet.css" rel="stylesheet"/>

<style rel="stylesheet">
    html,body{
        font-family: Helvetica,Microsoft YaHei,Hiragino Sans GB,WenQuanYi Micro Hei,sans-serif;
    }
    .navbar-right li:last-child {
        padding-left:15px ;
    }
    .navbar-right li:last-child a{
        display: inline-block;
        padding: 14px 0 0 0;
    }
</style>

<!-- 导航 -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid" style="margin-top: 0.5%">
        <div class="collapse navbar-collapse row" id="bs-example-navbar-collapse-1">
            <div class="navbar-left col-lg-8" style="border-right: 2px solid #e3d9d9">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#" style="font-weight: bold;">CMS</a>
                </div>
            </div>
            <ul class="nav navbar-nav navbar-right col-lg-4">
                <li><a href="#" id="toIndex">首页</a></li>
                <li><a href="#" id="aboutUs">关于我们</a></li>
                <li><a href="#" id="focusPlan">焦点规划</a></li>
                <li><a href="#" id="loginBtn">登录</a><a href="#" id="loginBtn1">/注册</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->

</nav>


<script type="text/javascript" src="/cms/js/lib/util.js"></script>