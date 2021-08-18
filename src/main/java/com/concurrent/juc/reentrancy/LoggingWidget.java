package com.concurrent.juc.reentrancy;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 证明synchronized是可重入锁
 * @date 2021/7/6 15:24
 */
public class LoggingWidget extends Widget{
    @Override
    public synchronized void doSomething() {
        System.out.println(Thread.currentThread().getName()+" 子类执行");
        super.doSomething();
    }

    public static void main(String[] args) {
        LoggingWidget lg = new LoggingWidget();
        new Thread(() -> {
            lg.doSomething();
        }).start();
    }
}
