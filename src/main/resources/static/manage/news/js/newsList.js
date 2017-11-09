$(function () {
    newsList.init();
})
var newsList = {
    init: function () {
        $('#newsList').bootstrapTable({
                url: 'news/newsList',         //请求后台的URL（*）
                sortOrder: "desc",     //排序方式
                sortName: "id",
                method: 'post',                      //请求方式（*）
                contentType: 'application/x-www-form-urlencoded',
                striped: true,                      //是否显示行间隔色
                queryParamsType: "pageSize,pageNumber",//传递参数（*）
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,                       //初始化加载第一页，默认第一页
                pagination: true,     //是否显示分页（*）
                paginationLoop: false,
                sortable: false,      //是否启用排序
                pageSize: 10,                       //每页的记录行数（*）
                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: true,
                columns: [{
                    field: 'id',
                    title: '序号',
                    formatter: function (value, row, index) {
                        console.log(row);
                        return index + 1;
                    }
                }
                ],
                queryParams: function (params) {
                    return params

                }
            }
        )
    }
}