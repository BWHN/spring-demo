package org.example.bean_post_processor;

import org.example.bean_post_processor.bean.Bean5;
import org.springframework.context.support.GenericApplicationContext;

public class Main {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("bean5", Bean5.class);
        context.refresh();
        context.close();
    }

}
