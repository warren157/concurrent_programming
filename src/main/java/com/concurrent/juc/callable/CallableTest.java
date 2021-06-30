package com.concurrent.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/6/30 13:12
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread thread = new MyThread();
        FutureTask<String> task = new FutureTask(thread);
        new Thread(task).start();
        String o = task.get();
        System.out.println(o);
    }
}
class MyThread implements  Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello world";
    }
}