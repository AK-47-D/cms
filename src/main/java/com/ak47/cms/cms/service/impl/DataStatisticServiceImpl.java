package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.api.PBCCrawler;
import com.ak47.cms.cms.common.CommonContent;
import com.ak47.cms.cms.dao.DataStatisticJpaRepository;
import com.ak47.cms.cms.entity.DataStatistics;
import com.ak47.cms.cms.enums.PBCType;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import com.ak47.cms.cms.service.DataStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DataStatisticServiceImpl implements DataStatisticService {
    @Autowired
    private DataStatisticJpaRepository dataStatisticJpaRepository;
    @Override
    public DataStatistics save(DataStatistics dataStatistics) {
        return dataStatisticJpaRepository.save(dataStatistics);
    }

    @Override
    public List<DataStatistics> findAll() {
        return dataStatisticJpaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        dataStatisticJpaRepository.deleteById(id);
    }

    @Override
    public DataStatistics findOne(Long id) {
        return dataStatisticJpaRepository.getOne(id);
    }

    @Override
    @Transactional
    public Result<List<DataStatistics>> syncDataStatistics() {
        List<DataStatistics> list = PBCCrawler.instanceCrawler().getCountData(CommonContent.PBC_HOST + PBCType.STATISTICS.getUrl(),PBCType.STATISTICS.getTypeCode());
        for(DataStatistics dataStatistics:list){
            List<DataStatistics> ds = dataStatisticJpaRepository.findByUrl(dataStatistics.getUrl3());
            if(ds == null || ds.size() == 0) dataStatisticJpaRepository.save(dataStatistics);
        }
        return ResultUtils.instanceResult("获取成功!",list,true);
    }

    @Override
    public Result<PageResult<DataStatistics>> findPage(PageResult<DataStatistics> pageResult) {
        PageRequest pageRequest = new PageRequest(pageResult.getPageNum()-1, pageResult.getPageSize(), new Sort(Sort.Direction.DESC,"gmtModified"));
        Page<DataStatistics> dataStatisticsPage = dataStatisticJpaRepository.findAll(pageRequest);
        return ResultUtils.instancePageResult(dataStatisticsPage.getNumber()+1,dataStatisticsPage.getSize(),dataStatisticsPage.getTotalElements(),dataStatisticsPage.getContent(),"获取成功",true);

    }
}
