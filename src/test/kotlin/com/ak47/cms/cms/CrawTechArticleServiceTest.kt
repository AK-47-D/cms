package com.ak47.cms.cms

import com.ak47.cms.cms.service.CrawTechArticleService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
class CrawTechArticleServiceTest {
    @Autowired lateinit var CrawTechArticleService: CrawTechArticleService

    @Test
    fun testCrawTechArticleService() {
        CrawTechArticleService.crawTechArticles(1)
    }
}