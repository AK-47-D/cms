package com.ak47.cms.cms.api;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wb-cmx239369 on 2017/11/3.
 */

public class Crawler {
    private static final Logger logger = LoggerFactory.getLogger(Crawler.class);
    private static SimpleDateFormat simpleDateFormat = null;
    private CrawlerWebClient crawlerWebClient = null;

    /**
     * 获取初始化后的crawlerWebClient
     * @return
     * @throws Exception
     */
    public CrawlerWebClient getCrawlerWebClient() {
        return crawlerWebClient;
    }
    /**
     * 初始化
     * @return
     * @throws Exception
     */
    protected Crawler(){
        crawlerWebClient = CrawlerWebClient.instanceCrawlerClient();
    }

    /**
     * 获取时间
     * @return
     * @throws Exception
     */
    public static Date getDate(String date, String format) throws Exception {
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat();
        }
        simpleDateFormat.applyPattern(format);
        return simpleDateFormat.parse(date);
    }

    /**
     * 爬取url的html
     * @param url
     * @return
     * @throws Exception
     */
    public String getPageXml(String url) {
        try {
            HtmlPage page = crawlerWebClient.getPage(url);
            logger.info(page.asXml());
           return page.asXml();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}