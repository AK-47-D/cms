package com.ak47.cms.cms.service;

import com.ak47.cms.cms.entity.Report;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Map;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface ReportService extends BaseService<Report>{
    Result<PageResult<Report>> findPage(PageResult<Report> pageResult, Example<Report> example);
    Result<Report> saveReport(Report report);
    Result<List<Report>> findCmsPage(Report report);
    Object findAroundDate();
}
