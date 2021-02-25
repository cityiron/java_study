package com.funnycode.jdk.java.lang;

import java.io.IOException;

/**
 * @author tc
 * @date 2021/1/25
 */
public class ThreadLocalTest {

    public static void main(String[] args) throws IOException {
        Thread t1 = new MyThread("t1");
        Thread t2 = new MyThread("t2");
        Thread t3 = new MyThread("t3");

        t1.start();
        t2.start();
        t3.start();

        System.in.read();
    }

    static class MyClass {
        private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

        public static void setValue(String value) {
            threadLocal.set(value);
        }

        public static String getValue() {
            return threadLocal.get();
        }

    }

    static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            MyClass.setValue(getName());
            for (int i = 0; i < 10; i++) {
                System.out.println(getName() + " 线程第 " + i + " 次获取值：" + MyClass.getValue() + "");
            }
        }
    }

}



