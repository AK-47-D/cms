package com.ak47.cms.cms.config;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.web.embedded.tomcat.TomcatEmbeddedWebappClassLoader;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import javax.servlet.Servlet;
import java.io.File;

@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@ConditionalOnWebApplication
public class DirConfig {
    @Configuration
    @ConditionalOnClass({ Servlet.class, Tomcat.class })
    @ConditionalOnMissingBean(value = TomcatServletWebServerFactory.class, search = SearchStrategy.CURRENT)
    public static class EmbeddedTomcat {
        @Bean
        public TomcatServletWebServerFactory tomcatEmbeddedServletContainerFactory() {
            TomcatServletWebServerFactory tomcatEmbeddedServletContainerFactory = new TomcatServletWebServerFactory();
            tomcatEmbeddedServletContainerFactory.setBaseDirectory(new File("D://tomcat"));
            return tomcatEmbeddedServletContainerFactory;
        }
    }
}