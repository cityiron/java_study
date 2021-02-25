package com.funnycode.javac;

/**
 * @author tc
 * @date 2021/1/27
 */
public class SynchronizedTest {

    public void method() {
        synchronized (this){
            System.out.println("Synchronized 代码库");
        }
    }

    public synchronized void method2() {
        System.out.println("Synchronized 方法");
    }

}
