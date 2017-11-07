package com.ak47.cms.cms.entity

import javax.persistence.*

@Entity
class CenterBankRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1

    @Column(name = "item_id", unique = true)
    var item_id = -1

    var title = ""

    var rate = ""

    @Column(name = "index_code")
    var next_meeting_at = ""

    @Column(name = "updated_at")
    var updated_at = 2017


    var country = ""


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