package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.common.CommonContent;
import com.ak47.cms.cms.dao.NewsArticalJpaRepository;
import com.ak47.cms.cms.dto.NewsArticalDto;
import com.ak47.cms.cms.entity.NewsArtical;
import com.ak47.cms.cms.entity.NewsLabel;
import com.ak47.cms.cms.enums.ManageStatusEnum;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import com.ak47.cms.cms.service.NewsArticalService;
import com.ak47.cms.cms.service.NewsLabelService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
@Service
public class NewsArticalServiceImpl implements NewsArticalService {
    @Autowired
    private NewsArticalJpaRepository newsArticalJpaRepository;
    @Autowired
    private NewsLabelService newsLabelService;
    @Override
    public void delete(Long id) {
        newsArticalJpaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public NewsArtical save(NewsArtical newsArtical) {
        Date now = new Date();
        newsArtical.setGmtModified(now);
        if(newsArtical.getId() == null) {
            newsArtical.setIsDeleted("n");
            newsArtical.setGmtCreate(now);
        }
        if(ManageStatusEnum.RELEASE.getCode() != newsArtical.getStatus()){
            newsArtical.setPublishDate(null);
        }
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
    public NewsArticalDto findDto(Long id) {
        NewsArtical newsArtical = newsArticalJpaRepository.getOne(id);
        List<NewsLabel> newsLabels = newsLabelService.findByNewsId(id);
        return new NewsArticalDto(newsArtical,newsLabels);
    }
    @Override
    @Transactional
    public Result<List<NewsArtical>> syncNews(List<NewsArtical> newsArticals) {
        for(NewsArtical newsArtical : newsArticals){
            List<NewsArtical> news = newsArticalJpaRepository.findByUrl(newsArtical.getUrl());
            if (news.size() == 0) {
                save(newsArtical);
            }
        }
        return ResultUtils.instanceResult("获取成功!", newsArticals,true);
    }

    @Override
    public Result<NewsArticalDto> saveNewsArtical(NewsArtical newsArtical, List<Integer> labels) {
        newsArtical.setStatus(ManageStatusEnum.DRAFT.getCode());
        newsArtical =  save(newsArtical);
        List<NewsLabel> newsLabels = new ArrayList<>();
        if(newsArtical != null && newsArtical.getId() != null){
            if(labels != null && labels.size() > 0) {
                List<NewsLabel> newsLabelList = newsLabelService.findByNewsId(newsArtical.getId());
                List<Long> oldDelLabelIds = newsLabelList.stream().filter(newsLabel -> !labels.contains(newsLabel.getLabel() + "")).map(newsLabel -> newsLabel.getId()).collect(Collectors.toList());
                oldDelLabelIds.stream().forEach(value -> newsLabelService.delete(value));
                List<Integer> oldLabel = newsLabelList.stream().filter(newsLabel -> !labels.contains(newsLabel.getLabel())).map(newsLabel -> newsLabel.getLabel()).collect(Collectors.toList());
                for (Integer label : labels) {
                    if (oldLabel.contains(label)) {
                        continue;
                    }
                    Date now = new Date();
                    NewsLabel newsLabel = new NewsLabel();
                    newsLabel.setGmtCreate(now);
                    newsLabel.setGmtModified(now);
                    newsLabel.setIsDeleted("n");
                    newsLabel.setLabel(label);
                    newsLabel.setNewsId(newsArtical.getId());
                    newsLabels.add(newsLabelService.save(newsLabel));
                }
            }else{
                List<NewsLabel> newsLabelList = newsLabelService.findByNewsId(newsArtical.getId());
                newsLabelService.deleteList(newsLabelList);
            }
        }
        return ResultUtils.instanceResult("保存成功!",new NewsArticalDto(newsArtical,newsLabels),true, CommonContent.NEWS_TITLE);
    }

    @Override
    public Result<NewsArticalDto> releaseNewsArtical(Long newsId) {
        NewsArtical newsArtical = newsArticalJpaRepository.getOne(newsId);
        newsArtical.setStatus(ManageStatusEnum.RELEASE.getCode());
        newsArtical = save(newsArtical);
        return ResultUtils.instanceResult("保存成功!",new NewsArticalDto(newsArtical,newsLabelService.findByNewsId(newsId)),true, CommonContent.NEWS_TITLE);
    }

    @Override
    public Result<PageResult<NewsArticalDto>> findCmsPage(PageResult<NewsArtical> pageResult){
        NewsArtical newsArtical = new NewsArtical();
        newsArtical.setStatus(ManageStatusEnum.RELEASE.getCode());
        return findPage(pageResult,Example.of(newsArtical,ExampleMatcher.matching().withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact())));
    }


    @Override
    public Result<PageResult<NewsArticalDto>> findPage(PageResult<NewsArtical> pageResult,Example<NewsArtical> example) {
        PageRequest pageRequest = new PageRequest(pageResult.getPageNumber()-1, pageResult.getPageSize(), new Sort(Sort.Direction.DESC,"gmtModified"));
        Page<NewsArtical> newsArticals = null;
        if(example == null) {
            newsArticals = newsArticalJpaRepository.findAll(pageRequest);
        }else{
            newsArticals = newsArticalJpaRepository.findAll(example,pageRequest);
        }
        List<NewsArticalDto> newsArticalDtos = new ArrayList<>();
        for(NewsArtical newsArtical:newsArticals.getContent()){
            newsArticalDtos.add(setDto(newsArtical));
        }
        return ResultUtils.instancePageResult(newsArticals.getNumber()+1,newsArticals.getSize(),newsArticals.getTotalElements(),newsArticalDtos,"获取成功",true);
    }

    private NewsArticalDto setDto(NewsArtical newsArtical){
        return new NewsArticalDto(newsArtical,newsLabelService.findByNewsId(newsArtical.getId()));
    }
}
