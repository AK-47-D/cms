package com.ak47.cms.cms.error;

import com.ak47.cms.cms.exception.CmsJsonException;
import com.ak47.cms.cms.exception.CmsViewException;
import com.ak47.cms.cms.result.ResultUtils;
import com.ak47.cms.cms.util.WebUtil;
import com.alibaba.fastjson.JSON;
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

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 登录认证异常
     */
    @ExceptionHandler(value={UnauthenticatedException.class, AuthenticationException.class})
    public String authenticationException(HttpServletRequest request, HttpServletResponse response) {
        if (WebUtil.isAjaxRequest(request)) {
            // 输出JSON
            throw new CmsJsonException("很抱歉,未登录!", "权限");
        } else {
            throw new CmsViewException("很抱歉,未登录!", "权限");
        }
    }

    /**
     * 权限异常
     */
    @ExceptionHandler(value={UnauthorizedException.class, AuthorizationException.class})
    public String authorizationException(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (WebUtil.isAjaxRequest(request)) {
            // 输出JSON
            throw new CmsJsonException("很抱歉,无权限!", "权限");
        } else {
            throw new CmsViewException("很抱歉,无权限!", "权限");
        }
    }

    /**
     * 权限异常
     */
    @ExceptionHandler(value = CmsJsonException.class)
    public String CmsJsonException(HttpServletResponse response, Exception e) throws Exception {
        logger.error("CmsJsonException====>",CmsJsonException.getStackMsg(e));
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(JSON.toJSONString(ResultUtils.instanceResult(e.getMessage(), null, false, ((CmsJsonException) e).getTitle())));
        return null;
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws IOException {
        logger.error("exceptionHandler====>",CmsJsonException.getStackMsg(e));
        ModelAndView modelAndView = new ModelAndView("/error"); //error页面
        modelAndView.addObject("errorMessage", e.getMessage());
        modelAndView.addObject("stackTrace", e.getStackTrace());
        modelAndView.addObject("requestURI", request.getRequestURI());
        return modelAndView;

    }
}
