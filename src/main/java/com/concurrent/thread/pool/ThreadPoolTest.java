package com.concurrent.thread.pool;

import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/13 11:37
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        DefaultThreadPool pool = new DefaultThreadPool();
        for (int i = 0; i < 10; i++) {
            final  int temp = i;
            Thread thread = new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello World="+temp);
            },""+i);
            pool.execute(thread);
        }

    }
}
