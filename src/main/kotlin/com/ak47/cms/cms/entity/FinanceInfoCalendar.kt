package com.ak47.cms.cms.entity

import java.util.*
import javax.persistence.*

/**
 * 财经日历
 */

@Entity
@Table(name = "finance_info_calendar", indexes = arrayOf(Index(name = "item_id", unique = true, columnList = "item_id")))
class FinanceInfoCalendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1

    @Column(name = "item_id", unique = true)
    var item_id = ""

    @Column(name = "importance")
    var importance = 0

    @Column(name = "previous")
    var previous = ""


    @Column(name = "actual")
    var actual = ""


    @Column(name = "forecast")
    var forecast = ""


    @Column(name = "revised")
    var revised = ""

    @Column(name = "stars")
    var stars = -1

    @Column(name = "timestamp")
    var timestamp = Date()

    @Column(name = "title")
    var title = ""

    @Column(name = "accurate_flag")
    var accurate_flag = ""


    @Column(name = "calendar_type")
    var calendar_type = ""

    @Column(name = "category_id")
    var category_id = ""

    @Column(name = "country")
    var country = ""

    @Column(name = "currency")
    var currency = ""


    @Column(name = "flag_url")
    var flagURL = ""

    @Column(name = "date_stamp")
    var date_stamp = Date()

}