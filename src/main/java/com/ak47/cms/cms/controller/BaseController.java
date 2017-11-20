package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.exception.CmsException;
import com.ak47.cms.cms.util.WebUtil;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    /**
     * 登录认证异常
     */
    @ExceptionHandler({ UnauthenticatedException.class, AuthenticationException.class })
    public String authenticationException(HttpServletRequest request, HttpServletResponse response){
        if (WebUtil.isAjaxRequest(request)) {
            // 输出JSON
            WebUtil.writeJson(response,"很抱歉,未登录!",null,false,"权限");
            return null;
        } else {
            return "redirect:/manage/login";
        }
    }
    /**
     * 权限异常
     */
    @ExceptionHandler({ UnauthorizedException.class, AuthorizationException.class })
    public String authorizationException(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (WebUtil.isAjaxRequest(request)) {
            // 输出JSON
            WebUtil.writeJson(response,"很抱歉,无权限!",null,false,"权限");
            return null;
        } else {
            throw new CmsException("很抱歉,无权限!");
        }
    }
}
