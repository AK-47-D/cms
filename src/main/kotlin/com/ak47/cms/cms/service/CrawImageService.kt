package com.ak47.cms.cms.service

import com.ak47.cms.cms.api.CrawlerWebClient
import com.ak47.cms.cms.api.GankApiBuilder
import com.ak47.cms.cms.api.ImageSearchApiBuilder
import com.ak47.cms.cms.dao.ImageRepository
import com.ak47.cms.cms.dao.SearchKeyWordRepository
import com.ak47.cms.cms.entity.Image
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import org.jsoup.Jsoup
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

@Service
class CrawImageService {
    val logger = LoggerFactory.getLogger(CrawImageService::class.java)

    val crawlerWebClient = CrawlerWebClient.instanceCrawlerClient()

    @Autowired lateinit var imageRepository: ImageRepository
    @Autowired lateinit var searchKeyWordRepository: SearchKeyWordRepository

    fun doBaiduImageCrawJob() = runBlocking {
        val list = searchKeyWordRepository.findAll()

        for (i in 1..1000) {
            list.forEach {
                launch(CommonPool) {
                    saveBaiduImage(it.keyWord, i)
                }
            }
        }
    }

    fun doGankImageCrawJob() = runBlocking {
        for (page in 1..6) {
            launch(CommonPool) {
                saveGankImage(page)
            }
        }
    }


    fun doCrawHuaBanImages() {
        val boardsUrls = getBoards()
        launch(CommonPool) {
            boardsUrls.forEach {
                saveHuaBanImages(it)
            }
        }
    }

    private fun getBoards(): MutableSet<String> {
        val boardsUrl = "https://huaban.com/boards/favorite/beauty/"
        val boardsUrls = mutableSetOf("http://huaban.com/favorite/beauty/", "http://huaban.com/boards/17375733/")

        crawlerWebClient.getPage(boardsUrl).asText()
        val boardsPageHtml = crawlerWebClient.getPage(boardsUrl).asXml()
        val document = Jsoup.parse(boardsPageHtml)
        println("document = ${document}")
        println("document = ${document.childNodeSize()}")

//        document.getElementsByClassName('Board wfc ')[0].getAttribute('data-id')
//        "30377705"
        document.getElementsByClass("Board wfc wft").forEach {
            val data_id = it.attr("data-id")
            println("data_id = ${data_id}")
            boardsUrls.add("http://huaban.com/boards/${data_id}")
        }

        println("boardsUrls = ${boardsUrls}")
        return boardsUrls
    }

    private fun saveHuaBanImages(beautyUrl: String) {

        val beautyPageHtml = crawlerWebClient.getPage(beautyUrl).asXml()
        val document = Jsoup.parse(beautyPageHtml)
//        println(document)
//        document.getElementsByClassName('img x layer-view loaded')[1].children[1].src
        document.getElementsByClass("img x layer-view loaded").forEach {
            var url = "http:" + it.child(1).attr("src")
            url = url.replace("/fw/480", "/fw/1080")
            println("花瓣 url = ${url}")
            if (imageRepository.countByUrl(url) == 0) {
                val image = Image()
                image.category = "花瓣 ${SimpleDateFormat("yyyy-MM-dd").format(Date())}"
                image.url = url
                image.sourceType = 2
                image.imageBlob = getByteArray(url)
                logger.info("image = ${image}")
                imageRepository.save(image)
            }
        }
    }


    private fun saveGankImage(page: Int) {
        val api = GankApiBuilder.build(page)
        JsonResultProcessor.getGankImageUrls(api).forEach {
            val url = it
            if (imageRepository.countByUrl(url) == 0) {
                val image = Image()
                image.category = "干货集中营福利 ${SimpleDateFormat("yyyy-MM-dd").format(Date())}"
                image.url = url
                image.sourceType = 1
                image.imageBlob = getByteArray(url)
                logger.info("image = ${image}")
                imageRepository.save(image)
            }
        }
    }

    private fun saveBaiduImage(word: String, i: Int) {
        val api = ImageSearchApiBuilder.build(word, i)
        JsonResultProcessor.getBaiduImageCategoryAndUrlList(api).forEach {
            val category = it.category
            val url = it.url
            if (imageRepository.countByUrl(url) == 0) {
                val image = Image()
                image.category = category
                image.url = url
                image.sourceType = 0
                //image.imageBlob = getByteArray(url)
                logger.info("image = ${image}")
                imageRepository.save(image)
            }
        }
    }

    private fun getByteArray(url: String): ByteArray {
        val urlObj = URL(url)
        return urlObj.readBytes()
    }
}
