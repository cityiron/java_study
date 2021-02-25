package com.funnycode.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author tc
 * @date 2021/1/27
 */
public class CacheTest {

    public static void main(String[] args) {
        LoadingCache<Integer, String> cache = CacheBuilder.newBuilder()
            .concurrencyLevel(Runtime.getRuntime().availableProcessors())
            .initialCapacity(10)
            .maximumSize(100)
            .expireAfterWrite(Duration.ofSeconds(1))
            //.removalListener(notification -> {
            //    System.out.println(
            //        notification.getKey() + " " + notification.getValue() + " 被移除,原因:" + notification.getCause());
            //})
            //.removalListener(RemovalListeners.asynchronous()) // 异步监听
            .build(new DemoCacheLoader());

        //模拟线程并发
        new Thread(() -> {
            //非线程安全的时间格式化工具
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            try {
                for (int i = 0; i < 10; i++) {
                    String value = cache.get(1);
                    System.out.println(
                        Thread.currentThread().getName() + " " + simpleDateFormat.format(new Date()) + " " + value);
                    TimeUnit.SECONDS.sleep(3);
                }
            } catch (Exception ignored) {
            }
        }).start();

        new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            try {
                for (int i = 0; i < 10; i++) {
                    String value = cache.get(1);
                    System.out.println(
                        Thread.currentThread().getName() + " " + simpleDateFormat.format(new Date()) + " " + value);
                    TimeUnit.SECONDS.sleep(5);
                }
            } catch (Exception ignored) {
            }
        }).start();

        //缓存状态查看
        System.out.println(cache.stats().toString());
    }

    static class DemoCacheLoader extends CacheLoader<Integer, String> {

        @Override
        public String load(Integer key) throws Exception {
            System.out.println(Thread.currentThread().getName() + " 加载数据开始");
            TimeUnit.SECONDS.sleep(2);
            Random random = new Random();
            System.out.println(Thread.currentThread().getName() + " 加载数据结束");
            return "value:" + random.nextInt(10000);
        }
    }

}


