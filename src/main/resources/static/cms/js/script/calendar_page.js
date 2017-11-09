var infoList = '';

function getEventList(events) {
    infoList = '';
    for (let i = 0; i < events.length; i++) {
        let flagImgSrc = '';
        let importanceStar = '';

        // 筛选出对应的国旗
        switch (events[i].country) {
            case '欧元区':
                flagImgSrc = "https://wpimg.wallstcn.com/4b/8f/f7/eurozone-2x.png";
                break;
            case '日本':
                flagImgSrc = "https://wpimg.wallstcn.com/84/39/2c/japan-2x.png";
                break;
            case '中国':
                flagImgSrc = "https://wpimg.wallstcn.com/de/bf/b5/china-2x.png";
                break;
            case '加拿大':
                flagImgSrc = "https://wpimg.wallstcn.com/96/ef/7b/candar-2x.png";
                break;
            case '瑞士':
                flagImgSrc = "https://wpimg.wallstcn.com/2e/ef/c6/swit-2x.png";
                break;
            case '美国':
                flagImgSrc = "https://wpimg.wallstcn.com/32/75/86/usa-2x.png";
                break;
            case '澳大利亚':
                flagImgSrc = "https://wpimg.wallstcn.com/81/fe/c2/australian-2x.png";
                break;
            case '英国':
                flagImgSrc = "https://wpimg.wallstcn.com/0d/ce/36/england.png";
                break;
            case '法国':
                flagImgSrc = "https://wpimg.wallstcn.com/7b/be/12/france-2x.png";
                break;
        }

        // 筛选出对应的重要性
        switch (events[i].importance) {
            case 1:
                importanceStar = "<div style='background-color:#F0F0F0;padding: 2px'>" +
                    "<span style='color: mediumseagreen' class='glyphicon glyphicon-star'></span>" +
                    "<span style='color: mediumseagreen' class='glyphicon glyphicon-star-empty'></span>" +
                    "<span style='color: mediumseagreen' class='glyphicon glyphicon-star-empty'></span>" +
                    "</div>";
                break;
            case 2:
                importanceStar = "<div style='background-color:#F0F0F0;padding: 2px'>" +
                    "<span style='color: #ffae29' class='glyphicon glyphicon-star'></span>" +
                    "<span style='color: #ffae29' class='glyphicon glyphicon-star'></span>" +
                    "<span style='color: #ffae29' class='glyphicon glyphicon-star-empty'></span>" +
                    "</div>";
                break;
            case 3:
                importanceStar = "<div style='background-color:#F0F0F0;padding: 2px'>" +
                    "<span style='color: #ff5959' class='glyphicon glyphicon-star'></span>" +
                    "<span style='color: #ff5959' class='glyphicon glyphicon-star'></span>" +
                    "<span style='color: #ff5959' class='glyphicon glyphicon-star'></span>" +
                    "</div>";
                break;
        }

        if(events[i].actual===""){
            events[i].actual = '--'
        }
        if(events[i].forecast===""){
            events[i].forecast = '--'
        }
        if(events[i].previous===""){
            events[i].previous = '--'
        }

        let info = "<div class=\"event row\" style='margin:15px 0'>" +
                        "<div style='padding-left: 25px' class=\"col-lg-1\">" + new Date(events[i].timestamp * 1000).Format('hh:mm') + "</div>" +
                        "<div style='padding-left: 50px' class=\"col-lg-2\"><img style='width:30px;height:15px; ' src=" + flagImgSrc + "><span style='padding-left: 5px'>" + events[i].country + "</span></div>" +
                        "<div style='padding-left: 25px' class=\"col-lg-4\">" + events[i].title + "</div>" +
                        "<div style='padding-left: 25px;text-align: center' class=\"col-lg-2\">" + importanceStar + "</div>" +
                        "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].actual+ "</div>" +
                        "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].forecast + "</div>" +
                        "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].previous + "</div>" +
                    "</div>";

        infoList += info;
    }
    // return info;
    $('.list_body').html(infoList);
}

var cale = {
    caleAjax: function (timeStamp) {
        $.ajax({
            url: '/api/FinanceInfoCalendar',
            method: 'get',
            data: {
                date_stamp: timeStamp
            },
            success: function (data) {
                // data = data.reverse();
                getEventList(data);
                debugger;
            },
            error: function (a, b, c) {

            }
        })
    }
}

$(document).ready(function () {
    $('#loginBtn').click(function () {
        $('#loginDiv').css({'display': 'block', 'zIndex': '1040'});
    });
    $('#closeLogin').click(function () {
        $('#loginDiv').css({'display': 'none', 'zIndex': '0'});
    });

    timebar.init("calendar", null);

    // doAjax(new Date().Format('yyyy-MM-dd'))

});

