package com.concurrent.juc.sync;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 无锁
 *  线程是一个单独的资源类，没有任何附属操作
 *  1.属性 2方法
 * @date 2021/6/29 17:53
 */
public class SaleTicketDemo01 {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for (int i=0;i<1000;i++){
            new Thread(() ->{
                ticket.sale();
            }).start();
        }
    }
}
//资源类
class Ticket{
    //1.属性 2方法
    private int number = 50;
    public synchronized  void sale(){
        if(number >0) {
            System.out.println(Thread.currentThread().getName()+" 卖出了第"+number--+"票，剩余："+number);
        }
    }
}


