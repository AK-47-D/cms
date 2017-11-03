package com.ak47.cms.cms.controller

import com.ak47.cms.cms.task.NewsArticalTask
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class SyncNewsArticleController {

    @Autowired lateinit var newsArticalTask: NewsArticalTask

    @GetMapping("/doSyncNewsArticle")
    @ResponseBody
    fun doSyncNewsArticle() :String{
        newsArticalTask.doSyncNewsArticalata()
        return "DONE"
    }
}