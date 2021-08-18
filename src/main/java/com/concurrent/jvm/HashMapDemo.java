package com.concurrent.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/7/8 15:02
 */
public class HashMapDemo {
    public static void main(String[] args) {
        int j = 0;
        HashMap<String, String> map = new HashMap<>();
       map.put("a", "b");
        map.put("a", "c");
        System.out.println(map.get("a"));
    }


}
