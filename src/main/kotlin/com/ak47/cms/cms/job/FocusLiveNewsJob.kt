package com.ak47.cms.cms.job

import com.ak47.cms.cms.task.FocusLiveNewsTask
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Component
class FocusLiveNewsJob {
    @Autowired lateinit var FocusLiveNewsTask: FocusLiveNewsTask

//    @Scheduled(cron = "*/30 * * * * ?")
    @Transactional
    fun doStockIndexTask() {
        println("开始执行定时任务 FocusLiveNewsTask： ${Date()}")
        FocusLiveNewsTask.doSyncFocusLiveNewsTask()
    }
}
