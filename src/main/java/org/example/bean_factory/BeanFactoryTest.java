package org.example.bean_factory;

import org.example.config.MyConfig;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;

public class BeanFactoryTest {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 构建beanDefinition
        AbstractBeanDefinition singleton = BeanDefinitionBuilder.genericBeanDefinition(MyConfig.class).setScope("singleton").getBeanDefinition();
        // 注册beanDefinition
        beanFactory.registerBeanDefinition("myConfig", singleton);
        // 向bean工厂加入Bean处理器
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
        // 应用Bean处理器
        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().forEach(e -> e.postProcessBeanFactory(beanFactory));

        beanFactory.getBeanNamesIterator().forEachRemaining(System.out::println);

    }

}
