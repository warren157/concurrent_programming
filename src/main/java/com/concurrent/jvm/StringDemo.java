package com.concurrent.jvm;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/9 14:50
 */
public class StringDemo {
    public static void main(String[] args) {
       String s1 = new String("abc");
       s1.intern();
       String s2 ="abc";
       System.out.println(s1 == s2);
    }

    public void test(){
        String s="";
    }

}
