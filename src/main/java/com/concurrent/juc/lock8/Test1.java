package com.concurrent.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 1.锁的对象是方法的调用者
 * @date 2021/6/30 8:19
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendSms();
        }).start();
      /*  try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {

        }*/
        new Thread(() -> {
            phone.call();
        }).start();
    }
}

class Phone {
    public synchronized  void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {

        }
        System.out.println("发短信");
    }
    public synchronized  void call(){
        System.out.println("打电话");
    }
}