package com.ak47.cms.cms.service;

import com.ak47.cms.cms.dto.NewsArticalDto;
import com.ak47.cms.cms.entity.NewsArtical;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import org.springframework.data.domain.Example;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface NewsArticalService extends BaseService<NewsArtical>{
    Result<List<NewsArtical>> syncNews(List<NewsArtical> newsArticals);
    Result<PageResult<NewsArticalDto>> findPage(PageResult<NewsArtical> pageResult,Example<NewsArtical> example);
    Result<NewsArticalDto> saveNewsArtical(NewsArtical newsArtical,List<Integer> labels);
    Result<PageResult<NewsArticalDto>> findCmsPage(PageResult<NewsArtical> pageResult);
    NewsArticalDto findDto(Long id);
}
