package com.ak47.cms.cms.dao

import com.ak47.cms.cms.entity.StockIndex
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

interface StockIndexRepository : CrudRepository<StockIndex, Long> {


    @Modifying
    @Transactional(propagation = Propagation.SUPPORTS)
    @Query(value = "INSERT INTO `stock_index` (`index_code`, `prod_name`, `last_px`, `px_change`, `px_change_rate`, `price_precision`,`gmt_created`,`gmt_modified`) " +
            "VALUES ( :index_code,  :prod_name,  :last_px,  :px_change , :px_change_rate,   :price_precision,  now(), now()) " +
            "ON DUPLICATE KEY UPDATE `gmt_modified` = now(), `last_px` = :last_px, `px_change` = :px_change,  `px_change_rate` = :px_change_rate , `price_precision` = :price_precision",
            nativeQuery = true)
    fun saveOnNoDuplicateKey(
        @Param("index_code") index_code: String,
        @Param("prod_name") prod_name: String,
        @Param("last_px") last_px: String,
        @Param("px_change") px_change: String,
        @Param("px_change_rate") px_change_rate: String,
        @Param("price_precision") price_precision: String
    ): Int

    override fun findAll(): List<StockIndex>

}


/*

        "prod_name",
        "last_px",
        "px_change",
        "px_change_rate",
        "price_precision"


  */