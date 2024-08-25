package org.example.spring_function.bean;

import org.springframework.stereotype.Component;

@Component
public class A {

    private final String name = "a";

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                '}';
    }

}
