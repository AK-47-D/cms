
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
                if(data[i].px_change>0){
                    rateStyle = 'color:crimson';
                }else if(data[i].px_change<0){
                    rateStyle = 'color:green'
                }
                let stockRate = "<div data-bankRate class=\"bankrate-item\">" +
                    "<span data-bankRate class=\"bank-name\">"+ data[i].prod_name+"</span>" +
                    "<span data-bankRate class=\"next-time\">"+ data[i].last_px+"</span>" +
                    "<span data-bankRate style="+rateStyle+" class=\"bank-rate\">"+ Number(data[i].px_change).toFixed(2)+"</span>" +
                    "<span data-bankRate style="+rateStyle+" class=\"bank-rate\">"+ Number(data[i].px_change_rate).toFixed(2)+"</span>" +
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
