package com.funnycode.jdk.java.util.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tc
 * @date 2021/1/25
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        NoFail();
        Fail();
    }

    public static void NoFail() {
        Lock lock = new ReentrantLock();
        Thread t1 = new MyThread("t1", lock);
        Thread t2 = new MyThread("t2", lock);
        Thread t3 = new MyThread("t3", lock);
        Thread t4 = new MyThread("t4", lock);
        Thread t5 = new MyThread("t5", lock);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    public static void Fail() {
        Lock lock = new ReentrantLock(true);
        Thread t1 = new MyThread("t1", lock);
        Thread t2 = new MyThread("t2", lock);
        Thread t3 = new MyThread("t3", lock);
        Thread t4 = new MyThread("t4", lock);
        Thread t5 = new MyThread("t5", lock);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    private static void doSomeThing(String name, int c) {
        System.out.println(name + " 线程第" + c + "次执行逻辑，好开心");
    }

    static class MyThread extends Thread {
        private Lock lock;

        public MyThread(String name, Lock lock) {
            super(name);
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    System.out.println(getName() + " 线程获取到锁");
                    TimeUnit.SECONDS.sleep(1);
                    doSomeThing(getName(), i);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println(getName() + " 线程释放锁");
                }
            }
        }
    }

}
