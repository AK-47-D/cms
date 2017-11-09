package com.ak47.cms.cms.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.*

/**
 * 实时快讯 */

@Entity
@Table(name = "focus_live_news", indexes = arrayOf(
        Index(name = "item_id", unique = true, columnList = "item_id")))
class FocusLiveNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1

    @Column(name = "item_id", unique = true)
    var item_id = ""

    @Column(name = "content")
    @Lob
    var content = ""

    @Column(name = "display_time")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var display_time = Date()

    @Column(name = "score")
    var score = -1

    /*
    * a_stock       A 股
    * commodity     商品
    * forex         外汇
    * global        宏观
    * us_stock      美股
    * */
    @Column(name = "type")
    var type = "a_stock"


    var gmtCreated: Date = Date()

    var gmtModified: Date = Date()

}