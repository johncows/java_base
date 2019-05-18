package com.kk.demo02;

/**
 * @author KK
 * @create 2019-05-18 21:57
 *
 * 实现目标 线程wait后 被唤醒 再次拿锁时 是否会从头执行?????
 *
 **/
public class ContinueWork {

    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{

            synchronized (LOCK) {
                System.out.println("工作完成1/2");

                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("工作完成100%");
            }
        }).start();


        Thread.sleep(2_000L);

        synchronized (LOCK){
            LOCK.notify();
        }







    }



}
