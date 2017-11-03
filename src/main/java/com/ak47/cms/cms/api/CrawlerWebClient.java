package com.ak47.cms.cms.api;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

/**
 * Created by wb-cmx239369 on 2017/11/3.
 */
public class CrawlerWebClient {
    private static CrawlerWebClient crawlerWebClient = null;
    public static CrawlerWebClient instanceCrawlerClient(){
        if(crawlerWebClient == null){
            crawlerWebClient = new CrawlerWebClient();
        }
        return crawlerWebClient;
    }
    private CrawlerWebClient(){

    }
    private WebClient webClient = null;

    public WebClient instanceWebClient(Integer javaScriptTimeout){
        if(webClient == null) {
            webClient = new WebClient();
        }
        if(javaScriptTimeout != null) {
            webClient.setJavaScriptTimeout(javaScriptTimeout);
        }
        return webClient;
    }
    public WebClient instanceWebClient(){
        return instanceWebClient(null);
    }

    public HtmlPage getPage(String url) throws IOException {
        WebClient webClient = instanceWebClient();
        return webClient.getPage(url);
    }
    public void webClientClose(){
        if(webClient == null) {
            webClient.close();
        }
    }
}
