package com.ak47.cms.cms.entity


import java.util.*
import javax.persistence.*

@Entity
@Table(indexes = arrayOf(
        Index(name = "idx_url", unique = true, columnList = "url3"),
        Index(name = "idx_title", unique = false, columnList = "dataName"))
)
class DataStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    var gmtCreate: Date = Date()
    var gmtModified: Date = Date()
    var PBCType:Int =0
    var type: Int = 0
    @Column(nullable = false, unique = true)
    var url1: String = ""
    @Column(nullable = false, unique = true)
    var url2:String =""
    var title1: String = ""
    var title2: String = ""
    var dataName:String =""
    @Column(nullable = false, unique = true)
    var url3:String=""
    var isDeleted = 0

    @Override
    fun clone():DataStatistics{
        var dataStatistics:DataStatistics = DataStatistics()
        dataStatistics.dataName = dataName
        dataStatistics.gmtCreate = gmtCreate
        dataStatistics.gmtModified = gmtModified
        dataStatistics.id = id
        dataStatistics.isDeleted = isDeleted
        dataStatistics.PBCType = PBCType
        dataStatistics.title1 = title1
        dataStatistics.title2 = title2
        dataStatistics.type = type
        dataStatistics.url1 = url1
        dataStatistics.url2 = url2
        dataStatistics.url3 = url3
        return dataStatistics
    }

}