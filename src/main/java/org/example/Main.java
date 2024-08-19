package org.example;

import org.example.test.SpringFunctionTester;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
//        // BeanFactory 功能
//        SpringFunctionTester.testBeanFactory(context);
//        // MessageResource 功能
//        SpringFunctionTester.testMessageSource(context);
//        // Environment 功能
//        SpringFunctionTester.testEnvironment(context);
//        // ResourcePatternResolver 功能
//        SpringFunctionTester.testResourcePatternResolver(context);
//        // ApplicationEventPublisher 功能
//        SpringFunctionTester.testEventPublish(context);

//        context.close();

    }
}