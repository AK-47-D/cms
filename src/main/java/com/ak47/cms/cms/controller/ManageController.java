package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.enums.*;
import com.ak47.cms.cms.exception.CmsJsonException;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.service.FocusEventsService;
import com.ak47.cms.cms.service.ManageMenuService;
import com.ak47.cms.cms.service.NewsArticalService;
import com.ak47.cms.cms.service.ReportService;
import com.ak47.cms.cms.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("manage")
public class ManageController {
    @Autowired
    private ManageMenuService manageMenuService;
    @Autowired
    private NewsArticalService newsArticalService;
    @Autowired
    private FocusEventsService focusEventsService;
    @Autowired
    private ReportService reportService;

    @GetMapping("main")
    public String manageMain(){
        return "cms_manage/content";
    }
    @GetMapping("login")
    public String manageLogin(HttpServletRequest request){
        if(WebUtil.isAjaxRequest(request)){
            throw new CmsJsonException("未登录","提示");
        }
        return "cms_manage/login";
    }
    @PostMapping("findMenu")
    @ResponseBody
    public Result findMenu(Long userId){
        return manageMenuService.findUserMenu(userId);
    }
    @GetMapping("news/news")
    public String news(Long newsId,ModelMap modelMap){
        modelMap.put("manageNewsType", NewsType.values());
        modelMap.put("manageNewsStatus", ManageStatusEnum.values());
        modelMap.put("manageNewsFrom", ManageFromEnum.values());
        modelMap.put("manageNewsCountry", ManageCountryEnum.values());
        if(newsId!=null) {
            modelMap.put("news", newsArticalService.findDto(newsId));
        }
        return "cms_manage/news/news";
    }
    @GetMapping("focus/focusEvents")
    public String focusEvents(Long focusId,ModelMap modelMap){
        modelMap.put("manageStatus", ManageStatusEnum.values());
        modelMap.put("manageFrom", ManageFromEnum.values());
        modelMap.put("manageCountry", ManageCountryEnum.values());
        modelMap.put("manageLevel", ManageLevelEnum.values());
        if(focusId!=null) {
            modelMap.put("focusEvents", focusEventsService.findOne(focusId));
        }
        return "cms_manage/focus_events/focus_events";
    }
    @GetMapping("report/report")
    public String report(Long reportId,ModelMap modelMap){
        modelMap.put("manageStatus", ManageStatusEnum.values());
        modelMap.put("manageFrom", ManageFromEnum.values());
        modelMap.put("manageCountry", ManageCountryEnum.values());
        modelMap.put("manageLevel", ManageLevelEnum.values());
        if(reportId!=null) {
            modelMap.put("report", reportService.findOne(reportId));
        }
        return "cms_manage/report/report";
    }
    @GetMapping("news/newsList")
    public String newsList(ModelMap modelMap){
        return "cms_manage/news/newsList";
    }

    @GetMapping("focus/focusList")
    public String focusList(ModelMap modelMap){
        return "cms_manage/focus_events/focusList";
    }

    @GetMapping("report/reportList")
    public String reportList(ModelMap modelMap){
        return "cms_manage/report/reportList";
    }

    @GetMapping("news/newsFile")
    public String newsFile(ModelMap modelMap){
        return "cms_manage/news/newsFile";
    }
}
