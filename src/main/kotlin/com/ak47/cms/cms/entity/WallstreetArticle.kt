package com.ak47.cms.cms.entity

import java.util.*
import javax.persistence.*


/**
 * 实时快讯 */

@Entity
@Table(name = "wallstreet_article", indexes = arrayOf(
        Index(name = "item_id", unique = true, columnList = "item_id")))
class WallstreetArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1

    @Column(name = "item_id", unique = true)
    var item_id = ""

    @Column(name = "content_short", length = 1000)
    var content_short = ""

    @Column(name = "display_time")
    var display_time = Date()

    @Column(name = "image_uri")
    var image_uri = ""

    @Column(name = "source_name")
    var source_name = ""

    @Column(name = "source_uri")
    var source_uri = ""

    @Column(name = "title")
    var title = ""

    @Column(name = "uri")
    var uri = ""

    @Column(name = "category")
    var category = ""

}