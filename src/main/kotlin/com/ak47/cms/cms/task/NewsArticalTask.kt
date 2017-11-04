package com.ak47.cms.cms.task

import com.ak47.cms.cms.api.PBCCrawler
import com.ak47.cms.cms.dao.NewsArticalRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class NewsArticalTask {

    val log = LoggerFactory.getLogger(NewsArticalTask::class.java)

    @Autowired lateinit var newsArticalRepository: NewsArticalRepository
    var newsArticleCrawer: PBCCrawler = PBCCrawler.instanceCrawler();

    @Transactional
    fun doSyncNewsArticalata() {

        val pageTotal = newsArticleCrawer.pageNoSum
        for (pageNo in 1..pageTotal+1) {
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