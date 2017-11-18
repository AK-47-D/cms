package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.common.CommonContent;
import com.ak47.cms.cms.dao.FocusEventsJapRepository;
import com.ak47.cms.cms.entity.FocusEvents;
import com.ak47.cms.cms.enums.ManageStatusEnum;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import com.ak47.cms.cms.service.FocusEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
@Service
public class FocusEventsServiceImpl implements FocusEventsService{
    @Autowired
    private FocusEventsJapRepository focusEventsJapRepository;
    @Override
    @Transactional
    public FocusEvents save(FocusEvents focusEvents) {
        Date now = new Date();
        focusEvents.setGmtModified(now);
        if(focusEvents.getId() == null) {
            focusEvents.setIsDeleted("n");
            focusEvents.setGmtCreate(now);
        }
        return focusEventsJapRepository.save(focusEvents);
    }

    @Override
    public List<FocusEvents> findAll() {
        return focusEventsJapRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        focusEventsJapRepository.deleteById(id);
    }

    @Override
    public FocusEvents findOne(Long id) {
        return focusEventsJapRepository.getOne(id);
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
            focusEventsPage = focusEventsJapRepository.findAll(pageRequest);
        }else{
            focusEventsPage = focusEventsJapRepository.findAll(example,pageRequest);
        }
        return ResultUtils.instancePageResult(focusEventsPage.getNumber()+1,focusEventsPage.getSize(),focusEventsPage.getTotalElements(),focusEventsPage.getContent(),"获取成功",true);

    }

    @Override
    public Result<List<FocusEvents>> findCmsPage(FocusEvents focusEvents) {
        List<FocusEvents> focusEventsList = focusEventsJapRepository.findCmsPage(focusEvents.getStatus());
        return ResultUtils.instanceResult("焦点list",focusEventsList.stream().filter(focus ->focus.getHappenDate().getDate() == focusEvents.getHappenDate().getDate()).collect(Collectors.toList()),true,CommonContent.FOCUS_TITLE);
    }
//    public static void main(String[] args){
//        System.out.println();
//    }
}
