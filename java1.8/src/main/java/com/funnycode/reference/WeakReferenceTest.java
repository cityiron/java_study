package com.funnycode.reference;

import java.util.WeakHashMap;

/**
 * @author tc
 * @date 2021/2/25
 */
public class WeakReferenceTest {

    public static void main(String[] args) {
        //WeakHashMap<String, String> cache = new WeakHashMap<>();
        //for (int i = 0; i < 1000; i++) {
        //    String s = String.valueOf(i);
        //    cache.put(s, s);
        //    System.gc();
        //    System.out.println("Map size :" + cache.size());
        //}

        WeakHashMap<Integer, Object> cache = new WeakHashMap<>();
        for (int i = 0; i < 1000; i++) {
            cache.put(i, i);
            System.gc();
            System.out.println("Map size :" + cache.size());
        }
    }

}
