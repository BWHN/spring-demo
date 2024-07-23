package org.example;

import org.example.listener.MyEvent;
import org.example.spring_function.SpringFunctionTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Locale;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        // BeanFactory 功能
        SpringFunctionTest.testBeanFactory(context);
        // MessageResource 功能
        SpringFunctionTest.testMessageSource(context);
        // Environment 功能
        SpringFunctionTest.testEnvironment(context);
        // ResourcePatternResolver 功能
        SpringFunctionTest.testResourcePatternResolver(context);
        // ApplicationEventPublisher 功能
        SpringFunctionTest.testEventPublish(context);
    }
}