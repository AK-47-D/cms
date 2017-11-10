$(function () {
    $.ajax({
        url: "/manage/findMenu",
        method: 'post',
        data: {userId: 1},
        dataType: 'json',
        success: function (data) {
            $(data.result).each(function(index,item){
                $("[flg=menu]").append(left.menu(item,item.childMenu));
            })
            $("[data-flg=left-menu]").unbind().bind('click',function(){
                $("[flg=menu]").find("li").removeClass('active');
                $(this).parent().addClass("active")
                mainjs.contentLoad($(this).attr("data-url"),null,null)
            })
        }
    })
})
var left = {
    menu: function (parentMenu, childMenu) {
        var html = "<li class=\"treeview\">\n" +
            "<a href=\"#\">\n" +
            "<i ></i> <span>" + parentMenu.name + "</span>\n" +
            "<span class=\"pull-right-container\">\n" +
            "  <i class=\"fa fa-angle-left pull-right\"></i>\n" +
            "</span>\n" +
            "</a>\n";
        if (childMenu && childMenu.length > 0) {
            html += "<ul class=\"treeview-menu\">\n";
            $(childMenu).each(function(index,row){
                html += "<li ><a data-flg='left-menu' href='javascript:void(0)' data-url='" + row.url + "'><i class=\"fa fa-circle-o\"></i>" + row.name + "</a></li>\n";
            })
            html += "</ul>\n";
        }
        html += "</li>";
        return html;
    }
}