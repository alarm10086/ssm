package com.soecode.lyf.web;

import com.soecode.lyf.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/**
 * API测试
 */
@WebAppConfiguration
@ContextConfiguration({ "classpath:spring/spring-web.xml" })
public class AbstractContextControllerTests extends BaseTest {

    @Autowired
    protected WebApplicationContext wac;
}