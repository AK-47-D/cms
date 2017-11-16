$(function () {
    news.init();
})
var news = {
    init: function () {
        $('[name=happenDate]').datetimepicker({
            language:"zh-CN",
            format: 'yyyy/mm/dd hh:ii:ss',
            todayBtn:"linked",
            todayHighlight: true,
            autoclose: true,
            forceParse: 1
        });
        $("[name=image]").unbind().bind('change',function(){
            $("#newsImage").attr("src",$(this).val());
        });
        $("#newsImage").attr("src",$("[name=image]").val());
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
        $("#releaseNews").unbind().bind('click',function(){
            debugger
            $.ajax({
                url: "news/releaseNews",
                method: 'post',
                data:{newsId:$("[name=id]").val()},
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