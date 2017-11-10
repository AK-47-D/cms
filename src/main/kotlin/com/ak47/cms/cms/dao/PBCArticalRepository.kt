package com.ak47.cms.cms.dao

import com.ak47.cms.cms.entity.NewsArtical
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

interface PBCArticalRepository : PagingAndSortingRepository<NewsArtical, Long> {

    @Query("select count(*) from PBC_Artical where url = :url", nativeQuery = true)
    fun countByUrl(@Param("url") url: String): Int

}