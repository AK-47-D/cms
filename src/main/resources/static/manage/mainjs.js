var mainjs = {
    getRemoveHtml: function (value) {
        return value.replace(/<[^>]+>/g, "");
    },
    getCountry: function () {
        if (mainjs.countryList == null) {
            $.ajax({
                url: "/findCountryList",
                method: 'get',
                dataType: 'json',
                async: false,
                success: function (data) {
                    mainjs.countryList = data;
                },
                error: function (data) {
                    mainjs.createDefaultPNotify("异常", "请联系管理员", "error");
                }
            })
        }
        return mainjs.countryList;
    },
    getBank: function () {
        if (mainjs.bankList == null) {
            $.ajax({
                url: "/findBankList",
                method: 'get',
                dataType: 'json',
                async: false,
                success: function (data) {
                    mainjs.bankList = data;
                },
                error: function (data) {
                    mainjs.createDefaultPNotify("异常", "请联系管理员", "error");
                }
            })
        }
        return mainjs.bankList;
    },
    getLevel: function () {
        if (mainjs.levelList == null) {
            $.ajax({
                url: "/findLevelList",
                method: 'get',
                dataType: 'json',
                async: false,
                success: function (data) {
                    mainjs.levelList = data;
                },
                error: function (data) {
                    mainjs.createDefaultPNotify("异常", "请联系管理员", "error");
                }
            })
        }
        return mainjs.levelList;
    },
    getFrom: function () {
        if (mainjs.fromList == null) {
            $.ajax({
                url: "/findFromList",
                method: 'get',
                dataType: 'json',
                async: false,
                success: function (data) {
                    mainjs.fromList = data;
                },
                error: function (data) {
                    mainjs.createDefaultPNotify("异常", "请联系管理员", "error");
                }
            })
        }
        return mainjs.fromList;
    },
    createPNotify: function (title, text, type, delay) {
        new PNotify({
            title: title,
            styling: 'bootstrap3',
            text: text,
            type: type,
            delay: delay
        });
    },
    createDefaultPNotify: function (title, text, type) {
        this.createPNotify(title, text, type, 5000);
    },
    contentLoadAddBreadCrumb: function (title, url, data, fun) {
        this.contentLoad(url, data, fun);
        $("[data-flg=breadcrumb]").find('.breadcrumb').append(this.createBreadCrumbLi(url, title, "class='active'"));
    },
    contentLoad: function (url, data, fun) {
        $("[data-flg=content]").load(url, data, fun);
    },
    createBreadCrumbLi: function (url, title, attr) {
        if (attr) {
            $("[data-flg=breadcrumb]").find('li').removeClass('active');
        } else {
            attr = "";
        }
        return "<li " + attr + "><a href=\"javascript:void(0)\" onclick=\"mainjs.contentLoadRemoveAfter('" + url + "',this)\">" + title + "</a></li>"
    },
    contentLoadRemoveAfter: function (url, a) {
        mainjs.contentLoad(url);
        $(a).parent().nextAll().remove();
    },
    createBreadCrumb: function (title, titleEn, titleObj) {
        var html = "<section class=\"content-header\">\n" +
            "    <h1>\n" +
            title +
            "        <small>" + (titleEn ? titleEn : "") + "</small>\n" +
            "    </h1>\n" +
            "    <ol class=\"breadcrumb\">\n" +
            "        <li><a href=\"/manage/main\"><i class=\"fa fa-dashboard\"></i> 主页</a></li>\n";
        $(titleObj).each(function (index, row) {
            if (index == titleObj.length - 1) {
                html += mainjs.createBreadCrumbLi(row.url, row.title, 'class="active"');
            } else {
                html += mainjs.createBreadCrumbLi(row.url, row.title, null);
            }

            $("[data-flg=breadcrumb]").html(html);
        });

        html += "    </ol>\n" +
            "</section>"
        return html;
    },
    checkIE :function () {
        var Sys = {};
        var ua = navigator.userAgent.toLowerCase();
        if (window.ActiveXObject) {
            Sys.ie = ua.match(/msie ([\d.]+)/)[1];
            //获取版本
            var ie_version = 6;
            if (Sys.ie.indexOf("7") > -1) {
                ie_version = 7;
            }
            if (Sys.ie.indexOf("8") > -1) {
                ie_version = 8;
            }
            if (Sys.ie.indexOf("9") > -1) {
                ie_version = 9;
            }
            if (Sys.ie.indexOf("10") > -1) {
                ie_version = 10;
            }
            if (Sys.ie.indexOf("11") > -1) {
                ie_version = 11;
            }
        }
        else if (ua.indexOf("firefox") > -1)
            Sys.firefox = ua.match(/firefox\/([\d.]+)/)[1];
        else if (ua.indexOf("chrome") > -1)
            Sys.chrome = ua.match(/chrome\/([\d.]+)/)[1];
        else if (window.opera)
            Sys.opera = ua.match(/opera.([\d.]+)/)[1];
        else if (window.openDatabase)
            Sys.safari = ua.match(/version\/([\d.]+)/)[1];

        return Sys;
    }
}

Date.prototype.Format = function (formatStr) {
    var str = formatStr;
    var Week = ['日', '一', '二', '三', '四', '五', '六'];

    str = str.replace(/yyyy|YYYY/, this.getFullYear());
    str = str.replace(/yy|YY/, (this.getYear() % 100) > 9 ? (this.getYear() % 100) : '0' + (this.getYear() % 100));

    str = str.replace(/MM/, this.getMonth() > 8 ? this.getMonth() + 1 : '0' + (this.getMonth() + 1));
    str = str.replace(/M/g, this.getMonth() + 1);

    str = str.replace(/w|W/g, Week[this.getDay()]);

    str = str.replace(/dd|DD/, this.getDate() > 9 ? this.getDate() : '0' + this.getDate());
    str = str.replace(/d|D/g, this.getDate());

    str = str.replace(/hh|HH/, this.getHours() > 9 ? this.getHours() : '0' + this.getHours());
    str = str.replace(/h|H/g, this.getHours());
    str = str.replace(/mm/, this.getMinutes() > 9 ? this.getMinutes() : '0' + this.getMinutes());
    str = str.replace(/m/g, this.getMinutes());

    str = str.replace(/ss|SS/, this.getSeconds() > 9 ? this.getSeconds() : '0' + this.getSeconds());
    str = str.replace(/s|S/g, this.getSeconds());

    return str;
};