package com.concurrent.jvm.classloader;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 主动使用和被动使用
 * 1.对于静态字段来说，只有直接定义了该字段的类才会被初始化
 * 2.主动使用，子类初始化的时候，会先初始化父类
 * -XX:+TraceClassLoading,用于追踪类的加载信息并打印出来
 */
public class MyTest {
    public static void main(String[] args) {
       System.out.println(MyChild1.str);
      // 2.System.out.println(MyChild1.str2);
    }
}

class MyParent1 {
    public static String str = "hello world";
    static {
        System.out.println("MyParent1 static block ....");
    }
}

class MyChild1 extends MyParent1 {

    public static String str2="welcome";

    static {
        System.out.println("MyChild1 static block ....");
    }
}