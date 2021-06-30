package com.concurrent.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/6/30 17:47
 */
public class Demo1 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            threadPool.submit(() -> {
                System.out.println(Thread.currentThread().getName()+"OK");
            });
        }
        threadPool.shutdown();
    }
}
