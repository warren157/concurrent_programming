package com.concurrent.juc.future;

import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/8/17 15:32
 */
public class RealData implements Data{
    protected final String result;
    public RealData(String para) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try{
                TimeUnit.MILLISECONDS.sleep(100);
            }catch (Exception e){

            }
        }
        result = sb.toString();
    }
    @Override
    public String getResult() {
        return result;
    }
}
