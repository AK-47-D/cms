$(function () {
    report.init();
})
var report = {
    init: function () {
        $('[name=happenDate]').datetimepicker({
            language:"zh-CN",
            format: 'yyyy/mm/dd hh:ii:ss',
            todayBtn:"linked",
            todayHighlight: true,
            autoclose: true,
            forceParse: 1
        });
        $("#saveReport").unbind().bind('click',function(){
            debugger;
            $.ajax({
                url: "report/saveReport",
                method: 'post',
                data:$("#reportForm").serialize(),
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