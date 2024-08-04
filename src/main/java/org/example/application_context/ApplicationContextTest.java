package org.example.application_context;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ApplicationContextTest {

    public static void main(String[] args) {
        // 测试 classpath xml
        testClassPathXmlApplicationContext();
        // classpath xml实现
        testClassPathXmlApplicationContextOther();
        // annotation context实现
    }

    private static void testClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println(classPathXmlApplicationContext.getBean("bean4"));
    }

    private static void testClassPathXmlApplicationContextOther() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        System.out.println("读取之前...");
        for(String name : beanFactory.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        System.out.println("读取之后...");
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(new ClassPathResource("bean4.xml"));
        for(String name : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanFactory.getBean(name));
        }
    }

    private static void testAnnotationApplicationContext() {

    }

}
