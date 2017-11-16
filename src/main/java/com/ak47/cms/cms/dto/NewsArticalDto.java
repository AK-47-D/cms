package com.ak47.cms.cms.dto;

import com.ak47.cms.cms.entity.NewsArtical;
import com.ak47.cms.cms.entity.NewsLabel;

import java.util.List;

public class NewsArticalDto extends NewsArtical {
    private List<NewsLabel> newsLabels;

    public List<NewsLabel> getNewsLabels() {
        return newsLabels;
    }

    public void setNewsLabels(List<NewsLabel> newsLabels) {
        this.newsLabels = newsLabels;
    }

    public NewsArticalDto() {
    }

    public NewsArticalDto(NewsArtical newsArtical,List<NewsLabel> newsLabels) {
        setIsDeleted(newsArtical.getIsDeleted());
        setGmtCreate(newsArtical.getGmtCreate());
        setGmtModified(newsArtical.getGmtModified());
        setHappenDate(newsArtical.getHappenDate());
        setHtml(newsArtical.getHtml());
        setId(newsArtical.getId());
        setImage(newsArtical.getImage());
        setPublishDate(newsArtical.getPublishDate());
        setSource(newsArtical.getSource());
        setStatus(newsArtical.getStatus());
        setTitle(newsArtical.getTitle());
        setType(newsArtical.getType());
        setUrl(newsArtical.getUrl());
        this.newsLabels = newsLabels;
    }
}
