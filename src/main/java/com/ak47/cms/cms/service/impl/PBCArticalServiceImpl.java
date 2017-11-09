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
    public void delete(Long id) {
        pbcArticalJpaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public PBCArtical save(PBCArtical pbcArtical) {
        return pbcArticalJpaRepository.save(pbcArtical);
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
        for(PBCArtical PBCArtical:PBCArticals){
            List<PBCArtical> news = pbcArticalJpaRepository.findByUrl(PBCArtical.getUrl());
            if (news.size() == 0) {
                save(PBCArtical);
            }
        }
        return ResultUtils.instanceResult("获取成功!",PBCArticals,true);
    }

    @Override
    public Result<PageResult<PBCArtical>> findPage(PageResult<PBCArtical> pageResult) {
        PageRequest pageRequest = new PageRequest(pageResult.getPageNum()-1, pageResult.getPageSize(), new Sort(Sort.Direction.DESC,"publishDate"));
        Page<PBCArtical> pbcArticalPage = pbcArticalJpaRepository.findAll(pageRequest);
        return ResultUtils.instancePageResult(pbcArticalPage.getNumber()+1,pbcArticalPage.getSize(),pbcArticalPage.getContent(),"获取成功",true);
    }
}
