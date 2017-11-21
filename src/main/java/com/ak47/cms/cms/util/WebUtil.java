package com.ak47.cms.cms.util;

import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtil {
    private static final Logger logger = LoggerFactory.getLogger(WebUtil.class);
    /**
     * 是否是Ajax请求
     *
     * @param request
     * @return
     * @author SHANHY
     * @create 2017年4月4日
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestedWith = request.getHeader("x-requested-with");
        if (requestedWith != null && requestedWith.equalsIgnoreCase("XMLHttpRequest")) {
            return true;
        } else {
            return false;
        }
    }

    public static void writeJson(HttpServletResponse response, String message, Object obj, boolean success, String title){
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        Result result = ResultUtils.instanceResult(message,obj,success,title);
        response.setHeader("result", JSON.toJSONString(result));
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("与客户端通讯异常:"+ e.getMessage(), e);
        }
    }
}
