package com.concurrent.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/13 10:30
 */
public class ThreadLocalDemo {

    public static void main(String args[]) throws InterruptedException{
        Runtime r = Runtime.getRuntime();//获得当前系统的CPU数量，根据这个数值创建对应数量的线程
        ExecutorService pool = Executors.newFixedThreadPool(r.availableProcessors());
        for (int i = 0;i < r.availableProcessors();i++){
            pool.execute(new Loop());
        }
        pool.shutdown();
    }
}
class Loop implements Runnable{
    @Override
    public void run() {
       /* int busyTime = 50;//可调节参数，单位为ms。50ms后线程休眠50毫秒，然后再经系统调度。该数值越小，则线程被调度得越频繁，则CPU使用率也就越高（平均）
        int idleTime = busyTime;
        while(true){
            long startTime = System.currentTimeMillis();
            //busy loop:
            while((System.currentTimeMillis()-startTime)<=busyTime)
                ;
            try {
                Thread.sleep(idleTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        // 角度的分割
        final double SPLIT = 0.01;
        // 2PI分割的次数，也就是2/0.01个，正好是一周
        final int COUNT = (int) (2 / SPLIT);
        final double PI = Math.PI;
        // 时间间隔
        final int INTERVAL = 200;
        long[] busySpan = new long[COUNT];
        long[] idleSpan = new long[COUNT];
        int half = INTERVAL / 2;
        double radian = 0.0;
        /*对busySpan和idleSpan数组赋值
        busySpan：100 102 104 ... 200 198 196 ... 100  98  96 ...   0   2   4 ... 100 循环
        idleSpan: 100  98  96 ...   0   2   4 ... 100 102 104 ... 200 198 196 ... 100 循环
        对于CPU，每次先工作busySpan[i]ms，再休眠idleSpan[i]ms。一次循环分四个阶段解读：
        阶段一：busySpan : 100 -> 200 idleSpan: 100 -> 0 在此阶段，CPU利用率整体呈上升(busySpan[i] - idleSpan[i] >= 0)，
                且每经过一个busySpan[i]和idleSpan[i]之后，曲线上升的幅度相比前一次更大，因为busySpan[i] - idleSpan[i]
                递增
        阶段二：busySpan: 200 -> 100 idleSpan: 0 -> 100 分析同上，此阶段CPU利用率整体仍呈上升趋势，但每一次上升幅度比前
                一次上升幅度小
        阶段三：busySpan: 100 -> 0 idleSpan: 100 -> 200 在此阶段，CPU利用率呈下降趋势，且下降幅度越来越大
        阶段四：busySpan: 0 -> 100 idleSpan: 200 -> 100 在此阶段，CPU利用率继续呈下降趋势，下降幅度越来越小
        最后，循环上述四个阶段
        */
        for (int i = 0; i < COUNT; i++) {
            busySpan[i] = (long) (half + (Math.sin(PI * radian) * half));
            idleSpan[i] = INTERVAL - busySpan[i];
            radian += SPLIT;
        }
        long startTime = 0;
        int j = 0;
        while (true){
            j = j % COUNT;
            startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < busySpan[j])
                ;
            try {
                Thread.sleep(idleSpan[j]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            j++;
        }
    }
}