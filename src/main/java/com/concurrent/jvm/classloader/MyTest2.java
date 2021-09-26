package com.concurrent.jvm.classloader;

/**
 * @author rui.wang
 * @version 1.0
 * @description:
 * 将常量存入到MyTest2的常量池中，之后MyTest2与MyParent2没有任何关系
 * 甚至，我们可以将MyParent2的class文件删除
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.str);
        System.out.println(MyParent2.str1);
    }
}

class MyParent2{
    public static String str="hello world";
    public static final String str1="hello world";
    static {
        System.out.println("MyParent2 static block ...");
    }
}

