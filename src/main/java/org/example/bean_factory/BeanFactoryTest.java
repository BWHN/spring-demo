package org.example.bean_factory;

import org.example.config.MyConfig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;

public class BeanFactoryTest {

    public static void main(String[] args) {
        // ConfigurableListableBeanFactory、BeanDefinitionRegistry默认实现
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 构建beanDefinition
        AbstractBeanDefinition singleton = BeanDefinitionBuilder.genericBeanDefinition(MyConfig.class)
                .setScope("singleton").getBeanDefinition();
        // 注册beanDefinition
        beanFactory.registerBeanDefinition("myConfig", singleton);
        // 向bean工厂加入BeanFactory后处理器、Bean后处理器
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
        // 应用BeanFactory后处理器
        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().forEach(e -> e.postProcessBeanFactory(beanFactory));
        // 应用Bean后处理器
        beanFactory.getBeansOfType(BeanPostProcessor.class).values().forEach(beanFactory::addBeanPostProcessor);
        // 打印BeanFactory中的Bean
        beanFactory.getBeanNamesIterator().forEachRemaining(e -> {
            System.out.println(e);
            if ("bean2".equals(e)) {
                System.out.println(beanFactory.getBean(e));
            }
        });
    }

}
