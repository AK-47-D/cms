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
            sidePagination: "server",
            pagination:true,
            pageNumber: pageNum,     //初始化加载第一页，默认第一页
            pageSize: pageSize,      //每页的记录行数（*）
            pageList:[10, 25, 50, 100],
            classes:'table-no-bordered',
            method:'post',
            url: '/findNewsList_' + pageNum + '_' + pageSize,
            //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
            //queryParamsType:'',
            ////查询参数,每次调用是会带上这个参数，可自定义
            // queryParams : function(params) {
            //     return {
            //         size: params.pageSize,
            //         page: params.pageNumber - 1,
            //     };
            // },
            columns: [{
                field: 'news',
                title: '',
                width: '60%',
                formatter: function (value, row, index) {
                    debugger;
                    return "<div data-news>" +
                        "<div class=\"news-item\" data-index=\"0\" data-news>" +
                        "<div class=\"news-item__main\">" +
                        "<a target=\"_blank\" href=\"/premium/articles/3039367\" class=\"news-item__main__title\">" +
                        row.title+
                        "</a>" +
                        "<a id=a_"+index+" target=\"_blank\" href=\"/premium/articles/3039367\" class=\"news-item__main__summary\">" +
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
            // data: data.result.rows,
            // onPostBody:function (rows) {
            //    debugger;
            //    $('a_'+row.index).find('p')
            // }
        });

    }

    doNewsAjax(1, 10);


})
