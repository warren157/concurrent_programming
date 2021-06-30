package com.concurrent.juc.unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/6/30 12:56
 */
public class MapTest {
    public static void main(String[] args) {
        //Map<String,String> map = new HashMap();
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                map.put(UUID.randomUUID().toString().substring(0,5), "");
                System.out.println(map);
            }).start();
        }
    }
}
