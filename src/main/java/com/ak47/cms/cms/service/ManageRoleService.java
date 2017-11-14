package com.ak47.cms.cms.service;

import com.ak47.cms.cms.entity.ManageRole;

import java.util.List;

public interface ManageRoleService extends BaseService<ManageRole> {
    List<ManageRole> findByUserId(Long userId);
}
