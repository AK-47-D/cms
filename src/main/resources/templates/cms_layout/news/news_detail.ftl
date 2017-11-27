
<#include '../../cms_common/header.ftl'>
<#include '../bankRate.ftl'>
<style>


</style>


<div id="newsDetail" style="width: 70%;min-height: 395px;margin: 110px 0 0 27%;">
    <div>
        <div style="text-align: center;font-size: 26px;font-weight: bold">
            <p>${news.title}</p>
            <p style="font-size: 12;color:#433f38">${news.publishDate}</p>
            <img style="width: 50%" src="${(news.image)!}" />
            <p style="font-size: 12px;font-weight: 100;margin-top: 10px"  id="newsTitle">(新闻图片)</p>
        </div>
        <div style="text-indent: 30px;margin-top: 50px">
            ${news.html}
        </div>
    </div>
</div>
<#--<script type="text/javascript" src="../cms/js/script/news_detail.js"></script>-->
<script type="text/javascript">
    $(function () {
        $('img').each(function(){
            if($(this).attr('src')===''){
                $(this).remove();
                $('#newsTitle').remove();
            }
        })
    })
</script>

<#include '../../cms_common/footer.ftl'>
