package com.concurrent.juc.function;

import java.util.function.Supplier;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/1 8:26
 */
public class Supplier01 {
    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {

                return "hello world";
            }
        };

        Supplier<String> s  = () -> {return "hello world lambda" ;};
        System.out.println(supplier.get());
        System.out.println(s.get());
    }
}
