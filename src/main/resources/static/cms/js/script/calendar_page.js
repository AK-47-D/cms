
$(document).ready(function () {
    $('#loginBtn').click(function () {
        $('#loginDiv').css({'display':'block','zIndex':'1040'});
    });
    $('#closeLogin').click(function () {
        $('#loginDiv').css({'display':'none','zIndex':'0'});
    });

    timebar.init("calendar",null);

    $.ajax({
        url: '/api/FinanceInfoCalendar',
        method:'get',
        data:{
            date_stamp:new Date().Format('yyyy-MM-dd')
        },
        success:function (data) {
            debugger;
        },
        error:function (a,b,c) {

        }
    })

});
