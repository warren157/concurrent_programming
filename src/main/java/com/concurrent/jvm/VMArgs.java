package com.concurrent.jvm;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
 * @date 2021/7/9 17:10
 */
public class VMArgs {
    private static final int _512KB=512 * 1024;
    private static final int _1MB=1024 * 1024;
    private static final int _6MB=1024 * 1024 * 6;
    private static final int _7MB=1024 * 1024 * 7;
    private static final int _8MB=1024 * 1024 * 8;

    public static void main(String[] args) throws InterruptedException {
        //ArrayList<byte[]> list = new ArrayList<>();
        /*list.add(new byte[_7MB]);
        list.add(new byte[_512KB]);*/
       // list.add(new byte[_8MB]); //直接存入老年代
        //测试内存溢出会不会导致主线程中断，测试结果，主线程不会中断
        /*new Thread(() -> {
            ArrayList<byte[]> list = new ArrayList<>();
            list.add(new byte[_8MB]);
            list.add(new byte[_8MB]);
        }).start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("主线程执行");*/
        long i =1l;
        long j=2l;
        if(1>j){

        }
    }
}
