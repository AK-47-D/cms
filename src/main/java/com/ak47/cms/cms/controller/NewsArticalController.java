package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.entity.NewsArtical;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import com.ak47.cms.cms.service.NewsArticalService;
import com.ak47.cms.cms.validator.NewsArticalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NewsArticalController {
    @Autowired
    private NewsArticalService newsArticalService;
    @Autowired
    private NewsArticalValidator newsArticalValidator;

    @ModelAttribute
    public void setModel(Long id, ModelMap modelMap){
        if(id != null) {
            modelMap.put("newsArtical", newsArticalService.findOne(id));
        }
    }

    @InitBinder("newsArtical")
    public void initBinder(WebDataBinder binder) {
        binder.replaceValidators(newsArticalValidator);
    }

    @PostMapping("/findNewsList_{pageNumber}_{pageSize}")
    @ResponseBody
    public PageResult<NewsArtical> findNewsPage(PageResult<NewsArtical> pageResult){
        return newsArticalService.findPage(pageResult).getResult();
    }

    @GetMapping("/news/{newsId}")
    public String findNewsPage(Long newsId, ModelMap modelMap){
        modelMap.addAttribute("news",newsArticalService.findOne(newsId));
        return "cms_layout/news/news_detail";
    }

    @PostMapping("manage/news/saveNews")
    @ResponseBody
    public Result<NewsArtical> saveNewsArtical(@ModelAttribute @Validated NewsArtical newsArtical, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResultUtils.instanceResult(newsArtical,bindingResult);
        }
        return newsArticalService.saveNewsArtical(newsArtical);
    }
    @PostMapping("manage/news/findNewsList")
    @ResponseBody
    public PageResult<NewsArtical> findNewsList(PageResult<NewsArtical> pageResult){
        return newsArticalService.findPage(pageResult).getResult();
    }
}
