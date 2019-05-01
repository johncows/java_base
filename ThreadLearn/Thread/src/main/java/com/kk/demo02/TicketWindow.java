package com.kk.demo02;



// 业务逻辑抽取到 Runnable 接口中
public class TicketWindow implements Runnable{


    private final int MAX = 50;


    private  int index = 1;


    @Override
    public void run() {
        while (index<=MAX){
            System.out.println(Thread.currentThread()+"发出号码 " + index++);
        }
    }
}
