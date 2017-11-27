package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.entity.Report;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import com.ak47.cms.cms.service.ReportService;
import com.ak47.cms.cms.validator.ReportValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportServic;
    @Autowired
    private ReportValidator reportValidator;

    @ModelAttribute
    public void setModel(Long id, ModelMap modelMap) {
        if (id != null) {
            modelMap.put("report", reportServic.findOne(id));
        }
    }

    @InitBinder("report")
    public void initBinder(WebDataBinder binder) {
        binder.replaceValidators(reportValidator);
    }

    @PostMapping("manage/report/findReportList")
    @ResponseBody
    public PageResult<Report> findReportList(PageResult<Report> pageResult) {
        return reportServic.findPage(pageResult, null).getResult();
    }
    @PostMapping("manage/report/saveReport")
    @ResponseBody
    public Result<Report> saveReport(@ModelAttribute @Validated Report report, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.instanceResult(report, bindingResult);
        }
        return reportServic.saveReport(report);
    }
    @PostMapping("/findReportList")
    @ResponseBody
    public List<Report> findReportPage(Report report) {
        return reportServic.findCmsPage(report).getResult();
    }
}
