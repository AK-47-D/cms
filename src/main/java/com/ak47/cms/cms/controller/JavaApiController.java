package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.api.PBCCrawler;
import com.ak47.cms.cms.common.CommonContent;
import com.ak47.cms.cms.entity.DataStatistics;
import com.ak47.cms.cms.entity.NewsArtical;
import com.ak47.cms.cms.enums.PBCType;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.service.DataStatisticService;
import com.ak47.cms.cms.service.NewsArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
@Controller
@RequestMapping("/news")
public class JavaApiController {
    @Autowired
    private NewsArticalService NewsArticalService;
    @Autowired
    private DataStatisticService dataStatisticService;
    @GetMapping("/syncNews")
    @ResponseBody
    public Result<List<NewsArtical>> syncNews(){
        List<NewsArtical> newsArticals = PBCCrawler.instanceCrawler().getAllNewsArtical(PBCType.NEWS.getUrl(),PBCType.NEWS.getTypeCode());
        return NewsArticalService.syncNews(newsArticals);
    }
    @GetMapping("/syncDataStatistic")
    @ResponseBody
    public Result<List<DataStatistics>> syncDataStatistic(){
        List<DataStatistics> dataStatisticsList = PBCCrawler.instanceCrawler().getCountData(CommonContent.PBC_HOST + PBCType.STATISTICS.getUrl(),PBCType.STATISTICS.getTypeCode());
        return dataStatisticService.syncDataStatistics(dataStatisticsList);
    }
}
