package com.ak47.cms.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("cms")
public class CMSController {

    @GetMapping("calendarPage")
    public String calendarPage() {
        return "cms_layout/calendar_page";
    }

    @GetMapping("manage/main")
    public String manageMain() {
        return "cms_manage/content";
    }


    @GetMapping("focusNewsPage")
    public String focusNewsPage() {
        return "cms_layout/focus_news_page";
    }

    @GetMapping("newsPage")
    public String newsPage() {
        return "cms_layout/news_page";
    }

    @GetMapping("reportPage")
    public String reportPage() {
        return "cms_layout/report_page";
    }


}
