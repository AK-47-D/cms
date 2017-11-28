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

function getList() {
    $.ajax({
        url:'/report/findAroundDate',
        method:'POST',
        data:{},
        success:(data)=>{
            debugger;
            let beginYear = Number(new Date(data[0]).Format('yyyy'))+1;
            let lastYear = Number(new Date(data[data.length-1]).Format('yyyy'));
            let reportList = '';
            
            for(let i = lastYear;i<beginYear;i++){
                let oneReport = '<div class="panel panel-default">' +
                    '            <div class="panel-heading" role="tab" id="heading'+i+'">' +
                    '                <h4 class="panel-title">' +
                    '                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse'+i+'" aria-expanded="false" aria-controls="collapse'+i+'">' +
                    '                        '+i+'年统计数据' +
                    '                    </a>' +
                    '                </h4>' +
                    '            </div>' +
                    '            <div id="collapse'+i+'" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading'+i+'">' +
                    '                <div class="panel-body"></div>' +
                    '            </div>' +
                    '        </div>';

                reportList+=oneReport;
            }
            $('#accordion').html(reportList);
        },
        error:(a,b,c)=>{
            debugger;
        }

    })
}

$(function () {
    $('.panel').css('margin-bottom','15px');
    $('.panel-title').find('a').css('color','#929090');


    $('.panel-collapse').each(function(){
        // console.log($(this).attr('id'))
        $(document).off('show.bs.collapse',$(this).attr('id')).on('show.bs.collapse',$(this).attr('id'),function (e) {
            doAjax(''+$(this).attr('id').split('collapse')[1]+'/01/01',e)
        })
    });

    getList();
});