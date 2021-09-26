package com.concurrent.lambda;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/8/19 14:13
 */
public class CalcuFutureDemo {

    public static Integer calc(Integer para) {
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e) {

        }
        return para * para;
    }

    public static Integer calcException(Integer para) {
        return para/0;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() ->calc(50))
                .thenApply((i) -> Integer.toString(i))
                .thenApply((str) -> "\""+str+"\"")
                .thenAccept(System.out::println);
        future.get();

        //异常处理
        CompletableFuture<Void> fu = CompletableFuture.supplyAsync(() ->calcException(50))
                .exceptionally(ex ->{
                    System.out.println(ex.toString());
                    return 0;
                })
                .thenApply((i) -> Integer.toString(i))
                .thenApply((str) -> "\""+str+"\"")
                .thenAccept(System.out::println);
        fu.get();
    }
}
