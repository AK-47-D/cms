package com.ak47.cms.cms.controller

import com.ak47.cms.cms.task.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class SyncTaskController {

    @Autowired lateinit var pbcArticalTask: PbcArticalTask
    @Autowired lateinit var FinanceInfoCalendarTask: FinanceInfoCalendarTask
    @Autowired lateinit var WallstreetArticleTask: WallstreetArticleTask
    @Autowired lateinit var CenterBankRateTask: CenterBankRateTask
    @Autowired lateinit var FocusLiveNewsTask: FocusLiveNewsTask


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


    @GetMapping("/CenterBankRateTask")
    @ResponseBody
    fun CenterBankRateTask(): String {
        CenterBankRateTask.doSyncCenterBankRateTask()
        return "DONE"
    }

    @GetMapping("/doSyncFocusLiveNewsTask")
    @ResponseBody
    fun doSyncFocusLiveNewsTask(): String {
        FocusLiveNewsTask.doSyncFocusLiveNewsTask()
        return "DONE"
    }


}
