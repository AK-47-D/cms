$(function(){
    login.init();
})
var login = {
    init:function(){
        $("#login").unbind().bind('click',function(){
            debugger
            $.ajax({
                url: "doLogin",
                method: 'post',
                data:$("#loginForm").serialize(),
                dataType: 'json',
                success: function (data) {
                    if (data.success) {
                        mainjs.createDefaultPNotify(data.title, data.message, "success");
                        location.href=data.result;
                    }else{
                        mainjs.createDefaultPNotify(data.title, data.message, "fail");
                    }
                },
                error:function(){
                    mainjs.createDefaultPNotify("异常","请联系管理员","error");
                }
            })
        })
    }
}
