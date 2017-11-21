package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.entity.DataStatistics;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.service.DataStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataStatisticController {
    @Autowired
    private DataStatisticService dataStatisticService;

    @PostMapping("/findDataStatisticList_{pageNumber}_{pageSize}")
    @ResponseBody
    public PageResult<DataStatistics> findDataStatisticPage(PageResult<DataStatistics> pageResult) {
        return dataStatisticService.findPage(pageResult).getResult();
    }
}
