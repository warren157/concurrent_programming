package com.concurrent.juc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/6/30 7:44
 */
public class JucPc {
    public static void main(String[] args) {
        Data1 data = new Data1();
        new Thread(() -> {
            for (;;) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(() -> {
            for (;;) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}

class Data1 {

    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public  void increment() throws InterruptedException {
        lock.lock();
        while(number!=0){
            condition.await();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        condition.signal();
    }

    public  void decrement() throws InterruptedException {
        lock.lock();
        while(number == 0){
            condition.await();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        condition.signal();
    }
}
