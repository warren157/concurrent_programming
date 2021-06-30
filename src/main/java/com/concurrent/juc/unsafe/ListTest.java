package com.concurrent.juc.unsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 线程不安全：java.util.ConcurrentModificationException
 * @date 2021/6/30 8:44
 */
public class ListTest {
    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        for (int i = 1;i<=10;i++) {
            new Thread(() ->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            }).start();
        }*/
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1;i<=100;i++) {
            new Thread(() ->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            }).start();
        }
    }
}
