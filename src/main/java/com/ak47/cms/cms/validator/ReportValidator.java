package com.ak47.cms.cms.validator;

import com.ak47.cms.cms.entity.Report;
import org.apache.commons.lang.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class ReportValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.getName().startsWith(Report.class.getName());
    }

    @Override
    public void validate(@Nullable Object target, Errors errors) {
        Report report = (Report) target;
        if (StringUtils.isBlank(report.getTitle())) {
            errors.rejectValue("title", null, null, "标题不能为空");
        }
        if (StringUtils.isBlank(report.getPdf())) {
            errors.rejectValue("pdf", null, null, "内容不能为空");
        }
        if (report.getStatus() == null || report.getStatus() == -1) {
            errors.rejectValue("status", null, null, "类型不能为空");
        }
        if (report.getSource() == null || report.getSource() == -1) {
            errors.rejectValue("source", null, null, "来源不能为空");
        }
    }
}
