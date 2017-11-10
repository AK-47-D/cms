package com.ak47.cms.cms.dao

import com.ak47.cms.cms.entity.FocusLiveNews
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface FocusLiveNewsRepository : PagingAndSortingRepository<FocusLiveNews, Long> {

    @Query("select count(*) from focus_live_news where item_id = :item_id", nativeQuery = true)
    fun countByItemId(@Param("item_id") item_id: String): Int

    @Query("SELECT a from #{#entityName} a  where a.type = :type   order by a.display_time desc")
    fun findFocusLiveNewsPage(@Param("type") type: String, pageable: Pageable): Page<FocusLiveNews>

    @Modifying
    @Transactional
    @Query("delete from focus_live_news where item_id = :item_id", nativeQuery = true)
    fun deleteFocusLiveNewsByItemId(@Param("item_id") item_id: String): Int

}
