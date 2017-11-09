package com.ak47.cms.cms.dao

import com.ak47.cms.cms.entity.FinanceInfoCalendar
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import java.util.*

interface FinanceInfoCalendarRespository : PagingAndSortingRepository<FinanceInfoCalendar, Long> {

    @Query("select count(*) from finance_info_calendar where item_id = :item_id", nativeQuery = true)
    fun countByItemId(@Param("item_id") item_id: String): Int

    @Query("SELECT a from #{#entityName} a  where  date(a.date_stamp) = date(:date_stamp)  order by a.timestamp desc")
    fun findFinanceInfoCalendarAll(@Param("date_stamp") date_stamp: Date): MutableList<FinanceInfoCalendar>

}
