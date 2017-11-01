package com.ak47.cms.cms.controller

import com.ak47.cms.cms.dao.StockIndexRepository
import com.ak47.cms.cms.entity.StockIndex
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by jack on 2017/7/22.
 */

@RestController
class ApiController {
    val log = LoggerFactory.getLogger(ApiController::class.java)

    @Autowired lateinit var stockIndexRepository: StockIndexRepository

    @RequestMapping(value = "/api/stock_index", method = arrayOf(RequestMethod.GET))
    fun stock_index(): List<StockIndex> {

        val all = stockIndexRepository.findAll()
        log.info("stockIndexRepository.findAll() = {}", all)
        return all
    }

}