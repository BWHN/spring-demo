package org.example.spring_function;

import org.example.spring_function.listener.MyEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Locale;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        // BeanFactory 功能
        testBeanFactory(context);
        // MessageResource 功能
        testMessageSource(context);
        // Environment 功能
        testEnvironment(context);
        // ResourcePatternResolver 功能
        testResourcePatternResolver(context);
        // ApplicationEventPublisher 功能
        testEventPublish(context);
        // 关闭容器
        context.close();
    }

    public static void testBeanFactory(ApplicationContext context) {
        Object a = context.getBean("a");
        System.out.println(a);
    }

    public static void testMessageSource(ApplicationContext context) {
        System.out.println(context.getMessage("hi", null, Locale.ENGLISH));
        System.out.println(context.getMessage("hi", null, Locale.CHINA));
    }

    public static void testEnvironment(ApplicationContext context) {
        System.out.println(context.getEnvironment().getProperty("spring.server.port"));
    }

    public static void testResourcePatternResolver(ApplicationContext context) throws IOException {
        Resource[] resources = context.getResources("classpath:org/example/spring_function/Main.class");
        for (Resource resource : resources) {
            if (resource.exists()) {
                System.out.println(resource.getFile());
            } else {
                System.out.println("file not exist");
            }
        }
    }

    public static void testEventPublish(ApplicationContext context) {
        context.publishEvent(new MyEvent("hello"));
    }

}