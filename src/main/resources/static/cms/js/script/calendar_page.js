let fr_calendar_infoList = '';
let ecb_calendar_infoList = '';
let boe_calendar_infoList = '';
let boj_calendar_infoList = '';
let rba_calendar_infoList = '';
let rzbn_calendar_infoList = '';
let snb_calendar_infoList = '';
let boc_calendar_infoList = '';


var countryList = mainjs.getCountry();

function getEventList(events,id) {
    debugger;

    fr_calendar_infoList = '';
    ecb_calendar_infoList = '';
    boe_calendar_infoList = '';
    boj_calendar_infoList = '';
    rba_calendar_infoList = '';
    rzbn_calendar_infoList = '';
    snb_calendar_infoList = '';
    boc_calendar_infoList = '';

    for (let i = 0; i < events.length; i++) {
        let flagImgSrc = '';
        let importanceStar = '';
        let boe_calendar_info = '';
        let boj_calendar_info = '';
        let boc_calendar_info = '';
        let snb_calendar_info = '';
        let fr_calendar_info = '';
        let rba_calendar_info = '';
        let rzbn_calendar_info = '';
        let ecb_calendar_info = '';

        // 筛选出对应的重要性
        switch (events[i].level) {
            case 1:
                importanceStar = "<div style='background-color:#F0F0F0;padding: 2px;width: 40%;margin-left: 30%'>" +
                    "<span style='color: mediumseagreen' class='glyphicon glyphicon-star'></span>" +
                    "<span style='color: mediumseagreen' class='glyphicon glyphicon-star-empty'></span>" +
                    "<span style='color: mediumseagreen' class='glyphicon glyphicon-star-empty'></span>" +
                    "</div>";
                break;
            case 2:
                importanceStar = "<div style='background-color:#F0F0F0;padding: 2px;width: 40%;margin-left: 30%'>" +
                    "<span style='color: #ffae29' class='glyphicon glyphicon-star'></span>" +
                    "<span style='color: #ffae29' class='glyphicon glyphicon-star'></span>" +
                    "<span style='color: #ffae29' class='glyphicon glyphicon-star-empty'></span>" +
                    "</div>";
                break;
            case 3:
                importanceStar = "<div style='background-color:#F0F0F0;padding: 2px;width: 40%;margin-left: 30%'>" +
                    "<span style='color: #ff5959' class='glyphicon glyphicon-star'></span>" +
                    "<span style='color: #ff5959' class='glyphicon glyphicon-star'></span>" +
                    "<span style='color: #ff5959' class='glyphicon glyphicon-star'></span>" +
                    "</div>";
                break;
        }

        if(events[i].nu===""){
            events[i].nu = '--'
        }
        if(events[i].cpi===""){
            events[i].cpi = '--'
        }
        if(events[i].gdp===""){
            events[i].gdp = '--'
        }

        // 筛选出对应的国旗
        switch (events[i].country) {
            // 欧洲
            case 1:
                flagImgSrc = "https://wpimg.wallstcn.com/4b/8f/f7/eurozone-2x.png";
                ecb_calendar_info = "<div class=\"event row\" style='margin:15px 0'>" +
                    "<div style='padding-left: 25px' class=\"col-lg-1\">" + new Date(events[i].happenDate).Format('hh:mm') + "</div>" +
                    "<div style='padding-left: 50px' class=\"col-lg-2\"><img style='width:30px;height:15px; ' src=" + flagImgSrc + "><span style='padding-left: 5px'>" + countryList[events[i].country].detail + "</span></div>" +
                    "<div style='padding-left: 25px' class=\"col-lg-4\"><a target=\"_blank\" href='/focus/"+events[i].id+"'>"+events[i].title+"</a></div>" +
                    "<div style='padding-left: 25px;text-align: center' class=\"col-lg-2\">" + importanceStar + "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].nu+ "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].cpi + "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].gdp + "</div>" +
                    "</div>";

                ecb_calendar_infoList += ecb_calendar_info;
                break;
            case 3:
                // 日本
                flagImgSrc = "https://wpimg.wallstcn.com/84/39/2c/japan-2x.png";
                boj_calendar_info = "<div class=\"event row\" style='margin:15px 0'>" +
                    "<div style='padding-left: 25px' class=\"col-lg-1\">" + new Date(events[i].happenDate).Format('hh:mm') + "</div>" +
                    "<div style='padding-left: 50px' class=\"col-lg-2\"><img style='width:30px;height:15px; ' src=" + flagImgSrc + "><span style='padding-left: 5px'>" + countryList[events[i].country].detail + "</span></div>" +
                    "<div style='padding-left: 25px' class=\"col-lg-4\"><a target=\"_blank\" href='/focus/"+events[i].id+"'>"+events[i].title+"</a></div>" +
                    "<div style='padding-left: 25px;text-align: center' class=\"col-lg-2\">" + importanceStar + "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].nu+ "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].cpi + "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].gdp + "</div>" +
                    "</div>";

                boj_calendar_infoList += boj_calendar_info;
                break;
            case '中国':
                flagImgSrc = "https://wpimg.wallstcn.com/de/bf/b5/china-2x.png";
                break;
            case 7:
                // 加拿大
                flagImgSrc = "https://wpimg.wallstcn.com/96/ef/7b/candar-2x.png";
                boc_calendar_info = "<div class=\"event row\" style='margin:15px 0'>" +
                    "<div style='padding-left: 25px' class=\"col-lg-1\">" + new Date(events[i].happenDate).Format('hh:mm') + "</div>" +
                    "<div style='padding-left: 50px' class=\"col-lg-2\"><img style='width:30px;height:15px; ' src=" + flagImgSrc + "><span style='padding-left: 5px'>" + countryList[events[i].country].detail + "</span></div>" +
                    "<div style='padding-left: 25px' class=\"col-lg-4\"><a target=\"_blank\" href='/focus/"+events[i].id+"'>"+events[i].title+"</a></div>" +
                    "<div style='padding-left: 25px;text-align: center' class=\"col-lg-2\">" + importanceStar + "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].nu+ "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].cpi + "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].gdp + "</div>" +
                    "</div>";

                boc_calendar_infoList += boc_calendar_info;
                break;
            case 6:
                // 瑞士
                flagImgSrc = "https://wpimg.wallstcn.com/2e/ef/c6/swit-2x.png";
                snb_calendar_info = "<div class=\"event row\" style='margin:15px 0'>" +
                    "<div style='padding-left: 25px' class=\"col-lg-1\">" + new Date(events[i].happenDate).Format('hh:mm') + "</div>" +
                    "<div style='padding-left: 50px' class=\"col-lg-2\"><img style='width:30px;height:15px; ' src=" + flagImgSrc + "><span style='padding-left: 5px'>" + countryList[events[i].country].detail + "</span></div>" +
                    "<div style='padding-left: 25px' class=\"col-lg-4\"><a target=\"_blank\" href='/focus/"+events[i].id+"'>"+events[i].title+"</a></div>" +
                    "<div style='padding-left: 25px;text-align: center' class=\"col-lg-2\">" + importanceStar + "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].nu+ "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].cpi + "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].gdp + "</div>" +
                    "</div>";

                snb_calendar_infoList += snb_calendar_info;
                break;
            case 0:
                // 美国
                debugger;
                flagImgSrc = "https://wpimg.wallstcn.com/32/75/86/usa-2x.png";
                fr_calendar_info = "<div class=\"event row\" style='margin:15px 0'>" +
                    "<div style='padding-left: 25px' class=\"col-lg-1\">" + new Date(events[i].happenDate).Format('hh:mm') + "</div>" +
                    "<div style='padding-left: 50px' class=\"col-lg-2\"><img style='width:30px;height:15px; ' src=" + flagImgSrc + "><span style='padding-left: 5px'>" + countryList[events[i].country].detail + "</span></div>" +
                    "<div style='padding-left: 25px' class=\"col-lg-4\"><a target=\"_blank\" href='/focus/"+events[i].id+"'>"+events[i].title+"</a></div>" +
                    "<div style='padding-left: 25px;text-align: center' class=\"col-lg-2\">" + importanceStar + "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].nu+ "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].cpi + "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].gdp + "</div>" +
                    "</div>";

                fr_calendar_infoList += fr_calendar_info;
                break;
            case 4:
                // 澳大利亚
                flagImgSrc = "https://wpimg.wallstcn.com/81/fe/c2/australian-2x.png";
                rba_calendar_info = "<div class=\"event row\" style='margin:15px 0'>" +
                    "<div style='padding-left: 25px' class=\"col-lg-1\">" + new Date(events[i].happenDate).Format('hh:mm') + "</div>" +
                    "<div style='padding-left: 50px' class=\"col-lg-2\"><img style='width:30px;height:15px; ' src=" + flagImgSrc + "><span style='padding-left: 5px'>" + countryList[events[i].country].detail + "</span></div>" +
                    "<div style='padding-left: 25px' class=\"col-lg-4\"><a target=\"_blank\" href='/focus/"+events[i].id+"'>"+events[i].title+"</a></div>" +
                    "<div style='padding-left: 25px;text-align: center' class=\"col-lg-2\">" + importanceStar + "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].nu+ "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].cpi + "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].gdp + "</div>" +
                    "</div>";

                rba_calendar_infoList += rba_calendar_info;
                break;
            case 2:
                // 美国
                flagImgSrc = "https://wpimg.wallstcn.com/0d/ce/36/england.png";
                boe_calendar_info = "<div class=\"event row\" style='margin:15px 0'>" +
                    "<div style='padding-left: 25px' class=\"col-lg-1\">" + new Date(events[i].happenDate).Format('hh:mm') + "</div>" +
                    "<div style='padding-left: 50px' class=\"col-lg-2\"><img style='width:30px;height:15px; ' src=" + flagImgSrc + "><span style='padding-left: 5px'>" + countryList[events[i].country].detail + "</span></div>" +
                    "<div style='padding-left: 25px' class=\"col-lg-4\"><a target=\"_blank\" href='/focus/"+events[i].id+"'>"+events[i].title+"</a></div>" +
                    "<div style='padding-left: 25px;text-align: center' class=\"col-lg-2\">" + importanceStar + "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].nu+ "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].cpi + "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].gdp + "</div>" +
                    "</div>";

                boe_calendar_infoList += boe_calendar_info;
                break;
            case '法国':
                flagImgSrc = "https://wpimg.wallstcn.com/7b/be/12/france-2x.png";
                break;
            case '德国':
                flagImgSrc = "https://wpimg.wallstcn.com/5d/29/59/germany-2x.png";
            break;
            case 5:
                // 新西兰
                flagImgSrc = "https://wpimg.wallstcn.com/f8/f5/ee/zealand-2x.png";
                rzbn_calendar_info = "<div class=\"event row\" style='margin:15px 0'>" +
                    "<div style='padding-left: 25px' class=\"col-lg-1\">" + new Date(events[i].happenDate).Format('hh:mm') + "</div>" +
                    "<div style='padding-left: 50px' class=\"col-lg-2\"><img style='width:30px;height:15px; ' src=" + flagImgSrc + "><span style='padding-left: 5px'>" + countryList[events[i].country].detail + "</span></div>" +
                    "<div style='padding-left: 25px' class=\"col-lg-4\"><a target=\"_blank\" href='/focus/"+events[i].id+"'>"+events[i].title+"</a></div>" +
                    "<div style='padding-left: 25px;text-align: center' class=\"col-lg-2\">" + importanceStar + "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].nu+ "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].cpi + "</div>" +
                    "<div style='padding-left: 15px;text-align: center' class=\"col-lg-1\">" + events[i].gdp + "</div>" +
                    "</div>";

                rzbn_calendar_infoList += rzbn_calendar_info;
                break;
            case '挪威':
                flagImgSrc = "https://wpimg.wallstcn.com/98/08/ca/nuowei.png";
                break;
            case '瑞典':
                flagImgSrc = "https://wpimg.wallstcn.com/96/bf/dd/ruidian.png";
                break;
            case '意大利':
                flagImgSrc = "https://wpimg.wallstcn.com/19/b4/4f/italy-2x.png";
            break;
            case '西班牙':
                flagImgSrc = "https://wpimg.wallstcn.com/d6/b5/a5/spain-2x.png";
            break;
            default:
                flagImgSrc = "/cms/img/default.png";
        }

    }

    $('#fr_calendar').next().find('.list_body').html(fr_calendar_infoList);
    $('#ecb_calendar').next().find('.list_body').html(ecb_calendar_infoList);
    $('#boe_calendar').next().find('.list_body').html(boe_calendar_infoList);
    $('#boj_calendar').next().find('.list_body').html(boj_calendar_infoList);
    $('#rba_calendar').next().find('.list_body').html(rba_calendar_infoList);
    $('#rzbn_calendar').next().find('.list_body').html(rzbn_calendar_infoList);
    $('#snb_calendar').next().find('.list_body').html(snb_calendar_infoList);
    $('#boc_calendar').next().find('.list_body').html(boc_calendar_infoList);


}

var cale = {
    caleAjax: function (timeStamp,id) {
        debugger;
        $.ajax({
            url: '/findFocusList',
            type: 'post',
            data: {
                happenDate: timeStamp
            },
            success: function (data) {
                // data = data.reverse();
                debugger;
                getEventList(data,id);

            },
            error: function (a, b, c) {

            }
        })
    }
};

$(document).ready(function () {

    timebar.init("fr_calendar",null);
    timebar.init("ecb_calendar",null);
    timebar.init("boe_calendar",null);
    timebar.init("boj_calendar",null);
    timebar.init("rba_calendar",null);
    timebar.init("rzbn_calendar",null);
    timebar.init("snb_calendar",null);
    timebar.init("boc_calendar",null);

});

