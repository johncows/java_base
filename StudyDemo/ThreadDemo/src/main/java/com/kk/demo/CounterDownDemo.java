package com.kk.demo;

public class CounterDownDemo implements Runnable {

//    倒计时的总数
    public  int count=10;

    private  static int threadId = 0;

    private final int id = threadId++;

    private void Status(){
        if(count!=0){
            System.out.format("线程号 %d -------倒计时还有%d \n",id,count);
        }else
        {
            System.out.println("++++++++已发射++++++");
        }
    }

    @Override
    public void run() {
            while (count-- >0){
                Status();
                Thread.yield();
            }

    }
}
