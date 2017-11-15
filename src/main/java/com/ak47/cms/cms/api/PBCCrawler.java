package com.ak47.cms.cms.api;

import com.ak47.cms.cms.common.CommonContent;
import com.ak47.cms.cms.entity.NewsArtical;
import com.ak47.cms.cms.entity.DataStatistics;
import com.ak47.cms.cms.enums.ManageFromEnum;
import com.ak47.cms.cms.enums.ManageStatusEnum;
import com.ak47.cms.cms.enums.NewsType;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by wb-cmx239369 on 2017/11/3.
 */

public class PBCCrawler extends Crawler {
    private static final Logger logger = LoggerFactory.getLogger(PBCCrawler.class);
    private static Optional<PBCCrawler> pbcCrawlerOptional = Optional.ofNullable(null);

    private PBCCrawler(){
        super();
    }
    /**
     * 单例获取PBCCrawler
     * @return
     * @throws Exception
     */
    public static PBCCrawler instanceCrawler() {
        if (!pbcCrawlerOptional.isPresent()) {
            pbcCrawlerOptional = Optional.of(new PBCCrawler());
        }
        return pbcCrawlerOptional.get();
    }

    /**
     * 获取PBC所有的NewsArtical
     * CommonContent.PBC_NEWS//新闻
     * CommonContent.PBC_DATA_INTERPRETATION//数据解读
     * @return
     * @throws Exception
     */
    public List<NewsArtical> getAllNewsArtical(String url, Integer PBCType){
        try {
            int pageNoSum = getPageNoSum(url);
            List<NewsArtical> news = Collections.synchronizedList(new ArrayList<>());
            List<Thread> threads = new ArrayList<>();
            for(int i = 0 ;i < pageNoSum;i++){
                try {
                    final int pageNo = i;
                    Thread t = new Thread(()->{
                        try {
                            news.addAll(getPageNewsArticle(pageNo+1,PBCType));
                        } catch (Exception e) {
                            logger.info("访问失败 ============>   {}页;{}",pageNo+1,e.getMessage());
                        }
                    });
                    t.setName("NewsArtical");
                    threads.add(t);
                    t.start();
                } catch (Exception e) {
                    logger.info("访问失败 ============>   {}页;{}",i+1,e.getMessage());
                }
            }
            while(true){
                boolean flg = false;
                for(Thread thread:threads){
                    if(thread.isAlive()){
                        flg = true;
                        break;
                    }
                }
                if(flg){
                    Thread.sleep(10000);
                    continue;
                }
                break;
            }
            return news;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            getCrawlerWebClient().webClientClose();
        }
        return null;
    }

    /**
     * 获取PBC第pageNoSumm
     * @return
     * @throws Exception
     */
    public int getPageNoSum(String url) {
        try {
            String html = getPageXml(url);
            logger.info(html);
            Document document = Jsoup.parse(html);
            //获取 页码
            //$('[opentype=page]').next().find('table').find('.Normal').html()
            String pageNoContent = document.getElementsByAttributeValue("opentype", "page").get(0).getElementsByTag("table").get(0).parents().next().get(0).getElementsByClass("Normal").html();
            int pageNoIndex = pageNoContent.lastIndexOf('/') + 1;
            return Integer.valueOf(pageNoContent.substring(pageNoIndex).trim());
        } catch (Exception e) {
            return 200;
        }
    }

    /**
     * 获取右侧内容
     * @param url
     * @return
     */
    public Elements getRightContentTagA(String url){
        String html = getPageXml(url);
        logger.info(html);
        // 当前页的文章列表 Html
        Document document = Jsoup.parse(html);
        //$("[name=右侧内容]").find('table:eq(0)').find("a")
        return document.body().getElementsByAttributeValue("name", "右侧内容").get(0).getElementsByTag("table").get(0).getElementsByTag("a");
    }
    /**
     * 获取内容介绍
     * @param url
     * @return
     */
    public Elements getContentDetailTagA(String url){
        String html = getPageXml(url);
        logger.info(html);
        // 当前页的文章列表 Html
        Document document = Jsoup.parse(html);
        //$("[name=右侧内容]").find('table:eq(0)').find("a")
        try {
            return document.body().getElementsByAttributeValue("name", "右侧内容").get(0).getElementsByTag("a");
        } catch (Exception e) {
            return document.body().getElementsByAttributeValue("name", "内容介绍").get(0).getElementsByTag("a");
        }
    }

    /**
     * 获取PBC第pageNo页的NewsArtical
     * @param pageNo
     * @return
     * @throws Exception
     */
    public List<NewsArtical> getPageNewsArticle(int pageNo, int PBCType) throws Exception {
        List<NewsArtical> NewsArticals = new ArrayList<>();
        String url = CommonContent.PBC_NEWS.replaceAll("index1", "index" + (pageNo + 1));
        Elements elements = getRightContentTagA(url);
        //获取新闻
        for (Element element : elements) {
            try {
                String href = CommonContent.PBC_HOST + element.attr("href");
                NewsArtical artical = new NewsArtical();
                artical.setTitle(element.html());
                artical.setType(PBCType);
                artical.setUrl(href);
                artical.setPublishDate(getDate(element.parents().next().html(), "yyyy-MM-dd"));
                artical.setStatus(ManageStatusEnum.DRAFT.getCode());
                artical.setSource(ManageFromEnum.PBC.getCode());
                Document documentHref = Jsoup.parse(getPageXml(href));
                String zoom = documentHref.body().getElementById("zoom").html();
                logger.info("zoom ============> {}", zoom);
                artical.setHtml(zoom);

                NewsArticals.add(artical);
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("访问失败 ============>   {};{}",element.toString(),e.getMessage());
            }
        }
        return NewsArticals;
    }

    /**
     * 获取数据报告
     * @return
     */
    public List<DataStatistics> getCountData(String url,int PBCType){
        try {
            List<DataStatistics> dataStatisticses = new ArrayList<>();
            Elements elements1 = getRightContentTagA(url);
            for(Element element1:elements1){
                try {
                    String href1 = CommonContent.PBC_HOST+element1.attr("href");
                    DataStatistics dataStatistics = new DataStatistics();
                    dataStatistics.setTitle1(element1.html());
                    dataStatistics.setType(NewsType.CENTRAL_BANK.getCode());
                    dataStatistics.setUrl1(href1);
                    dataStatistics.setPbcType(PBCType);
                    Elements elements2 = getContentDetailTagA(href1);
                    for(Element element2:elements2){
                        try {
                            String href2 = CommonContent.PBC_HOST+element2.attr("href");
                            dataStatistics.setUrl2(href2);
                            dataStatistics.setTitle2(element2.html());
                            Elements elements3 = getContentDetailTagA(href2);
                            String title = null;
                            Map<String,String> hrefMap = new HashMap<>();
                            for(int i = 0;i<elements3.size();i++){
                                Element element3 = elements3.get(i);
                                try {
                                    String e3Title = element3.parent().parent().getElementsByTag("td").get(0).getElementsByTag("div").html().trim();
                                    if(StringUtils.isNotBlank(title) && !title.equals(e3Title)){
                                        dataStatistics.setUrl3(JSONObject.toJSONString(hrefMap));
                                        title = "";
                                        hrefMap.clear();
                                        dataStatistics.setDataName(e3Title);
                                        dataStatisticses.add(dataStatistics.clone());
                                    }else{
                                        title = e3Title;
                                    }
                                    hrefMap.put(element3.html(),element3.attr("href"));
                                } catch (Exception e) {
                                    String e3Title = element3.html();
                                    dataStatistics.setDataName(e3Title);
                                    dataStatistics.setUrl3(element3.attr("href"));
                                    dataStatisticses.add(dataStatistics.clone());
                                    logger.info("访问失败 ============>   {};{}",element3.toString(),e.getMessage());
                                }
                            }
                        } catch (Exception e) {
                            logger.info("访问失败 ============>   {};{}",element2.toString(),e.getMessage());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.info("访问失败 ============>   {};{}",element1.toString(),e.getMessage());
                }
            }
            return dataStatisticses;
        } catch (Exception e) {
            logger.info("访问失败 ============> {}",e.getMessage());
        } finally {
            getCrawlerWebClient().webClientClose();
        }
        return null;
    }


}