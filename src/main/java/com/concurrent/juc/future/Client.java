package com.concurrent.juc.future;

import java.util.concurrent.TimeUnit;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/8/17 15:34
 */
public class Client {
    public static void main(String[] args) {
        Client client =new Client();
        Data data = client.request("name");
        System.out.println("请求完毕");
        try{
            TimeUnit.MILLISECONDS.sleep(2000);
        }catch (Exception e){

        }
        System.out.println("数据="+data.getResult());
    }
    public Data request(final String queryStr) {
        final FutureData future = new FutureData();
        new Thread(){
            @Override
            public void run() {
                RealData realData = new RealData(queryStr);
                future.setRealData(realData);
            }
        }.start();
        return future;
    }
}
