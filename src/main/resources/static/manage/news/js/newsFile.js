$(function () {
    newsFile.init();
})
var newsFile = {
    init: function () {
        $("#upload").unbind().bind("click",function(){
            debugger
            var formData = new FormData();
            formData.append("file",$("#file")[0].files[0])
            $.ajax({
                url: "file/upload",
                method: 'post',
                data:formData,
                contentType: false,
                processData: false,
                dataType: 'json',
                success: function (data) {
                    if (data.success) {
                        mainjs.createDefaultPNotify(data.title, data.message, "success");
                        $('#fileList').bootstrapTable('refresh');
                    }else{
                        mainjs.createDefaultPNotify(data.title, data.message, "fail");
                    }
                },
                error:function(){
                    mainjs.createDefaultPNotify("异常","请联系管理员","error");
                }
            })
        });

        $('#fileList').bootstrapTable({
                url: 'file/listFile',         //请求后台的URL（*）
                sortOrder: "desc",     //排序方式
                sortName: "id",
                method: 'post',                      //请求方式（*）
                contentType: 'application/x-www-form-urlencoded',
                striped: true,                      //是否显示行间隔色
                queryParamsType: "pageSize,pageNumber",//传递参数（*）
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,                       //初始化加载第一页，默认第一页
                pagination: true,     //是否显示分页（*）
                paginationLoop: true,
                sortable: false,      //是否启用排序
                pageSize: 10,                       //每页的记录行数（*）
                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: false,
                columns: [{
                    field: 'id',
                    title: '序号',
                    formatter: function (value, row, index) {
                        var options = $('#fileList').bootstrapTable("getOptions");
                        return (options.pageNumber-1)*options.pageSize + ++index;
                    }
                },{
                    field: 'name',
                    title: '文件名'
                }, {
                    field: 'type',
                    title: '后缀'
                }, {
                    field: 'url',
                    title: '链接',
                    formatter: function (value, row, index) {
                        return "<a href='/" + value + "' target='_blank'>" + value + "</a>";
                    }
                },{
                    field: 'modifiedFileDate',
                    title: '修改时间',
                    formatter: function (value, row, index) {
                        return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
                    }
                }],
                queryParams: function (params) {
                    return params

                }
            }
        )
    }
}