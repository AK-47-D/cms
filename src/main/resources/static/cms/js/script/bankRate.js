
$(document).ready(function () {
    $.ajax({
        url:'/api/CenterBankRate',
        method:'GET',
        data:{
            date_stamp:new Date().Format('yyyy-MM-dd')
        },
        success:function (data) {
            debugger;
            console.log(data)
            data = data.reverse();
        },
        error:function(a,b,c){
            console.log(a,b,c)
        }
    })
});
