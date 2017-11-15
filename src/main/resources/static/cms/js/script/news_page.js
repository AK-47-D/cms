$(function () {
    var newsList = '';

    function doNewsAjax(pageNum, pageSize) {
        // $.ajax({
        //     url: '/findNewsList_' + pageNum + '_' + pageSize,
        //     method: 'post',
        //     data: {},
        //     success: function (data) {
        //         debugger;
        //
        //         $('#newsList').bootstrapTable({
        //             sidePagination: "server",
        //             pagination:true,
        //             pageNumber: pageNum,     //初始化加载第一页，默认第一页
        //             pageSize: pageSize,      //每页的记录行数（*）
        //             pageList:[10, 25, 50, 100],
        //             classes:'table-no-bordered',
        //             url: '/findNewsList_' + pageNum + '_' + pageSize,
        //             //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //             //queryParamsType:'',
        //             ////查询参数,每次调用是会带上这个参数，可自定义
        //             queryParams : function(params) {
        //                 return {
        //                     size: params.pageSize,
        //                     page: params.pageNumber - 1,
        //                 };
        //             },
        //             columns: [{
        //                 field: 'news',
        //                 title: '',
        //                 width: '60%',
        //                 formatter: function (value, row, index) {
        //                     debugger;
        //                     return "<div data-news>" +
        //                                 "<div class=\"news-item\" data-index=\"0\" data-news>" +
        //                                     "<div class=\"news-item__main\">" +
        //                                         "<a target=\"_blank\" href=\"/premium/articles/3039367\" class=\"news-item__main__title\">" +
        //                                             row.title+
        //                                         "</a>" +
        //                                         "<a id=a_"+index+" target=\"_blank\" href=\"/premium/articles/3039367\" class=\"news-item__main__summary\">" +
        //                                             row.html.substring(0,(row.html.indexOf('</p>')+4))+'...'+
        //                                         "</a>" +
        //                                         "<div class=\"news-item__main__meta\">" +
        //                                             "<div class=\"news-item__main__meta__left\">" +
        //                                                 // "<div class=\"left-item\">" +
        //                                                 //     "<a target=\"_blank\" href=\"/authors/120000000496\" class=\"display-name\">脱水研报</a>" +
        //                                                 // "</div>" +
        //                                                 "<div class=\"left-item\">" +
        //                                                     "<span class=\"text\">"+new Date(row.publishDate).Format('yyyy-MM-dd')+"</span>" +
        //                                                 "</div>" +
        //                                             "</div>" +
        //                                         "</div>" +
        //                                     "</div>" +
        //                                 "</div>" +
        //                             "</div>"
        //                 }
        //             }],
        //             data: data.result.rows,
        //             // onPostBody:function (rows) {
        //             //    debugger;
        //             //    $('a_'+row.index).find('p')
        //             // }
        //         });
        //     },
        //     error: function (a, b, c) {
        //
        //     }
        // })
        $('#newsList').bootstrapTable({
                url: '/findNewsList__',         //请求后台的URL（*）
                sortOrder: "desc",     //排序方式
                sortName: "id",
                method: 'post',                      //请求方式（*）
                contentType: 'application/x-www-form-urlencoded',
                striped: false,                      //是否显示行间隔色
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
                classes:'table-no-bordered',
                onPostBody:function () {
                    $('.page-list').css('marginLeft','10px');
                    $('.fixed-table-pagination').css({'width':'70%','margin-left':'27%'})
                },
                columns: [{
                    field: 'title',
                    title: '',
                    formatter: function (value, row, index) {
                        debugger;
                        return "<div data-news>" +
                            "<div class=\"news-item\" data-index=\"0\" data-news>" +
                            "<div class=\"news-item__main\">" +
                            "<a target=\"_blank\" href=\"/news/"+row.id+"\" class=\"news-item__main__title\">" +
                            row.title+
                            "</a>" +
                            "<a id=a_"+$('.page-number.active').find('a').html()+"_"+index+" target=\"_blank\" href=\"/news/"+row.id+"\" class=\"news-item__main__summary\">" +
                            row.html.substring(0,(row.html.indexOf('</p>')+4))+'...'+
                            "</a>" +
                            "<div class=\"news-item__main__meta\">" +
                            "<div class=\"news-item__main__meta__left\">" +
                            // "<div class=\"left-item\">" +
                            //     "<a target=\"_blank\" href=\"/authors/120000000496\" class=\"display-name\">脱水研报</a>" +
                            // "</div>" +
                            "<div class=\"left-item\">" +
                            "<span class=\"text\">"+new Date(row.publishDate).Format('yyyy-MM-dd')+"</span>" +
                            "</div>" +
                            "</div>" +
                            "</div>" +
                            "</div>" +
                            "</div>" +
                            "</div>"
                    }
                }],
                queryParams: function (params) {
                    return params

                }
            }
        )
    }

    doNewsAjax(1, 10);


})
