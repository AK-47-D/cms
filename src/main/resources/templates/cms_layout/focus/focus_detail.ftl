<link rel="stylesheet" type="text/css" href="/cms/css/default.css">
<link rel="stylesheet" type="text/css" href="/cms/css/jquery.classycountdown.css"/>

<#include '../../cms_common/header.ftl'>
<#include '../bankRate.ftl'>
<style>
    .ClassyCountdownDemo {
        margin: -30px 0 0 12%;
        max-width: 800px;
        width: 80%;
        padding: 30px;
        display: block
    }
</style>


<div id="focusDetail" style="width: 70%;min-height: 405px;margin: 110px 0 0 27%;">
    <div id="countdown" class="ClassyCountdownDemo"></div>
    <input id="happenDate" hidden value=${focus.happenDate} />
    <input id="happenCountry" hidden value=${focus.country} />

    <div id="focusRate" class="wscn-sidebar bankrate" data-bankrate="" style="width: 300px;position: fixed;top:250px;left: 35px;">
        <div class="side-item-header" data-bankrate="">
            <span class="glyphicon glyphicon-jpy" style="color: royalblue"></span>
            <span class="header-text" data-bankrate="">三项指标</span>
        </div>

        <div class="side-item-tab" data-bankRate>
            <span class="tab-item" data-bankRate>指标名称</span>
            <span class="tab-item" data-bankRate>指标数据</span>
        </div>

        <div class="data-list" data-bankrate="">
            <div data-bankrate="" class="bankrate-item">
                <span data-bankrate="" class="bank-name">NU</span>
                <span data-bankrate="" class="next-time">${(focus.nu)!}</span>
            </div>
            <div data-bankrate="" class="bankrate-item">
                <span data-bankrate="" class="bank-name">CPI</span>
                <span data-bankrate="" class="next-time">${(focus.cpi)!}</span>
            </div>
            <div data-bankrate="" class="bankrate-item">
                <span data-bankrate="" class="bank-name">GDP</span>
                <span data-bankrate="" class="next-time">${(focus.gdp)!}</span>
            </div>
        </div>

    </div>
    <div>
        <div style="text-align: center;font-size: 26px;font-weight: bold;color: #5f5c5c">
            <p style="letter-spacing: 5px;color: #3498db">${focus.title}</p>
            <p id="happenTime" style="font-size: 12;color:#abb7be">${(focus.happenDate)!}</p>
        </div>
        <div style="text-indent: 30px;margin-top: 50px;margin-bottom: 50px">
            <p>${focus.content}</p>
        </div>
        <table id="newsList"></table>
    </div>
</div>
<#--<script type="text/javascript" src="../cms/js/script/news_detail.js"></script>-->

<#include '../../cms_common/footer.ftl'>
<script src="/cms/js/lib/jquery.knob.js"></script>
<script src="/cms/js/lib/jquery.throttle.js"></script>
<script src="/cms/js/lib/jquery.classycountdown.js"></script>
<script type="text/javascript" src="/manage/mainjs.js"></script>

<script type="text/javascript">
    $(function () {

        var countryList = mainjs.getCountry();
        debugger;

        var nowCountry = countryList[Number($('#happenCountry').val())].detail;

        $('#countdown').ClassyCountdown({
            theme: "flat-colors-very-wide",
            now: $.now(),
            end: new Date($('#happenTime').html()).getTime()
        });

        let newsList = '';

        function doNewsAjax(pageNum, pageSize) {
            $('#newsList').bootstrapTable({
                        url: '/findFocusNewsList',         //请求后台的URL（*）
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
                        classes: 'table-no-bordered',
                        onPostBody: function () {
                            $('.page-list').css('marginLeft', '10px');
                            $('.fixed-table-pagination').css({'width': '70%', 'margin-left': '27%'})
                        },
                        columns: [{
                            field: 'title',
                            title: '',
                            formatter: function (value, row, index) {
                                debugger;
                                let noImg = "/cms/img/default.png";
                                if (row.image) noImg = row.image;
                                return "<div data-news>" +
                                        "<div class=\"news-item\" data-index=\"0\" data-news>" +
                                        // 图片
                                        "<a target=\"_blank\" href=\"/articles/3042043\" class=\"home-news-item__cover\">" +
                                        "<div class=\"wscn-lazyload lazy\">" +
                                        "<img style='width: 100%' max-width='188px' src=" + noImg + ">" +
                                        "</div>" +
                                        "</a>" +
                                        "<div class=\"news-item__main\">" +
                                        "<a target=\"_blank\" href=\"/news/" + row.id + "\" class=\"news-item__main__title\">" +
                                        row.title +
                                        "</a>" +
                                        "<a id=a_" + $('.page-number.active').find('a').html() + "_" + index + " target=\"_blank\" href=\"/news/" + row.id + "\" class=\"news-item__main__summary\">" +
                                        row.html.substring(0, (row.html.indexOf('</p>') + 4)) + '...' +
                                        "</a>" +
                                        "<div class=\"news-item__main__meta\">" +
                                        "<div class=\"news-item__main__meta__left\">" +
                                        // "<div class=\"left-item\">" +
                                        //     "<a target=\"_blank\" href=\"/authors/120000000496\" class=\"display-name\">脱水研报</a>" +
                                        // "</div>" +
                                        "<div class=\"left-item\">" +
                                        "<span class=\"text\">" + new Date(row.publishDate).Format('yyyy-MM-dd') + "</span>" +
                                        "</div>" +
                                        "</div>" +
                                        "</div>" +
                                        "</div>" +
                                        "</div>" +
                                        "</div>"
                            }
                        }],
                        queryParams: function (params) {
                            params.happenDate = $('#happenTime').html().replace(/-/g, '/')
                            return params

                        }
                    }
            )
        }

        function doBankRateAjax() {
            $.ajax({
                url:'/api/CenterBankRate',
                method:'GET',
                data:{
                    date_stamp:new Date().Format('yyyy-MM-dd')
                },
                success:function (data) {
                    // debugger;
                    data = data.reverse();
                    var bankRateHtml = '';
                    for(let i = 0;i<data.length;i++){
                        if(data[i].title.includes(nowCountry)){
                            let rateStyle = '';
                            if(parseFloat(data[i].rate)>0){
                                rateStyle = 'color:crimson';
                            }else if(parseFloat(data[i].rate)<0){
                                rateStyle = 'color:green'
                            }
                            if(!data[i].next_meeting_at){
                                data[i].next_meeting_at = '--'
                            }
                            let bankRate = "<div data-bankRate class=\"bankrate-item\">" +
                                    "<span data-bankRate class=\"bank-name\">"+ data[i].title+"</span>" +
                                    "<span data-bankRate style="+rateStyle+" class=\"bank-rate\">"+ data[i].rate+"</span>" +
                                    "<span data-bankRate class=\"next-time\">"+ data[i].next_meeting_at+"</span>" +
                                    "</div>";
                            bankRateHtml += bankRate;
                        }

                    }
                    $('.bankrate-list').html(bankRateHtml)
                },
                error:function(a,b,c){
                    console.log(a,b,c)
                }
            })
        }

        doNewsAjax(1, 10);

        doBankRateAjax()



//        $.ajax({
//            url:'/findFocusNewsList',
//            type:'post',
//            data:{
//                happenDate:$('#happenDate').val().replace(/-/g,'/'),
//                pageSize:10,
//                pageNumber:1
//            },
//            success:(data)=>{
//                debugger;
//            },
//            error:(a,b,c)=>{
//                debugger;
//            }
//        })

    })
</script>