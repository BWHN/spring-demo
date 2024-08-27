package org.example.spring_function;

import lombok.extern.slf4j.Slf4j;
import org.example.bean_post_processor.LifeCycleBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

//@Component
@Slf4j
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (beanName.equals("lifeCycleBean")) {
            log.info("<<<<<<<<< 销毁之前执行，如 @PreDestroy: {}", bean);
        }
    }

    @Override
    public boolean requiresDestruction(Object bean) {
        if (bean instanceof LifeCycleBean) {
            log.info("<<<<<<<<< 是否执行销毁方法");
        }
        return true;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
        if (beanName.equals("lifeCycleBean")) {
            log.info("<<<<<<<<< 实例化之前执行，这里返回的对象会替换原来的 bean");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (beanName.equals("lifeCycleBean")) {
            log.info("<<<<<<<<< 实例化之后执行，这里返回 false 会跳过依赖注入:{}", bean);
        }
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues propertyValues, PropertyDescriptor[] propertyDescriptors, Object bean, String beanName) throws BeansException {
        if (beanName.equals("lifeCycleBean")) {
            log.info("<<<<<<<<< 依赖注入阶段执行，如@Autowird、@Value、@Resource:{}", bean);
        }
        return propertyValues;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("lifeCycleBean")) {
            log.info("<<<<<<<<< 初始化之前执行，这里返回的对象会替换原本的 bean，如@PostConstruct、@ConfigureProperties:{}", bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("lifeCycleBean")) {
            log.info("<<<<<<<<< 初始化之后执行，这里返回的对象会替换原本的 bean，如代理增强:{}", bean);
        }
        return bean;
    }
}
