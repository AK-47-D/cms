package com.ak47.cms.cms.controller

import com.ak47.cms.cms.dao.StockIndexRepository
import com.ak47.cms.cms.entity.StockIndex
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by jack on 2017/7/22.
 */

@RestController("/api")
class ApiController {

    @Autowired lateinit var StockIndexRepository: StockIndexRepository

    @RequestMapping(value = "/stock_index", method = arrayOf(RequestMethod.GET))
    fun stock_index(): List<StockIndex> {
        return StockIndexRepository.findAll()
    }

}