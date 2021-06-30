package com.concurrent.juc.syncrousqueue;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 同步队列,不存元素，或者只存单个元素
 *
 * @date 2021/6/30 17:33
 */
public class SyncQueueTest {
    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+" PUT 1");
                queue.put("1");
                System.out.println(Thread.currentThread().getName()+" PUT 2");
                queue.put("2");
                System.out.println(Thread.currentThread().getName()+" PUT 3");
                queue.put("3");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        },"T1").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+" "+queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+" "+queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+" "+queue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }
}
