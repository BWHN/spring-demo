package org.example.bean;

public class Bean2 {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean2{" +
                "name='" + name + '\'' +
                '}';
    }

}
