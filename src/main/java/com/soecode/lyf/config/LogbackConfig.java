package com.soecode.lyf.config;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.ext.spring.ApplicationContextHolder;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogbackConfig {

    @Bean
    public static ApplicationContextHolder applicationContextHolder() {
        return new ApplicationContextHolder();
    }

    @Bean
    public static LoggerContext loggerContext() {
        return (LoggerContext) LoggerFactory.getILoggerFactory();
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public static PatternLayoutEncoder encoder(final LoggerContext ctx) {
        final PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(ctx);
        encoder.setPattern("%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n");
        return encoder;
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public static ConsoleAppender STDOUT(final LoggerContext ctx, final PatternLayoutEncoder encoder) {
        final ConsoleAppender appender = new ConsoleAppender();
        appender.setContext(ctx);
        appender.setEncoder(encoder);
        return appender;
    }


}
