package com.ak47.cms.cms.dao

import com.ak47.cms.cms.entity.CenterBankRate
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional
import java.util.*

interface CenterBankRateRespository : CrudRepository<CenterBankRate, Long> {

    @Modifying
    @Transactional
    @Query("delete from center_bank_rate where date(date_stamp) = date(:date_stamp)", nativeQuery = true)
    fun deleteByDateStamp(@Param("date_stamp") date_stamp: Date): Int

}