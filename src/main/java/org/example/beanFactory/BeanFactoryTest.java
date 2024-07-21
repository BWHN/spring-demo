package org.example.beanFactory;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanFactoryTest {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        AbstractBeanDefinition singleton = BeanDefinitionBuilder.genericBeanDefinition(MyConfig.class).setScope("singleton").getBeanDefinition();

        beanFactory.registerBeanDefinition("myConfig", singleton);

        beanFactory.getBeanNamesIterator().forEachRemaining(System.out::println);

    }

    @Configuration
    static class MyConfig {

        @Bean
        public Bean1 bean1() {
            return new Bean1();
        }

    }

    static class Bean1 {}

}
