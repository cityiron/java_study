package com.funnycode.jdk.java.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tc
 * @date 2021/1/25
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>(1);
        for (int i = 0; i < 100; i++) {
            String v = String.valueOf(i);
            m.put(v, v);
        }

        Map<String, String> m2 = new HashMap<>(20);
        m2.put("1", "1");
        m2.put("1", "1");

        Map<String, String> m3 = new HashMap<>(4);

        Map<String, String> map = Collections.synchronizedMap(m3);
    }

}
