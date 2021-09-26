package com.concurrent.lambda;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/8/19 13:34
 */
public class Demo01 {
    static int[] arr = {1,3,5,7,9,10};
    public static void main(String[] args) {
        lambda2(arr);
    }

    private static void tradition(int[] arr){
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void lambda(int[] arr){
        Arrays.stream(arr).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
    }

    private static void lambda1(int[] arr) {
        Arrays.stream(arr).forEach(x -> {
            System.out.println(x);
        });
    }

    private static void lambda2(int[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
    }
}
