
<#include '../../cms_common/header.ftl'>
<#include '../bankRate.ftl'>
<style>


</style>


<div id="newsDetail" style="width: 70%;min-height: 395px;margin: 110px 0 0 27%;">
    <div>
        <div style="text-align: center;font-size: 26px;font-weight: bold">
            <p>${news.title}</p>
            <p style="font-size: 12;color:#f0f0f0">${news.publishDate}</p>
        </div>
        <div style="text-indent: 30px;margin-top: 50px">
            ${news.html}
        </div>
    </div>
</div>
<#--<script type="text/javascript" src="../cms/js/script/news_detail.js"></script>-->

<#include '../../cms_common/footer.ftl'>
