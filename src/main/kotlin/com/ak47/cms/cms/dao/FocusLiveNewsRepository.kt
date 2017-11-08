package com.ak47.cms.cms.dao

import com.ak47.cms.cms.entity.FocusLiveNews
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

interface FocusLiveNewsRepository : PagingAndSortingRepository<FocusLiveNews, Long> {

    @Query("select count(*) from focus_live_news where item_id = :item_id", nativeQuery = true)
    fun countByItemId(@Param("item_id") item_id: String): Int

    @Query("SELECT a from #{#entityName} a order by a.id desc")
    fun findFocusLiveNewsPage(pageable: Pageable): Page<FocusLiveNews>

}