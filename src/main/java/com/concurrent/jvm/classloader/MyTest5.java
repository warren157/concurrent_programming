package com.concurrent.jvm.classloader;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/9/26 8:52
 * 将myparent5的class文件删除后，还能打印6
 * 当一个接口在初始化时，并不要求其父接口都完成初始化
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}
interface MyParent5 {
    static int a = 5;
}
interface MyChild5 extends MyParent5 {
    static int b = 6;
}