package com.concurrent.juc;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/8/10 10:38
 */
public class VolatileDemo implements Runnable{
    static VolatileDemo demo = new VolatileDemo();
    static volatile int i=0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }

    public static synchronized void increase(){
        i++;
    }


    @Override
    public void run() {
        for (int j=0 ;i<10000000;j++) {
            increase();
        }
    }
}
