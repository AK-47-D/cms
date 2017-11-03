package com.ak47.cms.cms.task

import com.ak47.cms.cms.api.NewsArticleCrawler
import com.ak47.cms.cms.dao.NewsArticalRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class NewsArticalTask {

    val log = LoggerFactory.getLogger(NewsArticalTask::class.java)

    @Autowired lateinit var newsArticalRepository: NewsArticalRepository
    @Autowired lateinit var newsArticleCrawer: NewsArticleCrawler

    @Transactional
    fun doSyncNewsArticalata() {

        val pageTotal = newsArticleCrawer.pageNoSum
        for (pageNo in 1..pageTotal) {
            println(pageNo)
        }

        val articalList = newsArticleCrawer.getPageNewsArticle(1)
        articalList.forEach {
            val url = it.url
            val count = 0
            val count = newsArticalRepository.countByUrl(url)
            if (count == 0) {
                newsArticalRepository.save(it)
            }
        }
    }

}