package com.concurrent.jvm.classloader;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/9/26 8:34
 * 对于数组实例来说，其类型是由JVM在运行时期动态生成的，动态生成的类型其父类型就是Object，对于数组来说，javaDoc经常将构成数组的元素称为Component，实际上就是将数组降低一个维度后的类型
 */
public class MyTest4 {
    public static void main(String[] args) {
        //MyParent4 p = new MyParent4()
        MyParent4[] p = new MyParent4[1]; //不是主动使用
        System.out.println(p.getClass()); //class [Lcom.concurrent.jvm.classloader.MyParent4;,java虚拟机在运行期创建出来的
    }
}

class MyParent4 {
    static {
        System.out.println("MyParent4 block ");
    }
}