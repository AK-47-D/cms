package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.api.PBCCrawler;
import com.ak47.cms.cms.common.CommonContent;
import com.ak47.cms.cms.dao.NewsArticalJpaRepository;
import com.ak47.cms.cms.entity.DataStatistics;
import com.ak47.cms.cms.entity.NewsArtical;
import com.ak47.cms.cms.enums.ManageNewsStatusEnum;
import com.ak47.cms.cms.enums.PBCType;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import com.ak47.cms.cms.service.DataStatisticService;
import com.ak47.cms.cms.service.NewsArticalService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
@Service
public class NewsArticalServiceImpl implements NewsArticalService {
    @Autowired
    private NewsArticalJpaRepository newsArticalJpaRepository;
    @Autowired
    private DataStatisticService dataStatisticService;
    @Override
    public void delete(Long id) {
        newsArticalJpaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public NewsArtical save(NewsArtical newsArtical) {
        return newsArticalJpaRepository.save(newsArtical);
    }

    @Override
    public List<NewsArtical> findAll() {
        return newsArticalJpaRepository.findAll();
    }

    @Override
    public NewsArtical findOne(Long id) {
        return newsArticalJpaRepository.getOne(id);
    }

    @Override
    @Transactional
    public Result<List<NewsArtical>> syncNews(List<NewsArtical> newsArticals) {
        for(NewsArtical NewsArtical : newsArticals){
            List<NewsArtical> news = newsArticalJpaRepository.findByUrl(NewsArtical.getUrl());
            if (news.size() == 0) {
                save(NewsArtical);
            }
        }
        return ResultUtils.instanceResult("获取成功!", newsArticals,true);
    }

    @Override
    @Transactional
    public Result<NewsArtical> saveNewsArtical(NewsArtical newsArtical) {
        if(ManageNewsStatusEnum.RELEASE.getCode() != newsArtical.getStatus()){
            newsArtical.setPublishDate(null);
        }
        return ResultUtils.instanceResult("保存成功!", save(newsArtical),true, CommonContent.NEWS_TITLE);
    }

    @Override
    public Result<PageResult<NewsArtical>> findCmsPage(PageResult<NewsArtical> pageResult){
        NewsArtical newsArtical = new NewsArtical();
        newsArtical.setStatus(ManageNewsStatusEnum.RELEASE.getCode());
        return findPage(pageResult,Example.of(newsArtical,ExampleMatcher.matching().withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact())));
    }


    @Override
    public Result<PageResult<NewsArtical>> findPage(PageResult<NewsArtical> pageResult,Example<NewsArtical> example) {
        PageRequest pageRequest = new PageRequest(pageResult.getPageNumber()-1, pageResult.getPageSize(), new Sort(Sort.Direction.DESC,"publishDate"));
        Page<NewsArtical> newsArticals = null;
        if(example == null) {
            newsArticals = newsArticalJpaRepository.findAll(pageRequest);
        }else{
            newsArticals = newsArticalJpaRepository.findAll(example,pageRequest);
        }
        return ResultUtils.instancePageResult(newsArticals.getNumber()+1,newsArticals.getSize(),newsArticals.getTotalElements(),newsArticals.getContent(),"获取成功",true);
    }
}
