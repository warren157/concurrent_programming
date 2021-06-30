package com.concurrent.juc.pc;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 1.等待
 *               2.业务操作
 *               3.通知
 *               中断和虚假唤醒是可能的，并且该方法应该始终在循环中使用
 * @date 2021/6/30 7:30
 */
public class SyncPc {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for(;;){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for(;;){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}

//资源类
class Data {
    private int number=0;

    //+1
    public synchronized void increment() throws InterruptedException {
       /* if(number !=0) {
            wait();
        }*/
        while(number !=0) {
            wait();
        }
        number++;
        System.out.println("+"+Thread.currentThread().getName()+"=>"+number);
        notify();
    }

    //-1
    public synchronized void decrement() throws InterruptedException {
       /* if(number==0) {
            wait();
        }*/
        while(number==0) { //防止虚假唤醒
            wait();
        }
        number--;
        System.out.println("-"+Thread.currentThread().getName()+"=>"+number);
        notify();
    }

}