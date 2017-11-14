<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">搜图</a>
        </div>
        <div>
            <ul class="nav navbar-nav">


                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        API <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/api/stock_index" target="_blank">实时股票指数</a></li>
                        <li><a href="/api/FinanceInfoCalendar?date_stamp=2017-11-06" target="_blank">财经日历</a></li>
                        <li><a href="/api/WallstreetArticle?page=1&size=10" target="_blank">全球财经新闻</a></li>
                        <li><a href="/api/CenterBankRate?date_stamp=2017-11-07" target="_blank">央行利率</a></li>
                        <li><a href="#" target="_blank">XX</a></li>
                        <li><a href="#" target="_blank">XX</a></li>
                        <li><a href="#">央行报告</a></li>
                    </ul>
                </li>


                <li class="<#if requestURI?if_exists =="/sotu_view">active</#if>">
                    <a href="sotu_view">图片列表</a>
                </li>

                <li class="<#if requestURI?if_exists =="/sotu_gank_view">active</#if>">
                    <a href="sotu_gank_view">干货福利</a>
                </li>

                <li class="<#if requestURI?if_exists =="/sotu_huaban_view">active</#if>">
                    <a href="sotu_huaban_view">花瓣美女</a>
                </li>


                <li class="<#if requestURI?if_exists =="/sotu_favorite_view">active</#if>">
                    <a href="sotu_favorite_view">精选收藏</a>
                </li>

                <li class="<#if requestURI?if_exists =="/tech_article_view">active</#if>">
                    <a href="tech_article_view">技术文章</a>
                </li>

                <li class=" <#if requestURI?if_exists =="/search_keyword_view">active</#if>"><a
                        href="search_keyword_view">搜索关键字</a></li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        系统任务 <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="doBaiduImageCrawJob" target="_blank">抓取百度图片</a></li>
                        <li><a href="doGankImageCrawJob" target="_blank">抓取干货福利图</a></li>
                        <li><a href="doHuaBanImageCrawJob" target="_blank">抓取花瓣美女</a></li>
                        <li><a href="doCrawITEyeTechArticle" target="_blank">抓取ITEye技术文章</a></li>
                        <li><a href="doCrawJianShuTechArticle" target="_blank">抓取简书文章</a></li>
                        <li><a href="doBatchUpdateJob" target="_blank">更新图片总数</a></li>
                    </ul>
                </li>


                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        Kotlin <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="http://www.jianshu.com/nb/12976878" target="_blank">Kotlin 极简教程</a></li>
                        <li><a href="http://www.jianshu.com/nb/17117730" target="_blank">Kotlin 项目实战开发</a></li>
                        <li><a href="#">SpringBoot</a></li>
                        <li><a href="#">Java</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Scala</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Groovy</a></li>
                    </ul>
                </li>


                <li class="nav-item">
                    <a class="nav-link" href="#">关于</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


