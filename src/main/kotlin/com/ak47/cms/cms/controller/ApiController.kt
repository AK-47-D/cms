package com.ak47.cms.cms.controller

import com.ak47.cms.cms.dao.FinanceInfoCalendarRespository
import com.ak47.cms.cms.dao.StockIndexRepository
import com.ak47.cms.cms.dao.WallstreetArticleRepository
import com.ak47.cms.cms.entity.FinanceInfoCalendar
import com.ak47.cms.cms.entity.StockIndex
import com.ak47.cms.cms.entity.WallstreetArticle
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

    @RequestMapping(value = "/api/stock_index", method = arrayOf(RequestMethod.GET))
    fun stock_index(): List<StockIndex> {
        val all = stockIndexRepository.findAll()
        log.info("stockIndexRepository.findAll() = {}", all)
        return all
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
}