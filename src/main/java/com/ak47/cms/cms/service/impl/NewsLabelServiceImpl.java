package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.dao.NewsLabelJpaRepository;
import com.ak47.cms.cms.entity.NewsLabel;
import com.ak47.cms.cms.service.BaseService;
import com.ak47.cms.cms.service.NewsLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
@Service
public class NewsLabelServiceImpl implements NewsLabelService{
    @Autowired
    private NewsLabelJpaRepository newsLabelJpaRepository;
    @Override
    public NewsLabel save(NewsLabel newsLabel) {
        return newsLabelJpaRepository.save(newsLabel);
    }

    @Override
    public List<NewsLabel> findAll() {
        return newsLabelJpaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        newsLabelJpaRepository.deleteById(id);
    }

    @Override
    public void deleteList(List<NewsLabel> newsLabels) {
        newsLabelJpaRepository.deleteAll(newsLabels);
    }

    @Override
    public NewsLabel findOne(Long id) {
        return newsLabelJpaRepository.getOne(id);
    }

    @Override
    public List<NewsLabel> findByNewsId(Long newsId) {
        NewsLabel newsLabels = new NewsLabel();
        newsLabels.setNewsId(newsId);
        return newsLabelJpaRepository.findAll(Example.of(newsLabels, ExampleMatcher.matching().withMatcher("newsId",ExampleMatcher.GenericPropertyMatchers.exact())));
    }
    @Override
    public List<NewsLabel> findByNewsIdAndLabel(Long newsId,Integer label) {
        NewsLabel newsLabels = new NewsLabel();
        newsLabels.setNewsId(newsId);
        newsLabels.setLabel(label);
        return newsLabelJpaRepository.findAll(Example.of(newsLabels, ExampleMatcher.matching().withMatcher("newsId",ExampleMatcher.GenericPropertyMatchers.exact()).withMatcher("label",ExampleMatcher.GenericPropertyMatchers.exact())));
    }
}
