package com.ak47.cms.cms.task

import com.ak47.cms.cms.api.WallStreetAPI
import com.ak47.cms.cms.dao.CenterBankRateRespository
import com.ak47.cms.cms.entity.CenterBankRate
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONArray
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.net.URL
import java.util.*


@Service
class CenterBankRateTask {
    val log = LoggerFactory.getLogger(CenterBankRateTask::class.java)

    @Autowired lateinit var centerBankRateRespository: CenterBankRateRespository

    fun doSyncCenterBankRateTask() {

        val curdate = Date()
        val API = WallStreetAPI.央行利率_API
        val json = URL(API).readText()

        try {
            val obj = JSON.parse(json) as Map<*, *>
            val items = (obj["data"] as Map<*, *>)["items"] as JSONArray

            items.forEach {
                val item_id = (it as Map<*, *>)["id"].toString()
                val title = it["title"].toString()
                val rate = it["rate"].toString()
                val next_meeting_at = it["next_meeting_at"].toString()
                val updated_at = it["updated_at"].toString()
                val country = it["country"].toString()

                cleanAndSaveCenterBankRate(
                        date_stamp = curdate,
                        item_id = item_id,
                        title = title,
                        rate = rate,
                        next_meeting_at = next_meeting_at,
                        updated_at = updated_at,
                        country = country
                )
            }
        } catch (ex: Exception) {
            log.info("ex = {}", ex.message)
            ex.printStackTrace()

        }

    }

    private fun cleanAndSaveCenterBankRate(date_stamp: Date, item_id: String, title: String, rate: String, next_meeting_at: String, updated_at: String, country: String) {
        centerBankRateRespository.deleteByDateStamp(date_stamp)

        val centerBankRate = CenterBankRate()
        centerBankRate.date_stamp = date_stamp
        centerBankRate.item_id = item_id
        centerBankRate.title = title
        centerBankRate.rate = rate
        centerBankRate.next_meeting_at = next_meeting_at
        centerBankRate.updated_at = updated_at
        centerBankRate.country = country
        centerBankRateRespository.save(centerBankRate)
    }

}