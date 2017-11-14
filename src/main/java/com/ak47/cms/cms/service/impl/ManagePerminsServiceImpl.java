package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.dao.ManagePerminsJpaRepository;
import com.ak47.cms.cms.entity.ManagePermins;
import com.ak47.cms.cms.service.ManagePerminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagePerminsServiceImpl implements ManagePerminsService {
    @Autowired
    private ManagePerminsJpaRepository managePerminsJpaRepository;
    @Override
    public ManagePermins save(ManagePermins managePermins) {
        return managePerminsJpaRepository.save(managePermins);
    }

    @Override
    public List<ManagePermins> findAll() {
        return managePerminsJpaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        managePerminsJpaRepository.deleteById(id);
    }

    @Override
    public ManagePermins findOne(Long id) {
        return managePerminsJpaRepository.getOne(id);
    }

    @Override
    public List<ManagePermins> findByUserId(Long userId) {
        return managePerminsJpaRepository.findByUserId(userId);
    }
}
