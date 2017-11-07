package com.ak47.cms.cms.service;

import com.ak47.cms.cms.entity.PBCArtical;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface PBCArticalService extends BaseService<PBCArtical>{
    Result<List<PBCArtical>> syncNews(List<PBCArtical> newsArticals);
    Result<PageResult<PBCArtical>> findPage(PageResult<PBCArtical> pageResult);
}
