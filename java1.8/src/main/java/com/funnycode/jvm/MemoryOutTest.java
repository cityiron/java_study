package com.funnycode.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tc
 * @date 2021/1/27
 */
public class MemoryOutTest {

    private static final Integer K = 1024;

    public static void main(String[] args) {
        int size = K * K * 8;
        List<byte[]> list = new ArrayList<>();
        for (Integer i = 0; i < K; i++) {
            System.out.println("JVM 写入数据" + (i + 1) + "M");
            try {
                Thread.sleep( 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            list.add(new byte[size]);
        }
    }

}
