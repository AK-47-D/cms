package com.ak47.cms.cms.controller

import com.ak47.cms.cms.dao.*
import com.ak47.cms.cms.entity.*
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat

/**
 * Created by jack on 2017/7/22.
 */

@RestController
class ApiController {
    val log = LoggerFactory.getLogger(ApiController::class.java)

    @Autowired lateinit var stockIndexRepository: StockIndexRepository
    @Autowired lateinit var FinanceInfoCalendarRespository: FinanceInfoCalendarRespository
    @Autowired lateinit var WallstreetArticleRepository: WallstreetArticleRepository
    @Autowired lateinit var CenterBankRateRespository: CenterBankRateRespository
    @Autowired lateinit var FocusLiveNewsRespository: FocusLiveNewsRepository

    @RequestMapping(value = "/api/stock_index", method = arrayOf(RequestMethod.GET))
    fun stock_index(): List<StockIndex> {
        val all = stockIndexRepository.findAll()
        log.info("stockIndexRepository.findAll() = {}", all)
        return all
    }

    @RequestMapping(value = "/api/CenterBankRate", method = arrayOf(RequestMethod.GET))
    fun CenterBankRate(@RequestParam("date_stamp") date_stamp: String): List<CenterBankRate> {
        val dateStamp = SimpleDateFormat("yyyy-MM-dd").parse(date_stamp)
        return CenterBankRateRespository.findCurdateAll(date_stamp = dateStamp)
    }

    @RequestMapping(value = "/api/FinanceInfoCalendar", method = arrayOf(RequestMethod.GET))
    fun FinanceInfoCalendar(@RequestParam("date_stamp") date_stamp: String): MutableList<FinanceInfoCalendar> {
        val dateParam = SimpleDateFormat("yyyy-MM-dd").parse(date_stamp)
        return FinanceInfoCalendarRespository.findFinanceInfoCalendarAll(date_stamp = dateParam)
    }

    @RequestMapping(value = "/api/WallstreetArticle", method = arrayOf(RequestMethod.GET))
    fun WallstreetArticle(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "10") size: Int
    ): Page<WallstreetArticle> {
        val sort = Sort(Sort.Direction.DESC, "id")
        val pageable = PageRequest.of(page, size, sort)
        return WallstreetArticleRepository.findWallstreetArticlePage(pageable)
    }


    /**
     * 焦点快讯
     */
    @RequestMapping(value = "/api/FocusLiveNews", method = arrayOf(RequestMethod.GET))
    fun FocusLiveNews(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "10") size: Int,
        @RequestParam(value = "type", defaultValue = "global") type: String
    ): Page<FocusLiveNews> {
        val sort = Sort(Sort.Direction.DESC, "id")
        val pageable = PageRequest.of(page, size, sort)
        return FocusLiveNewsRespository.findFocusLiveNewsPage(type, pageable)
    }
}
