package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("manage")
public class ManageUserController {
    @RequestMapping("doLogin")
    @ResponseBody
    public Result<String> doLogin(String username,String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
        return ResultUtils.instanceResult("登录成功","main",true,"提示");
    }
}
