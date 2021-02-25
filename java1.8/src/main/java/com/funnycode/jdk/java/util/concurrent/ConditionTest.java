package com.funnycode.jdk.java.util.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tc
 * @date 2021/1/26
 */
public class ConditionTest {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("t1 获取锁");
                System.out.println("t1 执行 c1 await 被挂起");
                c1.await(); // 执行 await，会释放锁，进入的是条件队列
                System.out.println("t1 被唤醒成功");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("t1 释放锁");
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("t2 加锁成功");
                System.out.println("t2 执行 c2 await 被挂起");
                c2.await();
                c1.signal();
                System.out.println("t2 唤醒 t1");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("t2 释放锁");
            }
        }, "t2");
        Thread t3 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("t3 加锁成功");
                c2.signal();
                System.out.println("t3 唤醒 t2");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("t3 释放锁");
            }
        }, "t3");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("ReentrantLock");
    }

}
