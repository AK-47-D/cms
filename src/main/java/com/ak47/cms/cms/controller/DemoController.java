package com.ak47.cms.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("demo")
public class DemoController {

    @GetMapping("calendarPage")
    public String calendarPage(){
        return "cms_layout/calendar_page";
    }
    @GetMapping("newsPage")
    public String newsPage(){
        return "cms_layout/news_page";
    }
    @GetMapping("calendarPageT")
    @ResponseBody
    public ModelAndView calendarPageT(){
        return new ModelAndView("cms_layout/calendar_page");
    }
    @GetMapping("manage/main")
    public String manageMain(){
        return "cms_manage/content";
    }
}
