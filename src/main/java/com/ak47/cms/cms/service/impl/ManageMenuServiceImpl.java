package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.dao.ManageMenuJpaRepository;
import com.ak47.cms.cms.dto.ManageMenuDto;
import com.ak47.cms.cms.entity.ManageMenu;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import com.ak47.cms.cms.service.ManageMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageMenuServiceImpl implements ManageMenuService {
    @Autowired
    private ManageMenuJpaRepository manageMenuJpaRepository;
    @Override
    public Result<List<ManageMenuDto>> findUserMenu(Long userId) {
        List<ManageMenuDto> manageMenuDtos = manageMenuJpaRepository.findUserMenu(userId);
        for(ManageMenuDto manageMenuDto:manageMenuDtos){
            manageMenuDto.setChildMenu(manageMenuJpaRepository.findChildMenu(userId,manageMenuDto.getId()));
        }
        return ResultUtils.instanceResult("success",manageMenuDtos,true);
    }

    @Override
    public ManageMenu save(ManageMenu manageMenu) {
        return null;
    }

    @Override
    public List<ManageMenu> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ManageMenu findOne(Long id) {
        return null;
    }
}
