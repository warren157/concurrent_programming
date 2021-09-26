package com.concurrent.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/8/18 16:37
 */
public class RealData implements Callable<String> {
    private String para;

    public RealData(String para) {
        this.para = para;
    }
    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            TimeUnit.MILLISECONDS.sleep(100);
        }
        return sb.toString();
    }
}
