package org.example.bean_post_processor;

import org.example.bean_post_processor.bean.LifeCycleBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example.bean_post_processor");
        context.close();
    }
}
