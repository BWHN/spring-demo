package org.example.bean_post_processor;

import org.example.bean_post_processor.bean.Bean5;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.GenericApplicationContext;

public class Main {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("bean5", Bean5.class);
        // @Value 值注入
        context.getDefaultListableBeanFactory().setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());

        // @Autowired @Value
        context.registerBean(AutowiredAnnotationBeanPostProcessor.class);
        // @Resource @PostConstruct @PreDestroy
        context.registerBean(CommonAnnotationBeanPostProcessor.class);
        // @ConfigurationProperties
        ConfigurationPropertiesBindingPostProcessor.register(context.getDefaultListableBeanFactory(););

        context.refresh();
        context.close();
    }

}
