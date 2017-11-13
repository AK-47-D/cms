package com.ak47.cms.cms

import com.ak47.cms.cms.service.CrawImageService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class CrawHuaBanImagesTest {
    @Autowired lateinit var CrawImageService: CrawImageService

    @Test
    fun testCrawHuaBanImages() {
        CrawImageService.doCrawHuaBanImages()
    }
}