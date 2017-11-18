package com.ak47.cms.cms.service;

import com.ak47.cms.cms.entity.FocusEvents;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.result.Result;
import org.springframework.data.domain.Example;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface FocusEventsService extends BaseService<FocusEvents>{
    Result<FocusEvents> saveFocus(FocusEvents focusEvents);
    Result<PageResult<FocusEvents>> findPage(PageResult<FocusEvents> pageResult,Example<FocusEvents> example);
    Result<List<FocusEvents>> findCmsPage(FocusEvents focusEvents);
}
