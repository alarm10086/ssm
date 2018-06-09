package com.soecode.lyf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import sun.net.www.content.image.gif;
import sun.net.www.content.image.png;

/**
 * 配置SpringMVC
 */
@Configuration
/** 1.开启SpringMVC注解模式
 *  简化配置：
 *  (1)自动注册DefaultAnootationHandlerMapping,AnotationMethodHandlerAdapter
 *  (2)提供一些列：数据绑定，数字和日期的format @NumberFormat, @DateTimeFormat, xml,json默认读写支持
 */
@EnableWebMvc
/** 4.扫描web相关的bean */
@ComponentScan("com.soecode.lyf.web")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     *  2.静态资源默认servlet配置
     *  (1)加入对静态资源的处理：js,gif,png
     *  (2)允许使用"/"做整体映射
     */
    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /** 3.配置jsp 显示ViewResolver */
    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
