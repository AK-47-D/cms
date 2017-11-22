package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("manage")
public class ManageUserController {
    private static final Logger logger = LoggerFactory.getLogger(ManageUserController.class);
    @RequestMapping("doLogin")
    @ResponseBody
    public Result<String> doLogin(String username,String password) throws AuthenticationException{
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject currentUser = SecurityUtils.getSubject();
//        try {
            currentUser.login(token);
//        } catch (AuthenticationException e) {
//            logger.info("doLogin====>{}","登录失败");
//            return ResultUtils.instanceResult("登录失败","main",false,"提示");
//        }
        return ResultUtils.instanceResult("登录成功","main",true,"提示");
    }
}
