package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.api.Crawler;
import com.ak47.cms.cms.entity.NewsArtical;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/3.
 */
@Controller
public class CrawlerController {

    @GetMapping("testNews")
    @ResponseBody
    public List<NewsArtical> testNews(){
        return new Crawler().getContent();
    }
}
