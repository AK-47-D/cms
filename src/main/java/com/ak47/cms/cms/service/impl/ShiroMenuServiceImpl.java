package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.dao.ShiroMenuJapRepository;
import com.ak47.cms.cms.entity.ShiroMenu;
import com.ak47.cms.cms.service.ShiroMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiroMenuServiceImpl implements ShiroMenuService{
    @Autowired
    private ShiroMenuJapRepository shiroMenuJapRepository;
    @Override
    public ShiroMenu save(ShiroMenu shiroMenu) {
        return shiroMenuJapRepository.save(shiroMenu);
    }

    @Override
    public List<ShiroMenu> findAll() {
        return shiroMenuJapRepository.findAll( new Sort(Sort.Direction.ASC,"shiroOrder"));
    }

    @Override
    public void delete(Long id) {
        shiroMenuJapRepository.deleteById(id);
    }

    @Override
    public ShiroMenu findOne(Long id) {
        return shiroMenuJapRepository.getOne(id);
    }
}
