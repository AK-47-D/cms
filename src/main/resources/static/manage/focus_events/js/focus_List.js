$(function () {
    newsList.init();
})
var newsList = {
    init: function () {
        $("#addFocus").unbind().bind("click",function(){
            debugger
            mainjs.contentLoadAddBreadCrumb('新闻添加','/manage/focus/focusEvents',null,null)
        });
        $('#focusList').bootstrapTable({
                url: 'focus/findFocusList',         //请求后台的URL（*）
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
                    field: 'title',
                    title: '标题',
                    formatter: function (value, row, index) {
                        if(value.length > 20){
                            value = value.substring(0,20) + "..."
                        }
                        return value;
                    }
                }, {
                    field: 'content',
                    title: '内容',
                    formatter: function (value, row, index) {
                        if(value.length > 35){
                            value = getRemoveHtml(value).substring(0,35) + "..."
                        }
                        return value;
                    }
                }, {
                    field: 'country',
                    title: '国家',
                    formatter: function (value, row, index) {
                        var country = mainjs.getCountry();
                        debugger
                        $(country).each(function(k,v){
                            if(v.code == value){
                                value = v.detail;
                            }
                        })
                        return value;
                    }
                },{
                    field: 'source',
                    title: '来源',
                    formatter: function (value, row, index) {
                        var from = mainjs.getFrom();
                        $(from).each(function(k,v){
                            if(v.code == value){
                                value = v.cb;
                            }
                        })
                        return value;
                    }
                }, {
                    field: 'level',
                    title: '严重性',
                    formatter: function (value, row, index) {
                        var level = mainjs.getLevel();
                        $(level).each(function(k,v){
                            if(v.code == value){
                                value = v.detail;
                            }
                        })
                        return value;
                    }
                }, {
                    title: '操作',
                    formatter: function (value, row, index) {
                        return '<a class="editFocus" href="javascript:void(0)">编辑</a>'
                    },
                    events: {
                        'click .editFocus':function (e,value,row,index) {
                            mainjs.contentLoadAddBreadCrumb('新闻编辑','/manage/focus/focusEvents?focusId='+row.id,null,null)
                        }
                    }
                }],
                queryParams: function (params) {
                    return params

                }
            }
        )
    }
}