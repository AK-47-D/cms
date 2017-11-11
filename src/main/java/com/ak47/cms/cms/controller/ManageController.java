package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.enums.ManageNewsFromEnum;
import com.ak47.cms.cms.enums.ManageNewsStatusEnum;
import com.ak47.cms.cms.enums.NewsType;
import com.ak47.cms.cms.result.Result;
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

    @GetMapping("main")
    public String manageMain(){
        return "cms_manage/content";
    }
    @PostMapping("findMenu")
    @ResponseBody
    public Result findMenu(Long userId){
        return manageMenuService.findUserMenu(userId);
    }
    @GetMapping("news/news")
    public String news(Long newsId,ModelMap modelMap){
        modelMap.put("manageNewsType", NewsType.values());
        modelMap.put("manageNewsStatus", ManageNewsStatusEnum.values());
        modelMap.put("manageNewsFrom", ManageNewsFromEnum.values());
        if(newsId!=null) {
            modelMap.put("news", newsArticalService.findOne(newsId));
        }
        return "cms_manage/news/news";
    }
    @GetMapping("news/newsList")
    public String newsList(ModelMap modelMap){
        return "cms_manage/news/newsList";
    }
}
