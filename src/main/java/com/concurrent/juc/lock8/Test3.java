package com.concurrent.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/6/30 8:31
 */
public class Test3 {
    public static void main(String[] args) {
        Phone3 phone = new Phone3();
        Phone3 phone1 = new Phone3();
        new Thread(() -> {
            phone.sendSms();
        }).start();

        new Thread(() -> {
            phone1.call();
            // phone.hello();
        }).start();
    }
}
class Phone3 {

    public static  synchronized  void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {

        }
        System.out.println("发短信");
    }
    public static synchronized  void call(){
        System.out.println("打电话");
    }

    //这里没有锁，不是同步方法，不受锁的影响
    public void hello(){
        System.out.println("Hello");
    }

}