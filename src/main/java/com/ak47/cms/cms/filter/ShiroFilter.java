package com.ak47.cms.cms.filter;

import com.ak47.cms.cms.entity.ShiroMenu;
import com.ak47.cms.cms.service.ShiroMenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.AbstractShiroWebFilterConfiguration;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.NamedFilterList;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebFilter(urlPatterns = "/manage/*", filterName = "shiroFilter")
public class ShiroFilter implements Filter{
    private static final Logger logger = LoggerFactory.getLogger(ShiroFilter.class);
    @Autowired
    private ShiroFilterFactoryBean shiroFilterFactoryBean;
    @Autowired
    private ShiroMenuService shiroMenuService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("========{}=========","开始shiroFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Map<String,String> oldMap =  shiroFilterFactoryBean.getFilterChainDefinitionMap();
        // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        List<ShiroMenu> shiroMenuList = shiroMenuService.findAll();
        for(ShiroMenu shiroMenu:shiroMenuList){
            filterChainDefinitionMap.put(shiroMenu.getKey(), shiroMenu.getValue());
        }
        if(filterChainDefinitionMap != null){
            for(String key:filterChainDefinitionMap.keySet()){
                if(oldMap.get(key) == null || filterChainDefinitionMap.size() == oldMap.size() || !oldMap.get(key).equals(filterChainDefinitionMap.get(key))){
                    try {
                        PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) ((AbstractShiroFilter) shiroFilterFactoryBean.getObject()).getFilterChainResolver();
                        DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();
                        manager.getFilterChains().clear();
                        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
                        for(Map.Entry<String, String> entry :filterChainDefinitionMap.entrySet()) {
                            String url = entry.getKey();
                            String chainDefinition =entry.getValue().trim().replace(" ", "");
                            manager.createChain(url,chainDefinition);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("========{}=========","结束shiroFilter");
    }
}
