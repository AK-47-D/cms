<link rel="stylesheet" type="text/css" href="/cms/css/default.css">
<link rel="stylesheet" type="text/css" href="/cms/css/jquery.classycountdown.css" />

<#include '../../cms_common/header.ftl'>
<#include '../bankRate.ftl'>
<style>
    .ClassyCountdownDemo { margin:-30px 0 0 12%; max-width:800px; width:80%; padding:30px; display:block }
</style>


<div id="focusDetail" style="width: 70%;min-height: 405px;margin: 110px 0 0 27%;">
    <div id="countdown" class="ClassyCountdownDemo"></div>
    <input id="happenDate" hidden value=${focus.happenDate} />
    <div>
        <div style="text-align: center;font-size: 26px;font-weight: bold;color: #5f5c5c">
            <p style="letter-spacing: 5px;color: #3498db">${focus.title}</p>
            <p id="happenTime" style="font-size: 12;color:#abb7be">${(focus.happenDate)!}</p>
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
<script src="/cms/js/lib/jquery.knob.js"></script>
<script src="/cms/js/lib/jquery.throttle.js"></script>
<script src="/cms/js/lib/jquery.classycountdown.js"></script>
<script type="text/javascript">
    $(function () {

        $('#countdown').ClassyCountdown({
            theme: "flat-colors-very-wide",
            now: $.now(),
            end: new Date($('#happenTime').html()).getTime()
        });

        $.ajax({
            url:'findFocusNewsList',
            type:'POST',
            data:{
                happenDate:$('#happenDate').val()
            },
            success:(data)=>{
                debugger;
            },
            error:(a,b,c)=>{
                debugger;
            }
        })
    })
</script>