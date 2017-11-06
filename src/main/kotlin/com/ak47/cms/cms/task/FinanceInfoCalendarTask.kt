package com.ak47.cms.cms.task

import com.ak47.cms.cms.dao.FinanceInfoCalendarRespository
import com.ak47.cms.cms.entity.FinanceInfoCalendar
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONArray
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*


@Service
class FinanceInfoCalendarTask {

    val log = LoggerFactory.getLogger(FinanceInfoCalendarTask::class.java)

    @Autowired lateinit var financeInfoCalendarRespository: FinanceInfoCalendarRespository

    fun doSyncFinanceInfoCalendarTask() {
//   财经日历： https://api-prod.wallstreetcn.com/apiv1/finfo/calendars?start=1509897600&end=1509983999

        val curdate = Date()
        val curDateStr = SimpleDateFormat("yyyy-MM-dd").format(curdate)

        val startStr = curDateStr + " 00:00:00"
        val endStr = curDateStr + " 23:59:59"

        val start = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startStr).time
        val end = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endStr).time

        val 财经日历_API = "https://api-prod.wallstreetcn.com/apiv1/finfo/calendars?start=${start}&end=${end}"
        val json = URL(财经日历_API).readText()

        try {
            val obj = JSON.parse(json) as Map<*, *>
            val items = (obj["data"] as Map<*, *>)["items"] as JSONArray

            items.forEach {
                val item_id = (it as Map<*, *>)["id"].toString()
                val importance = it["importance"] as Int
                val previous = it["previous"].toString()
                val actual = it["actual"].toString()
                val forecast = it["forecast"].toString()
                val revised = it["revised"].toString()
                val timestamp = Date(it["timestamp"] as Long)
                val stars = it["stars"] as Int
                val title = it["title"].toString()
                val accurate_flag = it["accurate_flag"].toString()
                val calendar_type = it["calendar_type"].toString()
                val category_id = it["category_id"].toString()
                val country = it["country"].toString()
                val currency = it["currency"].toString()
                val flagURL = it["flagURL"].toString()

                if (financeInfoCalendarRespository.countByItemId(item_id) == 0) {
                    doSave(item_id = item_id,
                            importance = importance,
                            previous = previous,
                            actual = actual,
                            forecast = forecast,
                            revised = revised,
                            timestamp = timestamp,
                            stars = stars,
                            title = title,
                            accurate_flag = accurate_flag,
                            calendar_type = calendar_type,
                            category_id = category_id,
                            country = country,
                            currency = currency,
                            flagURL = flagURL
                    )
                }
            }
        } catch (ex: Exception) {
            log.info("ex = {}", ex.message)
            ex.printStackTrace()

        }
    }

    private fun doSave(item_id: String, importance: Int, previous: String, actual: String, forecast: String, revised: String, timestamp: Date, stars: Int, title: String, accurate_flag: String, calendar_type: String, category_id: String, country: String, currency: String, flagURL: String) {
        val financeInfo = FinanceInfoCalendar()
        financeInfo.item_id = item_id
        financeInfo.importance = importance
        financeInfo.previous = previous
        financeInfo.actual = actual
        financeInfo.forecast = forecast
        financeInfo.revised = revised
        financeInfo.timestamp = timestamp
        financeInfo.stars = stars
        financeInfo.title = title
        financeInfo.accurate_flag = accurate_flag
        financeInfo.calendar_type = calendar_type
        financeInfo.category_id = category_id
        financeInfo.country = country
        financeInfo.currency = currency
        financeInfo.flagURL = flagURL
        financeInfoCalendarRespository.save(financeInfo)
    }
}