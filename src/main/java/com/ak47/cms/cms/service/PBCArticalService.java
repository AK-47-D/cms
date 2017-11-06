package com.ak47.cms.cms.service;

import com.ak47.cms.cms.entity.PBCArtical;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface PBCArticalService extends BaseService<PBCArtical>{
    int syncNews(List<PBCArtical> newsArticals);
}
