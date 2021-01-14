package com.ironcity;

/**
 * @author tc
 * @date 2020/12/2
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public String sayHello(User user) {
        return "Hello " + user.getName() + " You are " + user.getAge();
    }

    @Override
    public String sayHello(User user, String name) {
        return "Hello " + name + " You are " + user.getAge();
    }

}
