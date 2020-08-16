package com.kk.cheapter12;

public class SimpleCountDownLatch {

    private Integer count = 0;

    public SimpleCountDownLatch(Integer count) {
        this.count = count;
    }

    public  void await(){
        synchronized (this){
            while(true){
                if(count==0){
                    break;
                }
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void countDown(){
        count--;
        this.notify();
    }
}
