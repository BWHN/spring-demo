package org.example.application_context;

import org.example.bean_factory.config.MyConfig;
import org.example.application_context.config.WebConfig;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {

    public static void main(String[] args) {
        // 测试 classpath xml
        testClassPathXmlApplicationContext();
        // classpath xml实现
        testClassPathXmlApplicationContextOther();
        // annotation context实现
        testAnnotationConfigApplicationContext();
        // annotation web实现
//        testAnnotationConfigServletApplicationContext();
    }

    private static void testClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println(context.getBean("bean4"));
    }

    private static void testClassPathXmlApplicationContextOther() {
        // 创建BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        System.out.println("读取之前...");
        for(String name : beanFactory.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        System.out.println("读取之后...");
        //将从xml中读取到的Bean定义注册到BeanFactory
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(new ClassPathResource("bean4.xml"));
        for(String name : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanFactory.getBean(name));
        }
    }

    private static void testAnnotationConfigApplicationContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Object bean2 = context.getBean("bean2");
        System.out.println(bean2);
    }

    private static void testAnnotationConfigServletApplicationContext() {
        new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);
    }

}
