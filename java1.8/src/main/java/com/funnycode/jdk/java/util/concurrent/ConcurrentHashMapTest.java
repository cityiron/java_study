package com.funnycode.jdk.java.util.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tc
 * @date 2021/1/26
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        Map<String, String> m = new ConcurrentHashMap<>(8);
        for (int i = 0; i < 100; i++) {
            String v = String.valueOf(i);
            m.put(v, v);
        }
    }

}
