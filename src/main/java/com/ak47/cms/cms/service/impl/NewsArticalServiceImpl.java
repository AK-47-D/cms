package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.common.CommonContent;
import com.ak47.cms.cms.dao.NewsArticalJpaRepository;
import com.ak47.cms.cms.entity.NewsArtical;
import com.ak47.cms.cms.enums.ManageNewsStatusEnum;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import com.ak47.cms.cms.service.NewsArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
@Service
public class NewsArticalServiceImpl implements NewsArticalService {
    @Autowired
    private NewsArticalJpaRepository newsArticalJpaRepository;
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
        return null;
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
    public Result<PageResult<NewsArtical>> findPage(PageResult<NewsArtical> pageResult) {
        PageRequest pageRequest = new PageRequest(pageResult.getPageNum(), pageResult.getPageSize(), new Sort(Sort.Direction.DESC,"publishDate"));
        Page<NewsArtical> newsArticals = newsArticalJpaRepository.findAll(pageRequest);
        return ResultUtils.instancePageResult(newsArticals.getNumber()+1,newsArticals.getSize(),newsArticals.getTotalElements(),newsArticals.getContent(),"获取成功",true);
    }


}
