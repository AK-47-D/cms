package com.ak47.cms.cms.service;

import com.ak47.cms.cms.entity.DataStatistics;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;

import java.util.List;

public interface DataStatisticService extends BaseService<DataStatistics> {
    Result<List<DataStatistics>> syncDataStatistics();
    Result<PageResult<DataStatistics>> findPage(PageResult<DataStatistics> pageResult);
}
