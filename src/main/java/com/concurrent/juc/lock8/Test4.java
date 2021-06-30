package com.concurrent.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/6/30 8:36
 */
public class Test4 {
    public static void main(String[] args) {
        Phone4 phone = new Phone4();
        Phone4 phone1 = new Phone4();
        new Thread(() -> {
            phone.sendSms();
        }).start();

        new Thread(() -> {
            phone1.call();
            // phone.hello();
        }).start();
    }
}
class Phone4 {

    //锁的是class
    public static  synchronized  void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {

        }
        System.out.println("发短信");
    }
    //锁的是调用者，不是同步一个锁
    public  synchronized  void call(){
        System.out.println("打电话");
    }

    //这里没有锁，不是同步方法，不受锁的影响
    public void hello(){
        System.out.println("Hello");
    }

}