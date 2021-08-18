package com.concurrent.thread;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/8/10 9:54
 */
public class ThreadGroupDemo extends Thread{

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(tg,new ThreadGroupDemo(),"t1");
        Thread t2 = new Thread(tg,new ThreadGroupDemo(),"t2");
        t1.start();
        t2.start();
        System.out.println(tg.activeCount());
        tg.list();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getThreadGroup().getName()+"-"+Thread.currentThread().getName();
        while (true) {
            System.out.println("I am "+name);
            try{
                Thread.sleep(3000);
            }catch (Exception e){

            }
        }
    }
}
