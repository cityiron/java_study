package com.funnycode.jdk.java.util.concurrent;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author tc
 * @date 2021/1/26
 */
public class AtomicStampedReferenceTest {

    public static void main(String[] args) {
        AtomicStampedReference<String> reference = new AtomicStampedReference<>("1", 1000);
        System.out.println(reference.getReference());
        boolean b = reference.compareAndSet("1", "3", 100, 50);
        assert b ? true : false;
        System.out.println(reference.getReference());
        reference.set("2", 88);
        System.out.println(reference.getReference());
    }

}
