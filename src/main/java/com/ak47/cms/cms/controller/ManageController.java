package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.enums.ManageCountryEnum;
import com.ak47.cms.cms.enums.ManageFromEnum;
import com.ak47.cms.cms.enums.ManageStatusEnum;
import com.ak47.cms.cms.enums.NewsType;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.service.FocusEventsService;
import com.ak47.cms.cms.service.ManageMenuService;
import com.ak47.cms.cms.service.NewsArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("manage")
public class ManageController {
    @Autowired
    private ManageMenuService manageMenuService;
    @Autowired
    private NewsArticalService newsArticalService;
    @Autowired
    private FocusEventsService focusEventsService;

    @GetMapping("main")
    public String manageMain(){
        return "cms_manage/content";
    }
    @GetMapping("login")
    public String manageLogin(){
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
        if(newsId!=null) {
            modelMap.put("news", newsArticalService.findOne(newsId));
        }
        return "cms_manage/news/news";
    }
    @GetMapping("focus/focusEvents")
    public String focusEvents(Long focusId,ModelMap modelMap){
        modelMap.put("manageStatus", ManageStatusEnum.values());
        modelMap.put("manageFrom", ManageFromEnum.values());
        modelMap.put("manageCountry", ManageCountryEnum.values());
        if(focusId!=null) {
            modelMap.put("focusEvents", focusEventsService.findOne(focusId));
        }
        return "cms_manage/focus_events/focus_events";
    }
    @GetMapping("news/newsList")
    public String newsList(ModelMap modelMap){
        return "cms_manage/news/newsList";
    }

    @GetMapping("focus/focusList")
    public String focusList(ModelMap modelMap){
        return "cms_manage/focus_events/focusList";
    }

    @GetMapping("news/newsFile")
    public String newsFile(ModelMap modelMap){
        return "cms_manage/news/newsFile";
    }
}
