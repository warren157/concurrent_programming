package com.concurrent.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/6/29 18:07
 */
public class LockTicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for (int i=0;i<1000;i++){
            new Thread(() ->{
                ticket.sale();
            }).start();
        }
    }
}

class Ticket {
    Lock lock = new ReentrantLock();
    private int number =50 ;

    public void sale(){
        lock.lock();
        try{
            if(number >0) {
                System.out.println(Thread.currentThread().getName()+" 卖出了第"+number--+"票，剩余："+number);
            }
        }finally {
            lock.unlock();
        }

    }
}
