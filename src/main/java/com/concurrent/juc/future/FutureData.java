package com.concurrent.juc.future;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/8/17 15:30
 */
public class FutureData implements Data{
    protected RealData realdata = null;
    protected boolean isReady = false;
    public synchronized void setRealData(RealData realData) {
        if(isReady) {
            return;
        }
        this.realdata = realData;
        isReady=true;
        notifyAll();
    }
    @Override
    public synchronized  String getResult() {
        while(!isReady) {
            try {
                wait();
            }catch (Exception e){

            }
        }
        return realdata.result;
    }
}
