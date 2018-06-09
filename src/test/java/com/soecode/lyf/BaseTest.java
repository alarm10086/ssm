package com.soecode.lyf;

import com.soecode.lyf.config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务逻辑测试基类
 */
@WebAppConfiguration
/** 告诉junit spring配置文件 */
@ContextConfiguration(classes = { RootConfig.class })
/** 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit */
@RunWith(SpringJUnit4ClassRunner.class)
/** 配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用 */
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
/** 测试专用的数据库配置 */
@TestPropertySource("classpath:jdbc.properties")
public class BaseTest {
    @Test
    public void test() {
    }

}
