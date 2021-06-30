package com.concurrent.juc.blockqueue;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description:
 *  1.添加
 *      1.
 *      2.
 *  2.删除
 *      1.
 *      2.
 * @date 2021/6/30 17:14
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueueTest test = new BlockingQueueTest();
        //test.test1();
        //test3();
        test4();
    }
    // 抛出异常
    public void test1(){
        ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(3);
       // System.out.println(queue.element()); 检测队首元素，没有元素会抛出元素，NoSuchElementException
        System.out.println(queue.add("A"));
        System.out.println(queue.add("B"));
        System.out.println(queue.add("C"));
       // System.out.println(queue.add("D"));  Queue full

        System.out.println("----------------");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
       //  System.out.println(queue.remove()); NoSuchElementException
    }

    //不抛出异常
    public void test2(){
        ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.offer("A"));
        System.out.println(queue.offer("B"));
        System.out.println(queue.offer("C"));
        System.out.println(queue.offer("D"));  //不抛出异常 返回false
        System.out.println(queue.peek()); //判断队首
        System.out.println("----------------");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll()); //不报错，返回null
    }

    //等待·一直阻塞
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(3);
        queue.put("A");
        queue.put("B");
        queue.put("C");
        //queue.put("C"); 一直等待
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
       // System.out.println(queue.take()); 一直等待

    }

    //等待·等待超时
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(3);
        queue.offer("A", 1000, TimeUnit.MILLISECONDS);
        queue.offer("B", 1000, TimeUnit.MILLISECONDS);
        queue.offer("C", 1000, TimeUnit.MILLISECONDS);
        queue.offer("D", 1000, TimeUnit.MILLISECONDS);
        System.out.println("-------------------");
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
    }
}
