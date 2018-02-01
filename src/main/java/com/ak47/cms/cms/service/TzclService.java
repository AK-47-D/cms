package com.ak47.cms.cms.service;

import com.ak47.cms.cms.dto.TzclDto;
import com.ak47.cms.cms.entity.Tzcl;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface TzclService extends BaseService<Tzcl>{
    Result<PageResult<TzclDto>> findPage(PageResult<Tzcl> pageResult);
}
