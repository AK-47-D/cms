package com.ak47.cms.cms.task

import com.ak47.cms.cms.api.WallStreetAPI
import com.ak47.cms.cms.dao.StockIndexRepository
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONArray
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.net.URL


@Service
class StockIndexTask {
    val log = LoggerFactory.getLogger(StockIndexTask::class.java)

    @Autowired lateinit var StockIndexRepository: StockIndexRepository

    @Transactional
    fun doSyncStockIndexData() {
        val api = WallStreetAPI.STOCK_INDEX_API
        val json = URL(api).readText()

        try {
            val obj = JSON.parse(json) as Map<*, *>
            val data = obj["data"] as Map<*, *>
            val map = data["snapshot"] as Map<*, *>

            for ((k, v) in map) {
                val index_code = k as String
                val valueArray = v as JSONArray
                StockIndexRepository.saveOnNoDuplicateKey(
                        index_code = index_code,
                        prod_name = valueArray[0].toString(),
                        last_px = valueArray[1].toString(),
                        px_change = valueArray[2].toString(),
                        px_change_rate = valueArray[3].toString(),
                        price_precision = valueArray[4].toString()
                )
            }

        } catch (ex: Exception) {
            log.info("ex = {}", ex.message)
            ex.printStackTrace()

        }
    }

    @Deprecated("Do not use this, just To Read understand StockIndex")
    fun doSyncStockIndexDataOld() {
        val api = WallStreetAPI.STOCK_INDEX_API
        val json = URL(api).readText()
//        log.info(json)

        try {
            val obj = JSON.parse(json) as Map<*, *>
            val data = obj["data"] as Map<*, *>
            val map = data["snapshot"] as Map<*, *>
//            log.info("map = {}", map)

            val 深证成指 = map["399001"] as JSONArray
            log.info("深证成指 = {}", 深证成指)
            log.info("深证成指[0] = {}", 深证成指[0])
            log.info("深证成指[1] = {}", 深证成指[1])
            log.info("深证成指[2] = {}", 深证成指[2])
            log.info("深证成指[3] = {}", 深证成指[3])

            val 创业板指 = map["399006"] as JSONArray
            val 上证综指 = map["000001"] as JSONArray
            val 欧元_美元 = map["EURUSD"] as JSONArray
            val 欧洲Stoxx50 = map["EUSTX50INDEX"] as JSONArray
            val 德国10年期国债 = map["GERMANY10YEAR"] as JSONArray
            val 日本10年期国债 = map["JAPAN10YEAR"] as JSONArray
            val 日经225指数 = map["JPN225INDEX"] as JSONArray
            val 标普500 = map["SPX500INDEX"] as JSONArray
            val 布伦特原油 = map["UKOIL"] as JSONArray
            val 美国10年期国债 = map["US10YEAR"] as JSONArray
            val 离岸人民币 = map["USDCNH"] as JSONArray
            val 美元_日元 = map["USDJPY"] as JSONArray
            val 白银 = map["XAGUSD"] as JSONArray
            val 黄金 = map["XAUUSD"] as JSONArray

            StockIndexRepository.saveOnNoDuplicateKey(index_code = "399001", prod_name = 深证成指[0].toString(), last_px = 深证成指[1].toString(), px_change = 深证成指[2].toString(), px_change_rate = 深证成指[3].toString(), price_precision = 深证成指[4].toString())
            StockIndexRepository.saveOnNoDuplicateKey(index_code = "399006", prod_name = 创业板指[0].toString(), last_px = 创业板指[1].toString(), px_change = 创业板指[2].toString(), px_change_rate = 创业板指[3].toString(), price_precision = 创业板指[4].toString())
            StockIndexRepository.saveOnNoDuplicateKey(index_code = "000001", prod_name = 上证综指[0].toString(), last_px = 上证综指[1].toString(), px_change = 上证综指[2].toString(), px_change_rate = 上证综指[3].toString(), price_precision = 上证综指[4].toString())
            StockIndexRepository.saveOnNoDuplicateKey(index_code = "EURUSD", prod_name = 欧元_美元[0].toString(), last_px = 欧元_美元[1].toString(), px_change = 欧元_美元[2].toString(), px_change_rate = 欧元_美元[3].toString(), price_precision = 欧元_美元[4].toString())
            StockIndexRepository.saveOnNoDuplicateKey(index_code = "EUSTX50INDEX", prod_name = 欧洲Stoxx50[0].toString(), last_px = 欧洲Stoxx50[1].toString(), px_change = 欧洲Stoxx50[2].toString(), px_change_rate = 欧洲Stoxx50[3].toString(), price_precision = 欧洲Stoxx50[4].toString())
            StockIndexRepository.saveOnNoDuplicateKey(index_code = "GERMANY10YEAR", prod_name = 德国10年期国债[0].toString(), last_px = 德国10年期国债[1].toString(), px_change = 德国10年期国债[2].toString(), px_change_rate = 德国10年期国债[3].toString(), price_precision = 德国10年期国债[4].toString())
            StockIndexRepository.saveOnNoDuplicateKey(index_code = "JAPAN10YEAR", prod_name = 日本10年期国债[0].toString(), last_px = 日本10年期国债[1].toString(), px_change = 日本10年期国债[2].toString(), px_change_rate = 日本10年期国债[3].toString(), price_precision = 日本10年期国债[4].toString())
            StockIndexRepository.saveOnNoDuplicateKey(index_code = "JPN225INDEX", prod_name = 日经225指数[0].toString(), last_px = 日经225指数[1].toString(), px_change = 日经225指数[2].toString(), px_change_rate = 日经225指数[3].toString(), price_precision = 日经225指数[4].toString())
            StockIndexRepository.saveOnNoDuplicateKey(index_code = "SPX500INDEX", prod_name = 标普500[0].toString(), last_px = 标普500[1].toString(), px_change = 标普500[2].toString(), px_change_rate = 标普500[3].toString(), price_precision = 标普500[4].toString())
            StockIndexRepository.saveOnNoDuplicateKey(index_code = "UKOIL", prod_name = 布伦特原油[0].toString(), last_px = 布伦特原油[1].toString(), px_change = 布伦特原油[2].toString(), px_change_rate = 布伦特原油[3].toString(), price_precision = 布伦特原油[4].toString())
            StockIndexRepository.saveOnNoDuplicateKey(index_code = "US10YEAR", prod_name = 美国10年期国债[0].toString(), last_px = 美国10年期国债[1].toString(), px_change = 美国10年期国债[2].toString(), px_change_rate = 美国10年期国债[3].toString(), price_precision = 美国10年期国债[4].toString())
            StockIndexRepository.saveOnNoDuplicateKey(index_code = "USDCNH", prod_name = 离岸人民币[0].toString(), last_px = 离岸人民币[1].toString(), px_change = 离岸人民币[2].toString(), px_change_rate = 离岸人民币[3].toString(), price_precision = 离岸人民币[4].toString())
            StockIndexRepository.saveOnNoDuplicateKey(index_code = "USDJPY", prod_name = 美元_日元[0].toString(), last_px = 美元_日元[1].toString(), px_change = 美元_日元[2].toString(), px_change_rate = 美元_日元[3].toString(), price_precision = 美元_日元[4].toString())
            StockIndexRepository.saveOnNoDuplicateKey(index_code = "XAGUSD", prod_name = 白银[0].toString(), last_px = 白银[1].toString(), px_change = 白银[2].toString(), px_change_rate = 白银[3].toString(), price_precision = 白银[4].toString())
            StockIndexRepository.saveOnNoDuplicateKey(index_code = "XAUUSD", prod_name = 黄金[0].toString(), last_px = 黄金[1].toString(), px_change = 黄金[2].toString(), px_change_rate = 黄金[3].toString(), price_precision = 黄金[4].toString())


        } catch (ex: Exception) {
            log.info("ex = {}", ex.message)
            ex.printStackTrace()

        }
    }

}


/*

      "XAUUSD": [
        "黄金",
        1278.45,
        7.41,
        0.58,
        2
      ],
      "fields": [
        "prod_name",
        "last_px",
        "px_change",
        "px_change_rate",
        "price_precision"
      ]

*/