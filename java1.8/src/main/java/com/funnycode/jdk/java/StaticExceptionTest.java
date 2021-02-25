package com.funnycode.jdk.java;

/**
 * @author tc
 * @date 2021/1/26
 */
public class StaticExceptionTest {

    static {
        int i = 1 / 0; // Caused by: java.lang.ArithmeticException: / by zero
    }

    public static void main(String[] args) {
        System.out.println("run");
    }

}
