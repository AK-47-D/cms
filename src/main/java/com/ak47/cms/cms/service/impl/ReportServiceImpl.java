package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.common.CommonContent;
import com.ak47.cms.cms.dao.ReportJapRepository;
import com.ak47.cms.cms.dto.NewsArticalDto;
import com.ak47.cms.cms.entity.NewsArtical;
import com.ak47.cms.cms.entity.Report;
import com.ak47.cms.cms.enums.ManageStatusEnum;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import com.ak47.cms.cms.service.ReportService;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportJapRepository reportJapRepository;

    @Override
    public Report save(Report report) {
        Date now = new Date();
        report.setGmtModified(now);
        if(report.getId() == null) {
            report.setIsDeleted("n");
            report.setGmtCreate(now);
        }
        return reportJapRepository.save(report);
    }

    @Override
    public List<Report> findAll() {
        return reportJapRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        reportJapRepository.deleteById(id);
    }

    @Override
    public Report findOne(Long id) {
        return reportJapRepository.getOne(id);
    }

    @Override
    public Result<PageResult<Report>> findPage(PageResult<Report> pageResult, Example<Report> example) {
        PageRequest pageRequest = new PageRequest(pageResult.getPageNumber()-1, pageResult.getPageSize(), new Sort(Sort.Direction.DESC,"gmtModified"));
        Page<Report> reportPage;
        if(example == null) {
            reportPage = reportJapRepository.findAll(pageRequest);
        }else{
            reportPage = reportJapRepository.findAll(example,pageRequest);
        }
        return ResultUtils.instancePageResult(reportPage.getNumber()+1,reportPage.getSize(),reportPage.getTotalElements(),reportPage.getContent(),"获取成功",true);
    }

    @Override
    public Result<Report> saveReport(Report report) {
        return ResultUtils.instanceResult("保存成功!", save(report),true, CommonContent.REPORT_TITLE);
    }

    @Override
    public Result<List<Report>> findCmsPage(Report report) {
        List<Report> reportList = reportJapRepository.findCmsPage(ManageStatusEnum.RELEASE.getCode());
        return ResultUtils.instanceResult("报告list",reportList.stream().filter(rp -> DateFormatUtils.format(rp.getHappenDate(),"yyyy").equals(DateFormatUtils.format(report.getHappenDate(),"yyyy"))).collect(Collectors.toList()),true,CommonContent.REPORT_TITLE);
    }
}
