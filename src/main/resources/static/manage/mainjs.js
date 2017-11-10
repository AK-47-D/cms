var mainjs = {
    createPNotify:function(title,text,type,delay){
        new PNotify({
            title: title,
            styling : 'bootstrap3',
            text: text,
            type: type,
            delay:delay
        });
    },
    createDefaultPNotify:function(title,text,type){
        this.createPNotify(title,text,type,5000);
    },
    contentLoadAddBreadCrumb:function(title,url,data,fun){
      this.contentLoad(url,data,fun);
      $("[data-flg=breadcrumb]").find('.breadcrumb').append(this.createBreadCrumbLi(url,title,"class='active'"));
    },
    contentLoad:function(url,data,fun){
        $("[data-flg=content]").load(url,data,fun);
    },
    createBreadCrumbLi:function(url,title,attr){
        if(attr){
            $("[data-flg=breadcrumb]").find('li').removeClass('active');
        }else{
           attr = "";
        }
        return "<li " + attr + "><a href=\"javascript:void(0)\" onclick=\"mainjs.contentLoadRemoveAfter('" + url + "',this)\">" + title + "</a></li>"
    },
    contentLoadRemoveAfter:function(url,a){
        mainjs.contentLoad(url);
        $(a).parent().nextAll().remove();
    },
    createBreadCrumb:function(title,titleEn,titleObj){
        var html =  "<section class=\"content-header\">\n" +
            "    <h1>\n" +
            title +
            "        <small>" + (titleEn?titleEn:"") + "</small>\n" +
            "    </h1>\n" +
            "    <ol class=\"breadcrumb\">\n" +
            "        <li><a href=\"/manage/main\"><i class=\"fa fa-dashboard\"></i> 主页</a></li>\n";
        $(titleObj).each(function(index,row){
            if(index == titleObj.length-1){
                html += mainjs.createBreadCrumbLi(row.url,row.title,'class="active"') ;
            }else{
                html += mainjs.createBreadCrumbLi(row.url,row.title,null) ;
            }

            $("[data-flg=breadcrumb]").html(html);
        });

        html += "    </ol>\n" +
            "</section>"
        return html;
    }
}