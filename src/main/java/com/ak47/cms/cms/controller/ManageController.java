package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.service.ManageMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("manage")
public class ManageController {
    @Autowired
    private ManageMenuService manageMenuService;
    @GetMapping("main")
    public String manageMain(){
        return "cms_manage/content";
    }
    @GetMapping("findMenu")
    @ResponseBody
    public Result findMenu(Long userId){
        return manageMenuService.findUserMenu(userId);
    }
}
