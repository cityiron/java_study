package com.funnycode;

/**
 * @author tc
 * @date 2021/1/29
 */
public class MyObject {

    public static void main(String[] args) {
        Object o1 = new Object();
        System.out.println(o1.hashCode());
        Object o2 = new Object();
        System.out.println(o2.hashCode());
        System.out.println(o1.equals(o2));
        String s1 = new String("1");
        System.out.println(s1.hashCode());
        String s2 = new String("1");
        System.out.println(s2.hashCode());
        System.out.println(s1.equals(s2));
    }

}
