package com.funnycode.jdk.java;

/**
 * @author tc
 * @date 2021/1/26
 */
public class ChongPaiXuTest {

    private static int num = 0;

    private static boolean ready = false;

    public static void main(String[] args) throws InterruptedException {
        ReadThread rt = new ReadThread();
        rt.start();

        WriterThread wt = new WriterThread();
        wt.start();

        Thread.sleep(100);
        rt.interrupt();
        System.out.println("main exit");
    }

    static class ReadThread extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (ready) {
                    System.out.println(num + num);
                }
                System.out.println("read thread...");
            }
        }
    }

    static class WriterThread extends Thread {
        @Override
        public void run() {
            num = 2;
            ready = true;
            System.out.println("write thread...");
        }
    }

}
