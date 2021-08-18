package com.concurrent.jvm;

/**
 * @author rui.wang
 * @version 1.0
 * @description: 栈帧
 * @date 2021/7/8 13:11
 */
public class StackFrameDemo {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        System.out.println("test...");
        test2();
    }
    public static void test2(){
        System.out.println("test2...");
    }
}
