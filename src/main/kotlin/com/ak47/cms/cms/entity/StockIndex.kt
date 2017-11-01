package com.ak47.cms.cms.entity

import java.util.*
import javax.persistence.*

@Entity
class StockIndex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1

    @Column(name = "index_code", unique = true)
    var index_code: String = ""

    @Column(name = "prod_name")
    var prod_name: String = ""


    @Column(name = "last_px")
    var last_px: String = ""


    @Column(name = "px_change")
    var px_change: String = ""


    @Column(name = "px_change_rate")
    var px_change_rate: String = ""


    @Column(name = "price_precision")
    var price_precision: String = ""

    var gmtCreated: Date = Date()
    var gmtModified: Date = Date()


    override fun toString(): String {
        return "StockIndex(id=$id, index_code='$index_code', prod_name='$prod_name', last_px='$last_px', px_change='$px_change', px_change_rate='$px_change_rate', price_precision='$price_precision', gmtCreated=$gmtCreated, gmtModified=$gmtModified)"
    }


}