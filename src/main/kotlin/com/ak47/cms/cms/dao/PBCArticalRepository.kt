package com.ak47.cms.cms.dao

import com.ak47.cms.cms.entity.PBCArtical
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

interface PBCArticalRepository : PagingAndSortingRepository<PBCArtical, Long> {

    @Query("select count(*) from news_artical where url = :url", nativeQuery = true)
    fun countByUrl(@Param("url") url: String): Int

}