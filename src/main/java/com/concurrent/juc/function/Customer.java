package com.concurrent.juc.function;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/1 8:32
 */
public class Customer {

    public static void main(String[] args) {
        CustomerFunction<Integer,String> customerFunction = (age,str) ->{return (str +" ," + age);};
        System.out.println(customerFunction.customer(18,"王锐"));
    }
}
