package com.concurrent.juc.pc;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 顺序执行
 * @date 2021/6/30 7:56
 */
public class AlterPrint {


    public static void main(String[] args) {
        Data2 data = new Data2();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        }).start();
    }
}

class Data2 {
    private Lock lock = new ReentrantLock();
    Condition aCondition = lock.newCondition();
    Condition bCondition = lock.newCondition();
    Condition cCondition = lock.newCondition();
    private int number = 1; //1 A 2 B 3 C
    public void printA(){
        lock.lock();
        try{
            while (number !=1 ){
                aCondition.await();
            }
            System.out.println("A");
            number=2;
            bCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
    public void printB(){
        lock.lock();
        try{
            while(number!=2) {
                bCondition.await();
            }
            System.out.println("B");
            number=3;
            cCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try{
            while(number!=3) {
                cCondition.await();
            }
            System.out.println("C");
            number=1;
            aCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
