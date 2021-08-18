package com.concurrent.juc.jol;


import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/7 13:18
 */
public class JOLDemo {
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        Demo object = new Demo();

        //三个线程去竞争访问一个锁对象
        for (int i = 0; i < 1; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (object){
                        System.out.println(ClassLayout.parseInstance(object).toPrintable());
                    }
                }
            }).start();
        }
    }
}

class Demo {
    private int i=0;


}
