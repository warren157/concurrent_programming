package com.concurrent.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/5 17:00
 */
public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AtomicInteger i = new AtomicInteger();
        CompletableFuture<Void> complete =  CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i.set(100);
        });
        System.out.println("111111");
        Void unused = complete.get();
        System.out.println(i.get());

    }
}
