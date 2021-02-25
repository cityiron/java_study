package com.funnycode.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author tc
 * @date 2021/1/27
 */
public class BloomFilterGuavaTest {

    private static int total = 1000000;
    private static BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), total);

    public static void main(String[] args) {
        for (int i = 0; i < total; i++) {
            bf.put(i);
        }

        for (int i = 0; i < total; i++) {
            if (!bf.mightContain(i)) {
                System.out.println("有坏人逃脱了");
            }
        }

        int count = 0;
        for (int i = total; i < total + 10000; i++) {
            if (bf.mightContain(i)) {
                count++;
            }
        }

        System.out.println("误伤的数量：" + count);
    }

}
