
$(document).ready(function () {
    $('#loginBtn').click(function () {
        $('#loginDiv').css({'display':'block','zIndex':'1040'});
    });
    $('#closeLogin').click(function () {
        $('#loginDiv').css({'display':'none','zIndex':'0'});
    });

    timebar.init("calendar",null);

});
