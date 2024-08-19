package org.example.test;

import org.example.listener.MyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Locale;

public class SpringFunctionTester {

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
        Resource[] resources = context.getResources("classpath:org/example/Main.class");
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
