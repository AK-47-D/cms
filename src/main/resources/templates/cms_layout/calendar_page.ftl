<#include '../cms_common/header.ftl'>
<#include 'bankRate.ftl'>

<link href="/cms/css/calendar_page.css" rel="stylesheet"/>
<link href="/cms/css/common.css" rel="stylesheet"/>

<div id="main" style="margin-top: 40px">
    <div id="topSection" >
        <ul id="myTab" class="nav nav-tabs" style="width: 70%;margin: 0 0 20px 26%">
            <li class="active">
                <a href="#fr" data-toggle="tab">
                    美联储
                </a>
            </li>
            <li>
                <a href="#ecb" data-toggle="tab">
                    欧洲央行
                </a>
            </li>
            <li>
                <a href="#boe" data-toggle="tab">
                    英国央行
                </a>
            </li>
            <li>
                <a href="#boj" data-toggle="tab">
                    日本央行
                </a>
            </li>
            <li>
                <a href="#rba" data-toggle="tab">
                    澳大利亚联储
                </a>
            </li>
            <li>
                <a href="#rzbn" data-toggle="tab">
                    新西兰联储
                </a>
            </li>
            <li>
                <a href="#snb" data-toggle="tab">
                    瑞士央行
                </a>
            </li>
            <li>
                <a href="#boc" data-toggle="tab">
                    加拿大央行
                </a>
            </li>

        </ul>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade in active" id="fr">
                <div id="fr_calendar" style="width: 70%;margin: 0 0 0 26%;"></div>
                <#include 'calendar_event_list.ftl'>
            </div>
            <div class="tab-pane fade" id="ecb">
                <div id="ecb_calendar" style="width: 70%;margin: 0 0 0 26%;"></div>
                <#include 'calendar_event_list.ftl'>
            </div>
            <div class="tab-pane fade" id="boe">
                <div id="boe_calendar" style="width: 70%;margin: 0 0 0 26%;"></div>
                <#include 'calendar_event_list.ftl'>
            </div>
            <div class="tab-pane fade" id="boj">
                <div id="boj_calendar" style="width: 70%;margin: 0 0 0 26%;"></div>
                <#include 'calendar_event_list.ftl'>
            </div>
            <div class="tab-pane fade" id="rba">
                <div id="rba_calendar" style="width: 70%;margin: 0 0 0 26%;"></div>
                <#include 'calendar_event_list.ftl'>
            </div>
            <div class="tab-pane fade" id="rzbn">
                <div id="rzbn_calendar" style="width: 70%;margin: 0 0 0 26%;"></div>
                <#include 'calendar_event_list.ftl'>
            </div>
            <div class="tab-pane fade" id="snb">
                <div id="snb_calendar" style="width: 70%;margin: 0 0 0 26%;"></div>
                <#include 'calendar_event_list.ftl'>
            </div>
            <div class="tab-pane fade" id="boc">
                <div id="boc_calendar" style="width: 70%;margin: 0 0 0 26%;"></div>
                <#include 'calendar_event_list.ftl'>
            </div>
        </div>
    </div>
</div>




<script type="text/javascript" src="/cms/js/script/calendar_page.js"></script>
<script type="text/javascript" src="/cms/js/lib/timebar.js"></script>
