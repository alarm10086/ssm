package com.soecode.lyf.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 配置DispatcherServlet
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     *  配置springMVC需要加载的配置文件:
     *  Mybatis(dao) -> spring(service) -> springmvc(web)
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    /** 默认匹配所有的请求 */
    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/" };
    }
}
