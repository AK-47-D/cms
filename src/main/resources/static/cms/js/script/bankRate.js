
$(document).ready(function () {
    $.ajax({
        url:'/api/CenterBankRate',
        method:'GET',
        data:{
            date_stamp:new Date().Format('yyyy-MM-dd')
        },
        success:function (data) {
            debugger;
            data = data.reverse();
            var bankRateHtml = '';
            for(let i = 0;i<data.length;i++){
                let rateStyle = '';
                if(parseFloat(data[i].rate)>0){
                    rateStyle = 'color:crimson';
                }else if(parseFloat(data[i].rate)<0){
                    rateStyle = 'color:green'
                }
                let bankRate = "<div data-bankRate class=\"bankrate-item\">" +
                                   "<span data-bankRate class=\"bank-name\">"+ data[i].title+"</span>" +
                                   "<span data-bankRate style="+rateStyle+" class=\"bank-rate\">"+ data[i].rate+"</span>" +
                                   "<span data-bankRate class=\"next-time\">"+ data[i].next_meeting_at+"</span>" +
                               "</div>";
                bankRateHtml += bankRate;
            }
            $('.bankrate-list').html(bankRateHtml)
        },
        error:function(a,b,c){
            console.log(a,b,c)
        }
    })
});
