package com.ak47.cms.cms.api;

import com.ak47.cms.cms.common.CommonContent;
import com.ak47.cms.cms.entity.NewsArtical;
import com.ak47.cms.cms.enums.NewsType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/3.
 */
@Service
public class NewsArticleCrawler {
    private static final Logger logger = LoggerFactory.getLogger(NewsArticleCrawler.class);
    private static SimpleDateFormat simpleDateFormat = null;
    private static NewsArticleCrawler newsArticleCrawler = null;
    private CrawlerWebClient crawlerWebClient = null;

    private NewsArticleCrawler() {
        crawlerWebClient = CrawlerWebClient.instanceCrawlerClient();
    }

    public static NewsArticleCrawler instanceCrawler() {
        if (newsArticleCrawler == null) {
            newsArticleCrawler = new NewsArticleCrawler();
        }
        return newsArticleCrawler;
    }

    public static Date getDate(String date, String format) throws Exception {
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat();
        }
        simpleDateFormat.applyPattern(format);
        return simpleDateFormat.parse(date);
    }

//    public static void main(String[] args) throws Exception {
//        NewsArticleCrawler newsArticleCrawler = new NewsArticleCrawler();
//        int pageNo = newsArticleCrawler.getPageNoSum();
//
//        List<NewsArtical> articlePage = newsArticleCrawler.getPageNewsArticle(1);
//        logger.info("news ======== >", JSON.toJSONString(articlePage));
//    }

    public int getPageNoSum() {
        try {
            HtmlPage page = crawlerWebClient.getPage(CommonContent.PBC_NEWS);
            logger.info(page.asXml());
            Document document = Jsoup.parse(page.asXml());
            //获取 页码
            //$('[opentype=page]').next().find('table').find('.Normal').html()
            String pageNoContent = document.getElementsByAttributeValue("opentype", "page").get(0).getElementsByTag("table").get(0).parents().next().get(0).getElementsByClass("Normal").html();
            int pageNoIndex = pageNoContent.lastIndexOf('/') + 1;
            return Integer.valueOf(pageNoContent.substring(pageNoIndex).trim());
        } catch (Exception e) {
            return 200;
        }
    }

    public List<NewsArtical> getPageNewsArticle(int pageNo) throws Exception {
        String url = CommonContent.PBC_NEWS.replaceAll("index1", "index" + (pageNo + 1));
        List<NewsArtical> newsArticals = new ArrayList<>();
        HtmlPage page = crawlerWebClient.getPage(url);
        logger.info(page.asXml());
        // 当前页的文章列表 Html
        Document document = Jsoup.parse(page.asXml());
        //$("[name=右侧内容]").find('table:eq(0)').find("a")
        Elements elements = document.body().getElementsByAttributeValue("name", "右侧内容").get(0).getElementsByTag("table").get(0).getElementsByTag("a");
        int i = 0;
        //获取新闻
        for (Element element : elements) {
            String href = element.attr("href");
            i++;
            logger.info("a  ============> {},{}", i, element.attr("href"));
            NewsArtical artical = new NewsArtical();
            artical.setTitle(element.html());
            artical.setType(NewsType.CENTRAL_BANK.getTypeCode());
            artical.setUrl(href);
            artical.setPublishDate(getDate(element.parents().next().html(), "yyyy-MM-dd"));

            HtmlPage pageHref = crawlerWebClient.getPage(CommonContent.PBC_HOST + href);
            Document documentHref = Jsoup.parse(pageHref.asXml());
            String zoom = documentHref.body().getElementById("zoom").html();
            logger.info("zoom ============> {}", zoom);
            System.out.println("zoom ============> " + zoom);
            artical.setHtml(zoom);

            newsArticals.add(artical);
        }
        return newsArticals;
    }
}