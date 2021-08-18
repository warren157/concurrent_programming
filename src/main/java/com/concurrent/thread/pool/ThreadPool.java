package com.concurrent.thread.pool;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/13 11:05
 */
public interface ThreadPool<Job extends Runnable> {
    //执行一个JOB
    void execute(Job job);
    //关闭线程池
    void shutdown();
    //增加工作线程
    void addWorkers(int num);
    //减少工作线程
    void removeWorker(int num) throws IllegalAccessException;
    //得到正在等待执行得任务数量
    int getJobSize();
}
