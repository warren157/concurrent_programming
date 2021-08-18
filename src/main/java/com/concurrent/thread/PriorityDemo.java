package com.concurrent.thread;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/8/10 10:30
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread hight = new HightPriority();
        Thread low = new LowPriority();
        hight.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);
        low.start();
        hight.start();
    }
    public static class HightPriority extends Thread {
        static int count = 0;
        @Override
        public void run() {
            while (true){
                synchronized (PriorityDemo.class) {
                    count ++;
                    if(count >10000000) {
                        System.out.println("HightPriority is complete");
                        break;
                    }
                }
            }
        }
    }

    public static class LowPriority extends  Thread {
        static int count = 0;
        @Override
        public void run() {
            while (true) {
                synchronized (PriorityDemo.class) {
                    count++;
                    if(count >10000000) {
                        System.out.println("LowPriority is complete");
                        break;
                    }
                }
            }
        }
    }
}
