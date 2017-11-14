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
    fun testCrawITEye() {
        CrawTechArticleService.crawITEyeTechArticles(1)
    }

    @Test
    fun testCrawJianShu() {
//        CrawTechArticleService.crawJianShuArticles(1,"http://www.jianshu.com/c/498ebcfd27ad")
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
                CrawTechArticleService.crawJianShuArticles(page, it)
            }
        }
    }
}