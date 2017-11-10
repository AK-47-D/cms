package com.ak47.cms.cms.job;

import com.ak47.cms.cms.api.PBCCrawler;
import com.ak47.cms.cms.common.CommonContent;
import com.ak47.cms.cms.entity.DataStatistics;
import com.ak47.cms.cms.entity.NewsArtical;
import com.ak47.cms.cms.enums.PBCType;
import com.alibaba.fastjson.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PBCSyncJob {
    @Scheduled(cron = "0 0 */1 * * ?")
    @Transactional
    public void syncPBCJob() {
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
        System.out.println("dataStatisticses ============== " + JSONObject.toJSONString(dataStatisticses));
        System.out.println("newsArticals ============== " + JSONObject.toJSONString(newsArticals));
        System.out.println(System.currentTimeMillis()-startTime);
    }
}
