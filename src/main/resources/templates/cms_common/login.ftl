
<!-- 登录注册 -->
<link href="/cms/css/loginDiv.css" rel="stylesheet"/>

<div id="loginDiv" style="display: none;position: fixed;top: 20%;left: 13%;" class="container w3layouts agileits">
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