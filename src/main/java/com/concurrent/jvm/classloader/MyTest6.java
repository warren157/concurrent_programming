package com.concurrent.jvm.classloader;



/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/9/26 17:17
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(Singleton.counter1);
        System.out.println(Singleton.counter2);
    }
}

class Singleton {
    public static int counter1=1;
   // 1. public static int counter2 = 0;  //打印1
   public static Singleton singleton = new Singleton();
    private Singleton(){
        counter1++;
        counter2++;
    }
    public static int counter2 = 0;


    public static Singleton getInstance() {
        return singleton;
    }
}