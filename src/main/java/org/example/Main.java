package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Locale;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        // BeanFactory 功能
        Object a = context.getBean("a");
        System.out.println(a);

        // MessageResource 功能
        System.out.println(context.getMessage("hi", null, Locale.ENGLISH));
        System.out.println(context.getMessage("hi", null, Locale.CHINA));

        // Environment 功能
        System.out.println(context.getEnvironment().getProperty("spring.server.port"));

    }
}