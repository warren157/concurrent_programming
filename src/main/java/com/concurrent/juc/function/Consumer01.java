package com.concurrent.juc.function;

import java.util.function.Consumer;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/1 8:24
 */
public class Consumer01 {
    public static void main(String[] args) {
        Consumer<String> consumer = (str) ->{
            System.out.println(str);
        };
        consumer.accept("hello wolrd");
    }
}
