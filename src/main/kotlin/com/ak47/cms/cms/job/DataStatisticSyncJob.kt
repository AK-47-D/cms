package com.ak47.cms.cms.job

import com.ak47.cms.cms.service.DataStatisticService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class DataStatisticSyncJob {
    private val logger:Logger=LoggerFactory.getLogger(DataStatisticSyncJob::class.java)

    @Autowired lateinit var dataStatisticService: DataStatisticService

//    @Scheduled(cron = "0 0 */1 * * ?")
    @Transactional
    fun doStockIndexTask() {
        println("开始执行定时任务 DataStatisticSyncJob： ${Date()}")
        logger.info("DataStatisticSyncJob =============> {}",dataStatisticService.syncDataStatistics())
    }

}