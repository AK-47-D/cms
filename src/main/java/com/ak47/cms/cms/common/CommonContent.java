package com.ak47.cms.cms.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Created by wb-cmx239369 on 2017/11/3.
 */
public interface CommonContent {
    static final String NEWS_TITLE = "新闻";
    static final String PBC_HOST = "http://www.pbc.gov.cn";//央行
    static final String PBC_NEWS = PBC_HOST + "/goutongjiaoliu/113456/113469/11040/index1.html";//央行第一页新闻
    static final String PBC_DATA_COUNT = PBC_HOST + "/diaochatongjisi/116219/116319/index.html";//央行数据统计
    static final String PBC_DATA_INTERPRETATION = PBC_HOST + "/diaochatongjisi/116219/116225/11871/index1.html";//数据解读下载
    static final String UPLOAD_PATH = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getRealPath("upload");
}
