package com.ak47.cms.cms.dao

import com.ak47.cms.cms.entity.FinanceInfoCalendar
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

interface FinanceInfoCalendarRespository : PagingAndSortingRepository<FinanceInfoCalendar, Long> {

    @Query("select count(*) from finance_info_calendar where item_id = :item_id" , nativeQuery = true)
    fun countByItemId(@Param("item_id") item_id: String): Int


}
