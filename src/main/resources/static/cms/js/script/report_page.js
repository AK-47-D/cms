function doAjax(happenDate,e) {
    debugger;
    let selector = '';
    if(e.currentTarget.id.includes(happenDate.split('/')[0])){
        selector = '#collapse'+happenDate.split('/')[0]
    }

    $.ajax({
        url:'/findReportList',
        method:'post',
        data:{
            happenDate:happenDate
        },
        success:function (data) {
            debugger;
            let reportList = '';
            for(let i =0;i<data.length;i++){
                let report =  "<div data-news>" +
                                  "<div class=\"news-item\" data-index=\"0\" data-news>" +
                                      "<div class=\"news-item__main\" style='display: flex;justify-content: space-between'>" +
                                          "<a style='font-size: 20px;font-weight: bold' target=\"_blank\" href=\"/report/"+data[i].id+"\">" +
                                              data[i].title+
                                          "</a>" +
                                          "<span class=\"text\">"+new Date(data[i].happenDate).Format('yyyy-MM-dd')+"</span>" +
                                      "</div>" +
                                  "</div>" +
                              "</div>";


                reportList += report
            }

            $(selector).find('.panel-body').html(reportList);


        },
        error:function (a,b,c) {
            console.log(a,b,c)
        }

    })
}

$(function () {
    $('.panel').css('margin-bottom','15px');
    $('.panel-title').find('a').css('color','#929090');

    $('#collapse2017').on('show.bs.collapse', function (e) {
        // do something…
        doAjax('2017/01/01',e)
    })

    $('#collapse2016').on('show.bs.collapse', function (e) {
        // do something…
        doAjax('2016/01/01',e)
    })
});