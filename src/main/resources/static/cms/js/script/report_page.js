function doAjax(happenDate) {
    $.ajax({
        url:'/',
        method:'post',
        data:{
            happenDate:happenDate
        },
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

    $('#collapse2017').on('show.bs.collapse', function () {
        // do something…
        alert('2017')
    })

    $('#collapse2016').on('show.bs.collapse', function () {
        // do something…
        alert('2016')
    })


    doAjax(1,10);
});