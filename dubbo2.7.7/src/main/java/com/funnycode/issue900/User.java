package com.funnycode.issue900;

import java.io.Serializable;

/**
 * @author tc
 * @date 2020/12/2
 */
public class User implements Serializable {

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
