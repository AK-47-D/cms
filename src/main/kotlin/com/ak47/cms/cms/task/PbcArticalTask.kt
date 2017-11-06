package com.ak47.cms.cms.task

import com.ak47.cms.cms.api.NewsArticleCrawler
import com.ak47.cms.cms.dao.NewsArticalRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PbcArticalTask {

    val log = LoggerFactory.getLogger(PbcArticalTask::class.java)

    @Autowired lateinit var newsArticalRepository: NewsArticalRepository
    @Autowired lateinit var newsArticleCrawer: NewsArticleCrawler

    fun doSyncPbcNewsArticleDta() {

        val pageTotal = newsArticleCrawer.pageNoSum
        for (pageNo in 1..pageTotal) {
            println(pageNo)
            val articalList = newsArticleCrawer.getPageNewsArticle(pageNo)
            articalList.forEach {
                val url = it.url
                var count = 0
                count = newsArticalRepository.countByUrl(url)
                if (count == 0) {
                    newsArticalRepository.save(it)
                }
            }
        }
    }

}