/**
 * @Name：可复用的日期控件
 * @author：cqf
 * @date：2017年11月12日下午
 */
var timebar = new function () {

    this.init = initTimeBar;  // 初始化日历控件
    this.getDate = getDisDate; // 获取当前所选的日期
    this.nextTime = nextTime;
    this.lastTime = lastTime;
    this.changeTime = changeTime;

    var now = new Date();
    var todayFlag = 1;
    var prevFlag = 1;

    /*
     * 初始化时间控件，传入要渲染div的id，和时间的点击事件
     */
    function initTimeBar(id, evn) {
        var timeHtml = '<p id="'+id+'Text" class="calendar-year calyearp"></p>' +
            '<a style="display: inline-block;margin-top: 15px;" href="javascript:timebar.nextTime('+id+');" class="mt20 calendar-btn calendar-btn-l"><span class="glyphicon glyphicon-chevron-left"></span></a>' +
            '<a style="display: inline-block;margin-top: 15px;" href="javascript:timebar.lastTime('+id+');" class="mt20 calendar-btn calendar-btn-r"><span class="glyphicon glyphicon-chevron-right"></span></a>' +
            '<div class="calendar-day">' +
				'<ul class="week week-hd">' +
					'<li class="wli1">日</li>' +
					'<li class="wli2">一</li>' +
					'<li class="wli3">二</li>' +
					'<li class="wli4">三</li>' +
					'<li class="wli5">四</li>' +
					'<li class="wli6">五</li>' +
					'<li class="wli7">六</li>' +
				'</ul>' +
				'<ul class="week week-day dul" >' +
					'<li class="dli1"><span>1</span><input type="hidden" value=""/></li>' +
					'<li class="dli2"><span>2</span><input type="hidden" value=""/></li>' +
					'<li class="dli3"><span>3</span><input type="hidden" value=""/></li>' +
					'<li class="dli4 duty-cur"><span>4</span><input type="hidden" value=""/></li>' +
					'<li class="dli5"><span>5</span><input type="hidden" value=""/></li>' +
					'<li class="dli6"><span>6</span><input type="hidden" value=""/></li>' +
					'<li class="dli7"><span>7</span><input type="hidden" value=""/></li>' +
				'</ul>' +
			'</div>';
        
        $('#' + id).html(timeHtml);
        showTime(id);//初始化时间
        // var distime = $("#dli4 input").val();
        var distime = $('#' + id).find(".dli4 input").val();
        changeTime(distime,id);//改变显示时间
        changeTimeStyle(id);//改变选中节点样式
        $("#" + id).find(".dul li").click(function () {
            
            clickTime(id,this.className);
            if (evn) {
                evn();
            }
        })
    }

    /*
     * 时间显示
     */
    function showTime(id) {
        var d = new Array(7);
        //var now = new Date();
        d[3] = now;
        d[2] = getLastDay(now);
        d[1] = getLastDay(d[2]);
        d[0] = getLastDay(d[1]);
        d[4] = getNextDay(now);
        d[5] = getNextDay(d[4]);
        d[6] = getNextDay(d[5]);
        setDataText(d,id);
        changeTimeStyle(id);
    }

    /*
     * 通过时间给文本赋值
     */
    function setDataText(d,id) {
        for (let i = 0; i < 7; i++) {
            let year = d[i].getYear() + 1900;
            let sunday = d[i].getDay();
            let month = d[i].getMonth() + 1;
            let day = d[i].getDate();
            $('#'+id).find(".wli" + (i + 1)).html(getweek(sunday));//给星期文本复制
            $('#'+id).find(".dli" + (i + 1) + " span").html(day);//给日期文本复制
            if (month < 10)
                month = "0" + month;
            if (day < 10)
                day = "0" + day;
            $('#'+id).find(".dli" + (i + 1) + " input").val(year + "-" + month + "-" + day);//给隐藏日期赋值
            //周六周日边变红
            if (getweek(sunday) == "日" || getweek(sunday) == "六") {
                $('#'+id).find(".wli" + (i + 1)).css("color", "red");
            }
            else {
                $('#'+id).find(".wli" + (i + 1)).css("color", "black");
            }
        }
    }

    /*
     * 设置显示日期
     * return: 当前选择日期
     */
    function getDisDate() {
        var time = $("#" + id + " input").val();
        var t = time.split("-");
        if (t[1].length == 1) t[1] = "0" + t[1];
        if (t[2].length == 1) t[2] = "0" + t[2];
        return new Date(t[0], t[1] - 1, t[2]);
    }

    /*
     * 获取时间
     */
    function clickTime(id,clickClass) {
        debugger;
        
        if(clickClass.includes('duty-cur')){
            return;
        }
        
        if (todayFlag) {
            $('#' + id).find(".dul li span").addClass('duty-prev')
        }
        $('#' + id).find(".dul li").removeClass("duty-cur");
        $("#" + id).find(".dul ."+clickClass).addClass("duty-cur");
        var time = $(event.currentTarget).find('input').val();
        
        changeTime(time,id);
        todayFlag = 0;

    }

    /*
     *改变选中显示时间
     */
    function changeTime(time,id) {
        var t = time.split("-");
        if (t[1].length == 1)
            t[1] = "0" + t[1];
        if (t[2].length == 1)
            t[2] = "0" + t[2];
        // $('#'+id).find(".calendar-year").html(t[0] + "年" + t[1] + "月" + t[2] + "日");
        $('#'+id+'Text').html(t[0] + "年" + t[1] + "月" + t[2] + "日");
        cale.caleAjax(time,id)
    }

    /*
     * 改变选中结点样式
     */
    function changeTimeStyle(id) {

        $('#'+id).find(".dul li").removeClass("duty-cur");
        var time = $(".calendar-year").html();
        var y = time.substring(0, 4);
        var m = time.substring(5, 7);
        var d = time.substring(8, 10);
        time = y + "-" + m + "-" + d;
        for (let i = 0; i < 7; i++) {
            if ($('#'+id).find(".dli" + (i + 1) + " input").val() == time){
                $('#'+id).find(".dli" + (i + 1)).addClass("duty-cur");
            }
        }
        for(let i = 0;i<7;i++){
            if($('#'+id).find(".dli" + (i + 1)).hasClass('duty-cur')){
                $('#'+id).find(".dli" + (i + 1)).prev().addClass('duty-prev');
                $('#'+id).find(".dli" + (i + 1)).next().addClass('duty-next');
            }
        }

    }

    /*
     * 时间切换,向左滚动,后退（左箭头点击事件）
     */
    function nextTime(id) {
        now = getLastDay(now);
        showTime(id.id);
    }

    /*
     * 时间切换,向右滚动,前进（右箭头点击事件）
     */
    function lastTime(id) {
        now = getNextDay(now);
        showTime(id.id);
    }

    /*
     * 获取后一天的时间
     */
    function getNextDay(d) {
        d = new Date(d);
        d = +d + 1000 * 60 * 60 * 24;
        d = new Date(d);
        return d;
    }

    /*
     * 获取前一天的时间
     */
    function getLastDay(d) {
        d = new Date(d);
        d = +d - 1000 * 60 * 60 * 24;
        d = new Date(d);
        return d;
    }

    /*
     * 获取星期
     */
    function getweek(day) {
        var week = "";
        switch (day) {
            case 0:
                week = "日";
                break;
            case 1:
                week = "一";
                break;
            case 2:
                week = "二";
                break;
            case 3:
                week = "三";
                break;
            case 4:
                week = "四";
                break;
            case 5:
                week = "五";
                break;
            case 6:
                week = "六";
                break;
        }
        return week;
    }

}
