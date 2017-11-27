package com.ak47.cms.cms.error;

import com.ak47.cms.cms.exception.CmsJsonException;
import com.ak47.cms.cms.exception.CmsViewException;
import com.ak47.cms.cms.result.ResultUtils;
import com.ak47.cms.cms.util.WebUtil;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws IOException{
        if(e instanceof CmsJsonException){
            //AJAX失败
            logger.error("CmsJsonException====>{}{}",CmsJsonException.getStackMsg(e));
            writeOut(response,e);
            return null;
        }else if (e instanceof UnauthorizedException || e instanceof AuthorizationException){
            //权限异常
            logger.error("权限异常====>{}{}",CmsJsonException.getStackMsg(e));
            if (WebUtil.isAjaxRequest(request) && request.getMethod().toLowerCase().equals("post")) {
                writeOut( response,e);
                return null;
            }
        }else if (e instanceof UnauthenticatedException || e instanceof AuthenticationException){
            //登录认证异常
            logger.error("登录认证异常====>{}",CmsJsonException.getStackMsg(e));
            if (WebUtil.isAjaxRequest(request) && request.getMethod().toLowerCase().equals("post")) {
                writeOut( response,e);
                return null;
            }
        }
        logger.error("exceptionHandler====>{}",CmsJsonException.getStackMsg(e));
        ModelAndView modelAndView = new ModelAndView("/error"); //error页面
        modelAndView.addObject("errorMessage", e.getMessage());
        modelAndView.addObject("stackTrace", e.getStackTrace());
        modelAndView.addObject("requestURI", request.getRequestURI());
        return modelAndView;
    }

    private static void writeOut(HttpServletResponse response,Exception e) throws IOException{
        logger.error("CmsJsonException====>{}",CmsJsonException.getStackMsg(e));
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(JSON.toJSONString(ResultUtils.instanceResult(e.getMessage(), null, false, e instanceof CmsJsonException?((CmsJsonException) e).getTitle():"提示")));
    }
}
