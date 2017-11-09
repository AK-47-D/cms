package com.ak47.cms.cms.entity


import java.util.*
import javax.persistence.*

@Entity
@Table(indexes = arrayOf(
        Index(name = "idx_url", unique = true, columnList = "url"),
        Index(name = "idx_title", unique = false, columnList = "title"))
)
class NewsArtical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    var gmtCreate: Date = Date()
    var gmtModified: Date = Date()
    var type: Int = 0
    @Column(nullable = false, unique = true)
    var url: String = ""
    var title: String = ""
    var publishDate: Date = Date()
    var isDeleted = 0
    var status:Int=0
    var source:Int=0
    @Lob
    var html: String = ""
}