<link href="/cms/css/bootstrap.css" rel="stylesheet"/>
<link href="/cms/css/wallStreet.css" rel="stylesheet"/>
<link href="/cms/css/common.css" rel="stylesheet"/>

<!-- 导航 -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid" style="margin-top: 0.5%">
        <div class="collapse navbar-collapse row" id="bs-example-navbar-collapse-1">
            <div class="navbar-left col-lg-9" style="border-right: 2px solid #e3d9d9">
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
            <ul class="nav navbar-nav navbar-right col-lg-3">
                <li><a href="#" id="toIndex">首页</a></li>
                <li><a href="#" id="aboutUs">关于我们</a></li>
                <li><a href="#" id="focusPlan">焦点规划</a></li>
                <li><a href="#" id="loginBtn">登录/注册</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->

</nav>
<div id="loginDiv" style="display: none;position: fixed;top: 25%;left: 25%;" class="container w3layouts agileits">
    <div class="login w3layouts agileits">
        <h2>登 录</h2>
        <form action="#" method="post">
            <input type="text" Name="Userame" placeholder="用户名" required="" value="admin">
            <input type="password" Name="Password" placeholder="密码" required="">
        </form>

        <div class="send-button w3layouts agileits">
            <form>
                <input type="submit" value="登 录">
            </form>
        </div>
        <a href="#">记住密码?</a>
        <div class="clear"></div>
    </div>
    <div class="register w3layouts agileits">
        <h2>注 册</h2>
        <span id="closeLogin" class="glyphicon glyphicon-remove" style="color:white;font-size:20px;position: absolute;top: 4%;left: 95%;"></span>
        <form action="#" method="post">
            <input type="text" Name="Name" placeholder="用户名" required="" value="admin">
            <input type="text" Name="Email" placeholder="邮箱" required="" value="admin@163.com">
            <input type="password" Name="Password" placeholder="密码" required="">
            <input type="text" Name="Phone Number" placeholder="手机号码" required="">
        </form>
        <div class="send-button w3layouts agileits">
            <form>
                <input type="submit" value="免费注册">
            </form>
        </div>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
</div>

<script type="text/javascript" src="/cms/js/lib/util.js"></script>