package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.api.PBCCrawler;
import com.ak47.cms.cms.entity.DataStatistics;
import com.ak47.cms.cms.entity.PBCArtical;
import com.ak47.cms.cms.enums.PBCType;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.service.DataStatisticService;
import com.ak47.cms.cms.service.PBCArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private PBCArticalService PBCArticalService;
    @Autowired
    private DataStatisticService dataStatisticService;
    @GetMapping("/syncNews")
    @ResponseBody
    public Result<List<PBCArtical>> syncNews(){
        List<PBCArtical> pbcArticals = PBCCrawler.instanceCrawler().getAllPBCArtical(PBCType.NEWS.getUrl(),PBCType.NEWS.getTypeCode());
        return PBCArticalService.syncNews(pbcArticals);
    }
    @GetMapping("/syncDataStatistic")
    @ResponseBody
    public Result<List<DataStatistics>> syncDataStatistic(){
        return dataStatisticService.syncDataStatistics();
    }
    @GetMapping("/findNewsList_{pageNum}_{pageSize}")
    @ResponseBody
    public Result<PageResult<PBCArtical>> findNewsPage(PageResult<PBCArtical> pageResult){
        return PBCArticalService.findPage(pageResult);
    }
    @GetMapping("/findDataStatisticList_{pageNum}_{pageSize}")
    @ResponseBody
    public Result<PageResult<DataStatistics>> findDataStatisticPage(PageResult<DataStatistics> pageResult){
        return dataStatisticService.findPage(pageResult);
    }
}
