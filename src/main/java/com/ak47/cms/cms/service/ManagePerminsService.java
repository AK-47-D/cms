package com.ak47.cms.cms.service;

import com.ak47.cms.cms.entity.ManagePermins;
import com.ak47.cms.cms.entity.ManageUser;
import com.ak47.cms.cms.result.Result;

import java.util.List;

public interface ManagePerminsService extends BaseService<ManagePermins> {
    List<ManagePermins> findByUserId(Long userId);
}
