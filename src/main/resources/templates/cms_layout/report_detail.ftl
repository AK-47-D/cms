
<#include '../cms_common/header.ftl'>
<#include 'bankRate.ftl'>
<style>


</style>


<div id="reportDetail" style="width: 70%;min-height: 395px;margin: 110px 0 0 27%;">
    <div style="text-align: center;font-size: 26px;font-weight: bold">
        <p>${report.title}</p>
        <p>${report.happenDate}</p>
    </div>
    <div id="pdfContainer" style="text-indent: 30px;margin-top: 50px">

    </div>
</div>

<input id="pdfLink" type="hidden" value="${report.pdf}">
<#--<script type="text/javascript" src="../cms/js/script/news_detail.js"></script>-->
<script type="text/javascript">
    $(function () {

    })
</script>

<#include '../cms_common/footer.ftl'>
