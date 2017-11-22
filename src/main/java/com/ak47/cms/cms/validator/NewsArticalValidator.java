package com.ak47.cms.cms.validator;

import com.ak47.cms.cms.entity.NewsArtical;
import org.apache.commons.lang.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class NewsArticalValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.getName().startsWith(NewsArtical.class.getName());
    }

    @Override
    public void validate(@Nullable Object target, Errors errors) {
        NewsArtical newsArtical = (NewsArtical) target;
        if (StringUtils.isBlank(newsArtical.getTitle())) {
            errors.rejectValue("title", null, null, "标题不能为空");
        }
        if (StringUtils.isBlank(newsArtical.getHtml())) {
            errors.rejectValue("html", null, null, "内容不能为空");
        }
        if (newsArtical.getType() == -1) {
            errors.rejectValue("type", null, null, "类型不能为空");
        }
        if (newsArtical.getSource() == -1) {
            errors.rejectValue("from", null, null, "来源不能为空");
        }
        if (newsArtical.getHappenDate() == null) {
            errors.rejectValue("happenDate", null, null, "发生时间不能为空");
        }
    }
}
