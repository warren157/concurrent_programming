package com.concurrent.lock;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/13 13:58
 */
public class MyLockTest {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(()->{
            phone.test();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"A").start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            phone.test();
        },"B").start();
    }
}

class  Phone {
    MyLock lock = new MyLock();
    public void test(){

    }
}