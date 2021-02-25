package com.funnycode.jdk.java.util;

import org.checkerframework.checker.units.qual.K;
import sun.misc.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author tc
 * @date 2021/1/26
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        // map 1
        //Map<String, String> map = new LinkedHashMap<>();
        //for (int i = 0; i < 10; i++) {
        //    String v = String.valueOf(i);
        //    map.put(v, v);
        //}
        //
        //System.out.println(map.get("5"));

        // map2
        LinkedHashMap<Integer,Integer> map2 = new LinkedHashMap<>(8, 0.75f, true);

        map2.put(1, 1);
        map2.put(2, 2);
        map2.put(3, 3);

        map2.get(2);
        map2.get(1);

        System.out.println(map2);
    }

    static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private int cacheSize;

        public LRUCache(int cacheSize) {
            super(16, 0.754f, true);
            this.cacheSize = cacheSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return super.removeEldestEntry(eldest);
        }
    }

}
