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
                <div class="col-lg-1">提醒</div>
            </div>
            <div class="list_body"></div>
        </div>

    </div>



    <#--<div id="newsDiv" class="col-lg-9 pull-right" style="padding: 0 30px;margin-top: 40px">-->
        <#--<div data-news>-->
            <#--<div class="news-item" data-index="0" data-news>-->

                <#--<div class="news-item__main">-->
                    <#--<a target="_blank" href="/premium/articles/3039367" class="news-item__main__title">-->
                        <#--热议到“炸裂”！行研和策略突然都盯上了这个板块——11月5日A股脱水研报-->
                    <#--</a>-->
                    <#--<a target="_blank" href="/premium/articles/3039367" class="news-item__main__summary">-->
                        <#--今日猛料超多：1、周末最燃话题半导体，最全的产业链梳理，最硬的基本面牛股，如何在叠加次新，简直了！想知道的全在这，非常详尽；2、两大事件重磅催化，优质次新标的梳理；3、除了单月涨幅40%的金牌橱柜，还有哪些高送转潜力股值得配；4、国家大基金唯一参股，国内短期无对手，这家电子材料公司真的牛上天了；5、不能小觑需求引发的爆炸，从底部爬起来的这家会复制京东方走势吗？6、意外发现一家业绩弹性很大的家电股进入了重仓TOP10。-->
                    <#--</a>-->
                    <#--<div class="news-item__main__meta">-->
                        <#--<div class="news-item__main__meta__left">-->
                            <#--<div class="left-item">-->
                                <#--<a target="_blank" href="/authors/120000000496" class="display-name">脱水研报</a></div>-->
                            <#--<!--&ndash;&gt; <!--&ndash;&gt;-->
                            <#--<div class="left-item">-->
                                <#--<span class="text">2小时前</span>-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div class="news-item__main__meta__right"></div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="news-item" data-index="1" data-news>-->

                <#--<div class="news-item__main">-->
                    <#--<a target="_blank" href="/premium/articles/3039367" class="news-item__main__title">-->
                        <#--早知道 | 下周重磅财经事件一览：中国进出口、通胀数据 特朗普访华-->
                    <#--</a>-->
                    <#--<a target="_blank" href="/premium/articles/3039367" class="news-item__main__summary">-->
                        <#--特朗普将于8-10日访华；中国将在周三公布10月进出口数据，关注出口是否依旧不及预期；周四将公布中国10月CPI及PPI；英国将在周四开启下一轮退欧谈判；阅文、搜狗和拍拍贷将上市。                        </a>-->
                    <#--<div class="news-item__main__meta">-->
                        <#--<div class="news-item__main__meta__left">-->
                            <#--<div class="left-item">-->
                                <#--<a target="_blank" href="/authors/120000000496" class="display-name">脱水研报</a></div>-->
                            <#--<!--&ndash;&gt; <!--&ndash;&gt;-->
                            <#--<div class="left-item">-->
                                <#--<span class="text">2小时前</span>-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div class="news-item__main__meta__right"></div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="news-item" data-index="2" data-news>-->

                <#--<div class="news-item__main">-->
                    <#--<a target="_blank" href="/premium/articles/3039367" class="news-item__main__title">-->
                        <#--除了海康威视、大华股份，这家纯正的人工智能公司可能被你忽视了——11月5日脱水个股-->
                    <#--</a>-->
                    <#--<a target="_blank" href="/premium/articles/3039367" class="news-item__main__summary">-->
                        <#--脱水个股为脱水研报的子篇，脱水研报包时段用户免费。单篇用户购买的话，6元。主要是覆盖每日券商上调评级、首次评级、强烈推荐评级的个股，并加以筛选梳理。更多的是从基本面去了解、跟踪部分个股的变化，希望对您的投资有所借鉴。此外，会增加部分市场热炒个股基本面覆盖、市场冷门低关注度个股覆盖、最热研报个股覆盖等。                        </a>-->
                    <#--<div class="news-item__main__meta">-->
                        <#--<div class="news-item__main__meta__left">-->
                            <#--<div class="left-item">-->
                                <#--<a target="_blank" href="/authors/120000000496" class="display-name">脱水研报</a></div>-->
                            <#--<!--&ndash;&gt; <!--&ndash;&gt;-->
                            <#--<div class="left-item">-->
                                <#--<span class="text">2小时前</span>-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div class="news-item__main__meta__right"></div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="news-item" data-index="3" data-news>-->

                <#--<div class="news-item__main">-->
                    <#--<a target="_blank" href="/premium/articles/3039367" class="news-item__main__title">-->
                        <#--上交所：开展“新蓝筹”行动 研究推出沪深300ETF期权-->
                    <#--</a>-->
                    <#--<a target="_blank" href="/premium/articles/3039367" class="news-item__main__summary">-->
                        <#--上交所理事长吴清在接受《经济日报》专访中表示，将挖掘与培育更多代表新经济和传统产业转型升级的优质企业登陆上交所融资；还在积极研究推出沪深300ETF期权，丰富交易所期权品种，积极推进央企ETF和跨省国企ETF开发，支持国企优化升级。                        </a>-->
                    <#--<div class="news-item__main__meta">-->
                        <#--<div class="news-item__main__meta__left">-->
                            <#--<div class="left-item">-->
                                <#--<a target="_blank" href="/authors/120000000496" class="display-name">脱水研报</a></div>-->
                            <#--<!--&ndash;&gt; <!--&ndash;&gt;-->
                            <#--<div class="left-item">-->
                                <#--<span class="text">2小时前</span>-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div class="news-item__main__meta__right"></div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="news-item" data-index="4" data-news>-->

                <#--<div class="news-item__main">-->
                    <#--<a target="_blank" href="/premium/articles/3039367" class="news-item__main__title">-->
                        <#--腾讯“吃鸡”网站悄然上线 代理《绝地求生》就在8号？-->
                    <#--</a>-->
                    <#--<a target="_blank" href="/premium/articles/3039367" class="news-item__main__summary">-->
                        <#--腾讯昨日悄然上线“暗藏玄鸡”网页，称“8号我们有大事宣布”，腾讯真的要代理《绝地求生》了吗？不过网页附带的微信公众号称，将在8日推出“重磅神秘手游”，而《绝地求生》是一款PC游戏。-->
                    <#--</a>-->
                    <#--<div class="news-item__main__meta">-->
                        <#--<div class="news-item__main__meta__left">-->
                            <#--<div class="left-item">-->
                                <#--<a target="_blank" href="/authors/120000000496" class="display-name">脱水研报</a></div>-->
                            <#--<!--&ndash;&gt; <!--&ndash;&gt;-->
                            <#--<div class="left-item">-->
                                <#--<span class="text">2小时前</span>-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div class="news-item__main__meta__right"></div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="news-item" data-index="5" data-news>-->

                <#--<div class="news-item__main">-->
                    <#--<a target="_blank" href="/premium/articles/3039367" class="news-item__main__title">-->
                        <#--热议到“炸裂”！行研和策略突然都盯上了这个板块——11月5日A股脱水研报-->
                    <#--</a>-->
                    <#--<a target="_blank" href="/premium/articles/3039367" class="news-item__main__summary">-->
                        <#--今日猛料超多：1、周末最燃话题半导体，最全的产业链梳理，最硬的基本面牛股，如何在叠加次新，简直了！想知道的全在这，非常详尽；2、两大事件重磅催化，优质次新标的梳理；3、除了单月涨幅40%的金牌橱柜，还有哪些高送转潜力股值得配；4、国家大基金唯一参股，国内短期无对手，这家电子材料公司真的牛上天了；5、不能小觑需求引发的爆炸，从底部爬起来的这家会复制京东方走势吗？6、意外发现一家业绩弹性很大的家电股进入了重仓TOP10。-->
                    <#--</a>-->
                    <#--<div class="news-item__main__meta">-->
                        <#--<div class="news-item__main__meta__left">-->
                            <#--<div class="left-item">-->
                                <#--<a target="_blank" href="/authors/120000000496" class="display-name">脱水研报</a></div>-->
                            <#--<!--&ndash;&gt; <!--&ndash;&gt;-->
                            <#--<div class="left-item">-->
                                <#--<span class="text">2小时前</span>-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div class="news-item__main__meta__right"></div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->
</div>

<script type="text/javascript" src="/cms/js/lib/bootstrap.js"></script>
<script type="text/javascript" src="/cms/js/lib/timebar.js"></script>
<script type="text/javascript" src="/cms/js/script/calendar_page.js"></script>