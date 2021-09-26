package com.concurrent.jvm.classloader;

import java.util.UUID;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 当一个类中的常量值并非编译期可以定义的时候，那么其值就不沪被放到调用类的常量池中
 * 这是在程序运行时，会导致主动使用这个常量所在的类，会导致这个类被初始化
 * @date 2021/9/26 8:21
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3 {
    public static final String str = UUID.randomUUID().toString();
    static {
        System.out.println("MyParent3 static block ...");
    }
}