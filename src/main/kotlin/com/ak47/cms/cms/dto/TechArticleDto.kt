package com.ak47.cms.cms.dto

import com.ak47.cms.cms.entity.TechArticle
import java.util.*

class TechArticleDto : TechArticle {
    var tagDetail = ""

    constructor(
            id: Long,
            url: String,
            title: String,
            simpleContent: String,
            showContent: String,
            tagId: Int,
            tagDetail: String,
            gmtCreate: Date,
            gmtModified: Date
    ) : super() {
        this.id = id
        this.url = url
        this.title = title
        this.simpleContent = simpleContent
        this.showContent = showContent
        this.tagId = tagId
        this.tagDetail = tagDetail
        this.gmtCreate = gmtCreate
        this.gmtModified = gmtModified
    }
}

