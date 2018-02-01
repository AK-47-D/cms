package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.dto.TzclDto;
import com.ak47.cms.cms.entity.Tzcl;
import com.ak47.cms.cms.result.PageResult;
import com.ak47.cms.cms.service.TzclService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TzclController {

    @Autowired
    private TzclService tzclService;

    @PostMapping("tzcl/findTzclList")
    @ResponseBody
    public PageResult<TzclDto> saveFocus(PageResult<Tzcl> pageResult){
        return tzclService.findPage(pageResult).getResult();
    }
}
