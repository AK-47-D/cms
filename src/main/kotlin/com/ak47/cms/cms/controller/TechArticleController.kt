package com.ak47.cms.cms.controller

import com.ak47.cms.cms.dao.TechArticleRepository
import com.ak47.cms.cms.dto.TechArticleDto
import com.ak47.cms.cms.service.CrawTechArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class TechArticleController {
    @Autowired lateinit var TechArticleRepository: TechArticleRepository
    @Autowired lateinit var CrawTechArticleService: CrawTechArticleService

    @GetMapping("listTechArticle")
    fun listTechArticle(
            @RequestParam(value = "page", defaultValue = "0") page: Int,
            @RequestParam(value = "size", defaultValue = "10") size: Int,
            @RequestParam(value = "searchText", defaultValue = "") searchText: String
    ): Page<TechArticleDto> {
        val pageRequest = PageRequest.of(page, size)

        return when (searchText) {
            "" -> TechArticleRepository.listTechArticleDto(pageRequest)
            else -> TechArticleRepository.searchTechArticleDto(pageRequest, searchText)
        }
    }



    @GetMapping("doCrawTechArticle")
    fun doCrawTechArticle():String{
        CrawTechArticleService.doCrawTechArticle()
        return "doCrawTechArticle Started"
    }


}