package com.ak47.cms.cms.service;

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
    Result<PageResult<NewsArtical>> findPage(PageResult<NewsArtical> pageResult,Example<NewsArtical> example);
    Result<NewsArtical> saveNewsArtical(NewsArtical newsArtical);
    Result<PageResult<NewsArtical>> findCmsPage(PageResult<NewsArtical> pageResult);
}
