package com.ak47.cms.cms.api;

import com.ak47.cms.cms.common.CommonContent;
import com.ak47.cms.cms.entity.NewsArtical;
import com.ak47.cms.cms.enums.NewsType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
     * @return
     * @throws Exception
     */
    public List<NewsArtical> getAllNewsArtical(){
        try {
            int pageNoSum = getPageNoSum();
            List<NewsArtical> news = new ArrayList<>();
            for(int i = 0 ;i < pageNoSum;i++){
                try {
                    news.addAll(getPageNewsArticle(i+1));
                } catch (Exception e) {
                    logger.info("访问失败 ============>   {}页;{}",pageNoSum+1,e.getMessage());
                }
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
    public int getPageNoSum() {
        try {
            String html = getPageXml(CommonContent.PBC_NEWS);
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
     * 获取PBC第pageNo页的NewsArtical
     * @param pageNo
     * @return
     * @throws Exception
     */
    public List<NewsArtical> getPageNewsArticle(int pageNo) throws Exception {
        String url = CommonContent.PBC_NEWS.replaceAll("index1", "index" + (pageNo + 1));
        List<NewsArtical> newsArticals = new ArrayList<>();
        String html = getPageXml(url);
        logger.info(html);
        // 当前页的文章列表 Html
        Document document = Jsoup.parse(html);
        //$("[name=右侧内容]").find('table:eq(0)').find("a")
        Elements elements = document.body().getElementsByAttributeValue("name", "右侧内容").get(0).getElementsByTag("table").get(0).getElementsByTag("a");
        int i = 0;
        //获取新闻
        for (Element element : elements) {
            try {
                String href = element.attr("href");
                NewsArtical artical = new NewsArtical();
                artical.setTitle(element.html());
                artical.setType(NewsType.CENTRAL_BANK.getTypeCode());
                artical.setUrl(href);
                artical.setPublishDate(getDate(element.parents().next().html(), "yyyy-MM-dd"));

                Document documentHref = Jsoup.parse(getPageXml(CommonContent.PBC_HOST + href));
                String zoom = documentHref.body().getElementById("zoom").html();
                logger.info("zoom ============> {}", zoom);
                System.out.println("zoom ============> " + zoom);
                artical.setHtml(zoom);

                newsArticals.add(artical);
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("访问失败 ============>   {};{}",element.toString(),e.getMessage());
            }
        }
        return newsArticals;
    }
}