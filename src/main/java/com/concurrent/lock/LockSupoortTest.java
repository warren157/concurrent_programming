package com.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/13 16:44
 */
public class LockSupoortTest {

    public static  class MyThread extends  Thread {
        @Override
        public void run() {
            System.out.println(getName()+" 进入线程");
            LockSupport.park();
            System.out.println("t1结束线程");
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("t1已经启动线程");
        LockSupport.unpark(thread);
        System.out.println("主线程结束");
    }
}
