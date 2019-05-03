package com.kk.demo05;


public class Worker01 implements Runnable{

    private static boolean flag =  true;


    @Override
    public void run() {
        while(flag){
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" work");
        }
    }

    public static void stopWork(){
        flag = !flag;
        System.out.println("停止工作吧");
    }

}
