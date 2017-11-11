package com.ak47.cms.cms.service

import com.ak47.cms.cms.api.CrawlerWebClient
import com.ak47.cms.cms.dao.TechArticleRepository
import com.ak47.cms.cms.entity.TechArticle
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import org.jsoup.Jsoup
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CrawTechArticleService {
    val logger = LoggerFactory.getLogger(CrawTechArticleService::class.java)
    val crawlerWebClient = CrawlerWebClient.instanceCrawlerClient()
    @Autowired lateinit var TechArticleRepository: TechArticleRepository

    fun doCrawTechArticle() {
        launch(CommonPool) {
            for (page in 1..2000) {
                crawTechArticles(page)
            }
        }
    }

    fun crawTechArticles(page: Int) {
        val articleSearchUrl = "http://www.iteye.com/blogs/category/language?page=${page}"
        val pageHtml = crawlerWebClient.getPage(articleSearchUrl).asXml()
        println("pageHtml = ${pageHtml}")
        val document = Jsoup.parse(pageHtml)
        document.getElementsByClass("blog clearfix").forEach {
            var href = it.child(0).child(0).child(0).attr("href")
            var title = it.child(0).child(0).child(0).attr("title")
            var simpleContent = it.child(0).child(1).html()
            var showContent = getShowContent(href)

            if (TechArticleRepository.countByUrl(href) == 0) {
                doSaveTechArticle(
                        href = href,
                        title = title,
                        simpleContent = simpleContent,
                        showContent = showContent
                )
            }
        }
    }

    private fun doSaveTechArticle(href: String, title: String, simpleContent: String, showContent: String) {
        val TechArticle = TechArticle()
        TechArticle.url = href
        TechArticle.title = title
        TechArticle.simpleContent = simpleContent
        TechArticle.showContent = showContent
        TechArticle.tagId = 1
        TechArticleRepository.save(TechArticle)
    }

    private fun getShowContent(href: String): String {
        val pageHtml = crawlerWebClient.getPage(href).asXml()
        val document = Jsoup.parse(pageHtml)
        return document.getElementsByClass("blog_main")[0].html()
    }

}