<#include '../cms_common/header.ftl'>
<#include '../cms_common/left.ftl'>

<link href="/cms/css/calendar_page.css" rel="stylesheet"/>
<link href="/cms/css/common.css" rel="stylesheet"/>

<div id="main" style="margin-top: 40px">
    <div id="topSection" >
        <div id="calendar" style="width: 70%;margin: 4% 0 0 26%;"></div>
    </div>
    <div id="eventList" style="width: 70%;margin: 4% 0 0 30%;">
        <div class="container-fluid" style="margin-top: 0.5%">
            <div class="list_header row">
                <div class="col-lg-1">时间</div>
                <div class="col-lg-1">地区</div>
                <div class="col-lg-4">事件</div>
                <div class="col-lg-1">重要性</div>
                <div class="col-lg-1">今值</div>
                <div class="col-lg-1">预期</div>
                <div class="col-lg-1">前值</div>
            </div>
            <div class="list_body" style="text-align: left;color: #333"></div>
        </div>
    </div>

</div>

<script type="text/javascript" src="/cms/js/lib/bootstrap.js"></script>
<script type="text/javascript" src="/cms/js/script/calendar_page.js"></script>
<script type="text/javascript" src="/cms/js/lib/timebar.js"></script>