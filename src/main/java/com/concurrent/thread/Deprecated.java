package com.concurrent.thread;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/13 9:21
 */
public class Deprecated {
    public static void main(String[] args) throws InterruptedException {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new Runner(),"PrintThread");
        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);
        //线程挂起
        printThread.suspend();
        System.out.println("Main suspend PrintThread at "+format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        printThread.resume();
        System.out.println("Main resume PrintThread at "+format.format(new Date()));
        printThread.stop();
        System.out.println("Main stop PrintThread at "+format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
    }
    public static class Runner implements Runnable {
        @Override
        public void run() {
            DateFormat format = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                System.out.println(Thread.currentThread().getName()+" Run at " + format.format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
