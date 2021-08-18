package com.concurrent.thread.pool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/13 11:10
 */
public class DefaultThreadPool<Job extends  Runnable> implements ThreadPool<Job>{
   //线程池最大限制数
    private static final int MAX_WORKER_NUMBERS = 10;
    //线程池默认数量
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    //线程池最小工作线程数量
    private static final int MIN_WORKER_NUMBERS =  1;
    //任务列表，将会向这里插入
    private final LinkedList<Job> jobs = new LinkedList<>();
    //工作线程列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    // 工作者线程的数量
    private int    workerNum    = DEFAULT_WORKER_NUMBERS;
    //线程编号生成
    private AtomicLong threadNum = new AtomicLong();
    public DefaultThreadPool(){
        initializeWokers(DEFAULT_WORKER_NUMBERS);
    }
    public DefaultThreadPool(int num) {
        workerNum = num > MAX_WORKER_NUMBERS ? num : num<MIN_WORKER_NUMBERS? MIN_WORKER_NUMBERS:num;
        initializeWokers(workerNum);
    }
    private void initializeWokers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }
    @Override
    public void execute(Job job) {
        if(job !=null ){
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs) {
            if((num+this.workerNum)>MAX_WORKER_NUMBERS){
                num = MAX_WORKER_NUMBERS-this.workerNum;
            }
            initializeWokers(num);
            this.workerNum +=num;
        }
    }

    @Override
    public void removeWorker(int num) throws IllegalAccessException {
        synchronized (jobs) {
            if (num >= this.workerNum) {
                throw  new IllegalAccessException("Beyond worknum");
            }
            int count = 0;
            while(count<num) {
                Worker worker = workers.get(count);
                if(workers.remove(worker)) {
                    count++;
                }
            }
            this.workerNum -=num;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    class Worker implements Runnable{
        private volatile boolean running = true;
        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobs) {
                    while(jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if(job!=null ){
                    job.run();
                }
            }
        }
        public void shutdown(){
            running = false;
        }
    }
}
