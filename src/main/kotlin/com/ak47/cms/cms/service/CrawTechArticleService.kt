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
            for (page in 1..20) {
                crawITEyeTechArticles(page)
            }

            val 简书专题URLs = arrayOf(
                    "http://www.jianshu.com/c/498ebcfd27ad",
                    "http://www.jianshu.com/c/c3fe8e7aeb09",
                    "http://www.jianshu.com/c/61314ad84456",
                    "http://www.jianshu.com/c/f0cf6eae1754",
                    "http://www.jianshu.com/c/98aaef9f5d2f",
                    "http://www.jianshu.com/c/1d2b61da81ad",
                    "http://www.jianshu.com/c/2e2ddd6ba967",
                    "http://www.jianshu.com/c/ef7836bf3e22",
                    "http://www.jianshu.com/c/38d96caffb2f",
                    "http://www.jianshu.com/c/04cb7410c597")

            简书专题URLs.forEach {
                for (page in 1..20) {
                    crawJianShuArticles(page, it)
                }
            }
        }

    }

    fun crawITEyeTechArticles(page: Int) {
        val articleSearchUrl = "http://www.iteye.com/blogs/category/language?page=${page}"
        val pageHtml = crawlerWebClient.getPage(articleSearchUrl).asXml()
        println("pageHtml = ${pageHtml}")
        val document = Jsoup.parse(pageHtml)
        document.getElementsByClass("blog clearfix").forEach {
            var url = it.child(0).child(0).child(0).attr("href")
            var title = it.child(0).child(0).child(0).attr("title")
            var simpleContent = it.child(0).child(1).html()
            var showContent = getITEyeBlogMainShowContent(url)

            if (TechArticleRepository.countByUrl(url) == 0) {
                doSaveTechArticle(
                        url = url,
                        title = title,
                        simpleContent = simpleContent,
                        showContent = showContent,
                        category = "IT Eye"
                )
            }
        }
    }

    private fun doSaveTechArticle(url: String, title: String, simpleContent: String, showContent: String, category: String) {
        val TechArticle = TechArticle()
        TechArticle.url = url
        TechArticle.title = title
        TechArticle.simpleContent = simpleContent
        TechArticle.showContent = showContent
        TechArticle.tagId = 1
        TechArticle.category = category
        TechArticleRepository.save(TechArticle)
    }

    private fun getITEyeBlogMainShowContent(href: String): String {
        val pageHtml = crawlerWebClient.getPage(href).asXml()
        val document = Jsoup.parse(pageHtml)
        return document.getElementsByClass("blog_main")[0].html()
    }


    fun crawJianShuArticles(page: Int, 简书专题URL: String) {
        val CRAW_API = "${简书专题URL}?order_by=added_at&page=${page}"
        val html = crawlerWebClient.getPage(CRAW_API).asXml()
        println("简书专题 HTML = ${html}")
        val document = Jsoup.parse(html)
        document.getElementsByClass("content").forEach {
            val url = "http://www.jianshu.com" + it.child(1).attr("href")
            val title = it.child(1).html()
            val simpleContent = it.child(2).html()
            val showContent = getJianShuShowContent(url)
            if (TechArticleRepository.countByUrl(url) == 0) {
                doSaveTechArticle(
                        url = url,
                        title = title,
                        simpleContent = simpleContent,
                        showContent = showContent,
                        category = "简书文章"
                )
            }
        }


    }

    private fun getJianShuShowContent(url: String): String {
        val html = crawlerWebClient.getPage(url).asXml()
        val document = Jsoup.parse(html)
        return document.getElementsByClass("article")[0].html()
    }

}