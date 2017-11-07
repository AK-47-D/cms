package com.ak47.cms.cms.task

import com.ak47.cms.cms.dao.WallstreetArticleRepository
import com.ak47.cms.cms.entity.WallstreetArticle
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONArray
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.net.URL
import java.util.*


@Service
class WallstreetArticleTask {

    val log = LoggerFactory.getLogger(WallstreetArticleTask::class.java)

    @Autowired lateinit var wallstreetArticleRepository: WallstreetArticleRepository


    fun doSyncWallstreetArticleTask() {

//        全球资讯API
//
//        全球   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=global&platform=wscn-platform
//        股市   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=shares&platform=wscn-platform
//        债券   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=bonds&platform=wscn-platform
//        商品   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=commodities&platform=wscn-platform
//        外汇   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=forex&platform=wscn-platform
//        公司   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=enterprise&platform=wscn-platform
//        经济   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=economy&platform=wscn-platform
//        数据   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=charts&platform=wscn-platform
//        中国   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=china&platform=wscn-platform
//        US    https://api-prod.wallstreetcn.com/apiv1/content/articles?platform=wscn-platform&category=us
//        欧洲   https://api-prod.wallstreetcn.com/apiv1/content/articles?platform=wscn-platform&category=europe
//        日本   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=japan&platform=wscn-platform

        val categorys = arrayListOf(
                "global",
                "shares",
                "bonds",
                "commodities",
                "forex",
                "enterprise",
                "economy",
                "charts",
                "china",
                "us",
                "europe",
                "japan"
        )

        categorys.forEach {
            doCrawWallstreetArticle(it)
        }
    }

    private fun doCrawWallstreetArticle(category: String) {
        val API = "https://api-prod.wallstreetcn.com/apiv1/content/articles?platform=wscn-platform&category=${category}"
        val json = URL(API).readText()

        try {

            val obj = JSON.parse(json) as Map<*, *>
            val items = ((obj["data"] as Map<*, *>) as Map<*, *>)["items"] as JSONArray
            items.forEach {

                val item_id = (it as Map<*, *>)["id"].toString()
                val content_short = it["content_short"].toString()
                val display_time = Date(((it["display_time"] as Int) / 1000).toLong())
                val image_uri = it["image_uri"].toString()
                val source_uri = it["source_uri"].toString()
                val title = it["title"].toString()
                val uri = it["uri"].toString()


                if (wallstreetArticleRepository.countByItemId(item_id) == 0) {
                    doSaveWallstreetArticle(
                            category = category,
                            item_id = item_id,
                            content_short = content_short,
                            display_time = display_time,
                            image_uri = image_uri,
                            source_uri = source_uri,
                            title = title,
                            uri = uri
                    )
                }


            }


        } catch (ex: Exception) {
            log.info("ex = {}", ex.message)
            ex.printStackTrace()
        }

    }

    private fun doSaveWallstreetArticle(category: String, item_id: String, content_short: String, display_time: Date, image_uri: String, source_uri: String, title: String, uri: String) {
        val article = WallstreetArticle()
        article.category = category
        article.item_id = item_id
        article.content_short = content_short
        article.display_time = display_time
        article.image_uri = image_uri
        article.source_uri = source_uri
        article.title = title
        article.uri = uri
        wallstreetArticleRepository.save(article)
    }


}