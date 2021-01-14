package com.ironcity;

/**
 * @author tc
 * @date 2020/12/2
 */
public interface DemoService {

    String sayHello(String name);

    String sayHello(User user);

    String sayHello(User user, String name);

}
