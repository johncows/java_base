package com.kk.demo05;


public class Worker02 implements Runnable {


    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(1_000);
                System.out.println(Thread.currentThread().getName() + " work");
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

        System.out.println(Thread.currentThread().getName() + "休息一下吧");
    }


}
