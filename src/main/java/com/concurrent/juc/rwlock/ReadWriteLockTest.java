package com.concurrent.juc.rwlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author rui.wang
 * @version 1.0
 * @description:
 * @date 2021/6/30 16:39
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        MyCacheLock cache = new MyCacheLock();
        for (int i = 1; i <= 5 ; i++) {
            final  int temp = i;
            new Thread(() -> {
                cache.put(temp+"", temp+"");
            }).start();
        }
        for (int i = 1; i <= 5 ; i++) {
            final  int temp = i;
            new Thread(() -> {
                cache.get(temp+"");
            }).start();
        }
    }
}

class MyCacheLock {
    ReentrantReadWriteLock lock =  new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    private volatile Map<String,Object> map = new HashMap<>();

    //写
    public void put(String key,Object val){
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, val);
            System.out.println(Thread.currentThread().getName() + "写入OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    //读
    public Object get(String key){
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            Object obj = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取OK");
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        return null;
    }
}

class MyCache {
    private volatile Map<String,Object> map = new HashMap<>();

    //写
    public void put(String key,Object val){
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key,val);
        System.out.println(Thread.currentThread().getName()+"写入OK");
    }

    //读
    public Object get(String key){
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        Object obj = map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取OK");
        return obj;
    }
}