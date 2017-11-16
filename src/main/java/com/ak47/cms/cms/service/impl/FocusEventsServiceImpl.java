package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.common.CommonContent;
import com.ak47.cms.cms.dao.FocusEventsRepository;
import com.ak47.cms.cms.entity.FocusEvents;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import com.ak47.cms.cms.service.FocusEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
@Service
public class FocusEventsServiceImpl implements FocusEventsService{
    @Autowired
    private FocusEventsRepository focusEventsRepository;
    @Override
    @Transactional
    public FocusEvents save(FocusEvents focusEvents) {
        Date now = new Date();
        focusEvents.setGmtModified(now);
        if(focusEvents.getId() == null) {
            focusEvents.setIsDeleted("n");
            focusEvents.setGmtCreate(now);
        }
        return focusEventsRepository.save(focusEvents);
    }

    @Override
    public List<FocusEvents> findAll() {
        return focusEventsRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        focusEventsRepository.deleteById(id);
    }

    @Override
    public FocusEvents findOne(Long id) {
        return focusEventsRepository.getOne(id);
    }

    @Override
    @Transactional
    public Result<FocusEvents> saveFocus(FocusEvents focusEvents) {
        return ResultUtils.instanceResult("保存成功!", save(focusEvents),true, CommonContent.FOCUS_TITLE);
    }

    @Override
    public Result<PageResult<FocusEvents>> findPage(PageResult<FocusEvents> pageResult, Example<FocusEvents> example) {
        PageRequest pageRequest = new PageRequest(pageResult.getPageNumber()-1, pageResult.getPageSize(), new Sort(Sort.Direction.DESC,"gmtModified"));
        Page<FocusEvents> focusEventsPage = null;
        if(example == null) {
            focusEventsPage = focusEventsRepository.findAll(pageRequest);
        }else{
            focusEventsPage = focusEventsRepository.findAll(example,pageRequest);
        }
        return ResultUtils.instancePageResult(focusEventsPage.getNumber()+1,focusEventsPage.getSize(),focusEventsPage.getTotalElements(),focusEventsPage.getContent(),"获取成功",true);

    }
}
