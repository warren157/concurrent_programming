package com.concurrent.thread;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/13 9:29
 */
public class Shutdown {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();
        Thread countThread = new Thread(runner,"countThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        Runner two = new Runner();
        countThread = new Thread(two,"countThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    public static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i ++;
            }
            System.out.println("Count i = "+i);
        }
        public void cancel() {
            on = false;
        }
    }
}
