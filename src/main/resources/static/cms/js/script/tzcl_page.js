$(function () {
    tzclPage.init();
})
var tzclPage ={
    init:()=>{
        tzclPage.initBootstrapTable();
    },
    getIndicator:(r,gdp,cpi,un)=>{
        if(r!= undefined&&gdp!= undefined&&cpi!= undefined&&un!= undefined){
            return `<span class="value_${r}">${r}</span><br><span class="value_${gdp}">${gdp}</span><br><span class="value_${cpi}">${cpi}</span><br><span class="value_${un}">${un}</span>`
        }
        return `R<br>GDP<br>CPI<br>UN`;
    },
    initBootstrapTable:()=>{
        $('#tzclPage').bootstrapTable({
                url: '/tzcl/findTzclList',         //请求后台的URL（*）
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
                    field: 'openDate',
                    title: 'Date',
                    style:'width:10%;padding:10px;border-bottom:1px solid #f1f1f1;'
                },{
                    field: '',
                    title: 'Bank',
                    style:'width:10%;padding:10px;border-bottom:1px solid #f1f1f1;',
                    formatter: (value, row, index)=> {
                        var countryDetail="";
                        var bankDetail="";
                        mainjs.getCountry().forEach((v,index)=>{
                            if(row.country == v.code){
                                countryDetail = v.detailEn
                                return;
                            }
                        });
                        mainjs.getBank().forEach((v,index)=>{
                            if(row.bank == v.code){
                                bankDetail = v.detailEn
                                return;
                            }
                        })
                        return countryDetail + "-" + bankDetail
                    }
                },{
                    field: '',
                    title: 'flag',
                    style:'padding:10px;border-bottom:1px solid #f1f1f1;',
                    formatter: (value, row, index)=> {
                        return `<img style='width:30px; ' src="${basePage.getCountryImg(row.country)}">`;
                    }
                },{
                    field: '',
                    title: 'Indicator',
                    style:'padding:10px;border-bottom:1px solid #f1f1f1;',
                    formatter: (value, row, index)=> {
                        return tzclPage.getIndicator();
                    }
                },{
                    field: '',
                    title: 'Actual',
                    style:'padding:10px;border-bottom:1px solid #f1f1f1;',
                    formatter: (value, row, index)=> {
                        return tzclPage.getIndicator(row.r,row.gdp,row.cpi,row.un);
                    }
                },{
                    field: '',
                    title: 'Previous',
                    style:'padding:10px;',
                    formatter: (value, row, index)=> {
                        return tzclPage.getIndicator(row.perR,row.perGdp,row.perCpi,row.perUn);
                    }
                },{
                    field: '',
                    title: 'Difference',
                    style:'padding:10px;border-bottom:1px solid #f1f1f1;',
                    formatter: (value, row, index)=> {
                        return tzclPage.getIndicator(row.rDiff,row.gdpDiff,row.cpiDiff,row.unDiff);
                    }
                },{
                    field: '',
                    title: 'Status',
                    style:'padding:10px;border-bottom:1px solid #f1f1f1;',
                    formatter: (value, row, index)=> {
                        return tzclPage.getIndicator(row.rStatus,row.gdpStatus,row.cpiStatus,row.unStatus);
                    }
                },{
                    field: 'scenario',
                    title: 'Scenario Planning',
                    align: 'center',
                    style:'padding:10px;border-bottom:1px solid #f1f1f1;',
                    formatter: (value, row, index)=> {
                        return `<span class="value_${value}">${value}</span>`
                    }
                }],
                queryParams: function (params) {
                    return params

                }
            }
        )
    }
} 