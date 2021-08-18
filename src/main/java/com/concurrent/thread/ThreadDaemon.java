package com.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/8/10 10:11
 */
public class ThreadDaemon {

    public static void main(String[] args) throws InterruptedException {
            Thread t = new Daemon();
            t.setDaemon(true);
            t.start();

            Thread.sleep(2000);
    }

    public static class Daemon extends  Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("I am lived");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
