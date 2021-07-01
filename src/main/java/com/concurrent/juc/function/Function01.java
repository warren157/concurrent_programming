package com.concurrent.juc.function;

import java.util.function.Function;

/**
 * @author rui.wang
 * @version 1.0
 * @description: Function 函数型接口，有一个输入 一个输出类型的参数
 *              只要是函数型接口，可以用lambda表达式简化
 * @date 2021/7/1 8:14
 */
public class Function01 {
    public static void main(String[] args) {
        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String o) {
                return  o;
            }
        };
        Function<String,String> function1 = (str) ->{return str;};
        System.out.println(function1.apply("hello world"));
    }
}
