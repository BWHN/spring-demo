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

        AbstractBeanDefinition singleton = BeanDefinitionBuilder.genericBeanDefinition(MyConfig.class).setScope("singleton").getBeanDefinition();

        beanFactory.registerBeanDefinition("myConfig", singleton);

        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);

        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().forEach(e -> e.postProcessBeanFactory(beanFactory));

        beanFactory.getBeanNamesIterator().forEachRemaining(System.out::println);

    }

}
