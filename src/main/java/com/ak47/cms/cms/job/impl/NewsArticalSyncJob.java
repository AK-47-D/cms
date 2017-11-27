package com.ak47.cms.cms.job.impl;

import com.ak47.cms.cms.api.PBCCrawler;
import com.ak47.cms.cms.common.CommonContent;
import com.ak47.cms.cms.entity.DataStatistics;
import com.ak47.cms.cms.entity.NewsArtical;
import com.ak47.cms.cms.enums.PBCType;
import com.ak47.cms.cms.job.BaseJob;
import com.ak47.cms.cms.service.DataStatisticService;
import com.ak47.cms.cms.service.NewsArticalService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsArticalSyncJob implements BaseJob {
    @Autowired
    private NewsArticalService newsArticalService;
    @Autowired
    private DataStatisticService dataStatisticService;

//    @Scheduled(cron = "0 0 */1 * * ?")
    @Transactional
    public void syncNewsJob() {
        job();
    }

    @Override
    public void job() {
        long startTime = System.currentTimeMillis();
        PBCCrawler pbcCrawler = PBCCrawler.instanceCrawler();
        List<NewsArtical> newsArticals = new ArrayList<>();
        List<DataStatistics> dataStatisticses = new ArrayList<>();
        for(PBCType pbcType:PBCType.values()){
            if(pbcType.getTypeCode() == 700000){
                dataStatisticses.addAll(pbcCrawler.getCountData(CommonContent.PBC_HOST + pbcType.getUrl(),pbcType.getTypeCode()));
            }else{
                newsArticals.addAll(pbcCrawler.getAllNewsArtical(CommonContent.PBC_HOST + pbcType.getUrl(),pbcType.getTypeCode()));
            }
        }
        logger.info("dataStatisticses ============== {}",JSONObject.toJSONString(dataStatisticses));
        logger.info("newsArticals ==============  {}" , JSONObject.toJSONString(newsArticals));
        logger.info("耗时 ============ {}",System.currentTimeMillis()-startTime);
        newsArticalService.syncNews(newsArticals);
        dataStatisticService.syncDataStatistics(dataStatisticses);
    }
}
