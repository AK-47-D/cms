package com.ak47.cms.cms.api;

import com.ak47.cms.cms.api.model.CrawlerClient;
import com.ak47.cms.cms.common.CommonContent;
import com.ak47.cms.cms.entity.NewsArtical;
import com.ak47.cms.cms.enums.NewsType;
import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.lang.time.DateUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/3.
 */
public class Crawler {
    private static final Logger logger = LoggerFactory.getLogger(Crawler.class);
    private CrawlerClient crawlerClient = null;
    private static SimpleDateFormat simpleDateFormat = null;
    private static Crawler crawler = null;
    public static Crawler instanceCrawler(){
        if(crawler == null){
            crawler = new Crawler();
        }
        return crawler;
    }
    private Crawler(){
        crawlerClient = CrawlerClient.instanceCrawlerClient();
    }
    public static Date getDate(String date,String format) throws Exception{
        if(simpleDateFormat == null){
            simpleDateFormat = new SimpleDateFormat();
        }
        simpleDateFormat.applyPattern(format);
        return simpleDateFormat.parse(date);
    }
    public List<NewsArtical> getContent(){
        try {
            HtmlPage page = crawlerClient.getPage(CommonContent.PBC_NEWS);
            logger.info(page.asXml());
            Document document = Jsoup.parse(page.asXml());
            //获取 页码
            //$('[opentype=page]').next().find('table').find('.Normal').html()
            String pageNoContent = document.getElementsByAttributeValue("opentype","page").get(0).getElementsByTag("table").get(0).parents().next().get(0).getElementsByClass("Normal").html();
            int pageNoIndex = pageNoContent.lastIndexOf('/')+1;
            int pageNoSum = Integer.valueOf(pageNoContent.substring(pageNoIndex).trim());
            List<NewsArtical> news = new ArrayList<>();
            for(int i = 0 ;i < pageNoSum;i++){
                news.addAll(getUrlNews(CommonContent.PBC_NEWS.replaceAll("index1","index"+(i+1))));
            }
            return news;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            crawlerClient.webClientClose();
        }
        return null;
    }
    public List<NewsArtical> getUrlNews(String url) throws Exception{
        HtmlPage page = crawlerClient.getPage(url);
        logger.info(page.asXml());
        Document document = Jsoup.parse(page.asXml());
        //$("[name=右侧内容]").find('table:eq(0)').find("a")
        Elements elements = document.body().getElementsByAttributeValue("name","右侧内容").get(0).getElementsByTag("table").get(0).getElementsByTag("a");
        int i = 0;
        //获取 新闻
        List<NewsArtical> newsArticals = new ArrayList<>();
        for(Element element :elements){
            String href=element.attr("href");
            i++;
            logger.info("a  ============> {},{}",i,element.attr("href"));
            NewsArtical newsArtical = new NewsArtical();
            newsArtical.setTitle(element.html());
            newsArtical.setType(NewsType.CENTRAL_BANK.getTypeCode());
            newsArtical.setUrl(href);
            newsArtical.setPulishDate(getDate(element.parents().next().html(),"yyyy-MM-dd"));
            newsArticals.add(newsArtical);
        }
        for(NewsArtical newsArtical:newsArticals){
            if(newsArtical.getUrl() == null){
                continue;
            }
            HtmlPage pageHref = crawlerClient.getPage(CommonContent.PBC_HOST + newsArtical.getUrl());
            Document documentHref = Jsoup.parse(pageHref.asXml());
            String zoom = documentHref.body().getElementById("zoom").html();
            logger.info("zoom ============> {}",documentHref.body().getElementById("zoom").html());
            newsArtical.setHtml(zoom);
        }
        return newsArticals;
    }
    public static void main(String[] args){
//        List<NewsArtical> news = getContent();
//        logger.info("news ======== >",JSONObject.toJSONString(news));
    }
}
