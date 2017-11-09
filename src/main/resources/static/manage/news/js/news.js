$(function () {
    news.init();
})
var news = {
    init: function () {
        $("#saveNews").unbind().bind('click',function(){
            debugger
            $.ajax({
                url: "news/saveNews",
                method: 'post',
                data:$("#newsForm").serialize(),
                dataType: 'json',
                success: function (data) {
                    if (data.success) {
                        mainjs.createDefaultPNotify(data.title, data.message, "success");
                    }else{
                        mainjs.createDefaultPNotify(data.title, data.message, "fail");
                    }
                },
                error:function(){
                    mainjs.createDefaultPNotify("异常","请联系管理员","error");
                }
            })
        });
    }
}