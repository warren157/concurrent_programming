package com.concurrent.jmm;

/**D:\study\concurrent_programming
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/6/21 8:21
 */
public class Test {
    public static boolean flag = false;
    public static void main(String[] args) {

        new Thread(new Runnable(){
            @Override
            public void run() {
                while(!flag) {
                    System.out.println(Thread.currentThread().getName()+"还没结束");
                }
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                flag = true;
            }
        }).start();
    }

}
