package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.dao.PBCArticalJpaRepository;
import com.ak47.cms.cms.entity.PBCArtical;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import com.ak47.cms.cms.service.PBCArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
@Service
public class PBCArticalServiceImpl implements PBCArticalService {
    @Autowired
    private PBCArticalJpaRepository pbcArticalJpaRepository;
    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    @Transactional
    public int save(PBCArtical pbcArtical) {
        pbcArticalJpaRepository.save(pbcArtical);
        return 1;
    }

    @Override
    public List<PBCArtical> findAll() {
        return pbcArticalJpaRepository.findAll();
    }

    @Override
    public PBCArtical findOne(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Result<List<PBCArtical>> syncNews(List<PBCArtical> PBCArticals) {
        int count = 0;
        for(PBCArtical PBCArtical:PBCArticals){
            List<PBCArtical> news = pbcArticalJpaRepository.findByUrl(PBCArtical.getUrl());
            if (news.size() == 0) {
                count += save(PBCArtical);
            }
        }
        return ResultUtils.instanceResult("获取成功!",PBCArticals,true);
    }

    @Override
    public Result<PageResult<PBCArtical>> findPage(PageResult<PBCArtical> pageResult) {
        PageRequest pageRequest = new PageRequest(pageResult.getPageNum()-1, pageResult.getPageSize(), new Sort(Sort.Direction.DESC,"gmtModified"));
        Page<PBCArtical> pbcArticalPage = pbcArticalJpaRepository.findAll(pageRequest);
        return ResultUtils.instancePageResult(pbcArticalPage.getNumber()+1,pbcArticalPage.getSize(),pbcArticalPage.getContent(),"获取成功",true);
    }
}
