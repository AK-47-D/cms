$(function () {
    $.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales['zh-CN'])


    // 宏观
    var global_columns = []
    global_columns.push({
        title: '',
        field: 'display_time',
        align: 'center',
        valign: 'middle',
        width: '5%',
        formatter: function (value, row, index) {

            return value
        }
    }, {
        title: ' ',
        field: 'content',
        align: 'left',
        width: '60%',
        formatter: function (value, row, index) {
            var html = value
            if (row.score == 2) {
                html = '<div style="color:red">' + value + '</div>'
            }
            return html
        }
    })

    $('#global_table').bootstrapTable({
        url: '/api/FocusLiveNews',
        sidePagination: "server",
        queryParamsType: 'page,size,type',
        contentType: "application/x-www-form-urlencoded",
        method: 'get',
        striped: false,     //是否显示行间隔色
        buttonsAlign: 'right',
        smartDisplay: true,
        cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,  //是否显示分页（*）
        paginationLoop: true,
        paginationHAlign: 'right', //right, left
        paginationVAlign: 'bottom', //bottom, top, both
        paginationDetailHAlign: 'left', //right, left
        paginationPreText: ' 上一页',
        paginationNextText: '下一页',
        search: false,
        sortable: true,    //是否启用排序
        sortOrder: "desc", //排序方式
        sortName: "id",
        pageNumber: 1,     //初始化加载第一页，默认第一页
        pageSize: 10,      //每页的记录行数（*）
        pageList: [20, 50, 100, 200, 500, 1000], // 可选的每页数据
        totalField: 'totalElements', // 所有记录 count
        dataField: 'content', //后端 json 对应的表格List数据的 key
        columns: global_columns,
        queryParams: function (params) {
            return {
                size: params.pageSize,
                page: params.pageNumber - 1,
                type: "global"
            }
        },
        classes: 'table table-responsive',
    })


    // A股
    var a_stock_columns = []
    a_stock_columns.push({
        title: '',
        field: 'display_time',
        align: 'center',
        valign: 'middle',
        width: '5%',
        formatter: function (value, row, index) {

            return value
        }
    }, {
        title: ' ',
        field: 'content',
        align: 'left',
        width: '60%',
        formatter: function (value, row, index) {
            var html = value
            if (row.score == 2) {
                html = '<div stype="color:red">' + value + '</div>'
            }
            return html
        }
    })

    $('#a_stock_table').bootstrapTable({
        url: '/api/FocusLiveNews',
        sidePagination: "server",
        queryParamsType: 'page,size,type',
        contentType: "application/x-www-form-urlencoded",
        method: 'get',
        striped: false,     //是否显示行间隔色
        buttonsAlign: 'right',
        smartDisplay: true,
        cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,  //是否显示分页（*）
        paginationLoop: true,
        paginationHAlign: 'right', //right, left
        paginationVAlign: 'bottom', //bottom, top, both
        paginationDetailHAlign: 'left', //right, left
        paginationPreText: ' 上一页',
        paginationNextText: '下一页',
        search: false,
        sortable: true,    //是否启用排序
        sortOrder: "desc", //排序方式
        sortName: "id",
        pageNumber: 1,     //初始化加载第一页，默认第一页
        pageSize: 10,      //每页的记录行数（*）
        pageList: [20, 50, 100, 200, 500, 1000], // 可选的每页数据
        totalField: 'totalElements', // 所有记录 count
        dataField: 'content', //后端 json 对应的表格List数据的 key
        columns: a_stock_columns,
        queryParams: function (params) {
            return {
                size: params.pageSize,
                page: params.pageNumber - 1,
                type: "a_stock"
            }
        },
        classes: 'table table-responsive',
    })

    //美股
    var us_stock_columns = []
    us_stock_columns.push({
        title: '',
        field: 'display_time',
        align: 'center',
        valign: 'middle',
        width: '5%',
        formatter: function (value, row, index) {
            return value
        }
    }, {
        title: ' ',
        field: 'content',
        align: 'left',
        width: '60%',
        formatter: function (value, row, index) {
            var html = value
            if (row.score == 2) {
                html = '<div stype="color:red">' + value + '</div>'
            }
            return html
        }
    })

    $('#us_stock_table').bootstrapTable({
        url: '/api/FocusLiveNews',
        sidePagination: "server",
        queryParamsType: 'page,size,type',
        contentType: "application/x-www-form-urlencoded",
        method: 'get',
        striped: false,     //是否显示行间隔色
        buttonsAlign: 'right',
        smartDisplay: true,
        cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,  //是否显示分页（*）
        paginationLoop: true,
        paginationHAlign: 'right', //right, left
        paginationVAlign: 'bottom', //bottom, top, both
        paginationDetailHAlign: 'left', //right, left
        paginationPreText: ' 上一页',
        paginationNextText: '下一页',
        search: false,
        sortable: true,    //是否启用排序
        sortOrder: "desc", //排序方式
        sortName: "id",
        pageNumber: 1,     //初始化加载第一页，默认第一页
        pageSize: 10,      //每页的记录行数（*）
        pageList: [20, 50, 100, 200, 500, 1000], // 可选的每页数据
        totalField: 'totalElements', // 所有记录 count
        dataField: 'content', //后端 json 对应的表格List数据的 key
        columns: us_stock_columns,
        queryParams: function (params) {
            return {
                size: params.pageSize,
                page: params.pageNumber - 1,
                type: "us_stock"
            }
        },
        classes: 'table table-responsive',
    })

    // 外汇
    var forex_columns = []
    forex_columns.push({
        title: '',
        field: 'display_time',
        align: 'center',
        valign: 'middle',
        width: '5%',
        formatter: function (value, row, index) {

            return value
        }
    }, {
        title: ' ',
        field: 'content',
        align: 'left',
        width: '60%',
        formatter: function (value, row, index) {
            var html = value
            if (row.score == 2) {
                html = '<div stype="color:red">' + value + '</div>'
            }
            return html
        }
    })

    $('#forex_table').bootstrapTable({
        url: '/api/FocusLiveNews',
        sidePagination: "server",
        queryParamsType: 'page,size,type',
        contentType: "application/x-www-form-urlencoded",
        method: 'get',
        striped: false,     //是否显示行间隔色
        buttonsAlign: 'right',
        smartDisplay: true,
        cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,  //是否显示分页（*）
        paginationLoop: true,
        paginationHAlign: 'right', //right, left
        paginationVAlign: 'bottom', //bottom, top, both
        paginationDetailHAlign: 'left', //right, left
        paginationPreText: ' 上一页',
        paginationNextText: '下一页',
        search: false,
        sortable: true,    //是否启用排序
        sortOrder: "desc", //排序方式
        sortName: "id",
        pageNumber: 1,     //初始化加载第一页，默认第一页
        pageSize: 10,      //每页的记录行数（*）
        pageList: [20, 50, 100, 200, 500, 1000], // 可选的每页数据
        totalField: 'totalElements', // 所有记录 count
        dataField: 'content', //后端 json 对应的表格List数据的 key
        columns: forex_columns,
        queryParams: function (params) {
            return {
                size: params.pageSize,
                page: params.pageNumber - 1,
                type: "forex"
            }
        },
        classes: 'table table-responsive',
    })


    // 商品 commodity
    var commodity_columns = []
    commodity_columns.push({
        title: '',
        field: 'display_time',
        align: 'center',
        valign: 'middle',
        width: '5%',
        formatter: function (value, row, index) {

            return value
        }
    }, {
        title: ' ',
        field: 'content',
        align: 'left',
        width: '60%',
        formatter: function (value, row, index) {
            var html = value
            if (row.score == 2) {
                html = '<div stype="color:red">' + value + '</div>'
            }
            return html
        }
    })

    $('#commodity_table').bootstrapTable({
        url: '/api/FocusLiveNews',
        sidePagination: "server",
        queryParamsType: 'page,size,type',
        contentType: "application/x-www-form-urlencoded",
        method: 'get',
        striped: false,     //是否显示行间隔色
        buttonsAlign: 'right',
        smartDisplay: true,
        cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,  //是否显示分页（*）
        paginationLoop: true,
        paginationHAlign: 'right', //right, left
        paginationVAlign: 'bottom', //bottom, top, both
        paginationDetailHAlign: 'left', //right, left
        paginationPreText: ' 上一页',
        paginationNextText: '下一页',
        search: false,
        sortable: true,    //是否启用排序
        sortOrder: "desc", //排序方式
        sortName: "id",
        pageNumber: 1,     //初始化加载第一页，默认第一页
        pageSize: 10,      //每页的记录行数（*）
        pageList: [20, 50, 100, 200, 500, 1000], // 可选的每页数据
        totalField: 'totalElements', // 所有记录 count
        dataField: 'content', //后端 json 对应的表格List数据的 key
        columns: commodity_columns,
        queryParams: function (params) {
            return {
                size: params.pageSize,
                page: params.pageNumber - 1,
                type: "commodity"
            }
        },
        classes: 'table table-responsive',
    })

})
