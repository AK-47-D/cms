package com.ak47.cms.cms.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "center_bank_rate")
class CenterBankRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1

    @Column(name = "item_id")
    var item_id = ""

    var title = ""

    var rate = ""

    @Column(name = "next_meeting_at")
    var next_meeting_at = ""

    @Column(name = "updated_at")
    var updated_at = ""

    var country = ""

    @Column(name = "date_stamp")
    var date_stamp = Date()
}


/*
{
    id: 1,
    title: "美联储",
    rate: "1-1.25%",
    next_meeting_at: "12月14日",
    updated_at: 2017,
    country: "us"
}
*/