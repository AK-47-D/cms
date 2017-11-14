function doAjax(pageNum,pageSize) {
    $.ajax({
        url:'/findDataStatisticList_'+pageNum+'_'+pageSize,
        method:'post',
        data:{},
        success:function (data) {
            debugger;
        },
        error:function (a,b,c) {
            console.log(a,b,c)
        }

    })
}

$(function () {
    $('.panel').css('margin-bottom','15px');
    $('.panel-title').find('a').css('color','#929090');


    doAjax(1,10);
});