package com.concurrent.juc.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/8/18 16:39
 */
public class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new RealData("a"));
        new Thread(futureTask).start();
        System.out.println("请求完毕");
        System.out.println(futureTask.get());
    }
}
