package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.dao.PBCArticalJpaRepository;
import com.ak47.cms.cms.entity.PBCArtical;
import com.ak47.cms.cms.service.PBCArticalService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public int syncNews(List<PBCArtical> PBCArticals) {
        int count = 0;
        for(PBCArtical PBCArtical:PBCArticals){
            List<PBCArtical> news = pbcArticalJpaRepository.findByUrl(PBCArtical.getUrl());
            if (news.size() == 0) {
                count += save(PBCArtical);
            }
        }
        return count;
    }
}
