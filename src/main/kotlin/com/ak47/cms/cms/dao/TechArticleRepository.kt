package com.ak47.cms.cms.dao

import com.ak47.cms.cms.dto.TechArticleDto
import com.ak47.cms.cms.entity.TechArticle
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TechArticleRepository : JpaRepository<TechArticle, Long> {

    @Query("select count(*) from #{#entityName} a where a.url = :url")
    fun countByUrl(@Param("url") url: String): Int

    @Query("select new com.ak47.cms.cms.dto.TechArticleDto( a.id, a.url, a.title, a.simpleContent, a.showContent , a.tagId, b.tagDetail , a.category, a.gmtCreate, a.gmtModified ) " +
            "from TechArticle a, TechArticleTag b where a.tagId = b.tagId order by a.id desc")
    fun listTechArticleDto(page: Pageable): Page<TechArticleDto>

    @Query("select new com.ak47.cms.cms.dto.TechArticleDto( a.id, a.url, a.title, a.simpleContent, a.showContent , a.tagId, b.tagDetail , a.category, a.gmtCreate, a.gmtModified ) " +
            "from TechArticle a left join TechArticleTag b on a.tagId = b.tagId where a.title like %:searchText% or a.showContent  like %:searchText%  order by a.id desc")
    fun searchTechArticleDto(page: Pageable, @Param("searchText") searchText: String): Page<TechArticleDto>

}