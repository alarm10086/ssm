package com.soecode.lyf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
/** 扫描service包下所有使用注解的类型 */
@ComponentScan("com.soecode.lyf.service")
/** 配置基于注解的声明式事务 */
@EnableTransactionManagement
public class ServiceConfig {

    /** 配置事务管理器 */
    @Bean
    public DataSourceTransactionManager transactionManager(final DataSource dataSource) {
        /** 注入数据库连接池 */
        return new DataSourceTransactionManager(dataSource);
    }

}
