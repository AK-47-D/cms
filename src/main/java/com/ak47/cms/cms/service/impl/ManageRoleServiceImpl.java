package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.dao.ManageRoleJpaRepository;
import com.ak47.cms.cms.entity.ManagePermins;
import com.ak47.cms.cms.entity.ManageRole;
import com.ak47.cms.cms.service.ManageRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageRoleServiceImpl implements ManageRoleService {
    @Autowired
    private ManageRoleJpaRepository manageRoleJpaRepository;

    @Override
    public ManageRole save(ManageRole manageRole) {
        return manageRoleJpaRepository.save(manageRole);
    }

    @Override
    public List<ManageRole> findAll() {
        return manageRoleJpaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        manageRoleJpaRepository.deleteById(id);
    }

    @Override
    public ManageRole findOne(Long id) {
        return manageRoleJpaRepository.getOne(id);
    }

    @Override
    public List<ManageRole> findByUserId(Long userId) {
        return manageRoleJpaRepository.findByUserId(userId);
    }
}
