package org.example.spring_function;

import org.example.listener.MyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Locale;

public class SpringFunctionTest {

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
        Resource[] resources = context.getResources("classpath*:META-INF/spring.factories");
        for (Resource resource : resources) {
            System.out.println(resource);
        }
    }

    public static void testEventPublish(ApplicationContext context) {
        context.publishEvent(new MyEvent("hello"));
    }

}
