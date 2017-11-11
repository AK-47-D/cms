package com.ak47.cms.cms.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class TechArticleTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1

    var tagId = -1
    // 文章标签：例如 Kotlin，Java，Spring Boot 等
    var tagDetail = "Kotlin"

    var gmtCreate = Date()
    var gmtModified = Date()
}