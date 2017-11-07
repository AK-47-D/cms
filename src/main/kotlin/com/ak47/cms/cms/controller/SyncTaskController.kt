package com.ak47.cms.cms.controller

import com.ak47.cms.cms.task.FinanceInfoCalendarTask
import com.ak47.cms.cms.task.PbcArticalTask
import com.ak47.cms.cms.task.WallstreetArticleTask
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class SyncTaskController {

    @Autowired lateinit var pbcArticalTask: PbcArticalTask
    @Autowired lateinit var FinanceInfoCalendarTask: FinanceInfoCalendarTask
    @Autowired lateinit var WallstreetArticleTask: WallstreetArticleTask

    @GetMapping("/doSyncPbcArticle")
    @ResponseBody
    fun doSyncNewsArticle(): String {
        pbcArticalTask.doSyncPbcNewsArticleDta()
        return "DONE"
    }

    @GetMapping("/FinanceInfoCalendarTask")
    @ResponseBody
    fun FinanceInfoCalendarTask(): String {
        FinanceInfoCalendarTask.doSyncFinanceInfoCalendarTask()
        return "DONE"
    }

    @GetMapping("/WallstreetArticleTask")
    @ResponseBody
    fun WallstreetArticleTask(): String {
        WallstreetArticleTask.doSyncWallstreetArticleTask()
        return "DONE"
    }


}