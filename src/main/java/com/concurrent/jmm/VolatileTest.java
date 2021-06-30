package com.concurrent.jmm;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/6/21 14:04
 */
public class VolatileTest {
    public static volatile boolean  flag = false;


    public static void main(String[] args) {

        new Thread(() -> {
            while(!flag) {

            }
            System.out.println(Thread.currentThread().getName()+"还没结束");
        }).start();
        new Thread(() ->{
            System.out.println("修改之前");
            flag = true;
            System.out.println("修改之后");
        }
        ).start();
    }
}
