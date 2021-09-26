package com.concurrent.lambda;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/8/19 13:49
 */
public class CompletableFutureDemo implements  Runnable{

    CompletableFuture<Integer> re = null;
    public CompletableFutureDemo( CompletableFuture<Integer> re) {
        this.re = re;
    }
    @Override
    public void run() {
        int myRe = 0;
        try {
            myRe = re.get() * re.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(myRe);
    }

    public static void main(String[] args) throws InterruptedException {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(new CompletableFutureDemo(future)).start();
        Thread.sleep(5000);
        future.complete(60);
    }
}
