package com.ak47.cms.cms.service;

import com.ak47.cms.cms.dto.ManageUserDto;
import com.ak47.cms.cms.entity.ManageUser;
import com.ak47.cms.cms.result.Result;

public interface ManageUserService extends BaseService<ManageUser> {
    Result<ManageUserDto> findByUser(String username, String password);
    ManageUser findByUsername(String username);
    ManageUser findByUsernameAndPwd(String username,String password);
}
