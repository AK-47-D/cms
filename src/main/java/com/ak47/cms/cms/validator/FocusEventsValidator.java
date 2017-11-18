package com.ak47.cms.cms.validator;

import com.ak47.cms.cms.entity.FocusEvents;
import org.apache.commons.lang.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class FocusEventsValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.getName().startsWith(FocusEvents.class.getName());
    }

    @Override
    public void validate(@Nullable Object target, Errors errors) {
        FocusEvents focusEvents = (FocusEvents) target;
        if (StringUtils.isBlank(focusEvents.getTitle())) {
            errors.rejectValue("title", null, null, "标题不能为空");
        }
        if (StringUtils.isBlank(focusEvents.getContent())) {
            errors.rejectValue("html", null, null, "内容不能为空");
        }
        if (focusEvents.getStatus() == -1) {
            errors.rejectValue("status", null, null, "状态不能为空");
        }
        if (focusEvents.getSource() == -1) {
            errors.rejectValue("from", null, null, "来源不能为空");
        }
        if (focusEvents.getCountry() == -1) {
            errors.rejectValue("country", null, null, "地区不能为空");
        }
        if (focusEvents.getCpi() == null) {
            errors.rejectValue("cpi", null, null, "cpi不能为空");
        }
        if (focusEvents.getGdp() == null) {
            errors.rejectValue("gdp", null, null, "gdp不能为空");
        }
        if (focusEvents.getNu() == null) {
            errors.rejectValue("bu", null, null, "nu不能为空");
        }
    }
}
