package com.soecode.lyf.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.soecode.lyf.dao.AppointmentDao;
import com.soecode.lyf.dao.BookDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 配置整合mybatis过程
 */
@Configuration
/** 1.配置数据库相关参数properties的属性：${url} */
@PropertySource("classpath:jdbc.properties")
/** 4.配置扫描Dao接口包，动态实现Dao接口，注入到spring容器中 */
@MapperScan("com.soecode.lyf.dao")
public class DaoConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /** 2.数据库连接池 */
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        final ComboPooledDataSource dataSource = new ComboPooledDataSource();
        /** 配置连接池属性 */
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        /** c3p0连接池的私有属性 */
        dataSource.setMaxPoolSize(30);
        dataSource.setMinPoolSize(10);
        /** 关闭连接后不自动commit */
        dataSource.setAutoCommitOnClose(false);
        /** 获取连接超时时间 */
        dataSource.setCheckoutTimeout(10000);
        /** 当获取连接失败重试次数 */
        dataSource.setAcquireRetryAttempts(2);
        return dataSource;
    }

    /** 3.配置SqlSessionFactory对象 */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(final DataSource dataSource) {
        /** 配置MyBatis全局配置文件 */
        final org.apache.ibatis.session.Configuration configuration =
                new org.apache.ibatis.session.Configuration();
        /** 使用列别名替换列名 默认:true */
        configuration.setUseColumnLabel(true);
        /** 使用jdbc的getGeneratedKeys获取数据库自增主键值 */
        configuration.setUseGeneratedKeys(true);
        /** 开启驼峰命名转换:Table{create_time} -> Entity{createTime} */
        configuration.setMapUnderscoreToCamelCase(true);

        final SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        /** 注入数据库连接池 */
        factory.setDataSource(dataSource);
        /** 注入MyBatis全局配置文件 */
        factory.setConfiguration(configuration);
        /** 扫描entity包 使用别名 */
        factory.setTypeAliasesPackage("com.soecode.lyf.entity");
//        /** 扫描sql配置文件:mapper需要的xml文件 */
//        factory.setMapperLocations(new ClassPathResource[]{ new ClassPathResource("mapper/*.xml") });
        return factory;
    }

//    /** 4.配置扫描Dao接口包，动态实现Dao接口，注入到spring容器中 */
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
//        /** 注入sqlSessionFactory */
//        scannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        /** 给出需要扫描Dao接口包 */
//        scannerConfigurer.setBasePackage("com.soecode.lyf.dao");
//        return scannerConfigurer;
//    }

//    @Bean
//    public MapperFactoryBean<BookDao> bookDaoMapper(final SqlSessionFactory factory) {
//        final MapperFactoryBean<BookDao> bean = new MapperFactoryBean<>(BookDao.class);
//        bean.setSqlSessionFactory(factory);
//        return bean;
//    }
//
//    @Bean
//    public MapperFactoryBean<AppointmentDao> appointmentDaoMapperFactoryBean(
//            final SqlSessionFactory factory) {
//        final MapperFactoryBean<AppointmentDao> bean = new MapperFactoryBean<>(AppointmentDao.class);
//        bean.setSqlSessionFactory(factory);
//        return bean;
//    }

}