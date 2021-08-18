package com.concurrent.juc.deadlock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/6 16:25
 */
public class DeadLockDemo {
    private static String A ="A";
    private static String B ="B";
    public static void main(String[] args) {
        new DeadLockDemo().deadLock();

    }
    public void deadLock(){
        Thread thread1 = new Thread(() -> {
            synchronized (A) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("1");
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (B) {
                synchronized (A) {
                    System.out.println("2");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
