package com.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 生产者消费者
 * @date 2021/7/13 10:15
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            for (;;) {
                try {
                    phone.increment();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"A").start();
        new Thread(() -> {
            for (;;) {
                try {
                    phone.decrement();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"B").start();
    }

}


class Phone {

    public volatile int  count = 0;

    public synchronized  void  increment() throws InterruptedException {
        while(count !=0) {
            wait();
        }
        count ++;
        notify();
        System.out.println(Thread.currentThread().getName()+"increment :"+count);
    }

    public synchronized  void  decrement() throws InterruptedException {
        while(count ==0) {
            wait();
        }
        count --;
        notify();
        System.out.println(Thread.currentThread().getName()+"decrement :"+count);
    }
}