package com.concurrent.juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 求和计算
 * //如何使用
 * 1.ForkJoinPool执行
 * 2.ForkJoinTask
 *
 * @date 2021/7/5 16:32
 */
public class ForkJoinTest extends RecursiveTask<Long> {
    private long start;
    private long end;
    private long holder = 10000;

    public ForkJoinTest(long start, long end, long holder) {
        this.start = start;
        this.end = end;
        this.holder = holder;
    }
    public ForkJoinTest(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = (1+1000000000L)*1000000000L>>1;
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"时间： "+(end-start));
    }

    public static void  test1(){
        long sum = 0;
        long start = System.currentTimeMillis();
        for (long i = 1; i <10_0000_0000 ; i++) {
            sum = sum+1;
        }

        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"时间： "+(end-start));
    }
    public static void  test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTest forkJoinTest = new ForkJoinTest(1, 10_0000_0000);
        ForkJoinTask<Long> submit = pool.submit(forkJoinTest);
        long end = System.currentTimeMillis();
        System.out.println("sum="+submit.get()+"时间： "+(end-start));
    }
    public static void  test3(){
        long start = System.currentTimeMillis();
        //stream并行流
        long sum = LongStream.rangeClosed(1, 1_0000_0000).parallel().reduce(1L,Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"时间： "+(end-start));
    }

    @Override
    protected Long compute() {
        long sum = 0;
        if((end-start)<holder){
            for (long i = start; i <= end; i++) {
                sum = sum+i;
            }
            return sum;
        }else{
            long middle = (start+end)/2 ;
            ForkJoinTest task1 = new ForkJoinTest(start,middle);
            task1.fork(); //拆分任务，把任务压入线程队列
            ForkJoinTest task2 = new ForkJoinTest(middle+1,end);
            task2.fork();

            return task1.join()+task2.join();
        }

    }
}
