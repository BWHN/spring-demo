package org.example.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Bean2 {
    @Autowired
    private Bean3 bean3;
    @Override
    public String toString() {
        return "Bean2{bean3=" + bean3 + '}';
    }
}
