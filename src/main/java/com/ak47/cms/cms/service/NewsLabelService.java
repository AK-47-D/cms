package com.ak47.cms.cms.service;

import com.ak47.cms.cms.entity.NewsLabel;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface NewsLabelService extends BaseService<NewsLabel>{
    List<NewsLabel> findByNewsId(Long newsId);
    List<NewsLabel> findByNewsIdAndLabel(Long newsId,Integer label);
    void deleteList(List<NewsLabel> newsLabels);
}
