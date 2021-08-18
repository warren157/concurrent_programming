package com.concurrent.juc.reentrancy;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/6 15:23
 */
public class Widget {

    public synchronized  void doSomething(){
        System.out.println( Thread.currentThread().getName()+"  父类执行....");
    }

}
