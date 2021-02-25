package com.funnycode.jdk.java.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tc
 * @date 2021/1/26
 */
public class MapBugTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Thread t1 = new Thread(() -> {
            map.put("1", "2");

            System.out.println(map.get("1"));
        }, "t1");
        Thread t2 = new Thread(() -> {
            map.put("1", "3");

            System.out.println(map.get("1"));
        }, "t2");
        Thread t3 = new Thread(() -> {
            map.put("1", "5");

            System.out.println(map.get("1"));
        }, "t3");
        Thread t4 = new Thread(() -> {
            map.put("1", "1");

            System.out.println(map.get("1"));
        }, "t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
