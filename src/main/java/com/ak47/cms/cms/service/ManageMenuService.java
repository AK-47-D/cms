package com.ak47.cms.cms.service;

import com.ak47.cms.cms.dto.ManageMenuDto;
import com.ak47.cms.cms.entity.ManageMenu;
import com.ak47.cms.cms.result.Result;

import java.util.List;

public interface ManageMenuService extends BaseService<ManageMenu> {
    Result<List<ManageMenuDto>> findUserMenu(Long userId);
}
