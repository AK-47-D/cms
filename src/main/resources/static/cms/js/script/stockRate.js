
$(document).ready(function () {
    $.ajax({
        url:'/api/stock_index',
        method:'GET',
        data:{
            date_stamp:new Date().Format('yyyy-MM-dd')
        },
        success:function (data) {
            debugger;
            // data = data.reverse();
            var stockRateHtml = '';
            for(let i = 0;i<data.length;i++){
                let rateStyle = '';
                if(parseFloat(data[i].rate)>0){
                    rateStyle = 'color:crimson';
                }else if(parseFloat(data[i].rate)<0){
                    rateStyle = 'color:green'
                }
                let stockRate = "<div data-bankRate class=\"bankrate-item\">" +
                    "<span data-bankRate class=\"bank-name\">"+ data[i].prod_name+"</span>" +
                    "<span data-bankRate class=\"next-time\">"+ data[i].last_px+"</span>" +
                    "<span data-bankRate style="+rateStyle+" class=\"bank-rate\">"+ data[i].px_change+"</span>" +
                    "<span data-bankRate style="+rateStyle+" class=\"next-time\">"+ data[i].px_change+"</span>" +
                    "</div>";
                stockRateHtml += stockRate;
            }
            $('.stockrate-list').html(stockRateHtml)
        },
        error:function(a,b,c){
            console.log(a,b,c)
        }
    })
});
