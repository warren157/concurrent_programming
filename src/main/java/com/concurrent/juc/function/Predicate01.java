package com.concurrent.juc.function;

import java.util.function.Predicate;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/1 8:20
 */
public class Predicate01 {
    public static void main(String[] args) {
        //判断字符串是否为空
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
        Predicate<String> predicate1 = (str) ->{
            return str.isEmpty();
        };
        System.out.println(predicate1.test("123"));
    }
}
