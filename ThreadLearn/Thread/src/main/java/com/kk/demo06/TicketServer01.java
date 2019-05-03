package com.kk.demo06;

public class TicketServer01 implements Runnable {

    private static final int MAX = 60;
    private static final Object LOCK =  new Object();

    private Integer index = 1;


    @Override
    public  void run() {
        while (true){

            synchronized (LOCK){
            if(index<=MAX){
                try {
                    Thread.sleep(1_00);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"=>"+index++);
            }else {
                break;
            }
            }

        }
    }
}
