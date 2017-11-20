
<#include '../../cms_common/header.ftl'>
<#include '../bankRate.ftl'>
<style>


</style>


<div id="focusDetail" style="width: 70%;min-height: 405px;margin: 110px 0 0 27%;">
    <input id="happenDate" hidden value=${focus.happenDate} />
    <div>
        <div style="text-align: center;font-size: 26px;font-weight: bold">
            <p>${focus.title}</p>
            <p style="font-size: 12;color:#433f38">${(focus.happenDate)!}</p>
        </div>
        <div style="text-indent: 30px;margin-top: 50px">
            <p>${focus.content}</p>
            <p style="margin-top: 30px">

            </p>
        </div>
    </div>
</div>
<#--<script type="text/javascript" src="../cms/js/script/news_detail.js"></script>-->

<#include '../../cms_common/footer.ftl'>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url:'findFocusNewsList',
            type:'POST',
            data:{
                happenDate:$('#happenDate').val()
            },
            success:(data)=>{

            },
            error:()=>{

            }
        })
    })
</script>