package com.soecode.lyf.web;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/**
 * api 测试基类
 */
/** 告诉junit spring配置文件 */
public class AbstractContextControllerTests extends BaseTest {

    @Autowired
    protected WebApplicationContext wac;
}