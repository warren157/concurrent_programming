package com.concurrent.juc.function;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/1 8:31
 */
@FunctionalInterface
public interface CustomerFunction<T,R> {

    R customer(T t,String str);



}
