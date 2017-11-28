package com.ak47.cms.cms.task

import com.ak47.cms.cms.api.WallStreetAPI
import com.ak47.cms.cms.dao.FocusLiveNewsRepository
import com.ak47.cms.cms.entity.FocusLiveNews
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONArray
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*


@Service
class FocusLiveNewsTask {

    val log = LoggerFactory.getLogger(FocusLiveNewsTask::class.java)
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    @Autowired lateinit var FocusLiveNewsRepository: FocusLiveNewsRepository

    fun doSyncFocusLiveNewsTask() {

/*
   * a_stock       A 股
   * commodity     商品
   * forex         外汇
   * global        宏观
   * us_stock      美股
   * */


        val json = URL(WallStreetAPI.焦点快讯_API).readText()
        try {
            val obj = JSON.parse(json) as Map<*, *>

            val a_stock = ((obj["data"] as Map<*, *>)["a_stock"] as Map<*, *>)["items"] as JSONArray
            a_stock.forEach {
                val item_id = (it as Map<*, *>)["id"].toString()
                val content = it["content"].toString()
                val time = (it["display_time"].toString().toLong()) * 1000
                val d = format.format(time)
                val date = format.parse(d)
                val display_time = date
                val score = it["score"] as Int

                if (FocusLiveNewsRepository.countByItemId(item_id) == 0) {
                    doSave(
                            item_id = item_id,
                            content = content,
                            display_time = display_time,
                            score = score,
                            type = "a_stock"
                    )
                }
            }


            val commodity = ((obj["data"] as Map<*, *>)["commodity"] as Map<*, *>)["items"] as JSONArray
            commodity.forEach {
                val item_id = (it as Map<*, *>)["id"].toString()
                val content = it["content"].toString()
                val time = (it["display_time"].toString().toLong()) * 1000
                val d = format.format(time)
                val date = format.parse(d)
                val display_time = date
                val score = it["score"] as Int

                if (FocusLiveNewsRepository.countByItemId(item_id) == 0) {
                    doSave(
                            item_id = item_id,
                            content = content,
                            display_time = display_time,
                            score = score,
                            type = "commodity"
                    )
                }
            }


            val forex = ((obj["data"] as Map<*, *>)["forex"] as Map<*, *>)["items"] as JSONArray
            forex.forEach {
                val item_id = (it as Map<*, *>)["id"].toString()
                val content = it["content"].toString()
                val time = (it["display_time"].toString().toLong()) * 1000
                val d = format.format(time)
                val date = format.parse(d)
                val display_time = date
                val score = it["score"] as Int

                if (FocusLiveNewsRepository.countByItemId(item_id) == 0) {
                    doSave(
                            item_id = item_id,
                            content = content,
                            display_time = display_time,
                            score = score,
                            type = "forex"
                    )
                }
            }


            val global = ((obj["data"] as Map<*, *>)["global"] as Map<*, *>)["items"] as JSONArray
            global.forEach {
                val item_id = (it as Map<*, *>)["id"].toString()
                val content = it["content"].toString()
                val time = ((it["display_time"] as Int) * 1000 as Int) * 1000
                val d = format.format(time)
                val date = format.parse(d)
                val display_time = date
                val score = it["score"] as Int

                if (FocusLiveNewsRepository.countByItemId(item_id) == 0) {
                    doSave(
                            item_id = item_id,
                            content = content,
                            display_time = display_time,
                            score = score,
                            type = "global"
                    )
                }
            }


            val us_stock = ((obj["data"] as Map<*, *>)["us_stock"] as Map<*, *>)["items"] as JSONArray
            us_stock.forEach {
                val item_id = (it as Map<*, *>)["id"].toString()
                val content = it["content"].toString()

                val time = (it["display_time"].toString().toLong()) * 1000
                val d = format.format(time)
                val date = format.parse(d)
                val display_time = date
                val score = it["score"] as Int

                if (FocusLiveNewsRepository.countByItemId(item_id) == 0) {
                    doSave(
                            item_id = item_id,
                            content = content,
                            display_time = display_time,
                            score = score,
                            type = "us_stock"
                    )
                } else {
                    deleteFocusLiveNewsByItemId(item_id)
                    doSave(
                            item_id = item_id,
                            content = content,
                            display_time = display_time,
                            score = score,
                            type = "us_stock"
                    )
                }
            }


        } catch (ex: Exception) {
            log.info("ex = {}", ex.message)
            ex.printStackTrace()

        }
    }

    private fun deleteFocusLiveNewsByItemId(item_id: String) {
        FocusLiveNewsRepository.deleteFocusLiveNewsByItemId(item_id)
    }


    private fun doSave(item_id: String, display_time: Date, content: String, score: Int, type: String) {
        val FocusLiveNews = FocusLiveNews()
        FocusLiveNews.item_id = item_id
        FocusLiveNews.content = content
        FocusLiveNews.display_time = display_time
        FocusLiveNews.score = score
        FocusLiveNews.type = type
        FocusLiveNewsRepository.save(FocusLiveNews)
    }
}
