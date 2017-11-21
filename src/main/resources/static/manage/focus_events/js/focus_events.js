$(function () {
    focusEvents.init();
})
var focusEvents = {
    init: function () {
        CKEDITOR.document.getById( 'content' );
        $('[name=happenDate]').datetimepicker({
            language:"zh-CN",
            format: 'yyyy/mm/dd hh:ii:ss',
            todayBtn:"linked",
            todayHighlight: true,
            autoclose: true,
            forceParse: 1
        });
        $("#saveFocus").unbind().bind('click',function(){
            debugger;
            $('[name=content]').val(CKEDITOR.instances.content.getData());
            $.ajax({
                url: "focus/saveFocus",
                method: 'post',
                data:$("#focusForm").serialize(),
                dataType: 'json',
                success: function (data) {
                    if (data.success) {
                        mainjs.createDefaultPNotify(data.title, data.message, "success");
                    }else{
                        mainjs.createDefaultPNotify(data.title, data.message, "fail");
                    }
                },
                error:function(data){
                    mainjs.createDefaultPNotify("异常","请联系管理员","error");
                }
            })
        });
        CKEDITOR.replace("content");
    }
}